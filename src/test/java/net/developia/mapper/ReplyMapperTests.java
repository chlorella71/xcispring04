package net.developia.mapper;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.stream.IntStream;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.log4j.Log4j;
import net.developia.domain.Criteria;
import net.developia.domain.ReplyVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="file:**/*-context.xml")
@WebAppConfiguration
@Log4j
public class ReplyMapperTests {
	
	private Long[] bnoArr = {1000151L,
			1000150L,
			1000149L,
			1000148L,
			1000033L};

	@Autowired
	private ReplyMapper mapper;
	
	@Test
	public void testMapper() {
		log.info(mapper);
	}
	
	@Ignore
	@Test
	public void testCreate() {
		IntStream.rangeClosed(1,10).forEach(i->{
			ReplyVO vo = new ReplyVO();
			vo.setBno(bnoArr[i%5]);
			vo.setReply("댓글테스트"+i);
			vo.setReplyer("replyer"+i);
			
			mapper.insert(vo);
			
		});
	}
	
	@Test
	public void testRead() {
		Long targetRno =5L;
		ReplyVO vo= mapper.read(targetRno);
		
		log.info(vo);
	}
	
	@Transactional
	@Test
	public void testDelete() {
		Long targetRno=2L;
		
//		mapper.delete(targetRno);
		assertEquals(1, mapper.delete(targetRno));
	}
	
	@Transactional
	@Test
	public void testUpdate() {
		Long targetRno=10L;
		
		ReplyVO vo=mapper.read(targetRno);
		vo.setReply("Update Rep[y");
		int count=mapper.update(vo);
		log.info("UPDATE COUNT: "+count);
		assertEquals(1, count);
	}
	
	@Test
	public void testList() {
		Criteria cri = new Criteria();
		
		//3145745L
		List<ReplyVO> replies = mapper.getListWithPaging(cri, bnoArr[3]);
		replies.forEach(reply->log.info(reply));
	}
}
