/*
 * Class 
 * @filename DB_invoice 
 * @encoding UTF-8
 * @author Liquid Edge Solutions  * 
 * @copyright Copyright Liquid Edge Solutions. All rights reserved. * 
 * @programmer Ryno van Zyl * 
 * @date 25 Aug 2017 * 
 */
package app.db;

import core.com.db.ComDBTable;
import core.interfaces.DB_datatype;
import core.interfaces.DB_table_interface;
import java.util.HashMap;

/**
 *
 * @author Ryno
 */
public class DB_invoice_item extends ComDBTable implements DB_table_interface{
	
    //--------------------------------------------------------------------------
    public DB_invoice_item(){ this.get_fromdefault(); }
    //--------------------------------------------------------------------------
    public DB_invoice_item(Object mixed){ this.get_fromdb(mixed); }
    //--------------------------------------------------------------------------
    @Override
    public HashMap <String, DB_datatype.Datatype> get_field_arr() {
        HashMap arr = new HashMap();
        arr.put("ini_id"			, DB_datatype.Datatype.INT);
        arr.put("ini_ref_invoice"               , DB_datatype.Datatype.REFERENCE.set_reference("invoice"));
        arr.put("ini_ref_quote_item"            , DB_datatype.Datatype.REFERENCE.set_reference("quote_item"));
        return arr;
    }
    //--------------------------------------------------------------------------
    @Override public String get_key() { return "ini_id"; }
    //--------------------------------------------------------------------------
    @Override public String get_table() { return "invoice_item"; }
    //--------------------------------------------------------------------------
    @Override public String get_name() { return "Invoice Item"; }
    //--------------------------------------------------------------------------
    @Override public String get_display() { return "ini_ref_invoice"; }
    //--------------------------------------------------------------------------
	// methods
    //--------------------------------------------------------------------------
    public DB_quote_item get_quote_item() {
        return new DB_quote_item(this.get("ini_ref_quote_item"));
    }
    //--------------------------------------------------------------------------
}
