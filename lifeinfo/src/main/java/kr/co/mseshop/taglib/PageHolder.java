package kr.co.mseshop.taglib;

/**
 * @author sungbae,kim
 * @version $Revision: 1.6 $ $Date: 2008/05/25 23:20:58 $
 */
public class PageHolder {

	public static final int DEFAULT_LISTSIZE = 20;

	public static final int DEFAULT_PAGESIZE = 5;

	private int listSize = DEFAULT_LISTSIZE;

	private int pageSize = DEFAULT_PAGESIZE;

	private int totalRows;

	private int currentPage;

	public PageHolder(int totalRows, int currentPage) {
		this.totalRows = totalRows;
		this.currentPage = currentPage;
	}

	public PageHolder(int totalRows, int currentPage, int listSize) {
		this.totalRows = totalRows;
		this.currentPage = currentPage;
		this.listSize = listSize;
	}

	public PageHolder(int totalRows, int currentPage, int listSize, int pageSize) {
		this.totalRows = totalRows;
		this.currentPage = currentPage;
		this.listSize = listSize;
		this.pageSize = pageSize;
	}

	public int getCurrentPage() {
		return this.currentPage;
	}

	public int getLineSize() {
		return this.listSize;
	}

	public int getPageSize() {
		return this.pageSize;
	}

	public int getTotalPages() {
		if ((totalRows > 0) && (currentPage > 0)) {
			int totalPages = totalRows / listSize;

			if (totalRows % listSize > 0) {
				totalPages++;
			}

			return totalPages;
		} else {
			return 0;
		}
	}

	public int getTotalRows() {
		return this.totalRows;
	}
}
