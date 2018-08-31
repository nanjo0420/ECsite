package com.internousdev.sampleweb2.util;

import java.util.ArrayList;
import java.util.List;

import com.internousdev.sampleweb2.dto.PaginationDTO;
import com.internousdev.sampleweb2.dto.ProductionInfoDTO;

public class Pagination {

	//初期化
	public PaginationDTO initialize(List<ProductionInfoDTO> list, int pageSize){

		//list : 商品数
		//pageSize : 1ページに表示する商品数

		PaginationDTO paginationDTO = new PaginationDTO();
		//全ページ数
		paginationDTO.setTotalPageSize((int)(Math.ceil(list.size() / pageSize)));

		//ex) pageSize = 9 , list.size = 30 , 30/9= 3.3333.... → 4 = totalPageSize

		//現在のページ番号
		paginationDTO.setCurrentPageNo(1);
		//全レコード数(商品数)
		paginationDTO.setTotalRecordSize(list.size() - 1);
		//現在のページ番号に対する開始レコード番号（オフセット）
		paginationDTO.setStartRecordNo(pageSize * (paginationDTO.getCurrentPageNo() -1));

		/*ex) pageSize = 9 , paginationDTO.getCurrentPageNo() = 1 → 9 * (1-1) = 0
		 		すなわち1ページ目は商品番号0から始まる。*/

		//現在のページ番号に対する終了レコード番号
		paginationDTO.setEndRecordNo(paginationDTO.getStartRecordNo() + (pageSize - 1));

		/*ex) paginationDTO.getStartRecorsNo() = 0 , pageSize = 9  → 0 + (9-1) = 8
		  		すなわち1ページ目は商品番号8で終わる*/

		List<Integer> pageNumberList = new ArrayList<Integer>();
		for(int pageNumber = 1; pageNumber <= paginationDTO.getTotalPageSize(); pageNumber++){
			pageNumberList.add(pageNumber);
		}

		List<ProductionInfoDTO> productInfoPages = new ArrayList<ProductionInfoDTO>();
		for(int pageNumberOffset=paginationDTO.getStartRecordNo(); pageNumberOffset <= paginationDTO.getEndRecordNo(); pageNumberOffset++){
			productInfoPages.add(list.get(pageNumberOffset));
		}
		paginationDTO.setCurrentProductionInfoPage(productInfoPages);

		if((paginationDTO.getStartRecordNo() - 1) <= 0){
			paginationDTO.setPreviousPage(false);
		}else{
			paginationDTO.setPreviousPage(true);
			paginationDTO.setPreviouPageNo(paginationDTO.getCurrentPageNo() - 1);
		}

		if(paginationDTO.getEndRecordNo() + pageSize > paginationDTO.getTotalRecordSize()){
			paginationDTO.setNextPage(false);
		}else{
			paginationDTO.setNextPage(true);
			paginationDTO.setNextPageNo(paginationDTO.getCurrentPageNo() + 1);
		}
		return paginationDTO;
	}

	public PaginationDTO getPage(List<ProductionInfoDTO> list, int pageSize, String pageNo){

		PaginationDTO paginationDTO = new PaginationDTO();
		//全ページ数
		paginationDTO.setTotalPageSize((int)(Math.ceil(list.size() / pageSize)));
		//現在のページ番号
		paginationDTO.setCurrentPageNo(Integer.parseInt(pageNo));
		//全レコード数
		paginationDTO.setTotalRecordSize(list.size() - 1);
		//現在のページ番号に対する開始レコード番号（オフセット）
		paginationDTO.setStartRecordNo(pageSize * (paginationDTO.getCurrentPageNo() -1));
		//現在のページ番号に対する開始レコード番号
//		paginationDTO.setStartRecordNo((pageSize * paginationDTO.getCurrentPageNo()) + 1);
		//現在のページ番号に対する終了レコード番号
		paginationDTO.setEndRecordNo(paginationDTO.getStartRecordNo() + (pageSize - 1));

		List<Integer> pageNumberList = new ArrayList<Integer>();
		for(int pageNumber = 1; pageNumber <= paginationDTO.getTotalPageSize(); pageNumber++){
			pageNumberList.add(pageNumber);
		}

		List<ProductionInfoDTO> productInfoPages = new ArrayList<ProductionInfoDTO>();
		for(int pageNumberOffset=paginationDTO.getStartRecordNo(); pageNumberOffset <= paginationDTO.getEndRecordNo(); pageNumberOffset++){
			productInfoPages.add(list.get(pageNumberOffset));
		}
		paginationDTO.setCurrentProductionInfoPage(productInfoPages);

		if((paginationDTO.getStartRecordNo() - 1) <= 0) {
			paginationDTO.setPreviousPage(false);
		}else{
			paginationDTO.setPreviousPage(true);
			paginationDTO.setPreviouPageNo(paginationDTO.getCurrentPageNo() - 1);
		}

		if(paginationDTO.getEndRecordNo() + pageSize > paginationDTO.getTotalRecordSize()){
			paginationDTO.setNextPage(false);
		}else{
			paginationDTO.setNextPage(true);
			paginationDTO.setNextPageNo(paginationDTO.getCurrentPageNo() + 1);
		}

		return paginationDTO;
	}
}
