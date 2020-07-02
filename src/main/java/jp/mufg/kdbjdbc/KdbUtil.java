package jp.mufg.kdbjdbc;

import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.function.Function;

public class KdbUtil {
    private static final int STRING_BUFFER_INITIAL_CAPACITY = 1000;

    private static final ThreadLocal<Function<Timestamp, String>> TIMESTAMP_FORMAT = new ThreadLocal<Function<Timestamp, String>>()
    {
        final SimpleDateFormat datetime_format = new SimpleDateFormat("yyyy.MM.dd'D'HH:mm:ss");
        final DecimalFormat nano_format = new DecimalFormat("000000000");
        @Override
        protected Function<Timestamp, String> initialValue()
        {
            return new Function<Timestamp, String>() {
                @Override
                public String apply(Timestamp value) {
                    if(value == null)
                        return null;
                    return datetime_format.format(value) + "." + nano_format.format(value.getNanos());
                }
            };
        }
    };

    private KdbUtil() {}

    static String toVarChar(Timestamp ts) {
        return TIMESTAMP_FORMAT.get().apply(ts);
    }
    
    //@VisibleForTesting
    static String toVarChar(int[] a)
    {
        //StringBuilder with pre allocated is faster than Stream.
        StringBuilder sb = new StringBuilder(STRING_BUFFER_INITIAL_CAPACITY);
        for (int i = 0; i < a.length; i++)
        {
            if (i > 0)
                sb.append(" ");
            if (a[i] == Integer.MIN_VALUE) {
                sb.append("0Ni"); //null value
            } else {
                sb.append(a[i]);
            }
        }
        return sb.toString();
    }

    //@VisibleForTesting
    static String toVarChar(long[] a)
    {
        //StringBuilder with pre allocated is faster than Stream.
        StringBuilder sb = new StringBuilder(STRING_BUFFER_INITIAL_CAPACITY);
        for (int i = 0; i < a.length; i++)
        {
            if (i > 0)
                sb.append(" ");
            if (a[i] == Long.MIN_VALUE) {
                sb.append("0Nj"); //null value
            } else {
                sb.append(a[i]);
            }
        }
        return sb.toString();
    }

    //@VisibleForTesting
    static String toVarChar(double[] a)
    {
        //StringBuilder with pre allocated is faster than Stream.
        StringBuilder sb = new StringBuilder(STRING_BUFFER_INITIAL_CAPACITY);
        for (int i = 0; i < a.length; i++)
        {
            if (i > 0)
                sb.append(" ");
            sb.append(a[i]);
        }
        return sb.toString();
    }

    //@VisibleForTesting
    static String toVarChar(byte[] a)
    {
        //TODO use apache-codec Hex library
        StringBuilder s = new StringBuilder(a.length * 2 + 2);
        s.append("0x");
        for(int i = 0; i < a.length; i++) {
            byte num = a[i];
            s.append(Character.forDigit((num >> 4) & 0xF, 16));
            s.append(Character.forDigit((num & 0xF), 16));
        }
        return s.toString();
    }

    //@VisibleForTesting
    static String toVarChar(Timestamp[] timestamps)
    {
        //StringBuilder with pre allocated is faster than Stream.
        StringBuilder sb = new StringBuilder(STRING_BUFFER_INITIAL_CAPACITY);
        for (int i = 0; i < timestamps.length; i++)
        {
            if (i > 0)
                sb.append(" ");
            if (timestamps[i].getTime() == Long.MIN_VALUE) {
                sb.append("0Np");
            } else {
                sb.append(toVarChar(timestamps[i]));
            }
        }
        return sb.toString();
    }

    static String symbolToVarChar(String value) {
        //symbol
        if (value == null) {
            return "`";
        }
        else {
            return "`" + String.valueOf(value);
        }                        
    } 

    //@VisibleForTesting
    static String toVarChar(String[] symbols)
    {
        //StringBuilder with pre allocated is faster than Stream.
        StringBuilder sb = new StringBuilder(STRING_BUFFER_INITIAL_CAPACITY);
        for (int i = 0; i < symbols.length; i++)
        {
            sb.append(symbolToVarChar(symbols[i]));
        }
        return sb.toString();
    }
}