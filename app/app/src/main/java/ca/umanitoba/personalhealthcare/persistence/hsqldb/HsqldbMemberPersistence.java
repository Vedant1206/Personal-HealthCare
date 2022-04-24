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
        try {
            statement = dbConnection.prepareStatement("SELECT email, password FROM Member WHERE email = ? AND password = ?");
            statement.setString(1, email);
            statement.setString(2, password);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String returnedEmail = resultSet.getString("email");
                String returnedPassword = resultSet.getString("password");
                boolean isPatient = resultSet.getBoolean("isPatience");
                if (isPatient) {
                    //TODO: id
                    Member patient = new Patient("1", returnedEmail, returnedPassword);
                } else {
                    return null;
                }
            } else {
                return null;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            return null;
        }

    }

    @Override
    public Member createMember(Member member) throws EmailExistException {
        return null;
    }
}
