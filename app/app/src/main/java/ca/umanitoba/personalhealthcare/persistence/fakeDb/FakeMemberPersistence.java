package ca.umanitoba.personalhealthcare.persistence.fakeDb;

import java.util.ArrayList;

import ca.umanitoba.personalhealthcare.objects.EmailExistException;
import ca.umanitoba.personalhealthcare.objects.Member;
import ca.umanitoba.personalhealthcare.persistence.MemberPersistence;

public class FakeMemberPersistence implements MemberPersistence {
    public static MemberPersistence memberPersistence;

    private ArrayList<Member> members;

    private FakeMemberPersistence () {
        members = new ArrayList<>();
    }

    public static MemberPersistence getMemberPersistence () {
        if (memberPersistence == null) {
            memberPersistence = new FakeMemberPersistence();
        }
        return memberPersistence;
    }

    @Override
    public Member getMember(String email, String password) {
        for (Member member : members) {
            if (member.getEmail().equals(email) && member.getPassword().equals(password)) {
                return member;
            }
        }
        return null;
    }

    @Override
    public Member createMember(Member newMember) throws EmailExistException {
        for (Member member : members) {
            if (member.getEmail()
                    .equals(newMember.getEmail())) {
                throw new EmailExistException();
            }
        }

        this.members.add(newMember);

        newMember.setID(this.members.size()+"");

        return null;
    }
}
