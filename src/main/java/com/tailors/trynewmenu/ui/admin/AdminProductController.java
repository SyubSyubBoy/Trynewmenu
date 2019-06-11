package com.tailors.trynewmenu.ui.admin;

import com.tailors.trynewmenu.domain.product.Product;
import com.tailors.trynewmenu.service.product.ProductFindService;
import com.tailors.trynewmenu.service.product.ProductManagementService;
import com.tailors.trynewmenu.ui.dto.BooleanResult;
import com.tailors.trynewmenu.ui.dto.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/product")
public class AdminProductController {

    @Autowired
    ProductManagementService service;

    @Autowired
    ProductFindService findService;

    @RequestMapping(method = RequestMethod.GET)
    public Page<Product> getProductPage(Pageable pageable) {
        return findService.getProductsByPageable(pageable);
    }

    @RequestMapping(value = "/{code}", method = RequestMethod.GET)
    public Product getProduct(@PathVariable("code") String code) {
        return findService.getProductByProductCode(code);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Product create(@RequestBody ProductDto.CreateRequest createRequest) {
        return service.createNewProduct(createRequest);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Product update(@RequestBody ProductDto.UpdateRequest updateRequest) {
        return service.updateProduct(updateRequest);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public BooleanResult delete(@RequestBody ProductDto.DeleteRequest deleteRequest) {
        service.deleteProduct(deleteRequest.getProductCode());
        return new BooleanResult(true);
    }
}
