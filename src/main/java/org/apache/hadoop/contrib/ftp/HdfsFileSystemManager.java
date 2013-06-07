package org.apache.hadoop.contrib.ftp;

import java.io.File;

import org.apache.ftpserver.ftplet.FileSystemManager;
import org.apache.ftpserver.ftplet.FileSystemView;
import org.apache.ftpserver.ftplet.FtpException;
import org.apache.ftpserver.ftplet.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Impelented FileSystemManager to use HdfsFileSystemView
 */
public class HdfsFileSystemManager implements FileSystemManager {
	public FileSystemView createFileSystemView(User user) throws FtpException {
		// create home if does not exist
		String homeDirStr = user.getHomeDirectory();
		FileSystemView view = new HdfsFileSystemView(user);
		view.changeDirectory(homeDirStr);
		return view;
	}
}
