package kosta.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import kosta.mapper.BoardMapper;

//자동 객체 생성 해주는 역할 - dao에서는 repository
@Repository
public class BoardDao {
//JDBC 사용	
/*	//autowired의 생성자, 세타메소드,필드에 사용가능
	private JdbcTemplate jdbcTemplate;

	//bean 객체를 사용하지 않고 xml에 선언한 객체를 자동으로 생성해서 받아와서 사용하겠다는 선언
	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public void insert(Board board){
	String sql = "insert into board" +
				 "(seq, title, writer, contents, regdate, hitcount)" +
				 "values(board_seq.nextval, ?, ?, ?, sysdate, 0)";
	
	Object values[] = {
				board.getTitle(),
				board.getWriter(),
				board.getContents()
	};
	
	//query의 insert, delete 같은것은 update문을 사용
	jdbcTemplate.update(sql,values);
}

public List<Board> listBoard(){
	String sql = "select * from board order by seq desc";
	
	RowMapper<Board> mapper = new RowMapper<Board>() {
		@Override
		public Board mapRow(ResultSet rs, int arg1) throws SQLException {
			Board board = new Board();
			
			board.setContents(rs.getString("contents"));
			board.setHitcount(rs.getInt("hitcount"));
			board.setRegdate(rs.getString("regdate"));
			board.setSeq(rs.getInt("seq"));
			board.setTitle(rs.getString("title"));
			board.setWriter(rs.getString("writer"));
			
			return board;
		}
	};
	
	//값을 가져올 때 query문을 이용하여 가져와서 mapper에 담아주고 board로 보내져서 return
	List<Board> list = jdbcTemplate.query(sql, mapper);	
	return list;
}

	public Board getBoard(int seq){
		String sql = "select * from board where seq=?";
		Object values[] = {seq};
		
		//보드 객체 매핑
		RowMapper<Board> mapper = new RowMapper<Board>() {
			@Override
			public Board mapRow(ResultSet rs, int arg1) throws SQLException {
				Board board = new Board();
				
				board.setContents(rs.getString("contents"));
				board.setHitcount(rs.getInt("hitcount"));
				board.setRegdate(rs.getString("regdate"));
				board.setSeq(rs.getInt("seq"));
				board.setTitle(rs.getString("title"));
				board.setWriter(rs.getString("writer"));
				
				return board;
			}
		};
		
		//쿼리의 값이 하나일때 queryForObject 사용
		Board board = jdbcTemplate.queryForObject(sql, values, mapper);
		
		return board;
	}
*/
	
//마이바티스 사용
	private SqlSessionTemplate sqlTemplate;
	
	@Autowired
	public void setSqlTemplate(SqlSessionTemplate sqlTemplate) {
		this.sqlTemplate = sqlTemplate;
	}

	public void insert(Board board){
		//spring에서는 commit 과 rollback 자동으로 생성
		sqlTemplate.getMapper(BoardMapper.class).insertBoard(board);
	}
	
	public List<Board> listBoard(){
		return sqlTemplate.getMapper(BoardMapper.class).listBoard();
	}
	
	public Board getBoard(int seq){
		return sqlTemplate.getMapper(BoardMapper.class).getBoard(seq);
	}
	
}
