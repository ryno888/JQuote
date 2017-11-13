/*
 * Class 
 * @filename DB_quote_item 
 * @encoding UTF-8
 * @author Liquid Edge Solutions  * 
 * @copyright Copyright Liquid Edge Solutions. All rights reserved. * 
 * @programmer Ryno van Zyl * 
 * @date 25 Aug 2017 * 
 */
package app.db;

import core.com.db.ComDBTable;
import core.com.string.ComString;
import core.interfaces.DB_datatype;
import core.interfaces.DB_table_interface;
import java.util.HashMap;

/**
 *
 * @author Ryno
 */
public class DB_person extends ComDBTable implements DB_table_interface{
	
    //--------------------------------------------------------------------------
    public DB_person(){ this.get_fromdefault(); }
    //--------------------------------------------------------------------------
    public DB_person(Object mixed){ this.get_fromdb(mixed); }
    //--------------------------------------------------------------------------
    @Override
    public HashMap <String, DB_datatype.Datatype> get_field_arr() {
        HashMap arr = new HashMap();
        arr.put("per_id"			, DB_datatype.Datatype.INT);
        arr.put("per_name"			, DB_datatype.Datatype.VARCHAR);
        arr.put("per_firstname"		, DB_datatype.Datatype.VARCHAR);
        arr.put("per_lastname"		, DB_datatype.Datatype.VARCHAR);
        arr.put("per_email"			, DB_datatype.Datatype.VARCHAR);
        arr.put("per_trading_name"	, DB_datatype.Datatype.VARCHAR);
        arr.put("per_contact_nr"	, DB_datatype.Datatype.VARCHAR);
        arr.put("per_account_nr"	, DB_datatype.Datatype.VARCHAR);
        arr.put("per_is_active"		, DB_datatype.Datatype.TINYINT);
        arr.put("per_birthday"		, DB_datatype.Datatype.DATETIME);
        return arr;
    }
    //--------------------------------------------------------------------------
    @Override
    public String get_key() { return "per_id"; }
    //--------------------------------------------------------------------------
    @Override
    public String get_table() { return "person"; }
    //--------------------------------------------------------------------------
    @Override
    public String get_name() { return "Person"; }
    //--------------------------------------------------------------------------
    @Override
    public String get_display() { return "per_name"; }
    //--------------------------------------------------------------------------
	// methods
    //--------------------------------------------------------------------------
    @Override
    public void on_insert() { 
		this.set("per_account_nr", ComString.pad("PER", 7, '0')+this.get_next_id());
	}
    //--------------------------------------------------------------------------
    @Override
    public void on_update() { 
		if(this.is_empty("per_account_nr")){
			this.set("per_account_nr", ComString.pad("PER", 7, '0')+this.get_id());
		}
	}
    //--------------------------------------------------------------------------
    @Override
    public void on_delete() { 
		DB_address address = new DB_address("add_ref_person = " + this.get_id());
		if(!address.is_empty()){ address.delete(); }
	}
    //--------------------------------------------------------------------------
    public String format_name() { 
		return this.get("per_firstname") + " " + this.get("per_lastname");
	}
    //--------------------------------------------------------------------------
    public DB_address get_address() { 
		DB_address address = null;
		if(!this.is_empty("per_id")){
			address = new DB_address("add_ref_person = " + this.get("per_id"));
			if(address.is_empty()){
				address = new DB_address();
				address.set("add_ref_person", this.get("per_id"));
			}
		}
		return address;
	}
    //--------------------------------------------------------------------------
}
