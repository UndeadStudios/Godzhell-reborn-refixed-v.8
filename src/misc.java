import com.google.common.base.Preconditions;
import com.google.gson.Gson;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.Range;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.zip.GZIPInputStream;

// a collection of misc methods
public class misc {
	
	public static int getCurrentHP(int i, int i1, int i2) {
		double x = (double)i / (double)i1;
		return (int)Math.round(x*i2);
	}

    public static final char playerNameXlateTable[] = {
        '_', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
        'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0',
        '1', '2', '3', '4', '5', '6', '7', '8', '9'
    };

    public static String longToPlayerName(long l) {
        int i = 0;
        char ac[] = new char[12];

        while (l != 0L) {
            long l1 = l;

            l /= 37L;
            ac[11 - i++] = playerNameXlateTable[(int) (l1 - l * 37L)];
        }
        return new String(ac, 12 - i, i);
    }

    public static long playerNameToLong(String s) {
        long l = 0L;

        for (int i = 0; i < s.length() && i < 12; i++) {
            char c = s.charAt(i);

            l *= 37L;
            if (c >= 'A' && c <= 'Z') {
                l += (1 + c) - 65;
            } else if (c >= 'a' && c <= 'z') {
                l += (1 + c) - 97;
            } else if (c >= '0' && c <= '9') {
                l += (27 + c) - 48;
            }
        }
        for (; l % 37L == 0L && l != 0L; l /= 37L) {
            ;
        }
        return l;
    }

    public static void print_debug(String str) {
        System.out.print(str); // comment this line out if you want to get rid of debug messages
    }

    public static void println_debug(String str) {
        System.out.println(str);
    }

    public static void print(String str) {
        System.out.print(str);
    }

    public static void println(String str) {
        System.out.println(str);
    }

    public static String Hex(byte data[]) {
        return Hex(data, 0, data.length);
    }

    public static String Hex(byte data[], int offset, int len) {
        String temp = "";

        for (int cntr = 0; cntr < len; cntr++) {
            int num = data[offset + cntr] & 0xFF;
            String myStr;

            if (num < 16) {
                myStr = "0";
            } else {
                myStr = "";
            }
            temp += myStr + Integer.toHexString(num) + " ";
        }
        return temp.toUpperCase().trim();
    }

    public static int HexToInt(byte data[], int offset, int len) {
        int temp = 0;
        int i = 1000;

        for (int cntr = 0; cntr < len; cntr++) {
            int num = (data[offset + cntr] & 0xFF) * i;

            temp += (int) num;
            if (i > 1) {
                i = i / 1000;
            }
        }
        return temp;
    }

    public static int random(int range) { // 0 till range (range INCLUDED)
        return (int) (java.lang.Math.random() * (range + 1));
    }

    public static int random2(int range) { // 1 till range
        return (int) ((java.lang.Math.random() * range) + 1);
    }

    public static int random3(int range) { // 0 till range
        return (int) (java.lang.Math.random() * range);
    }

    public static int random4(int range) { // 0 till range (range INCLUDED)
        return (int) (java.lang.Math.random() * (range + 1));
    }

    public static long playerNameToInt64(String s) {
        long l = 0L;

        for (int i = 0; i < s.length() && i < 12; i++) {
            char c = s.charAt(i);

            l *= 37L;
            if (c >= 'A' && c <= 'Z') {
                l += (1 + c) - 65;
            } else if (c >= 'a' && c <= 'z') {
                l += (1 + c) - 97;
            } else if (c >= '0' && c <= '9') {
                l += (27 + c) - 48;
            }
        }
        while (l % 37L == 0L && l != 0L) {
            l /= 37L;
        }
        return l;
    }

    private static char decodeBuf[] = new char[4096];
    public static String textUnpack(byte packedData[], int size) {
        int idx = 0, highNibble = -1;

        for (int i = 0; i < size * 2; i++) {
            int val = packedData[i / 2] >> (4 - 4 * (i % 2)) & 0xf;

            if (highNibble == -1) {
                if (val < 13) {
                    decodeBuf[idx++] = xlateTable[val];
                } else {
                    highNibble = val;
                }
            } else {
                decodeBuf[idx++] = xlateTable[((highNibble << 4) + val) - 195];
                highNibble = -1;
            }
        }

        return new String(decodeBuf, 0, idx);
    }

