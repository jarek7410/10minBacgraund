package sample.dataOperation;

        import java.io.*;

public class SaveLoad {
    /**
     * constructor
     * @param saveFileName the name of file which contain data
     */
    public SaveLoad(String saveFileName){
        fileName=saveFileName;
    }
    private String fileName;

    /**
     * you can change the name of file wich contain save data
     * @param fileName the name of file which contain data
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * you can get the name of file wich contein save data
     * @return you get String with name of file wich contain data
     */
    public String getFileName(){
        return this.fileName;
    }

    private DataInputStream inputStream = null;
    private DataOutputStream outputStream = null;



    public void openSaveStream () throws FileNotFoundException{
        outputStream = new DataOutputStream(new FileOutputStream(fileName));
    }
    public void closeSavestream () throws IOException{
        if (outputStream != null)
            outputStream.close();

    }
    public void writeBoolean (boolean a) throws IOException {
        outputStream.writeBoolean(a);
    }
    public void writeShort (short  a) throws IOException {
        outputStream.writeShort(a);
    }
    public void writeInt (int a) throws IOException {
        outputStream.writeInt(a);
    }
    public void writeLong (long a) throws IOException {
        outputStream.writeLong(a);
    }
    public void writeFloat (float a) throws IOException {
        outputStream.writeFloat(a);
    }
    public void writeDouble (double a) throws IOException {
        outputStream.writeDouble(a);
    }
    public void writeChar (char a) throws IOException {
        outputStream.writeChar(a);
    }
    public void writeString(String a) throws IOException {
        outputStream.writeInt(a.length());
        outputStream.writeChars(a);
    }

    public void openLoadStream() throws FileNotFoundException {
        inputStream = new DataInputStream(new FileInputStream(fileName));
    }
    public void closeLoadStream() throws IOException {
        if (inputStream != null)
        inputStream.close();
    }
    public boolean readBoolean() throws IOException {
        return inputStream.readBoolean();
    }
    public short readShort() throws IOException {
        return inputStream.readShort();
    }
    public int readInt() throws IOException {
        return inputStream.readInt();
    }
    public long readLong() throws IOException {
        return inputStream.readLong();
    }
    public float readFloat() throws IOException {
        return inputStream.readFloat();
    }
    public double readDouble() throws IOException {
        return inputStream.readDouble();
    }
    public char readChar() throws IOException {
        return inputStream.readChar();
    }
    public String readString() throws IOException {
        String s="";

        for(int i=0;i<inputStream.readInt();i++)
            s+=inputStream.readChar();
        return s;
    }



}
