package ca.umanitoba.personalhealthcare.persistence;

import ca.umanitoba.personalhealthcare.objects.EmailExistException;
import ca.umanitoba.personalhealthcare.objects.Member;

public interface MemberPersistence {
    /**
     *
     */
    public Member getMember (String email, String password);

    /**
     * Given email and password, create a new account in persistence
     *
     * @param  member               a new member has at least email and password
     * @return Member               new Member with an id
     * @throws EmailExistException  if email has already been used for another account
     */
    public Member createMember (Member member) throws EmailExistException;
}