    public static String optimizeText(String text) {
        char buf[] = text.toCharArray();
        boolean endMarker = true; // marks the end of a sentence to make the next char capital

        for (int i = 0; i < buf.length; i++) {
            char c = buf[i];

            if (endMarker && c >= 'a' && c <= 'z') {
                buf[i] -= 0x20; // transform lower case into upper case
                endMarker = false;
            }
            if (c == '.' || c == '!' || c == '?') {
                endMarker = true;
            }
        }
        return new String(buf, 0, buf.length);
    }

    public static void textPack(byte packedData[], java.lang.String text) {
        if (text.length() > 80) {
            text = text.substring(0, 80);
        }
        text = text.toLowerCase();

        int carryOverNibble = -1;
        int ofs = 0;

        for (int idx = 0; idx < text.length(); idx++) {
            char c = text.charAt(idx);
            int tableIdx = 0;

            for (int i = 0; i < xlateTable.length; i++) {
                if (c == xlateTable[i]) {
                    tableIdx = i;
                    break;
                }
            }
            if (tableIdx > 12) {
                tableIdx += 195;
            }
            if (carryOverNibble == -1) {
                if (tableIdx < 13) {
                    carryOverNibble = tableIdx;
                } else {
                    packedData[ofs++] = (byte) (tableIdx);
                }
            } else if (tableIdx < 13) {
                packedData[ofs++] = (byte) ((carryOverNibble << 4) + tableIdx);
                carryOverNibble = -1;
            } else {
                packedData[ofs++] = (byte) ((carryOverNibble << 4)
                        + (tableIdx >> 4));
                carryOverNibble = tableIdx & 0xf;
            }
        }

        if (carryOverNibble != -1) {
            packedData[ofs++] = (byte) (carryOverNibble << 4);
        }
    }

    public static char xlateTable[] = {
        ' ', 'e', 't', 'a', 'o', 'i', 'h', 'n', 's', 'r', 'd', 'l', 'u', 'm',
        'w', 'c', 'y', 'f', 'g', 'p', 'b', 'v', 'k', 'x', 'j', 'q', 'z', '0',
        '1', '2', '3', '4', '5', '6', '7', '8', '9', ' ', '!', '?', '.', ',',
        ':', ';', '(', ')', '-', '&', '*', '\\', '\'', '@', '#', '+', '=',
        '\243', '$', '%', '"', '[', ']', '/'
    };

    // gets the direction between the two given points
    // valid directions are N:0, NE:2, E:4, SE:6, S:8, SW:10, W:12, NW:14
    // the invalid (inbetween) direction are 1,3,5,7,9,11,13,15 i.e. odd integers
    // returns -1, if src and dest are the same
    public static int direction(int srcX, int srcY, int destX, int destY) {
        int dx = destX - srcX, dy = destY - srcY;

        // a lot of cases that have to be considered here ... is there a more sophisticated (and quick!) way?
        if (dx < 0) {
            if (dy < 0) {
                if (dx < dy) {
                    return 11;
                } else if (dx > dy) {
                    return 9;
                } else {
                    return 10;
                }		// dx == dy
            } else if (dy > 0) {
                if (-dx < dy) {
                    return 15;
                } else if (-dx > dy) {
                    return 13;
                } else {
                    return 14;
                }		// -dx == dy
            } else { // dy == 0
                return 12;
            }
        } else if (dx > 0) {
            if (dy < 0) {
                if (dx < -dy) {
                    return 7;
                } else if (dx > -dy) {
                    return 5;
                } else {
                    return 6;
                }		// dx == -dy
            } else if (dy > 0) {
                if (dx < dy) {
                    return 1;
                } else if (dx > dy) {
                    return 3;
                } else {
                    return 2;
                }		// dx == dy
            } else { // dy == 0
                return 4;
            }
        } else { // dx == 0
            if (dy < 0) {
                return 8;
            } else if (dy > 0) {
                return 0;
            } else { // dy == 0
                return -1; // src and dest are the same
            }
        }
    }

    public static byte directionDeltaX[] = new byte[] {
        0, 1, 1, 1, 0, -1, -1, -1 };
    public static byte directionDeltaY[] = new byte[] {
        1, 1, 0, -1, -1, -1, 0, 1 };

    // translates our direction convention to the one used in the protocol
    public static byte xlateDirectionToClient[] = new byte[] {
        1, 2, 4, 7, 6, 5, 3, 0 };

