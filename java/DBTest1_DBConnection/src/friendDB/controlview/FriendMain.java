package friendDB.controlview;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import friendDB.dao.FriendDAO;
import friendDB.dao.FriendDAOIml;
import friendDB.vo.FriendVo;

public class FriendMain {
	private FriendDAO dao = new FriendDAOIml();
	
	private void displayMenu() {
		System.out.println("===============");
		System.out.println("친구관리 ver1.0");
		System.out.println("1. 친구저장");
		System.out.println("2. 친구검색 (이름으로 검색)");
		System.out.println("3. 침구검색 (번호로 검색)");
		System.out.println("4. 모든 친구 출력");
		System.out.println("5. 친구 정보 수정 ");
		System.out.println("6. 친구 삭제 ");
		System.out.println("7. 종료 ");
		System.out.println("===============");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		FriendMain fm = new FriendMain();
		int menu = 0;
		do {
			System.out.println("메뉴 입력 ...");
			fm.displayMenu();
			menu = sc.nextInt();
			switch (menu) {
			case 1:				
				System.out.println("친구 저장 눌렀다");
				fm.insertFriend();
				break;
			case 2:				
				System.out.println("친구 검색(이름) 눌렀다");
				fm.searchFriendsName();
				break;
			case 3:				
				System.out.println("친구 검색(번호) 눌렀다");
				fm.searchFriendsMobile();
				break;
			case 4:				
				System.out.println("친구 출력 눌렀다");
				fm.outputEntireFriends();
				break;
			case 5:				
				System.out.println("친구 정보 수정 눌렀다");
				fm.updateFriend();
				break;
			case 6:				
				System.out.println("친구 삭제 눌렀다");
				fm.deleteFriend();
				break;
			case 7:	
				System.out.println("종료");
				System.exit(0); 
			default:
				break;
			}
		}while(menu != 7);
	}

private void insertFriend() {		
		
		int nextFriendNo = 0; 
		try {
			nextFriendNo = dao.nextFriendNo();
			System.out.println("다음 친구 번호(PK) : " + nextFriendNo);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Scanner sc = new Scanner(System.in);		
		System.out.println("친구이름 : ");
		String friendName = sc.next();
		System.out.println("친구번호 : ");
		String friendMobile = sc.next();
		System.out.println("친구주소 : ");
		String friendAddress= sc.next();

		try {
			if(dao.insertFriend(new FriendVo
					(nextFriendNo, friendName,friendMobile, friendAddress))) {
					System.out.println("등록 성공");
				}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("디비 작업 에러");
			e.printStackTrace();
		}
	}

	private void updateFriend() {
		
		// 친구 이름들을 쭉 불러온다.
		outputEntireFriends();
		
		//수정할 친구 번호를 받는다
		Scanner sc = new Scanner(System.in);
		System.out.println("수정할 친구 번호");
		int friendNo = sc.nextInt();
		
		// 나중에 할 일 : 업데이트 하고 싶은 자료만 구분하기 
		System.out.println("친구이름 : ");
		String friendName = sc.next();
		System.out.println("친구번호 : ");
		String friendMobile = sc.next();
		System.out.println("친구주소 : ");
		String friendAddress= sc.next();
		
		try {			
			if(dao.updateFriend(new FriendVo
					(friendNo, friendName,friendMobile, friendAddress))) {
				System.out.println("업데이트 성공");
				// 친구 이름들을 쭉 불러온다.
				outputEntireFriends();
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("업데이트 실패");
			e.printStackTrace();
		}
	}
	private void deleteFriend() {
		// TODO Auto-generated method stub
		// 친구 이름들을 쭉 불러온다.
		outputEntireFriends();
		
		// 수정할 친구 번호를 받는다
		Scanner sc = new Scanner(System.in);
		System.out.println("삭제할 친구 번호");
		int friendNo = sc.nextInt();
		
		try {
			if(dao.deleteFriend(new FriendVo(friendNo))) {
				System.out.println("친구등록 성공");
				// 친구 이름들을 쭉 불러온다.
				outputEntireFriends();
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("친구 삭제 실패");
			e.printStackTrace();
		}

	}

	private void searchFriendsName() {
		// TODO Auto-generated method stub
		// 검색받은 이름 받아온다
		Scanner sc = new Scanner(System.in);
		System.out.println("검색할 이름을 입력 하세요 : ");
		String name = sc.next();
		
		List<FriendVo> lst = null;
		try {
			lst = dao.searchFriendByName(name);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(!lst.isEmpty()) {
			for (FriendVo vo : lst) {
				System.out.println(
						vo.getFriendNo() + " " + vo.getFriendName() +
						" " + vo.getFriendMobile() + " " + vo.getFriendAddress());
			}
		}else {								
			System.out.println("검색한 결과가 없습니다.");
		}
	}

	private void searchFriendsMobile() {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("검색할 번호를 입력 하세요 : ");
		String mobile = sc.next();
		
		try {
			List<FriendVo> lst = dao.searchFriendByMobile(mobile);			
			if(!lst.isEmpty()) {				
				for (FriendVo vo : lst) {
					System.out.println(
							vo.getFriendNo() + " " + vo.getFriendName() +
							" " + vo.getFriendMobile() + " " + vo.getFriendAddress());
				}
			}else {								
				System.out.println("등록된 친구가 없다.");
			}

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("번호로 찾기 실패");
			e.printStackTrace();
		}
	}

	private void outputEntireFriends() {
		// TODO Auto-generated method stub
		try {
			List<FriendVo> lst = dao.selectEntireFriends();
			if(!lst.isEmpty()) {
				for (FriendVo vo : lst) {
					System.out.println(
							vo.getFriendNo() + " " + vo.getFriendName() +
							" " + vo.getFriendMobile() + " " + vo.getFriendAddress());
				}
			}else {								
				System.out.println("등록된 친구가 없다.");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("친구 불러오기 오류");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("친구 불러오기 오류");
		}
	}

}
