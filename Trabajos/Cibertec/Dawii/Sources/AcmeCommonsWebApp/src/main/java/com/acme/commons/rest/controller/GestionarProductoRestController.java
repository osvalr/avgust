package com.acme.commons.rest.controller;

import com.acme.commons.business.service.IGestionarProductoService;
import com.acme.mybatis.query.mapper.ProductoQueryMapper;
import com.acme.mybatis.query.model.ProductoQuery;
import com.acme.mybatis.query.model.ProductoQueryCriteria;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

/**
 * Created by JRaffo on 10/27/15.
 */

@RestController
public class GestionarProductoRestController {

    private static Logger log = Logger.getLogger(GestionarProductoRestController.class);

    @Autowired
    private IGestionarProductoService iGestionarProductoService;

    @RequestMapping(value = "/producto/", method = RequestMethod.GET)
    public ResponseEntity<List<ProductoQuery>> listAllUsers() throws Exception {
        List<ProductoQuery> list = iGestionarProductoService.selectByQuery(ProductoQueryMapper.class,new ProductoQueryCriteria(),false);
        if(list.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @RequestMapping(value = "/producto/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProductoQuery> getUser(@PathVariable("id") Integer id) throws Exception {

        ProductoQueryCriteria productoQueryCriteria = new ProductoQueryCriteria();
        productoQueryCriteria.setId_producto(id);

        ProductoQuery productoQuery = iGestionarProductoService.selectOneByQuery(ProductoQueryMapper.class, productoQueryCriteria);
        if (productoQuery == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(productoQuery, HttpStatus.OK);
    }

    @RequestMapping(value = "/producto/", method = RequestMethod.POST)
    public ResponseEntity<Void> createUser(@RequestBody ProductoQuery productoQuery, UriComponentsBuilder ucBuilder) throws Exception {

        //Auditoria
        productoQuery.setId_user(1);
        productoQuery.setId_user_mod(1);
        productoQuery.setId_estado(1);

        if (productoQuery.getId_producto() != null) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

        iGestionarProductoService.create(productoQuery);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/producto/{id}").buildAndExpand(productoQuery.getId_producto()).toUri());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

}
