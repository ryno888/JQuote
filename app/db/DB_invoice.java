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
public class DB_invoice extends ComDBTable implements DB_table_interface{
	
    //--------------------------------------------------------------------------
    public DB_invoice(){ this.get_fromdefault(); }
    //--------------------------------------------------------------------------
    public DB_invoice(Object mixed){ this.get_fromdb(mixed); }
    //--------------------------------------------------------------------------
    @Override
    public HashMap <String, DB_datatype.Datatype> get_field_arr() {
        HashMap arr = new HashMap();
        arr.put("inv_id"			, DB_datatype.Datatype.INT);
        arr.put("inv_number"			, DB_datatype.Datatype.VARCHAR);
        arr.put("inv_ref_person"                , DB_datatype.Datatype.REFERENCE.set_reference("person"));
        arr.put("inv_total_excl"                , DB_datatype.Datatype.DOUBLE);
        arr.put("inv_date_created"              , DB_datatype.Datatype.DATETIME);
        return arr;
    }
    //--------------------------------------------------------------------------
    @Override public String get_key() { return "inv_id"; }
    //--------------------------------------------------------------------------
    @Override public String get_table() { return "invoice"; }
    //--------------------------------------------------------------------------
    @Override public String get_name() { return "Invoice"; }
    //--------------------------------------------------------------------------
    @Override public String get_display() { return "inv_number"; }
    //--------------------------------------------------------------------------
	// methods
    //--------------------------------------------------------------------------
    public String generate_invoice_nr() {
        return "121212";
    }
    //--------------------------------------------------------------------------
}
