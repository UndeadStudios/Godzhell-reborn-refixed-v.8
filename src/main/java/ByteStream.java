public class ByteStream {

	private byte[] buffer;
	private int offset;

	public ByteStream(byte[] buffer)
	{
		this.buffer = buffer;
		this.offset = 0;
	}

	public void skip(int length)
	{
		offset += length;
	}

	public void setOffset(int position)
	{
		offset = position;
	}
	
	public void setOffset(long position)
	{
		offset = (int) position;
	}

	public int length()
	{
		return buffer.length;
	}
	
	public byte getByte()
	{
		return buffer[offset++];
	}

	public int getUByte()
	{
		return buffer[offset++] & 0xff;
	}

	public int getShort()
	{
		int val = (getByte() << 8) + getByte();
		if(val > 32767)
            		val -= 0x10000;
		return val;
	}

	public int getUShort()
	{
        return (getUByte() << 8) + getUByte();
    }
	
	public int getInt()
	{
		return (getUByte() << 24) + (getUByte() << 16) + (getUByte() << 8) + getUByte();
	}
	
	public long getLong()
	{
		return (getUByte() << 56) + (getUByte() << 48) + (getUByte() << 40) + (getUByte() << 32) + (getUByte() << 24) + (getUByte() << 16) + (getUByte() << 8) + getUByte();
	}
	public int method1606() {
		int var2 = 0;

		int var3;
		for (var3 = this.readUShortSmart(); var3 == 32767; var3 = this.readUShortSmart()) {
			var2 += 32767;
		}

		var2 += var3;
		return var2;
	}
	public int readUShortSmart() {
		int var1 = this.buffer[this.offset] & 0xff;
		return var1 < 128?this.getUByte() : this.getUShort() - '\u8000';
	}
	public int getUSmart()
	{
        int i = buffer[offset] & 0xff;
        if (i < 128) {
        	return getUByte();
        } else {
        	return getUShort() - 32768;
        }
    }
	public int getUSmart2() {
		int baseVal = 0;
		int lastVal = 0;
		while ((lastVal = getUSmart()) == 32767) {
			baseVal += 32767;
		}
		return baseVal + lastVal;
	}
	public int readShort2() {
		offset += 2;
		int i = ((buffer[offset - 2] & 0xff) << 8) + (buffer[offset - 1] & 0xff);
		if(i > 32767)
			i -= 65537;
		return i;
	}
	public String getNString()
    {
		int i = offset;
		while(buffer[offset++] != 0) ;
		return new String(buffer, i, offset - i - 1);
    }

	public byte[] getBytes()
    {
        int i = offset;
        while(buffer[offset++] != 10) ;
        byte abyte0[] = new byte[offset - i - 1];
        System.arraycopy(buffer, i, abyte0, i - i, offset - 1 - i);
        return abyte0;
    }
	
	public byte[] read(int length)
	{
		byte[] b = new byte[length+45000];
		for (int i = 0; i < length; i++)
			b[i] = buffer[offset++];
		return b;
	}

}
	