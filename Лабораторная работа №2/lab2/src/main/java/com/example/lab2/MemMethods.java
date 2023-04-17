package com.example.lab2;


import com.sun.jna.*;


public class MemMethods {
    Pointer address;
    int pid;
    CLibrary libc = (CLibrary) Native.loadLibrary("c", CLibrary.class);

    public MemMethods(int pid, String adrStr){
        this.pid = pid;
        address = new Pointer(Long.parseLong(adrStr, 16));
    }

    public int read(){
        libc.ptrace(CLibrary.PTRACE_ATTACH, pid, null,0);
        int peek = libc.ptrace(CLibrary.PTRACE_PEEKDATA, pid, address, 0);
        libc.ptrace(CLibrary.PTRACE_DETACH, pid, null,0);
        return peek;
    }

    public void write(int value){
        libc.ptrace(CLibrary.PTRACE_ATTACH, pid, null,0);
        libc.ptrace(CLibrary.PTRACE_POKEDATA, pid, address, value);
        libc.ptrace(CLibrary.PTRACE_DETACH, pid, null,0);
    }
    public String getAddress(){
        return address.toString();
    }

}
interface CLibrary extends Library
{
    int PTRACE_ATTACH = 16;
    int PTRACE_DETACH = 17;
    int PTRACE_PEEKDATA = 2;
    int PTRACE_POKEDATA = 5;
    int ptrace(int request, int pid, Pointer addr, int data);

}

