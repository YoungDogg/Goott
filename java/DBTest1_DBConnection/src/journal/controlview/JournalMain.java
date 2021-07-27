package journal.controlview;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import javax.swing.text.html.HTMLEditorKit.Parser;

import friendDB.controlview.FriendMain;
import friendDB.vo.FriendVo;
import journal.dao.JournalDAO;
import journal.dao.JournalDAOIml;
import journal.vo.JournalVo;

public class JournalMain {
	private JournalDAO dao = new JournalDAOIml();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		JournalMain fm = new JournalMain();
		int menu = 0;
		do {
			System.out.println("메뉴 입력 ...");
			fm.displayMenu();
			menu = sc.nextInt();
			switch (menu) {
			case 1:
				System.out.println("일기 저장 눌렀다");
				fm.insertJournal();
				break;
			case 2:
				System.out.println("일기 검색(날짜) 눌렀다");
				fm.searchJournalDate();
				break;
			case 3:
				System.out.println("일기 출력 눌렀다");
				fm.outputEntireJournal();
				break;
			case 4:
				System.out.println("일기 정보 수정 눌렀다");
				fm.updateJournal();
				break;
			case 5:
				System.out.println("일기 삭제 눌렀다");
				fm.deleteJournal();
				break;
			case 6:
				System.out.println("종료");
				System.exit(0);
			default:
				break;
			}
		} while (menu != 7);
	}

	private void displayMenu() {
		System.out.println("===============");
		System.out.println("일기관리 ver1.0");
		System.out.println("1. 일기저장");
		System.out.println("2. 일기검색 (날짜로 검색)");
		System.out.println("3. 모든 일기 출력");
		System.out.println("4. 일기 정보 수정 ");
		System.out.println("5. 일기 삭제 ");
		System.out.println("6. 종료 ");
		System.out.println("===============");
	}

	private void insertJournal() {
		// TODO Auto-generated method stub
		int nextJournaldNo = 0;
		try {
			nextJournaldNo = dao.nextJournalNo();
		} catch (ClassNotFoundException | SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		String nextJournalDate = "";
		String nextJournalDate2 = "";
		try {
			nextJournalDate = dao.nextJournalDate();
			nextJournalDate2 = nextJournalDate;
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");		
		try {
			date = formatter.parse(nextJournalDate2);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		formatter = new SimpleDateFormat("yyyy년 MM월 dd일 E요일");
		nextJournalDate2 = formatter.format(date);

		formatter = new SimpleDateFormat("yyyy/MM/dd");
		try {
			date = formatter.parse(nextJournalDate);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		System.out.println("nextJournaldNo : " + nextJournaldNo);
		System.out.println("nextJournalDate : " + date);
		Scanner sc = new Scanner(System.in);
		System.out.println("일기내용 : ");
		String journalContent = sc.next();

		try {
			if (dao.insertJournal(new JournalVo(nextJournaldNo, date, journalContent))) {
				System.out.println("등록 성공");
			}
		} catch (ClassNotFoundException | SQLException | ParseException e) {
			// TODO Auto-generated catch block
			System.out.println("디비 작업 에러");
			e.printStackTrace();
		}
	}

	private void updateJournal() {
		// TODO Auto-generated method stub

		outputEntireJournal();

		Scanner sc = new Scanner(System.in);
		System.out.println("수정할 일기 번호");
		int journalNo = sc.nextInt();

		// 나중에 할 일 : 업데이트 하고 싶은 자료만 구분하기
		System.out.println("일기날짜 : ");
		String journalDate = sc.next();
		System.out.println("일기내용 : ");
		String journalContent = sc.next();

		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
		try {
			date = formatter.parse(journalDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (dao.updateJournal(new JournalVo(journalNo, date, journalContent))) {
			System.out.println("업데이트 성공");
		}
		outputEntireJournal();
	}

	private void deleteJournal() {
		// TODO Auto-generated method stub
		outputEntireJournal();

		Scanner sc = new Scanner(System.in);
		System.out.println("삭제할 일기 번호");
		int journalNo = sc.nextInt();

		try {
			if (dao.deleteJournal(new JournalVo(journalNo))) {
				System.out.println("일기 삭제 성공");
			}
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		outputEntireJournal();
	}

	private void searchJournalDate() {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("검색할 날짜를 입력 하세요 : ");
		String date = sc.next();

		List<JournalVo> lst = null;
		try {
			lst = dao.selectAllJournal();
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (!lst.isEmpty()) {
			for (JournalVo vo : lst) {
				System.out.println(vo.getJournalNo() + " " + vo.getJournalDate() + " " + vo.getJournalContent());
			}
		}
	}

	private void outputEntireJournal() {
		List<JournalVo> lst = null;
		try {
			lst = dao.selectAllJournal();
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(!lst.isEmpty()) {
			for (JournalVo vo : lst) {
				System.out.println(
						vo.getJournalNo() + " " + vo.getJournalDate() +
						" " + vo.getJournalContent());
			}
		}else {								
			System.out.println("등록된 친구가 없다.");
		}

	}

}
