package com.Adam.bankingapplication.DAO;

import com.Adam.bankingapplication.Entities.Notice;
import com.Adam.bankingapplication.repositories.NoticeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class NoticeDAO {

	@Autowired
	NoticeRepository noticeRepository;

	public List<Notice> getNotices() {
		List<Notice> notices = noticeRepository.findAllActiveNotices();
		if(notices != null) {
			return notices;
		}
		return new ArrayList<Notice>();
	}

}
