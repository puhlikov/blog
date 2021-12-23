package com.epam.training.filters;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.awt.*;
import java.util.regex.Pattern;

public class XSSWrapperRQ extends HttpServletRequestWrapper{
    public XSSWrapperRQ(HttpServletRequest request) {
        super(request);
    }

    private static Pattern [] patterns = new Pattern[]{
            //Script fragments
            Pattern.compile("<script>(.*?)</script>", Pattern.CASE_INSENSITIVE),
            //src = '...'
            Pattern.compile("src[\r\n]*=[\r\n]*\\\'(.*?)\\\'", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
            // lonely script tags
            Pattern.compile("</script>", Pattern.CASE_INSENSITIVE),
            Pattern.compile("<sript(.*?)>", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
            //javascript:...
            Pattern.compile("javascript:", Pattern.CASE_INSENSITIVE),
            // onload(...)=...
            Pattern.compile("onload(.*?)=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL)
    };

    @Override
    public String [] getParameterValues (String value){
            String[] values = super.getParameterValues(value);
            if (values == null ){
                return values;
            }
            int count = values.length;
            String[] encodedValues = new String[count];
            for (int i = 0; i < count; i++){
                encodedValues[i] = stripXSS (values [i]);
            }
            return encodedValues;
    }

    @Override
    public String getParameter (String parameter){
        String value = super.getParameter(parameter);
        return stripXSS(value);
    }

    private String stripXSS(String value){
        if (value != null){
            value = value
                    .replaceAll("\0","")
                    .replaceAll(" ","")
                    .replaceAll("script", "")
                    .replaceAll("<", "&lt;")
                    .replaceAll(">", "&gt;");
            //remove all section that use in pattern
            for (Pattern scriptPattern: patterns){
                value = scriptPattern
                        .matcher(value)
                        .replaceAll("");
            }
        }
        return value;
    }
}
