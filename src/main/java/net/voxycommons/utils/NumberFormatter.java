package net.voxycommons.utils;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class NumberFormatter
{
    public static final double LOG = 6.907755278982137;
    public static final Object[][] VALUES;
    public static final DecimalFormat FORMAT;
    
    public static String format(final double number) {
        if (number == 0.0) {
            return NumberFormatter.FORMAT.format(number);
        }
        final int index = (int)(Math.log(number) / 6.907755278982137);
        return NumberFormatter.FORMAT.format(number / (double)NumberFormatter.VALUES[1][index]) + NumberFormatter.VALUES[0][index];
    }
    
    static {
        VALUES = new Object[][] { { "", "K", "M", "B", "T", "Q", "QQ", "S", "SS", "O", "N", "D", "UN", "DD", "TR", "QT", "QN", "SD", "SPD", "OD", "ND", "VG", "UVG", "DVG", "TVG", "QTV" }, { 1.0, 1000.0, 1000000.0, 1.0E9, 1.0E12, 1.0E15, 1.0E18, 1.0E21, 1.0E24, 1.0E27, 1.0E30, 1.0E33, 1.0E36, 1.0E39, 1.0E42, 1.0E45, 1.0E48, 1.0E51, 1.0E54, 1.0E57, 1.0E60, 1.0E63, 1.0E66, 1.0E69, 1.0E72 } };
        FORMAT = new DecimalFormat("#,###.##", new DecimalFormatSymbols(new Locale("pt", "BR")));
    }
}