    /**
     * Returns the delta coordinates. Note that the returned Position is not an
     * actual position, instead it's values represent the delta values between
     * the two arguments.
     *
     * @param a
     *            the first position
     * @param b
     *            the second position
     * @return the delta coordinates contained within a position
     */
    public static Position delta(Position a, Position b) {
        return new Position(b.getX() - a.getX(), b.getY() - a.getY());
    }

    public static final boolean goodDistance(Position pos1, Position pos2, int distance) {
        if (pos1 == null || pos2 == null) {
            return false;
        }
        return goodDistance(pos1.getX(), pos1.getY(), pos2.getX(), pos2.getY(), distance) && pos1.getZ() == pos2.getZ();
    }
    public static byte[] getBuffer(File f) throws Exception
    {
        if(!f.exists())
            return null;
        byte[] buffer = new byte[(int) f.length()];
        DataInputStream dis = new DataInputStream(new FileInputStream(f));
        dis.readFully(buffer);
        dis.close();
        byte[] gzipInputBuffer = new byte[999999];
        int bufferlength = 0;
        GZIPInputStream gzip = new GZIPInputStream(new ByteArrayInputStream(buffer));
        do {
            if(bufferlength == gzipInputBuffer.length)
            {
                System.out.println("Error inflating data.\nGZIP buffer overflow.");
                break;
            }
            int readByte = gzip.read(gzipInputBuffer, bufferlength, gzipInputBuffer.length - bufferlength);
            if(readByte == -1)
                break;
            bufferlength += readByte;
        } while(true);
        byte[] inflated = new byte[bufferlength];
        System.arraycopy(gzipInputBuffer, 0, inflated, 0, bufferlength);
        buffer = inflated;
        if(buffer.length < 10)
            return null;
        return buffer;
    }
    public static final boolean goodDistance(int objectX, int objectY, int playerX, int playerY, int distance) {
        int deltaX = objectX - playerX;
        int deltaY = objectY - playerY;
        int trueDistance = ((int) Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2)));
        return trueDistance <= distance;
    }
    public static double distance(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
    }
    public static String replaceBracketsWithArguments(String string, Object...args) {
        for (Object arg : args) {
            int index = string.indexOf("{}");
            Preconditions.checkState(index != -1, "Invalid number of parameters for string replace.");
            string = string.replaceFirst("\\{}", arg == null ? "null" : arg.toString());
        }
        return string;
    }

    public static String capitalize(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (i == 0) {
                s = String.format("%s%s", Character.toUpperCase(s.charAt(0)),
                        s.substring(1));
            }
            if (!Character.isLetterOrDigit(s.charAt(i))) {
                if (i + 1 < s.length()) {
                    s = String.format("%s%s%s", s.subSequence(0, i + 1),
                            Character.toUpperCase(s.charAt(i + 1)),
                            s.substring(i + 2));
                }
            }
        }
        return s;
    }

    public static int randomSearch(int[] elements, int inclusive, int exclusiveLength) {
        Preconditions.checkArgument(exclusiveLength <= elements.length, "The length specified is greater than the length of the array.");
        return elements[RandomUtils.nextInt(inclusive, exclusiveLength)];
    }

    /**
     * Used to determine if the value of the input is a non-negative value. This does permit the value zero as valid input as zero is neither positive nor negative.
     *
     * @param input the input we're trying to determine is a non-negative or not
     * @return {@code} true if the value is greater than negative one, otherwise {@code false}.
     */
    public static boolean isNonNegative(int input) {
        return input > -1;
    }

    public static <T> List<T> jsonArrayToList(Path path, Class<T[]> clazz) {
        try {
            T[] collection = new Gson().fromJson(Files.newBufferedReader(path), clazz);
            return new ArrayList<T>(Arrays.asList(collection));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public static int random(Range<Integer> range) {
        int minimum = range.getMinimum();
        return minimum + random(range.getMaximum() - minimum);
    }

    public static Random random = new Random();
    public static int random(final int min, final int max) {
        return min + (max == min ? 0 : random.nextInt(max - min));
    }

    public static <T> T randomSearch(T[] elements, int inclusive, int exclusiveLength) {
        Preconditions.checkArgument(exclusiveLength <= elements.length, "The length specified is greater than the length of the array.");
        return elements[RandomUtils.nextInt(inclusive, exclusiveLength)];
    }
    public static String[] nullToEmpty(int length) {
        String[] output = new String[length];
        Arrays.fill(output, 0, length, "");
        return output;
    }
}

