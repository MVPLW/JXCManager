package cn.jxc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;

import cn.jxc.pojo.Product;
import cn.jxc.pojo.StockPile;
import cn.jxc.pojo.StoreHouse;
import cn.jxc.service.ProductService;
import cn.jxc.service.StockPileService;
import cn.jxc.service.StoreHouseService;

@Controller
public class StockPileController {

	@Autowired
	private StockPileService stockPileService;
	@Autowired
	private StoreHouseService storeHouseService;
	@Autowired
	private ProductService productService;

	private static int pageSize = 5;

	/**
	 * 跳转到库存信息页面
	 * 
	 * @param model
	 * @param pageNo
	 *            当前页码
	 * @param storeHouseId
	 *            仓库id
	 * @param productId
	 *            产品id
	 * @return
	 */
	@RequestMapping("/goStockPile")
	public String goStockPileList(Model model, @RequestParam(value = "pageNo", required = false) Integer pageNo,
			@RequestParam(value = "storeHouseId", required = false) Integer storeHouseId,
			@RequestParam(value = "productId", required = false) String productId) {
		if (pageNo == null) {
			pageNo = 1;
		}
		PageInfo<StockPile> stockPileAll = stockPileService.getStockPileAll(storeHouseId, productId, pageNo, pageSize);
		List<StoreHouse> storeHouselist = storeHouseService.getStoreHouselist();
		List<Product> list = productService.getProductAll(1, 10000).getList();

		model.addAttribute("stockPileAll", stockPileAll);
		model.addAttribute("storeHouselist", storeHouselist);
		model.addAttribute("productList", list);
		model.addAttribute("storeHouseId", storeHouseId);
		model.addAttribute("productId", productId);
		return "stockpile/stockpile";
	}

}
