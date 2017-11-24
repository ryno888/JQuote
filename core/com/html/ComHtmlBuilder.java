/*
 * Class 
 * @filename ComHtmlBuilder 
 * @encoding UTF-8
 * @author Liquid Edge Solutions  * 
 * @copyright Copyright Liquid Edge Solutions. All rights reserved. * 
 * @programmer Ryno van Zyl * 
 * @date 24 Nov 2017 * 
 */
package core.com.html;

import core.com.utils.ComHashmap;
import j2html.TagCreator;
import java.util.HashMap;

/**
 *
 * @author Ryno
 */
public class ComHtmlBuilder {
    StringBuilder html = new StringBuilder();
    //--------------------------------------------------------------------------
    public ComHtmlBuilder label(String label, HashMap options){
        
        options = ComHashmap.merge(new HashMap(){{
            put("multiple", false);
            put("customsql", false);
        }}, options);
        
        String css = this.get_css(options);
        String attr = this.get_attributes(options);
        html.append(TagCreator.label(label).withClass(css).attr(attr).render());
        return this;
    }
    //--------------------------------------------------------------------------
    public ComHtmlBuilder img(String src, HashMap options){
        options = ComHashmap.merge(new HashMap(){{
            put("multiple", false);
            put("customsql", false);
        }}, options);
        
        String css = this.get_css(options);
        String attr = this.get_attributes(options);
        html.append(TagCreator.img().withSrc(src).withClass(css).attr(attr).render());
        return this;
    }
    //--------------------------------------------------------------------------
    private String get_css(HashMap <String, Object> options){
        StringBuilder css = new StringBuilder();
        options.forEach((key, value) -> {
            if(key.codePointAt(0) == '.' && value.equals(true)){
                if(!css.toString().isEmpty()){ css.append(" "); }
                css.append(key.substring(1));
            }
        });
        return css.toString().isEmpty() ? null : css.toString();
    }
    //--------------------------------------------------------------------------
    private String get_attributes(HashMap <String, Object> options){
        StringBuilder attr = new StringBuilder();
        options.forEach((key, value) -> {
            if(key.codePointAt(0) == '@'){
                if(!attr.toString().isEmpty()){ attr.append(" "); }
                attr.append(key.substring(1));
                attr.append("=");
                attr.append("'").append(value.toString()).append("'");
            }
        });
        return attr.toString().isEmpty() ? null : attr.toString();
    }
    //--------------------------------------------------------------------------
    public String get_html(){
        return this.html.toString();
    }
    //--------------------------------------------------------------------------
}
