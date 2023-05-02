package com.trip.mukja.model.dto;

<<<<<<< HEAD
=======
import lombok.Builder;
import lombok.EqualsAndHashCode;
>>>>>>> origin/dev
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
<<<<<<< HEAD
public class MemberDTO {

=======
@EqualsAndHashCode
public class MemberDTO {
	
>>>>>>> origin/dev
	private String userId;
	private String userName;
	private String userPwd;
	private String emailId;
	private String emailDomain;
	private String joinDate;
	private String salt;
<<<<<<< HEAD
	private Role role;

	private enum Role{
		ADMIN, USER
	}
	



=======
	private String role;
	

	
	
>>>>>>> origin/dev
}
