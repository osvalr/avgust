CREATE or REPLACE TRIGGER TX_TB_CUSTOMER
  AFTER INSERT OR UPDATE OR DELETE ON tambos.tb_customer
  FOR EACH ROW 

DECLARE
      p_batch_process_info_id number;  
      p_nameTable    varchar2(100):=upper('tb_customer');
BEGIN

select max(a.BATCHPROCESSINFOID) into p_batch_process_info_id from TB_BATCH_PROCESS_INFO a
where a.TABLENAME = p_nameTable;

IF DELETING THEN 
  
  update TB_BATCH_PROCESS_INFO set DELETEDROWS = (DELETEDROWS + 1)
  where BATCHPROCESSINFOID = p_batch_process_info_id;
  
END IF;

IF INSERTING THEN 
  update TB_BATCH_PROCESS_INFO set INSERTEDROWS = (INSERTEDROWS + 1)
  where BATCHPROCESSINFOID = p_batch_process_info_id;
END IF;

IF UPDATING THEN 
  update TB_BATCH_PROCESS_INFO set UPDATEDROWS = (UPDATEDROWS + 1)
  where BATCHPROCESSINFOID = p_batch_process_info_id;
END IF;    

EXCEPTION
    WHEN OTHERS THEN 
      p_batch_process_info_id:=null;

END;

CREATE or REPLACE TRIGGER TX_tb_delivery_address
  AFTER INSERT OR UPDATE OR DELETE ON tambos.tb_delivery_address
  FOR EACH ROW 

DECLARE
      p_batch_process_info_id number;  
      p_nameTable    varchar2(100):=upper('tb_delivery_address');
BEGIN

select max(a.BATCHPROCESSINFOID) into p_batch_process_info_id from TB_BATCH_PROCESS_INFO a
where a.TABLENAME = p_nameTable;

IF DELETING THEN 
  
  update TB_BATCH_PROCESS_INFO set DELETEDROWS = (DELETEDROWS + 1)
  where BATCHPROCESSINFOID = p_batch_process_info_id;
  
END IF;

IF INSERTING THEN 
  update TB_BATCH_PROCESS_INFO set INSERTEDROWS = (INSERTEDROWS + 1)
  where BATCHPROCESSINFOID = p_batch_process_info_id;
END IF;

IF UPDATING THEN 
  update TB_BATCH_PROCESS_INFO set UPDATEDROWS = (UPDATEDROWS + 1)
  where BATCHPROCESSINFOID = p_batch_process_info_id;
END IF;    

EXCEPTION
    WHEN OTHERS THEN 
      p_batch_process_info_id:=null;

END;

CREATE or REPLACE TRIGGER TX_tb_product
  AFTER INSERT OR UPDATE OR DELETE ON tambos.tb_product
  FOR EACH ROW 

DECLARE
      p_batch_process_info_id number;  
      p_nameTable    varchar2(100):=upper('tb_product');
BEGIN

select max(a.BATCHPROCESSINFOID) into p_batch_process_info_id from TB_BATCH_PROCESS_INFO a
where a.TABLENAME = p_nameTable;

IF DELETING THEN 
  
  update TB_BATCH_PROCESS_INFO set DELETEDROWS = (DELETEDROWS + 1)
  where BATCHPROCESSINFOID = p_batch_process_info_id;
  
END IF;

IF INSERTING THEN 
  update TB_BATCH_PROCESS_INFO set INSERTEDROWS = (INSERTEDROWS + 1)
  where BATCHPROCESSINFOID = p_batch_process_info_id;
END IF;

IF UPDATING THEN 
  update TB_BATCH_PROCESS_INFO set UPDATEDROWS = (UPDATEDROWS + 1)
  where BATCHPROCESSINFOID = p_batch_process_info_id;
END IF;    

EXCEPTION
    WHEN OTHERS THEN 
      p_batch_process_info_id:=null;

END;

CREATE or REPLACE TRIGGER TX_tb_condition_sale
  AFTER INSERT OR UPDATE OR DELETE ON tambos.tb_condition_sale
  FOR EACH ROW 

DECLARE
      p_batch_process_info_id number;  
      p_nameTable    varchar2(100):=upper('tb_condition_sale');
BEGIN

select max(a.BATCHPROCESSINFOID) into p_batch_process_info_id from TB_BATCH_PROCESS_INFO a
where a.TABLENAME = p_nameTable;

IF DELETING THEN 
  
  update TB_BATCH_PROCESS_INFO set DELETEDROWS = (DELETEDROWS + 1)
  where BATCHPROCESSINFOID = p_batch_process_info_id;
  
END IF;

IF INSERTING THEN 
  update TB_BATCH_PROCESS_INFO set INSERTEDROWS = (INSERTEDROWS + 1)
  where BATCHPROCESSINFOID = p_batch_process_info_id;
END IF;

IF UPDATING THEN 
  update TB_BATCH_PROCESS_INFO set UPDATEDROWS = (UPDATEDROWS + 1)
  where BATCHPROCESSINFOID = p_batch_process_info_id;
END IF;    

EXCEPTION
    WHEN OTHERS THEN 
      p_batch_process_info_id:=null;

