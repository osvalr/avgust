package sernanp.app.dao.query.domain; 

public class TablaTipoReferQueryCriteria { 

private String orderColumn;
private String orderDirecction;
private String destabla; 
private Integer int_cod_refer_tablatipo; 

public TablaTipoReferQueryCriteria() {
this.orderColumn = "1";
this.orderDirecction = "ASC";
}
public String getDestabla() { 
  return destabla; 
} 
public void setDestabla(String destabla) { 
  this.destabla = destabla; 
} 
public Integer getInt_cod_refer_tablatipo() { 
  return int_cod_refer_tablatipo; 
} 
public void setInt_cod_refer_tablatipo(Integer int_cod_refer_tablatipo) { 
  this.int_cod_refer_tablatipo = int_cod_refer_tablatipo; 
} 
public String getOrderColumn() {
return orderColumn;
}
public void setOrderColumn(String orderColumn) {
this.orderColumn = orderColumn;
}
public String getOrderDirecction() {
return orderDirecction;
}
public void setOrderDirecction(String orderDirecction) {
this.orderDirecction = orderDirecction;
}

} 
