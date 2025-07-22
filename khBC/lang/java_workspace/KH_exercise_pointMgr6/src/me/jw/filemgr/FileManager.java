package me.jw.filemgr;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import me.jw.model.dto.PointDTO;
import me.jw.model.vo.Grade;

public class FileManager {

	FileInputStream fi;
	FileOutputStream fo;
	ObjectInputStream ois;
	ObjectOutputStream oos;
	PointDTO dto;
	ArrayList<Grade> members;

	public FileManager() {
		super();

	}

	public FileManager(PointDTO dto) {
	    this.dto = dto;
	}
	public FileManager(FileInputStream fi, FileOutputStream fo, ObjectInputStream ois, ObjectOutputStream oos, PointDTO dto) {
		super();
		this.fi = fi;
		this.fo = fo;
		this.ois = ois;
		this.oos = oos;
		this.dto = dto;
	}

	public boolean importMember() {
		try {
			fi = new FileInputStream("membersBackup.txt");
			ois = new ObjectInputStream(fi);
			Object obj = ois.readObject();
			dto.setList((ArrayList<Grade>) obj);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				if(ois==null) {
					return false;
				}
				ois.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return true;
	}

	public  boolean exportMember( ) {
	try {
		fo = new FileOutputStream("membersBackup.txt");
		oos = new ObjectOutputStream(fo);
		oos.writeObject(dto.getList());
		return true;
	} catch (FileNotFoundException e) {
		e.printStackTrace();
		return false;
	} catch (IOException e) {
		e.printStackTrace();
		return false;
	}finally {
		try {
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
		
	}

}