END;

CREATE or REPLACE TRIGGER TX_tb_product_price
  AFTER INSERT OR UPDATE OR DELETE ON tambos.tb_product_price
  FOR EACH ROW 

DECLARE
      p_batch_process_info_id number;  
      p_nameTable    varchar2(100):=upper('tb_product_price');
BEGIN

select max(a.BATCHPROCESSINFOID) into p_batch_process_info_id from TB_BATCH_PROCESS_INFO a
where a.TABLENAME = p_nameTable;

IF DELETING THEN 
  
  update TB_BATCH_PROCESS_INFO set DELETEDROWS = (DELETEDROWS + 1)
  where BATCHPROCESSINFOID = p_batch_process_info_id;
  
END IF;

IF INSERTING THEN 
  update TB_BATCH_PROCESS_INFO set INSERTEDROWS = (INSERTEDROWS + 1)
  where BATCHPROCESSINFOID = p_batch_process_info_id;
END IF;

IF UPDATING THEN 
  update TB_BATCH_PROCESS_INFO set UPDATEDROWS = (UPDATEDROWS + 1)
  where BATCHPROCESSINFOID = p_batch_process_info_id;
END IF;    

EXCEPTION
    WHEN OTHERS THEN 
      p_batch_process_info_id:=null;

END;

CREATE or REPLACE TRIGGER TX_tb_price_list
  AFTER INSERT OR UPDATE OR DELETE ON tambos.tb_price_list
  FOR EACH ROW 

DECLARE
      p_batch_process_info_id number;  
      p_nameTable    varchar2(100):=upper('tb_price_list');
BEGIN

select max(a.BATCHPROCESSINFOID) into p_batch_process_info_id from TB_BATCH_PROCESS_INFO a
where a.TABLENAME = p_nameTable;

IF DELETING THEN 
  
  update TB_BATCH_PROCESS_INFO set DELETEDROWS = (DELETEDROWS + 1)
  where BATCHPROCESSINFOID = p_batch_process_info_id;
  
END IF;

IF INSERTING THEN 
  update TB_BATCH_PROCESS_INFO set INSERTEDROWS = (INSERTEDROWS + 1)
  where BATCHPROCESSINFOID = p_batch_process_info_id;
END IF;

IF UPDATING THEN 
  update TB_BATCH_PROCESS_INFO set UPDATEDROWS = (UPDATEDROWS + 1)
  where BATCHPROCESSINFOID = p_batch_process_info_id;
END IF;    

EXCEPTION
    WHEN OTHERS THEN 
      p_batch_process_info_id:=null;

END;

CREATE or REPLACE TRIGGER TX_tb_currency
  AFTER INSERT OR UPDATE OR DELETE ON tambos.tb_currency
  FOR EACH ROW 

DECLARE
      p_batch_process_info_id number;  
      p_nameTable    varchar2(100):=upper('tb_currency');
BEGIN

select max(a.BATCHPROCESSINFOID) into p_batch_process_info_id from TB_BATCH_PROCESS_INFO a
where a.TABLENAME = p_nameTable;

IF DELETING THEN 
  
  update TB_BATCH_PROCESS_INFO set DELETEDROWS = (DELETEDROWS + 1)
  where BATCHPROCESSINFOID = p_batch_process_info_id;
  
END IF;

IF INSERTING THEN 
  update TB_BATCH_PROCESS_INFO set INSERTEDROWS = (INSERTEDROWS + 1)
  where BATCHPROCESSINFOID = p_batch_process_info_id;
END IF;

IF UPDATING THEN 
  update TB_BATCH_PROCESS_INFO set UPDATEDROWS = (UPDATEDROWS + 1)
  where BATCHPROCESSINFOID = p_batch_process_info_id;
END IF;    

EXCEPTION
    WHEN OTHERS THEN 
      p_batch_process_info_id:=null;

END;


CREATE or REPLACE TRIGGER TX_tb_zone
  AFTER INSERT OR UPDATE OR DELETE ON tambos.tb_zone
  FOR EACH ROW 

DECLARE
      p_batch_process_info_id number;  
      p_nameTable    varchar2(100):=upper('tb_zone');
BEGIN

select max(a.BATCHPROCESSINFOID) into p_batch_process_info_id from TB_BATCH_PROCESS_INFO a
where a.TABLENAME = p_nameTable;

IF DELETING THEN 
  
  update TB_BATCH_PROCESS_INFO set DELETEDROWS = (DELETEDROWS + 1)
  where BATCHPROCESSINFOID = p_batch_process_info_id;
  
END IF;

IF INSERTING THEN 
  update TB_BATCH_PROCESS_INFO set INSERTEDROWS = (INSERTEDROWS + 1)
  where BATCHPROCESSINFOID = p_batch_process_info_id;
END IF;

IF UPDATING THEN 
  update TB_BATCH_PROCESS_INFO set UPDATEDROWS = (UPDATEDROWS + 1)
  where BATCHPROCESSINFOID = p_batch_process_info_id;
END IF;    

EXCEPTION
    WHEN OTHERS THEN 
      p_batch_process_info_id:=null;

END;