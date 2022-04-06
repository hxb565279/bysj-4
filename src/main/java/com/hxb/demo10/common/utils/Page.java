package com.hxb.demo10.common.utils;
import java.util.List;
/**
 * The type Page.
 *
 * @param <T> the type parameter
 */
public class Page<T> {
	// 总条数
	private int total;
	// 当前页
	private int page;

	// 每页数
	private int size;

	//  结果集
	private List<T> rows;
  /**
   * Gets total.
   *
   * @return the total
   */
  public int getTotal() {
		return total;
	}
  /**
   * Sets total.
   *
   * @param total the total
   */
  public void setTotal(int total) {
		this.total = total;
	}
  /**
   * Gets page.
   *
   * @return the page
   */
  public int getPage() {
		return page;
	}
  /**
   * Sets page.
   *
   * @param page the page
   */
  public void setPage(int page) {
		this.page = page;
	}
  /**
   * Gets size.
   *
   * @return the size
   */
  public int getSize() {
		return size;
	}
  /**
   * Sets size.
   *
   * @param size the size
   */
  public void setSize(int size) {
		this.size = size;
	}
  /**
   * Gets rows.
   *
   * @return the rows
   */
  public List<T> getRows() {
		return rows;
	}
  /**
   * Sets rows.
   *
   * @param rows the rows
   */
  public void setRows(List<T> rows) {
		this.rows = rows;
	}  
}
