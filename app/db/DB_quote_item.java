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
public class DB_quote_item extends ComDBTable implements DB_table_interface{
	
    //--------------------------------------------------------------------------
    public DB_quote_item(){ this.get_fromdefault(); }
    //--------------------------------------------------------------------------
    public DB_quote_item(Object mixed){ this.get_fromdb(mixed); }
    //--------------------------------------------------------------------------
    @Override
    public HashMap <String, DB_datatype.Datatype> get_field_arr() {
        HashMap arr = new HashMap();
        arr.put("qut_id"			, DB_datatype.Datatype.INT);
        arr.put("qut_name"			, DB_datatype.Datatype.VARCHAR);
        arr.put("qut_unit"			, DB_datatype.Datatype.INT);
        arr.put("qut_unit_price"	, DB_datatype.Datatype.DOUBLE);
        arr.put("qut_price"			, DB_datatype.Datatype.DOUBLE);
        return arr;
    }
    //--------------------------------------------------------------------------
    @Override public String get_key() { return "qut_id"; }
    //--------------------------------------------------------------------------
    @Override public String get_table() { return "quote_item"; }
    //--------------------------------------------------------------------------
    @Override public String get_name() { return "Quote Item"; }
    //--------------------------------------------------------------------------
    @Override public String get_display() { return "qut_name"; }
    //--------------------------------------------------------------------------
	// methods
    //--------------------------------------------------------------------------
    //--------------------------------------------------------------------------
}
