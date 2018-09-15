package by.htp.project.human_resource.util.listener;

import java.sql.SQLException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import by.htp.project.human_resource.util.poolconnection.ConnectionPool;

public class ContextListener implements ServletContextListener {

	/** Field for logging {@link LoggerFactory} */
	private Logger logger = LoggerFactory.getLogger(ContextListener.class);

	@Override
	public void contextInitialized(ServletContextEvent sce) {
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {

		ConnectionPool connectionPool = ConnectionPool.getInstance();
		try {
			connectionPool.dispose();
		} catch (SQLException e) {
			logger.error("ContextListener: contextDestroyed " + e);
		}
	}
}
