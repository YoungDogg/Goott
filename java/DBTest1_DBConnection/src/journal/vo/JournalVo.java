package journal.vo;

import java.util.Date;

public class JournalVo {
	private int JournalNo;
	private Date JournalDate;
	private String JournalContent;
	
	public JournalVo(int journalNo, Date journalDate, String journalContent) {
		super();
		JournalNo = journalNo;
		JournalDate = journalDate;
		JournalContent = journalContent;
	}

	public JournalVo(int journalNo) {
		super();
		JournalNo = journalNo;
	}

	public int getJournalNo() {
		return JournalNo;
	}

	public void setJournalNo(int journalNo) {
		JournalNo = journalNo;
	}

	public Date getJournalDate() {
		return JournalDate;
	}

	public void setJournalDate(Date journalDate) {
		JournalDate = journalDate;
	}

	public String getJournalContent() {
		return JournalContent;
	}

	public void setJournalContent(String journalContent) {
		JournalContent = journalContent;
	}
	
	
}
