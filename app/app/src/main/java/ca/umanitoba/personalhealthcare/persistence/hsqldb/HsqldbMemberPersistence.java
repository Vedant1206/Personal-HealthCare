package ca.umanitoba.personalhealthcare.persistence.hsqldb;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

import ca.umanitoba.personalhealthcare.objects.EmailExistException;
import ca.umanitoba.personalhealthcare.objects.Member;
import ca.umanitoba.personalhealthcare.objects.Patient;
import ca.umanitoba.personalhealthcare.persistence.MemberPersistence;

public class HsqldbMemberPersistence implements MemberPersistence {

    @Override
    public Member getMember(String email, String password) {
        Connection dbConnection = HsqldbConnection.getInstance().getConnection();
        PreparedStatement statement;
        ResultSet resultSet;
        Member member = null;
        try {
            statement = dbConnection.prepareStatement("SELECT * FROM PUBLIC.MEMBER WHERE email = ? AND password = ?");
            statement.setString(1, email);
            statement.setString(2, password);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                String returnedEmail = resultSet.getString("email");
                String returnedPassword = resultSet.getString("password");
                boolean isPatient = resultSet.getBoolean("is_patience");
                if (isPatient) {
                    member = new Patient(id + "", returnedEmail, returnedPassword);

                    return  member;
                } else {
                    return null;
                }
            } else {
                return null;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            return member;
        }



    }

    @Override
    public Member createMember(Member member) throws EmailExistException {
        Connection dbConnection = HsqldbConnection.getInstance().getConnection();
        PreparedStatement statement;
        ResultSet resultSet;
        String sql = "INSERT INTO PUBLIC.MEMBER (EMAIL, PASSWORD) VALUES ( ?, ?)";
        int result = 0;
        try {
            statement = dbConnection.prepareStatement(sql);
            statement.setString(1, member.getEmail());
            statement.setString(2, member.getPassword());
            result = statement.executeUpdate();

            if (result == 0) {
                member = null;
                return member;
            } else {
                return member;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            member = null;
        } finally {
            return member;
        }

    }
}
