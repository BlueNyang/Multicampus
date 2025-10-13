package kr.bluenyang.practice.springbootex.auth.service;

import kr.bluenyang.practice.springbootex.auth.model.MemberEditDTO;
import kr.bluenyang.practice.springbootex.auth.model.MemberVO;

/**
 * Service interface for Member operations.
 */
public interface MemberService {
    /**
     * Attempt to log in with the provided ID and password.
     *
     * @param id  Member ID
     * @param pwd Member Password
     * @return "success" if login is successful, otherwise an error message or "fail"
     */
    String tryLogin(String id, String pwd);

    /**
     * Check for duplicate member ID.
     * MemberVO
     *
     * @param id Member ID to check
     * @return "available" if ID is not taken, otherwise "unavailable"
     */
    String idDupCheck(String id);

    /**
     * Register a new member.
     *
     * @param dto Member data transfer object containing member details
     */
    void joinMember(MemberVO dto);

    /**
     * Retrieve member details by ID.
     *
     * @param id Member ID
     * @return MemberVO containing member details
     */
    MemberVO getMember(String id);

    /**
     * Update member information.
     *
     * @param dto MemberEditDTO containing updated member details
     * @return "success" if update is successful, otherwise an error message
     */
    String updateMember(MemberEditDTO dto);

    /**
     * Unregister a member.
     *
     * @param dto MemberEditDTO containing member ID and password for verification
     * @return "success" if unregistration is successful, otherwise an error message
     */
    String unregisterMember(MemberEditDTO dto);
}
