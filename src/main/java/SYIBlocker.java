import java.util.ArrayList;
import java.util.Iterator;

public class SYIBlocker
{

    public SYIBlocker()
    {
    }

    public static final void start()
    {
        addCrasher("SYIpkpker");
    }

    public static final void addCrasher(String s)
    {
        Names.add(s.toLowerCase());
    }

    public static final boolean bannedSYI(String s)
    {
        s = s.toLowerCase();
        for(Iterator<String> iterator = Names.iterator(); iterator.hasNext();)
        {
            String s1 = (String)iterator.next();
            if(s.contains(s1))
                return true;
        }

        char ac[] = s.toCharArray();
        int i = ac.length;
        for(int j = 0; j < i; j++)
        {
            Character character = Character.valueOf(ac[j]);
            if(!Character.isLetterOrDigit(character.charValue()) && Character.isSpaceChar(character.charValue()) && !Character.isSpaceChar(character.charValue()))
                return true;
        }

        return false;
    }

    public static final void banIP(String s)
    {
        Addresses.add(s.toLowerCase());
    }

    public static final boolean bannedIP(String s)
    {
        s = s.toLowerCase();
        for(Iterator<String> iterator = Addresses.iterator(); iterator.hasNext();)
        {
            String s1 = (String)iterator.next();
            if(s1.equals(s))
                return true;
        }

        return false;
    }

    public static ArrayList<String> Names = new ArrayList<String>();
    public static ArrayList<String> Addresses = new ArrayList<String>();

}
