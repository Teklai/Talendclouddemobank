
package talendclouddemobank.chia_matching_distances_2_0_1;

import routines.DataOperation;
import routines.TalendDataGenerator;
import routines.DataQuality;
import routines.Relational;
import routines.DataQualityDependencies;
import routines.Mathematical;
import routines.SQLike;
import routines.Numeric;
import routines.r;
import routines.TalendStringUtil;
import routines.TalendString;
import routines.DQTechnical;
import routines.MDM;
import routines.StringHandling;
import routines.DataMasking;
import routines.TalendDate;
import routines.DqStringHandling;
import routines.system.*;
import routines.system.api.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.math.BigDecimal;
import java.io.ByteArrayOutputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.util.Comparator;

@SuppressWarnings("unused")

/**
 * Job: CHIA_Matching_Distances_2 Purpose: <br>
 * Description: <br>
 * 
 * @author Teklai, Hailemichael
 * @version 8.0.1.20250704_1436-patch
 * @status
 */
public class CHIA_Matching_Distances_2 implements TalendJob {
	static {
		System.setProperty("TalendJob.log", "CHIA_Matching_Distances_2.log");
	}

	private static org.apache.logging.log4j.Logger log = org.apache.logging.log4j.LogManager
			.getLogger(CHIA_Matching_Distances_2.class);

	static {
		String javaUtilLoggingConfigFile = System.getProperty("java.util.logging.config.file");
		if (javaUtilLoggingConfigFile == null) {
			setupDefaultJavaUtilLogging();
		}
	}

	/**
	 * This class replaces the default {@code System.err} stream used by Java Util
	 * Logging (JUL). You can use your own configuration through the
	 * {@code java.util.logging.config.file} system property, enabling you to
	 * specify an external logging configuration file for tailored logging setup.
	 */
	public static class StandardConsoleHandler extends java.util.logging.StreamHandler {
		public StandardConsoleHandler() {
			// Set System.out as default log output stream
			super(System.out, new java.util.logging.SimpleFormatter());
		}

		/**
		 * Publish a {@code LogRecord}. The logging request was made initially to a
		 * {@code Logger} object, which initialized the {@code LogRecord} and forwarded
		 * it here.
		 *
		 * @param record description of the log event. A null record is silently ignored
		 *               and is not published
		 */
		@Override
		public void publish(java.util.logging.LogRecord record) {
			super.publish(record);
			flush();
		}

		/**
		 * Override {@code StreamHandler.close} to do a flush but not to close the
		 * output stream. That is, we do <b>not</b> close {@code System.out}.
		 */
		@Override
		public void close() {
			flush();
		}
	}

	protected static void setupDefaultJavaUtilLogging() {
		java.util.logging.LogManager logManager = java.util.logging.LogManager.getLogManager();

		// Get the root logger
		java.util.logging.Logger rootLogger = logManager.getLogger("");

		// Remove existing handlers to set standard console handler only
		java.util.logging.Handler[] handlers = rootLogger.getHandlers();
		for (java.util.logging.Handler handler : handlers) {
			rootLogger.removeHandler(handler);
		}

		rootLogger.addHandler(new StandardConsoleHandler());
		rootLogger.setLevel(java.util.logging.Level.INFO);
	}

	protected static boolean isCBPClientPresent() {
		boolean isCBPClientPresent = false;
		try {
			Class.forName("org.talend.metrics.CBPClient");
			isCBPClientPresent = true;
		} catch (java.lang.ClassNotFoundException e) {
		}
		return isCBPClientPresent;
	}

	protected static void logIgnoredError(String message, Throwable cause) {
		log.error(message, cause);

	}

	public final Object obj = new Object();

	// for transmiting parameters purpose
	private Object valueObject = null;

	public Object getValueObject() {
		return this.valueObject;
	}

	public void setValueObject(Object valueObject) {
		this.valueObject = valueObject;
	}

	private final static String defaultCharset = java.nio.charset.Charset.defaultCharset().name();

	private final static String utf8Charset = "UTF-8";

	public static String taskExecutionId = null;

	public static String jobExecutionId = java.util.UUID.randomUUID().toString();;

	private final static boolean isCBPClientPresent = isCBPClientPresent();

	// contains type for every context property
	public class PropertiesWithType extends java.util.Properties {
		private static final long serialVersionUID = 1L;
		private java.util.Map<String, String> propertyTypes = new java.util.HashMap<>();

		public PropertiesWithType(java.util.Properties properties) {
			super(properties);
		}

		public PropertiesWithType() {
			super();
		}

		public void setContextType(String key, String type) {
			propertyTypes.put(key, type);
		}

		public String getContextType(String key) {
			return propertyTypes.get(key);
		}
	}

	// create and load default properties
	private java.util.Properties defaultProps = new java.util.Properties();

	// create application properties with default
	public class ContextProperties extends PropertiesWithType {

		private static final long serialVersionUID = 1L;

		public ContextProperties(java.util.Properties properties) {
			super(properties);
		}

		public ContextProperties() {
			super();
		}

		public void synchronizeContext() {

			if (MySQL_CDCF_Password != null) {

				this.setProperty("MySQL_CDCF_Password", MySQL_CDCF_Password.toString());

			}

			if (MySQL_CDCF_Port != null) {

				this.setProperty("MySQL_CDCF_Port", MySQL_CDCF_Port.toString());

			}

			if (MySQL_CDCF_Server != null) {

				this.setProperty("MySQL_CDCF_Server", MySQL_CDCF_Server.toString());

			}

			if (MySQL_CDCF_Database != null) {

				this.setProperty("MySQL_CDCF_Database", MySQL_CDCF_Database.toString());

			}

			if (MySQL_CDCF_AdditionalParams != null) {

				this.setProperty("MySQL_CDCF_AdditionalParams", MySQL_CDCF_AdditionalParams.toString());

			}

			if (MySQL_CDCF_Login != null) {

				this.setProperty("MySQL_CDCF_Login", MySQL_CDCF_Login.toString());

			}

		}

		// if the stored or passed value is "<TALEND_NULL>" string, it mean null
		public String getStringValue(String key) {
			String origin_value = this.getProperty(key);
			if (NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY.equals(origin_value)) {
				return null;
			}
			return origin_value;
		}

		public java.lang.String MySQL_CDCF_Password;

		public java.lang.String getMySQL_CDCF_Password() {
			return this.MySQL_CDCF_Password;
		}

		public String MySQL_CDCF_Port;

		public String getMySQL_CDCF_Port() {
			return this.MySQL_CDCF_Port;
		}

		public String MySQL_CDCF_Server;

		public String getMySQL_CDCF_Server() {
			return this.MySQL_CDCF_Server;
		}

		public String MySQL_CDCF_Database;

		public String getMySQL_CDCF_Database() {
			return this.MySQL_CDCF_Database;
		}

		public String MySQL_CDCF_AdditionalParams;

		public String getMySQL_CDCF_AdditionalParams() {
			return this.MySQL_CDCF_AdditionalParams;
		}

		public String MySQL_CDCF_Login;

		public String getMySQL_CDCF_Login() {
			return this.MySQL_CDCF_Login;
		}
	}

	protected ContextProperties context = new ContextProperties(); // will be instanciated by MS.

	public ContextProperties getContext() {
		return this.context;
	}

	protected java.util.Map<String, String> defaultProperties = new java.util.HashMap<String, String>();
	protected java.util.Map<String, String> additionalProperties = new java.util.HashMap<String, String>();

	public java.util.Map<String, String> getDefaultProperties() {
		return this.defaultProperties;
	}

	public java.util.Map<String, String> getAdditionalProperties() {
		return this.additionalProperties;
	}

	private final String jobVersion = "0.1";
	private final String jobName = "CHIA_Matching_Distances_2";
	private final String projectName = "TALENDCLOUDDEMOBANK";
	public Integer errorCode = null;
	private String currentComponent = "";
	public static boolean isStandaloneMS = Boolean.valueOf("false");

	private void s(final String component) {
		try {
			org.talend.metrics.DataReadTracker.setCurrentComponent(jobName, component);
		} catch (Exception | NoClassDefFoundError e) {
			// ignore
		}
	}

	private void mdc(final String subJobName, final String subJobPidPrefix) {
		mdcInfo.forEach(org.slf4j.MDC::put);
		org.slf4j.MDC.put("_subJobName", subJobName);
		org.slf4j.MDC.put("_subJobPid", subJobPidPrefix + subJobPidCounter.getAndIncrement());
	}

	private void sh(final String componentId) {
		ok_Hash.put(componentId, false);
		start_Hash.put(componentId, System.currentTimeMillis());
	}

	{
		s("none");
	}

	private String cLabel = null;

	private final java.util.Map<String, Object> globalMap = new java.util.HashMap<String, Object>();
	private final static java.util.Map<String, Object> junitGlobalMap = new java.util.HashMap<String, Object>();

	private final java.util.Map<String, Long> start_Hash = new java.util.HashMap<String, Long>();
	private final java.util.Map<String, Long> end_Hash = new java.util.HashMap<String, Long>();
	private final java.util.Map<String, Boolean> ok_Hash = new java.util.HashMap<String, Boolean>();
	public final java.util.List<String[]> globalBuffer = new java.util.ArrayList<String[]>();

	private final JobStructureCatcherUtils talendJobLog = new JobStructureCatcherUtils(jobName,
			"_D2ItsLx2Ee-ILekM8jCPpA", "0.1");
	private org.talend.job.audit.JobAuditLogger auditLogger_talendJobLog = null;

	private RunStat runStat = new RunStat(talendJobLog, System.getProperty("audit.interval"));

	// OSGi DataSource
	private final static String KEY_DB_DATASOURCES = "KEY_DB_DATASOURCES";

	private final static String KEY_DB_DATASOURCES_RAW = "KEY_DB_DATASOURCES_RAW";

	public void setDataSources(java.util.Map<String, javax.sql.DataSource> dataSources) {
		java.util.Map<String, routines.system.TalendDataSource> talendDataSources = new java.util.HashMap<String, routines.system.TalendDataSource>();
		for (java.util.Map.Entry<String, javax.sql.DataSource> dataSourceEntry : dataSources.entrySet()) {
			talendDataSources.put(dataSourceEntry.getKey(),
					new routines.system.TalendDataSource(dataSourceEntry.getValue()));
		}
		globalMap.put(KEY_DB_DATASOURCES, talendDataSources);
		globalMap.put(KEY_DB_DATASOURCES_RAW, new java.util.HashMap<String, javax.sql.DataSource>(dataSources));
	}

	public void setDataSourceReferences(List serviceReferences) throws Exception {

		java.util.Map<String, routines.system.TalendDataSource> talendDataSources = new java.util.HashMap<String, routines.system.TalendDataSource>();
		java.util.Map<String, javax.sql.DataSource> dataSources = new java.util.HashMap<String, javax.sql.DataSource>();

		for (java.util.Map.Entry<String, javax.sql.DataSource> entry : BundleUtils
				.getServices(serviceReferences, javax.sql.DataSource.class).entrySet()) {
			dataSources.put(entry.getKey(), entry.getValue());
			talendDataSources.put(entry.getKey(), new routines.system.TalendDataSource(entry.getValue()));
		}

		globalMap.put(KEY_DB_DATASOURCES, talendDataSources);
		globalMap.put(KEY_DB_DATASOURCES_RAW, new java.util.HashMap<String, javax.sql.DataSource>(dataSources));
	}

	private final java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
	private final java.io.PrintStream errorMessagePS = new java.io.PrintStream(new java.io.BufferedOutputStream(baos));

	public String getExceptionStackTrace() {
		if ("failure".equals(this.getStatus())) {
			errorMessagePS.flush();
			return baos.toString();
		}
		return null;
	}

	private Exception exception;

	public Exception getException() {
		if ("failure".equals(this.getStatus())) {
			return this.exception;
		}
		return null;
	}

	private class TalendException extends Exception {

		private static final long serialVersionUID = 1L;

		private java.util.Map<String, Object> globalMap = null;
		private Exception e = null;

		private String currentComponent = null;
		private String cLabel = null;

		private String virtualComponentName = null;

		public void setVirtualComponentName(String virtualComponentName) {
			this.virtualComponentName = virtualComponentName;
		}

		private TalendException(Exception e, String errorComponent, final java.util.Map<String, Object> globalMap) {
			this.currentComponent = errorComponent;
			this.globalMap = globalMap;
			this.e = e;
		}

		private TalendException(Exception e, String errorComponent, String errorComponentLabel,
				final java.util.Map<String, Object> globalMap) {
			this(e, errorComponent, globalMap);
			this.cLabel = errorComponentLabel;
		}

		public Exception getException() {
			return this.e;
		}

		public String getCurrentComponent() {
			return this.currentComponent;
		}

		public String getExceptionCauseMessage(Exception e) {
			Throwable cause = e;
			String message = null;
			int i = 10;
			while (null != cause && 0 < i--) {
				message = cause.getMessage();
				if (null == message) {
					cause = cause.getCause();
				} else {
					break;
				}
			}
			if (null == message) {
				message = e.getClass().getName();
			}
			return message;
		}

		@Override
		public void printStackTrace() {
			if (!(e instanceof TalendException || e instanceof TDieException)) {
				if (virtualComponentName != null && currentComponent.indexOf(virtualComponentName + "_") == 0) {
					globalMap.put(virtualComponentName + "_ERROR_MESSAGE", getExceptionCauseMessage(e));
				}
				globalMap.put(currentComponent + "_ERROR_MESSAGE", getExceptionCauseMessage(e));
				System.err.println("Exception in component " + currentComponent + " (" + jobName + ")");
			}
			if (!(e instanceof TDieException)) {
				if (e instanceof TalendException) {
					e.printStackTrace();
				} else {
					e.printStackTrace();
					e.printStackTrace(errorMessagePS);
				}
			}
			if (!(e instanceof TalendException)) {
				CHIA_Matching_Distances_2.this.exception = e;
			}
			if (!(e instanceof TalendException)) {
				try {
					for (java.lang.reflect.Method m : this.getClass().getEnclosingClass().getMethods()) {
						if (m.getName().compareTo(currentComponent + "_error") == 0) {
							m.invoke(CHIA_Matching_Distances_2.this, new Object[] { e, currentComponent, globalMap });
							break;
						}
					}

					if (!(e instanceof TDieException)) {
						if (enableLogStash) {
							talendJobLog.addJobExceptionMessage(currentComponent, cLabel, null, e);
							talendJobLogProcess(globalMap);
						}
					}
				} catch (Exception e) {
					this.e.printStackTrace();
				}
			}
		}
	}

	public void tDBInput_3_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_3_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tRecordMatching_2_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_3_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tMap_3_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap)
			throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_3_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tLogRow_2_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_3_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tDBInput_2_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_3_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tAdvancedHash_Target_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_3_onSubJobError(exception, errorComponent, globalMap);
	}

	public void talendJobLog_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		talendJobLog_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tDBInput_3_onSubJobError(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public void talendJobLog_onSubJobError(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public static class PossibleMatchesOutputStruct
			implements routines.system.IPersistableRow<PossibleMatchesOutputStruct> {
		final static byte[] commonByteArrayLock_TALENDCLOUDDEMOBANK_CHIA_Matching_Distances_2 = new byte[0];
		static byte[] commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Matching_Distances_2 = new byte[0];

		public String FirstName;

		public String getFirstName() {
			return this.FirstName;
		}

		public Boolean FirstNameIsNullable() {
			return true;
		}

		public Boolean FirstNameIsKey() {
			return false;
		}

		public Integer FirstNameLength() {
			return 16;
		}

		public Integer FirstNamePrecision() {
			return 0;
		}

		public String FirstNameDefault() {

			return null;

		}

		public String FirstNameComment() {

			return "";

		}

		public String FirstNamePattern() {

			return "";

		}

		public String FirstNameOriginalDbColumnName() {

			return "FirstName";

		}

		public String LastName;

		public String getLastName() {
			return this.LastName;
		}

		public Boolean LastNameIsNullable() {
			return true;
		}

		public Boolean LastNameIsKey() {
			return false;
		}

		public Integer LastNameLength() {
			return 10;
		}

		public Integer LastNamePrecision() {
			return 0;
		}

		public String LastNameDefault() {

			return null;

		}

		public String LastNameComment() {

			return "";

		}

		public String LastNamePattern() {

			return "";

		}

		public String LastNameOriginalDbColumnName() {

			return "LastName";

		}

		public String Gender;

		public String getGender() {
			return this.Gender;
		}

		public Boolean GenderIsNullable() {
			return true;
		}

		public Boolean GenderIsKey() {
			return false;
		}

		public Integer GenderLength() {
			return 6;
		}

		public Integer GenderPrecision() {
			return 0;
		}

		public String GenderDefault() {

			return null;

		}

		public String GenderComment() {

			return "";

		}

		public String GenderPattern() {

			return "";

		}

		public String GenderOriginalDbColumnName() {

			return "Gender";

		}

		public String PatientAddress;

		public String getPatientAddress() {
			return this.PatientAddress;
		}

		public Boolean PatientAddressIsNullable() {
			return true;
		}

		public Boolean PatientAddressIsKey() {
			return false;
		}

		public Integer PatientAddressLength() {
			return 38;
		}

		public Integer PatientAddressPrecision() {
			return 0;
		}

		public String PatientAddressDefault() {

			return null;

		}

		public String PatientAddressComment() {

			return "";

		}

		public String PatientAddressPattern() {

			return "";

		}

		public String PatientAddressOriginalDbColumnName() {

			return "PatientAddress";

		}

		public String City;

		public String getCity() {
			return this.City;
		}

		public Boolean CityIsNullable() {
			return true;
		}

		public Boolean CityIsKey() {
			return false;
		}

		public Integer CityLength() {
			return 14;
		}

		public Integer CityPrecision() {
			return 0;
		}

		public String CityDefault() {

			return null;

		}

		public String CityComment() {

			return "";

		}

		public String CityPattern() {

			return "";

		}

		public String CityOriginalDbColumnName() {

			return "City";

		}

		public String State;

		public String getState() {
			return this.State;
		}

		public Boolean StateIsNullable() {
			return true;
		}

		public Boolean StateIsKey() {
			return false;
		}

		public Integer StateLength() {
			return 2;
		}

		public Integer StatePrecision() {
			return 0;
		}

		public String StateDefault() {

			return null;

		}

		public String StateComment() {

			return "";

		}

		public String StatePattern() {

			return "";

		}

		public String StateOriginalDbColumnName() {

			return "State";

		}

		public Integer PostalCode;

		public Integer getPostalCode() {
			return this.PostalCode;
		}

		public Boolean PostalCodeIsNullable() {
			return true;
		}

		public Boolean PostalCodeIsKey() {
			return false;
		}

		public Integer PostalCodeLength() {
			return 10;
		}

		public Integer PostalCodePrecision() {
			return 0;
		}

		public String PostalCodeDefault() {

			return null;

		}

		public String PostalCodeComment() {

			return "";

		}

		public String PostalCodePattern() {

			return "";

		}

		public String PostalCodeOriginalDbColumnName() {

			return "PostalCode";

		}

		public java.util.Date Birthday;

		public java.util.Date getBirthday() {
			return this.Birthday;
		}

		public Boolean BirthdayIsNullable() {
			return true;
		}

		public Boolean BirthdayIsKey() {
			return false;
		}

		public Integer BirthdayLength() {
			return 19;
		}

		public Integer BirthdayPrecision() {
			return 0;
		}

		public String BirthdayDefault() {

			return null;

		}

		public String BirthdayComment() {

			return "";

		}

		public String BirthdayPattern() {

			return "yyyy-MM-dd";

		}

		public String BirthdayOriginalDbColumnName() {

			return "Birthday";

		}

		public String SSN;

		public String getSSN() {
			return this.SSN;
		}

		public Boolean SSNIsNullable() {
			return true;
		}

		public Boolean SSNIsKey() {
			return false;
		}

		public Integer SSNLength() {
			return 11;
		}

		public Integer SSNPrecision() {
			return 0;
		}

		public String SSNDefault() {

			return null;

		}

		public String SSNComment() {

			return "";

		}

		public String SSNPattern() {

			return "";

		}

		public String SSNOriginalDbColumnName() {

			return "SSN";

		}

		public Integer HPLNID;

		public Integer getHPLNID() {
			return this.HPLNID;
		}

		public Boolean HPLNIDIsNullable() {
			return true;
		}

		public Boolean HPLNIDIsKey() {
			return false;
		}

		public Integer HPLNIDLength() {
			return 10;
		}

		public Integer HPLNIDPrecision() {
			return 0;
		}

		public String HPLNIDDefault() {

			return null;

		}

		public String HPLNIDComment() {

			return "";

		}

		public String HPLNIDPattern() {

			return "";

		}

		public String HPLNIDOriginalDbColumnName() {

			return "HPLNID";

		}

		public String NYSIISFirstName;

		public String getNYSIISFirstName() {
			return this.NYSIISFirstName;
		}

		public Boolean NYSIISFirstNameIsNullable() {
			return true;
		}

		public Boolean NYSIISFirstNameIsKey() {
			return false;
		}

		public Integer NYSIISFirstNameLength() {
			return 16;
		}

		public Integer NYSIISFirstNamePrecision() {
			return 0;
		}

		public String NYSIISFirstNameDefault() {

			return null;

		}

		public String NYSIISFirstNameComment() {

			return "";

		}

		public String NYSIISFirstNamePattern() {

			return "";

		}

		public String NYSIISFirstNameOriginalDbColumnName() {

			return "NYSIISFirstName";

		}

		public String NYSIISLastName;

		public String getNYSIISLastName() {
			return this.NYSIISLastName;
		}

		public Boolean NYSIISLastNameIsNullable() {
			return true;
		}

		public Boolean NYSIISLastNameIsKey() {
			return false;
		}

		public Integer NYSIISLastNameLength() {
			return 10;
		}

		public Integer NYSIISLastNamePrecision() {
			return 0;
		}

		public String NYSIISLastNameDefault() {

			return null;

		}

		public String NYSIISLastNameComment() {

			return "";

		}

		public String NYSIISLastNamePattern() {

			return "";

		}

		public String NYSIISLastNameOriginalDbColumnName() {

			return "NYSIISLastName";

		}

		public String HealthPlanID;

		public String getHealthPlanID() {
			return this.HealthPlanID;
		}

		public Boolean HealthPlanIDIsNullable() {
			return true;
		}

		public Boolean HealthPlanIDIsKey() {
			return false;
		}

		public Integer HealthPlanIDLength() {
			return 8;
		}

		public Integer HealthPlanIDPrecision() {
			return 0;
		}

		public String HealthPlanIDDefault() {

			return null;

		}

		public String HealthPlanIDComment() {

			return "";

		}

		public String HealthPlanIDPattern() {

			return "";

		}

		public String HealthPlanIDOriginalDbColumnName() {

			return "HealthPlanID";

		}

		public Integer MRN;

		public Integer getMRN() {
			return this.MRN;
		}

		public Boolean MRNIsNullable() {
			return true;
		}

		public Boolean MRNIsKey() {
			return false;
		}

		public Integer MRNLength() {
			return 10;
		}

		public Integer MRNPrecision() {
			return 0;
		}

		public String MRNDefault() {

			return null;

		}

		public String MRNComment() {

			return "";

		}

		public String MRNPattern() {

			return "";

		}

		public String MRNOriginalDbColumnName() {

			return "MRN";

		}

		public String TargetFirstName;

		public String getTargetFirstName() {
			return this.TargetFirstName;
		}

		public Boolean TargetFirstNameIsNullable() {
			return true;
		}

		public Boolean TargetFirstNameIsKey() {
			return false;
		}

		public Integer TargetFirstNameLength() {
			return 16;
		}

		public Integer TargetFirstNamePrecision() {
			return 0;
		}

		public String TargetFirstNameDefault() {

			return null;

		}

		public String TargetFirstNameComment() {

			return "";

		}

		public String TargetFirstNamePattern() {

			return "";

		}

		public String TargetFirstNameOriginalDbColumnName() {

			return "TargetFirstName";

		}

		public String TargetLastName;

		public String getTargetLastName() {
			return this.TargetLastName;
		}

		public Boolean TargetLastNameIsNullable() {
			return true;
		}

		public Boolean TargetLastNameIsKey() {
			return false;
		}

		public Integer TargetLastNameLength() {
			return 10;
		}

		public Integer TargetLastNamePrecision() {
			return 0;
		}

		public String TargetLastNameDefault() {

			return null;

		}

		public String TargetLastNameComment() {

			return "";

		}

		public String TargetLastNamePattern() {

			return "";

		}

		public String TargetLastNameOriginalDbColumnName() {

			return "TargetLastName";

		}

		public String TargetGender;

		public String getTargetGender() {
			return this.TargetGender;
		}

		public Boolean TargetGenderIsNullable() {
			return true;
		}

		public Boolean TargetGenderIsKey() {
			return false;
		}

		public Integer TargetGenderLength() {
			return 6;
		}

		public Integer TargetGenderPrecision() {
			return 0;
		}

		public String TargetGenderDefault() {

			return null;

		}

		public String TargetGenderComment() {

			return "";

		}

		public String TargetGenderPattern() {

			return "";

		}

		public String TargetGenderOriginalDbColumnName() {

			return "TargetGender";

		}

		public String TargetPatientAddress;

		public String getTargetPatientAddress() {
			return this.TargetPatientAddress;
		}

		public Boolean TargetPatientAddressIsNullable() {
			return true;
		}

		public Boolean TargetPatientAddressIsKey() {
			return false;
		}

		public Integer TargetPatientAddressLength() {
			return 38;
		}

		public Integer TargetPatientAddressPrecision() {
			return 0;
		}

		public String TargetPatientAddressDefault() {

			return null;

		}

		public String TargetPatientAddressComment() {

			return "";

		}

		public String TargetPatientAddressPattern() {

			return "";

		}

		public String TargetPatientAddressOriginalDbColumnName() {

			return "TargetPatientAddress";

		}

		public String TargetCity;

		public String getTargetCity() {
			return this.TargetCity;
		}

		public Boolean TargetCityIsNullable() {
			return true;
		}

		public Boolean TargetCityIsKey() {
			return false;
		}

		public Integer TargetCityLength() {
			return 14;
		}

		public Integer TargetCityPrecision() {
			return 0;
		}

		public String TargetCityDefault() {

			return null;

		}

		public String TargetCityComment() {

			return "";

		}

		public String TargetCityPattern() {

			return "";

		}

		public String TargetCityOriginalDbColumnName() {

			return "TargetCity";

		}

		public String TargetState;

		public String getTargetState() {
			return this.TargetState;
		}

		public Boolean TargetStateIsNullable() {
			return true;
		}

		public Boolean TargetStateIsKey() {
			return false;
		}

		public Integer TargetStateLength() {
			return 2;
		}

		public Integer TargetStatePrecision() {
			return 0;
		}

		public String TargetStateDefault() {

			return null;

		}

		public String TargetStateComment() {

			return "";

		}

		public String TargetStatePattern() {

			return "";

		}

		public String TargetStateOriginalDbColumnName() {

			return "TargetState";

		}

		public Integer TargetPostalCode;

		public Integer getTargetPostalCode() {
			return this.TargetPostalCode;
		}

		public Boolean TargetPostalCodeIsNullable() {
			return true;
		}

		public Boolean TargetPostalCodeIsKey() {
			return false;
		}

		public Integer TargetPostalCodeLength() {
			return 10;
		}

		public Integer TargetPostalCodePrecision() {
			return 0;
		}

		public String TargetPostalCodeDefault() {

			return null;

		}

		public String TargetPostalCodeComment() {

			return "";

		}

		public String TargetPostalCodePattern() {

			return "";

		}

		public String TargetPostalCodeOriginalDbColumnName() {

			return "TargetPostalCode";

		}

		public java.util.Date TargetBirthday;

		public java.util.Date getTargetBirthday() {
			return this.TargetBirthday;
		}

		public Boolean TargetBirthdayIsNullable() {
			return true;
		}

		public Boolean TargetBirthdayIsKey() {
			return false;
		}

		public Integer TargetBirthdayLength() {
			return 19;
		}

		public Integer TargetBirthdayPrecision() {
			return 0;
		}

		public String TargetBirthdayDefault() {

			return null;

		}

		public String TargetBirthdayComment() {

			return "";

		}

		public String TargetBirthdayPattern() {

			return "MM/dd/yyyy";

		}

		public String TargetBirthdayOriginalDbColumnName() {

			return "TargetBirthday";

		}

		public String TargetSSN;

		public String getTargetSSN() {
			return this.TargetSSN;
		}

		public Boolean TargetSSNIsNullable() {
			return true;
		}

		public Boolean TargetSSNIsKey() {
			return false;
		}

		public Integer TargetSSNLength() {
			return 11;
		}

		public Integer TargetSSNPrecision() {
			return 0;
		}

		public String TargetSSNDefault() {

			return null;

		}

		public String TargetSSNComment() {

			return "";

		}

		public String TargetSSNPattern() {

			return "";

		}

		public String TargetSSNOriginalDbColumnName() {

			return "TargetSSN";

		}

		public Integer TargetHPLNID;

		public Integer getTargetHPLNID() {
			return this.TargetHPLNID;
		}

		public Boolean TargetHPLNIDIsNullable() {
			return true;
		}

		public Boolean TargetHPLNIDIsKey() {
			return false;
		}

		public Integer TargetHPLNIDLength() {
			return 10;
		}

		public Integer TargetHPLNIDPrecision() {
			return 0;
		}

		public String TargetHPLNIDDefault() {

			return null;

		}

		public String TargetHPLNIDComment() {

			return "";

		}

		public String TargetHPLNIDPattern() {

			return "";

		}

		public String TargetHPLNIDOriginalDbColumnName() {

			return "TargetHPLNID";

		}

		public String TargetNYSIISFirstName;

		public String getTargetNYSIISFirstName() {
			return this.TargetNYSIISFirstName;
		}

		public Boolean TargetNYSIISFirstNameIsNullable() {
			return true;
		}

		public Boolean TargetNYSIISFirstNameIsKey() {
			return false;
		}

		public Integer TargetNYSIISFirstNameLength() {
			return 16;
		}

		public Integer TargetNYSIISFirstNamePrecision() {
			return 0;
		}

		public String TargetNYSIISFirstNameDefault() {

			return null;

		}

		public String TargetNYSIISFirstNameComment() {

			return "";

		}

		public String TargetNYSIISFirstNamePattern() {

			return "";

		}

		public String TargetNYSIISFirstNameOriginalDbColumnName() {

			return "TargetNYSIISFirstName";

		}

		public String TargetNYSIISLastName;

		public String getTargetNYSIISLastName() {
			return this.TargetNYSIISLastName;
		}

		public Boolean TargetNYSIISLastNameIsNullable() {
			return true;
		}

		public Boolean TargetNYSIISLastNameIsKey() {
			return false;
		}

		public Integer TargetNYSIISLastNameLength() {
			return 10;
		}

		public Integer TargetNYSIISLastNamePrecision() {
			return 0;
		}

		public String TargetNYSIISLastNameDefault() {

			return null;

		}

		public String TargetNYSIISLastNameComment() {

			return "";

		}

		public String TargetNYSIISLastNamePattern() {

			return "";

		}

		public String TargetNYSIISLastNameOriginalDbColumnName() {

			return "TargetNYSIISLastName";

		}

		public String TargetHealthPlanID;

		public String getTargetHealthPlanID() {
			return this.TargetHealthPlanID;
		}

		public Boolean TargetHealthPlanIDIsNullable() {
			return true;
		}

		public Boolean TargetHealthPlanIDIsKey() {
			return false;
		}

		public Integer TargetHealthPlanIDLength() {
			return 8;
		}

		public Integer TargetHealthPlanIDPrecision() {
			return 0;
		}

		public String TargetHealthPlanIDDefault() {

			return null;

		}

		public String TargetHealthPlanIDComment() {

			return "";

		}

		public String TargetHealthPlanIDPattern() {

			return "";

		}

		public String TargetHealthPlanIDOriginalDbColumnName() {

			return "TargetHealthPlanID";

		}

		public Integer TargetMRN;

		public Integer getTargetMRN() {
			return this.TargetMRN;
		}

		public Boolean TargetMRNIsNullable() {
			return true;
		}

		public Boolean TargetMRNIsKey() {
			return false;
		}

		public Integer TargetMRNLength() {
			return 10;
		}

		public Integer TargetMRNPrecision() {
			return 0;
		}

		public String TargetMRNDefault() {

			return null;

		}

		public String TargetMRNComment() {

			return "";

		}

		public String TargetMRNPattern() {

			return "";

		}

		public String TargetMRNOriginalDbColumnName() {

			return "TargetMRN";

		}

		public String MATCHINGDISTANCES;

		public String getMATCHINGDISTANCES() {
			return this.MATCHINGDISTANCES;
		}

		public Boolean MATCHINGDISTANCESIsNullable() {
			return true;
		}

		public Boolean MATCHINGDISTANCESIsKey() {
			return false;
		}

		public Integer MATCHINGDISTANCESLength() {
			return 255;
		}

		public Integer MATCHINGDISTANCESPrecision() {
			return 0;
		}

		public String MATCHINGDISTANCESDefault() {

			return null;

		}

		public String MATCHINGDISTANCESComment() {

			return null;

		}

		public String MATCHINGDISTANCESPattern() {

			return null;

		}

		public String MATCHINGDISTANCESOriginalDbColumnName() {

			return "MATCHINGDISTANCES";

		}

		public Double MATCHINGWEIGHT;

		public Double getMATCHINGWEIGHT() {
			return this.MATCHINGWEIGHT;
		}

		public Boolean MATCHINGWEIGHTIsNullable() {
			return true;
		}

		public Boolean MATCHINGWEIGHTIsKey() {
			return false;
		}

		public Integer MATCHINGWEIGHTLength() {
			return 20;
		}

		public Integer MATCHINGWEIGHTPrecision() {
			return 0;
		}

		public String MATCHINGWEIGHTDefault() {

			return "";

		}

		public String MATCHINGWEIGHTComment() {

			return null;

		}

		public String MATCHINGWEIGHTPattern() {

			return null;

		}

		public String MATCHINGWEIGHTOriginalDbColumnName() {

			return "MATCHINGWEIGHT";

		}

		public String SSNBlockingKey;

		public String getSSNBlockingKey() {
			return this.SSNBlockingKey;
		}

		public Boolean SSNBlockingKeyIsNullable() {
			return true;
		}

		public Boolean SSNBlockingKeyIsKey() {
			return false;
		}

		public Integer SSNBlockingKeyLength() {
			return 20;
		}

		public Integer SSNBlockingKeyPrecision() {
			return 0;
		}

		public String SSNBlockingKeyDefault() {

			return null;

		}

		public String SSNBlockingKeyComment() {

			return "";

		}

		public String SSNBlockingKeyPattern() {

			return "";

		}

		public String SSNBlockingKeyOriginalDbColumnName() {

			return "SSNBlockingKey";

		}

		public String FNDOBBlockingKey;

		public String getFNDOBBlockingKey() {
			return this.FNDOBBlockingKey;
		}

		public Boolean FNDOBBlockingKeyIsNullable() {
			return true;
		}

		public Boolean FNDOBBlockingKeyIsKey() {
			return false;
		}

		public Integer FNDOBBlockingKeyLength() {
			return 25;
		}

		public Integer FNDOBBlockingKeyPrecision() {
			return 0;
		}

		public String FNDOBBlockingKeyDefault() {

			return null;

		}

		public String FNDOBBlockingKeyComment() {

			return "";

		}

		public String FNDOBBlockingKeyPattern() {

			return "";

		}

		public String FNDOBBlockingKeyOriginalDbColumnName() {

			return "FNDOBBlockingKey";

		}

		public String LNPCBlockingKey;

		public String getLNPCBlockingKey() {
			return this.LNPCBlockingKey;
		}

		public Boolean LNPCBlockingKeyIsNullable() {
			return true;
		}

		public Boolean LNPCBlockingKeyIsKey() {
			return false;
		}

		public Integer LNPCBlockingKeyLength() {
			return 20;
		}

		public Integer LNPCBlockingKeyPrecision() {
			return 0;
		}

		public String LNPCBlockingKeyDefault() {

			return null;

		}

		public String LNPCBlockingKeyComment() {

			return "";

		}

		public String LNPCBlockingKeyPattern() {

			return "";

		}

		public String LNPCBlockingKeyOriginalDbColumnName() {

			return "LNPCBlockingKey";

		}

		public String NYSIISFNLNBlockingKey;

		public String getNYSIISFNLNBlockingKey() {
			return this.NYSIISFNLNBlockingKey;
		}

		public Boolean NYSIISFNLNBlockingKeyIsNullable() {
			return true;
		}

		public Boolean NYSIISFNLNBlockingKeyIsKey() {
			return false;
		}

		public Integer NYSIISFNLNBlockingKeyLength() {
			return 20;
		}

		public Integer NYSIISFNLNBlockingKeyPrecision() {
			return 0;
		}

		public String NYSIISFNLNBlockingKeyDefault() {

			return null;

		}

		public String NYSIISFNLNBlockingKeyComment() {

			return "";

		}

		public String NYSIISFNLNBlockingKeyPattern() {

			return "";

		}

		public String NYSIISFNLNBlockingKeyOriginalDbColumnName() {

			return "NYSIISFNLNBlockingKey";

		}

		public String DOBPCBlockingKey;

		public String getDOBPCBlockingKey() {
			return this.DOBPCBlockingKey;
		}

		public Boolean DOBPCBlockingKeyIsNullable() {
			return true;
		}

		public Boolean DOBPCBlockingKeyIsKey() {
			return false;
		}

		public Integer DOBPCBlockingKeyLength() {
			return 20;
		}

		public Integer DOBPCBlockingKeyPrecision() {
			return 0;
		}

		public String DOBPCBlockingKeyDefault() {

			return null;

		}

		public String DOBPCBlockingKeyComment() {

			return "";

		}

		public String DOBPCBlockingKeyPattern() {

			return "";

		}

		public String DOBPCBlockingKeyOriginalDbColumnName() {

			return "DOBPCBlockingKey";

		}

		public String MRNBlockingKey;

		public String getMRNBlockingKey() {
			return this.MRNBlockingKey;
		}

		public Boolean MRNBlockingKeyIsNullable() {
			return true;
		}

		public Boolean MRNBlockingKeyIsKey() {
			return false;
		}

		public Integer MRNBlockingKeyLength() {
			return 20;
		}

		public Integer MRNBlockingKeyPrecision() {
			return 0;
		}

		public String MRNBlockingKeyDefault() {

			return null;

		}

		public String MRNBlockingKeyComment() {

			return "";

		}

		public String MRNBlockingKeyPattern() {

			return "";

		}

		public String MRNBlockingKeyOriginalDbColumnName() {

			return "MRNBlockingKey";

		}

		public String HealthPlanIDBlockingKey;

		public String getHealthPlanIDBlockingKey() {
			return this.HealthPlanIDBlockingKey;
		}

		public Boolean HealthPlanIDBlockingKeyIsNullable() {
			return true;
		}

		public Boolean HealthPlanIDBlockingKeyIsKey() {
			return false;
		}

		public Integer HealthPlanIDBlockingKeyLength() {
			return 20;
		}

		public Integer HealthPlanIDBlockingKeyPrecision() {
			return 0;
		}

		public String HealthPlanIDBlockingKeyDefault() {

			return null;

		}

		public String HealthPlanIDBlockingKeyComment() {

			return "";

		}

		public String HealthPlanIDBlockingKeyPattern() {

			return "";

		}

		public String HealthPlanIDBlockingKeyOriginalDbColumnName() {

			return "HealthPlanIDBlockingKey";

		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Matching_Distances_2.length) {
					if (length < 1024 && commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Matching_Distances_2.length == 0) {
						commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Matching_Distances_2 = new byte[1024];
					} else {
						commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Matching_Distances_2 = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Matching_Distances_2, 0, length);
				strReturn = new String(commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Matching_Distances_2, 0, length,
						utf8Charset);
			}
			return strReturn;
		}

		private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException {
			String strReturn = null;
			int length = 0;
			length = unmarshaller.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Matching_Distances_2.length) {
					if (length < 1024 && commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Matching_Distances_2.length == 0) {
						commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Matching_Distances_2 = new byte[1024];
					} else {
						commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Matching_Distances_2 = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Matching_Distances_2, 0, length);
				strReturn = new String(commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Matching_Distances_2, 0, length,
						utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		private Integer readInteger(ObjectInputStream dis) throws IOException {
			Integer intReturn;
			int length = 0;
			length = dis.readByte();
			if (length == -1) {
				intReturn = null;
			} else {
				intReturn = dis.readInt();
			}
			return intReturn;
		}

		private Integer readInteger(org.jboss.marshalling.Unmarshaller dis) throws IOException {
			Integer intReturn;
			int length = 0;
			length = dis.readByte();
			if (length == -1) {
				intReturn = null;
			} else {
				intReturn = dis.readInt();
			}
			return intReturn;
		}

		private void writeInteger(Integer intNum, ObjectOutputStream dos) throws IOException {
			if (intNum == null) {
				dos.writeByte(-1);
			} else {
				dos.writeByte(0);
				dos.writeInt(intNum);
			}
		}

		private void writeInteger(Integer intNum, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (intNum == null) {
				marshaller.writeByte(-1);
			} else {
				marshaller.writeByte(0);
				marshaller.writeInt(intNum);
			}
		}

		private java.util.Date readDate(ObjectInputStream dis) throws IOException {
			java.util.Date dateReturn = null;
			int length = 0;
			length = dis.readByte();
			if (length == -1) {
				dateReturn = null;
			} else {
				dateReturn = new Date(dis.readLong());
			}
			return dateReturn;
		}

		private java.util.Date readDate(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException {
			java.util.Date dateReturn = null;
			int length = 0;
			length = unmarshaller.readByte();
			if (length == -1) {
				dateReturn = null;
			} else {
				dateReturn = new Date(unmarshaller.readLong());
			}
			return dateReturn;
		}

		private void writeDate(java.util.Date date1, ObjectOutputStream dos) throws IOException {
			if (date1 == null) {
				dos.writeByte(-1);
			} else {
				dos.writeByte(0);
				dos.writeLong(date1.getTime());
			}
		}

		private void writeDate(java.util.Date date1, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (date1 == null) {
				marshaller.writeByte(-1);
			} else {
				marshaller.writeByte(0);
				marshaller.writeLong(date1.getTime());
			}
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_TALENDCLOUDDEMOBANK_CHIA_Matching_Distances_2) {

				try {

					int length = 0;

					this.FirstName = readString(dis);

					this.LastName = readString(dis);

					this.Gender = readString(dis);

					this.PatientAddress = readString(dis);

					this.City = readString(dis);

					this.State = readString(dis);

					this.PostalCode = readInteger(dis);

					this.Birthday = readDate(dis);

					this.SSN = readString(dis);

					this.HPLNID = readInteger(dis);

					this.NYSIISFirstName = readString(dis);

					this.NYSIISLastName = readString(dis);

					this.HealthPlanID = readString(dis);

					this.MRN = readInteger(dis);

					this.TargetFirstName = readString(dis);

					this.TargetLastName = readString(dis);

					this.TargetGender = readString(dis);

					this.TargetPatientAddress = readString(dis);

					this.TargetCity = readString(dis);

					this.TargetState = readString(dis);

					this.TargetPostalCode = readInteger(dis);

					this.TargetBirthday = readDate(dis);

					this.TargetSSN = readString(dis);

					this.TargetHPLNID = readInteger(dis);

					this.TargetNYSIISFirstName = readString(dis);

					this.TargetNYSIISLastName = readString(dis);

					this.TargetHealthPlanID = readString(dis);

					this.TargetMRN = readInteger(dis);

					this.MATCHINGDISTANCES = readString(dis);

					length = dis.readByte();
					if (length == -1) {
						this.MATCHINGWEIGHT = null;
					} else {
						this.MATCHINGWEIGHT = dis.readDouble();
					}

					this.SSNBlockingKey = readString(dis);

					this.FNDOBBlockingKey = readString(dis);

					this.LNPCBlockingKey = readString(dis);

					this.NYSIISFNLNBlockingKey = readString(dis);

					this.DOBPCBlockingKey = readString(dis);

					this.MRNBlockingKey = readString(dis);

					this.HealthPlanIDBlockingKey = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_TALENDCLOUDDEMOBANK_CHIA_Matching_Distances_2) {

				try {

					int length = 0;

					this.FirstName = readString(dis);

					this.LastName = readString(dis);

					this.Gender = readString(dis);

					this.PatientAddress = readString(dis);

					this.City = readString(dis);

					this.State = readString(dis);

					this.PostalCode = readInteger(dis);

					this.Birthday = readDate(dis);

					this.SSN = readString(dis);

					this.HPLNID = readInteger(dis);

					this.NYSIISFirstName = readString(dis);

					this.NYSIISLastName = readString(dis);

					this.HealthPlanID = readString(dis);

					this.MRN = readInteger(dis);

					this.TargetFirstName = readString(dis);

					this.TargetLastName = readString(dis);

					this.TargetGender = readString(dis);

					this.TargetPatientAddress = readString(dis);

					this.TargetCity = readString(dis);

					this.TargetState = readString(dis);

					this.TargetPostalCode = readInteger(dis);

					this.TargetBirthday = readDate(dis);

					this.TargetSSN = readString(dis);

					this.TargetHPLNID = readInteger(dis);

					this.TargetNYSIISFirstName = readString(dis);

					this.TargetNYSIISLastName = readString(dis);

					this.TargetHealthPlanID = readString(dis);

					this.TargetMRN = readInteger(dis);

					this.MATCHINGDISTANCES = readString(dis);

					length = dis.readByte();
					if (length == -1) {
						this.MATCHINGWEIGHT = null;
					} else {
						this.MATCHINGWEIGHT = dis.readDouble();
					}

					this.SSNBlockingKey = readString(dis);

					this.FNDOBBlockingKey = readString(dis);

					this.LNPCBlockingKey = readString(dis);

					this.NYSIISFNLNBlockingKey = readString(dis);

					this.DOBPCBlockingKey = readString(dis);

					this.MRNBlockingKey = readString(dis);

					this.HealthPlanIDBlockingKey = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// String

				writeString(this.FirstName, dos);

				// String

				writeString(this.LastName, dos);

				// String

				writeString(this.Gender, dos);

				// String

				writeString(this.PatientAddress, dos);

				// String

				writeString(this.City, dos);

				// String

				writeString(this.State, dos);

				// Integer

				writeInteger(this.PostalCode, dos);

				// java.util.Date

				writeDate(this.Birthday, dos);

				// String

				writeString(this.SSN, dos);

				// Integer

				writeInteger(this.HPLNID, dos);

				// String

				writeString(this.NYSIISFirstName, dos);

				// String

				writeString(this.NYSIISLastName, dos);

				// String

				writeString(this.HealthPlanID, dos);

				// Integer

				writeInteger(this.MRN, dos);

				// String

				writeString(this.TargetFirstName, dos);

				// String

				writeString(this.TargetLastName, dos);

				// String

				writeString(this.TargetGender, dos);

				// String

				writeString(this.TargetPatientAddress, dos);

				// String

				writeString(this.TargetCity, dos);

				// String

				writeString(this.TargetState, dos);

				// Integer

				writeInteger(this.TargetPostalCode, dos);

				// java.util.Date

				writeDate(this.TargetBirthday, dos);

				// String

				writeString(this.TargetSSN, dos);

				// Integer

				writeInteger(this.TargetHPLNID, dos);

				// String

				writeString(this.TargetNYSIISFirstName, dos);

				// String

				writeString(this.TargetNYSIISLastName, dos);

				// String

				writeString(this.TargetHealthPlanID, dos);

				// Integer

				writeInteger(this.TargetMRN, dos);

				// String

				writeString(this.MATCHINGDISTANCES, dos);

				// Double

				if (this.MATCHINGWEIGHT == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeDouble(this.MATCHINGWEIGHT);
				}

				// String

				writeString(this.SSNBlockingKey, dos);

				// String

				writeString(this.FNDOBBlockingKey, dos);

				// String

				writeString(this.LNPCBlockingKey, dos);

				// String

				writeString(this.NYSIISFNLNBlockingKey, dos);

				// String

				writeString(this.DOBPCBlockingKey, dos);

				// String

				writeString(this.MRNBlockingKey, dos);

				// String

				writeString(this.HealthPlanIDBlockingKey, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// String

				writeString(this.FirstName, dos);

				// String

				writeString(this.LastName, dos);

				// String

				writeString(this.Gender, dos);

				// String

				writeString(this.PatientAddress, dos);

				// String

				writeString(this.City, dos);

				// String

				writeString(this.State, dos);

				// Integer

				writeInteger(this.PostalCode, dos);

				// java.util.Date

				writeDate(this.Birthday, dos);

				// String

				writeString(this.SSN, dos);

				// Integer

				writeInteger(this.HPLNID, dos);

				// String

				writeString(this.NYSIISFirstName, dos);

				// String

				writeString(this.NYSIISLastName, dos);

				// String

				writeString(this.HealthPlanID, dos);

				// Integer

				writeInteger(this.MRN, dos);

				// String

				writeString(this.TargetFirstName, dos);

				// String

				writeString(this.TargetLastName, dos);

				// String

				writeString(this.TargetGender, dos);

				// String

				writeString(this.TargetPatientAddress, dos);

				// String

				writeString(this.TargetCity, dos);

				// String

				writeString(this.TargetState, dos);

				// Integer

				writeInteger(this.TargetPostalCode, dos);

				// java.util.Date

				writeDate(this.TargetBirthday, dos);

				// String

				writeString(this.TargetSSN, dos);

				// Integer

				writeInteger(this.TargetHPLNID, dos);

				// String

				writeString(this.TargetNYSIISFirstName, dos);

				// String

				writeString(this.TargetNYSIISLastName, dos);

				// String

				writeString(this.TargetHealthPlanID, dos);

				// Integer

				writeInteger(this.TargetMRN, dos);

				// String

				writeString(this.MATCHINGDISTANCES, dos);

				// Double

				if (this.MATCHINGWEIGHT == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeDouble(this.MATCHINGWEIGHT);
				}

				// String

				writeString(this.SSNBlockingKey, dos);

				// String

				writeString(this.FNDOBBlockingKey, dos);

				// String

				writeString(this.LNPCBlockingKey, dos);

				// String

				writeString(this.NYSIISFNLNBlockingKey, dos);

				// String

				writeString(this.DOBPCBlockingKey, dos);

				// String

				writeString(this.MRNBlockingKey, dos);

				// String

				writeString(this.HealthPlanIDBlockingKey, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("FirstName=" + FirstName);
			sb.append(",LastName=" + LastName);
			sb.append(",Gender=" + Gender);
			sb.append(",PatientAddress=" + PatientAddress);
			sb.append(",City=" + City);
			sb.append(",State=" + State);
			sb.append(",PostalCode=" + String.valueOf(PostalCode));
			sb.append(",Birthday=" + String.valueOf(Birthday));
			sb.append(",SSN=" + SSN);
			sb.append(",HPLNID=" + String.valueOf(HPLNID));
			sb.append(",NYSIISFirstName=" + NYSIISFirstName);
			sb.append(",NYSIISLastName=" + NYSIISLastName);
			sb.append(",HealthPlanID=" + HealthPlanID);
			sb.append(",MRN=" + String.valueOf(MRN));
			sb.append(",TargetFirstName=" + TargetFirstName);
			sb.append(",TargetLastName=" + TargetLastName);
			sb.append(",TargetGender=" + TargetGender);
			sb.append(",TargetPatientAddress=" + TargetPatientAddress);
			sb.append(",TargetCity=" + TargetCity);
			sb.append(",TargetState=" + TargetState);
			sb.append(",TargetPostalCode=" + String.valueOf(TargetPostalCode));
			sb.append(",TargetBirthday=" + String.valueOf(TargetBirthday));
			sb.append(",TargetSSN=" + TargetSSN);
			sb.append(",TargetHPLNID=" + String.valueOf(TargetHPLNID));
			sb.append(",TargetNYSIISFirstName=" + TargetNYSIISFirstName);
			sb.append(",TargetNYSIISLastName=" + TargetNYSIISLastName);
			sb.append(",TargetHealthPlanID=" + TargetHealthPlanID);
			sb.append(",TargetMRN=" + String.valueOf(TargetMRN));
			sb.append(",MATCHINGDISTANCES=" + MATCHINGDISTANCES);
			sb.append(",MATCHINGWEIGHT=" + String.valueOf(MATCHINGWEIGHT));
			sb.append(",SSNBlockingKey=" + SSNBlockingKey);
			sb.append(",FNDOBBlockingKey=" + FNDOBBlockingKey);
			sb.append(",LNPCBlockingKey=" + LNPCBlockingKey);
			sb.append(",NYSIISFNLNBlockingKey=" + NYSIISFNLNBlockingKey);
			sb.append(",DOBPCBlockingKey=" + DOBPCBlockingKey);
			sb.append(",MRNBlockingKey=" + MRNBlockingKey);
			sb.append(",HealthPlanIDBlockingKey=" + HealthPlanIDBlockingKey);
			sb.append("]");

			return sb.toString();
		}

		public String toLogString() {
			StringBuilder sb = new StringBuilder();

			if (FirstName == null) {
				sb.append("<null>");
			} else {
				sb.append(FirstName);
			}

			sb.append("|");

			if (LastName == null) {
				sb.append("<null>");
			} else {
				sb.append(LastName);
			}

			sb.append("|");

			if (Gender == null) {
				sb.append("<null>");
			} else {
				sb.append(Gender);
			}

			sb.append("|");

			if (PatientAddress == null) {
				sb.append("<null>");
			} else {
				sb.append(PatientAddress);
			}

			sb.append("|");

			if (City == null) {
				sb.append("<null>");
			} else {
				sb.append(City);
			}

			sb.append("|");

			if (State == null) {
				sb.append("<null>");
			} else {
				sb.append(State);
			}

			sb.append("|");

			if (PostalCode == null) {
				sb.append("<null>");
			} else {
				sb.append(PostalCode);
			}

			sb.append("|");

			if (Birthday == null) {
				sb.append("<null>");
			} else {
				sb.append(Birthday);
			}

			sb.append("|");

			if (SSN == null) {
				sb.append("<null>");
			} else {
				sb.append(SSN);
			}

			sb.append("|");

			if (HPLNID == null) {
				sb.append("<null>");
			} else {
				sb.append(HPLNID);
			}

			sb.append("|");

			if (NYSIISFirstName == null) {
				sb.append("<null>");
			} else {
				sb.append(NYSIISFirstName);
			}

			sb.append("|");

			if (NYSIISLastName == null) {
				sb.append("<null>");
			} else {
				sb.append(NYSIISLastName);
			}

			sb.append("|");

			if (HealthPlanID == null) {
				sb.append("<null>");
			} else {
				sb.append(HealthPlanID);
			}

			sb.append("|");

			if (MRN == null) {
				sb.append("<null>");
			} else {
				sb.append(MRN);
			}

			sb.append("|");

			if (TargetFirstName == null) {
				sb.append("<null>");
			} else {
				sb.append(TargetFirstName);
			}

			sb.append("|");

			if (TargetLastName == null) {
				sb.append("<null>");
			} else {
				sb.append(TargetLastName);
			}

			sb.append("|");

			if (TargetGender == null) {
				sb.append("<null>");
			} else {
				sb.append(TargetGender);
			}

			sb.append("|");

			if (TargetPatientAddress == null) {
				sb.append("<null>");
			} else {
				sb.append(TargetPatientAddress);
			}

			sb.append("|");

			if (TargetCity == null) {
				sb.append("<null>");
			} else {
				sb.append(TargetCity);
			}

			sb.append("|");

			if (TargetState == null) {
				sb.append("<null>");
			} else {
				sb.append(TargetState);
			}

			sb.append("|");

			if (TargetPostalCode == null) {
				sb.append("<null>");
			} else {
				sb.append(TargetPostalCode);
			}

			sb.append("|");

			if (TargetBirthday == null) {
				sb.append("<null>");
			} else {
				sb.append(TargetBirthday);
			}

			sb.append("|");

			if (TargetSSN == null) {
				sb.append("<null>");
			} else {
				sb.append(TargetSSN);
			}

			sb.append("|");

			if (TargetHPLNID == null) {
				sb.append("<null>");
			} else {
				sb.append(TargetHPLNID);
			}

			sb.append("|");

			if (TargetNYSIISFirstName == null) {
				sb.append("<null>");
			} else {
				sb.append(TargetNYSIISFirstName);
			}

			sb.append("|");

			if (TargetNYSIISLastName == null) {
				sb.append("<null>");
			} else {
				sb.append(TargetNYSIISLastName);
			}

			sb.append("|");

			if (TargetHealthPlanID == null) {
				sb.append("<null>");
			} else {
				sb.append(TargetHealthPlanID);
			}

			sb.append("|");

			if (TargetMRN == null) {
				sb.append("<null>");
			} else {
				sb.append(TargetMRN);
			}

			sb.append("|");

			if (MATCHINGDISTANCES == null) {
				sb.append("<null>");
			} else {
				sb.append(MATCHINGDISTANCES);
			}

			sb.append("|");

			if (MATCHINGWEIGHT == null) {
				sb.append("<null>");
			} else {
				sb.append(MATCHINGWEIGHT);
			}

			sb.append("|");

			if (SSNBlockingKey == null) {
				sb.append("<null>");
			} else {
				sb.append(SSNBlockingKey);
			}

			sb.append("|");

			if (FNDOBBlockingKey == null) {
				sb.append("<null>");
			} else {
				sb.append(FNDOBBlockingKey);
			}

			sb.append("|");

			if (LNPCBlockingKey == null) {
				sb.append("<null>");
			} else {
				sb.append(LNPCBlockingKey);
			}

			sb.append("|");

			if (NYSIISFNLNBlockingKey == null) {
				sb.append("<null>");
			} else {
				sb.append(NYSIISFNLNBlockingKey);
			}

			sb.append("|");

			if (DOBPCBlockingKey == null) {
				sb.append("<null>");
			} else {
				sb.append(DOBPCBlockingKey);
			}

			sb.append("|");

			if (MRNBlockingKey == null) {
				sb.append("<null>");
			} else {
				sb.append(MRNBlockingKey);
			}

			sb.append("|");

			if (HealthPlanIDBlockingKey == null) {
				sb.append("<null>");
			} else {
				sb.append(HealthPlanIDBlockingKey);
			}

			sb.append("|");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(PossibleMatchesOutputStruct other) {

			int returnValue = -1;

			return returnValue;
		}

		private int checkNullsAndCompare(Object object1, Object object2) {
			int returnValue = 0;
			if (object1 instanceof Comparable && object2 instanceof Comparable) {
				returnValue = ((Comparable) object1).compareTo(object2);
			} else if (object1 != null && object2 != null) {
				returnValue = compareStrings(object1.toString(), object2.toString());
			} else if (object1 == null && object2 != null) {
				returnValue = 1;
			} else if (object1 != null && object2 == null) {
				returnValue = -1;
			} else {
				returnValue = 0;
			}

			return returnValue;
		}

		private int compareStrings(String string1, String string2) {
			return string1.compareTo(string2);
		}

	}

	public static class PossibleMatchesStruct implements routines.system.IPersistableRow<PossibleMatchesStruct> {
		final static byte[] commonByteArrayLock_TALENDCLOUDDEMOBANK_CHIA_Matching_Distances_2 = new byte[0];
		static byte[] commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Matching_Distances_2 = new byte[0];

		public String FirstName;

		public String getFirstName() {
			return this.FirstName;
		}

		public Boolean FirstNameIsNullable() {
			return true;
		}

		public Boolean FirstNameIsKey() {
			return false;
		}

		public Integer FirstNameLength() {
			return 16;
		}

		public Integer FirstNamePrecision() {
			return 0;
		}

		public String FirstNameDefault() {

			return null;

		}

		public String FirstNameComment() {

			return "";

		}

		public String FirstNamePattern() {

			return "";

		}

		public String FirstNameOriginalDbColumnName() {

			return "FirstName";

		}

		public String LastName;

		public String getLastName() {
			return this.LastName;
		}

		public Boolean LastNameIsNullable() {
			return true;
		}

		public Boolean LastNameIsKey() {
			return false;
		}

		public Integer LastNameLength() {
			return 10;
		}

		public Integer LastNamePrecision() {
			return 0;
		}

		public String LastNameDefault() {

			return null;

		}

		public String LastNameComment() {

			return "";

		}

		public String LastNamePattern() {

			return "";

		}

		public String LastNameOriginalDbColumnName() {

			return "LastName";

		}

		public String Gender;

		public String getGender() {
			return this.Gender;
		}

		public Boolean GenderIsNullable() {
			return true;
		}

		public Boolean GenderIsKey() {
			return false;
		}

		public Integer GenderLength() {
			return 6;
		}

		public Integer GenderPrecision() {
			return 0;
		}

		public String GenderDefault() {

			return null;

		}

		public String GenderComment() {

			return "";

		}

		public String GenderPattern() {

			return "";

		}

		public String GenderOriginalDbColumnName() {

			return "Gender";

		}

		public String PatientAddress;

		public String getPatientAddress() {
			return this.PatientAddress;
		}

		public Boolean PatientAddressIsNullable() {
			return true;
		}

		public Boolean PatientAddressIsKey() {
			return false;
		}

		public Integer PatientAddressLength() {
			return 38;
		}

		public Integer PatientAddressPrecision() {
			return 0;
		}

		public String PatientAddressDefault() {

			return null;

		}

		public String PatientAddressComment() {

			return "";

		}

		public String PatientAddressPattern() {

			return "";

		}

		public String PatientAddressOriginalDbColumnName() {

			return "PatientAddress";

		}

		public String City;

		public String getCity() {
			return this.City;
		}

		public Boolean CityIsNullable() {
			return true;
		}

		public Boolean CityIsKey() {
			return false;
		}

		public Integer CityLength() {
			return 14;
		}

		public Integer CityPrecision() {
			return 0;
		}

		public String CityDefault() {

			return null;

		}

		public String CityComment() {

			return "";

		}

		public String CityPattern() {

			return "";

		}

		public String CityOriginalDbColumnName() {

			return "City";

		}

		public String State;

		public String getState() {
			return this.State;
		}

		public Boolean StateIsNullable() {
			return true;
		}

		public Boolean StateIsKey() {
			return false;
		}

		public Integer StateLength() {
			return 2;
		}

		public Integer StatePrecision() {
			return 0;
		}

		public String StateDefault() {

			return null;

		}

		public String StateComment() {

			return "";

		}

		public String StatePattern() {

			return "";

		}

		public String StateOriginalDbColumnName() {

			return "State";

		}

		public Integer PostalCode;

		public Integer getPostalCode() {
			return this.PostalCode;
		}

		public Boolean PostalCodeIsNullable() {
			return true;
		}

		public Boolean PostalCodeIsKey() {
			return false;
		}

		public Integer PostalCodeLength() {
			return 10;
		}

		public Integer PostalCodePrecision() {
			return 0;
		}

		public String PostalCodeDefault() {

			return null;

		}

		public String PostalCodeComment() {

			return "";

		}

		public String PostalCodePattern() {

			return "";

		}

		public String PostalCodeOriginalDbColumnName() {

			return "PostalCode";

		}

		public java.util.Date Birthday;

		public java.util.Date getBirthday() {
			return this.Birthday;
		}

		public Boolean BirthdayIsNullable() {
			return true;
		}

		public Boolean BirthdayIsKey() {
			return false;
		}

		public Integer BirthdayLength() {
			return 19;
		}

		public Integer BirthdayPrecision() {
			return 0;
		}

		public String BirthdayDefault() {

			return null;

		}

		public String BirthdayComment() {

			return "";

		}

		public String BirthdayPattern() {

			return "MM/dd/yyyy";

		}

		public String BirthdayOriginalDbColumnName() {

			return "Birthday";

		}

		public String SSN;

		public String getSSN() {
			return this.SSN;
		}

		public Boolean SSNIsNullable() {
			return true;
		}

		public Boolean SSNIsKey() {
			return false;
		}

		public Integer SSNLength() {
			return 11;
		}

		public Integer SSNPrecision() {
			return 0;
		}

		public String SSNDefault() {

			return null;

		}

		public String SSNComment() {

			return "";

		}

		public String SSNPattern() {

			return "";

		}

		public String SSNOriginalDbColumnName() {

			return "SSN";

		}

		public Integer HPLNID;

		public Integer getHPLNID() {
			return this.HPLNID;
		}

		public Boolean HPLNIDIsNullable() {
			return true;
		}

		public Boolean HPLNIDIsKey() {
			return false;
		}

		public Integer HPLNIDLength() {
			return 10;
		}

		public Integer HPLNIDPrecision() {
			return 0;
		}

		public String HPLNIDDefault() {

			return null;

		}

		public String HPLNIDComment() {

			return "";

		}

		public String HPLNIDPattern() {

			return "";

		}

		public String HPLNIDOriginalDbColumnName() {

			return "HPLNID";

		}

		public String NYSIISFirstName;

		public String getNYSIISFirstName() {
			return this.NYSIISFirstName;
		}

		public Boolean NYSIISFirstNameIsNullable() {
			return true;
		}

		public Boolean NYSIISFirstNameIsKey() {
			return false;
		}

		public Integer NYSIISFirstNameLength() {
			return 16;
		}

		public Integer NYSIISFirstNamePrecision() {
			return 0;
		}

		public String NYSIISFirstNameDefault() {

			return null;

		}

		public String NYSIISFirstNameComment() {

			return "";

		}

		public String NYSIISFirstNamePattern() {

			return "";

		}

		public String NYSIISFirstNameOriginalDbColumnName() {

			return "NYSIISFirstName";

		}

		public String NYSIISLastName;

		public String getNYSIISLastName() {
			return this.NYSIISLastName;
		}

		public Boolean NYSIISLastNameIsNullable() {
			return true;
		}

		public Boolean NYSIISLastNameIsKey() {
			return false;
		}

		public Integer NYSIISLastNameLength() {
			return 10;
		}

		public Integer NYSIISLastNamePrecision() {
			return 0;
		}

		public String NYSIISLastNameDefault() {

			return null;

		}

		public String NYSIISLastNameComment() {

			return "";

		}

		public String NYSIISLastNamePattern() {

			return "";

		}

		public String NYSIISLastNameOriginalDbColumnName() {

			return "NYSIISLastName";

		}

		public String HealthPlanID;

		public String getHealthPlanID() {
			return this.HealthPlanID;
		}

		public Boolean HealthPlanIDIsNullable() {
			return true;
		}

		public Boolean HealthPlanIDIsKey() {
			return false;
		}

		public Integer HealthPlanIDLength() {
			return 8;
		}

		public Integer HealthPlanIDPrecision() {
			return 0;
		}

		public String HealthPlanIDDefault() {

			return null;

		}

		public String HealthPlanIDComment() {

			return "";

		}

		public String HealthPlanIDPattern() {

			return "";

		}

		public String HealthPlanIDOriginalDbColumnName() {

			return "HealthPlanID";

		}

		public Integer MRN;

		public Integer getMRN() {
			return this.MRN;
		}

		public Boolean MRNIsNullable() {
			return true;
		}

		public Boolean MRNIsKey() {
			return false;
		}

		public Integer MRNLength() {
			return 10;
		}

		public Integer MRNPrecision() {
			return 0;
		}

		public String MRNDefault() {

			return null;

		}

		public String MRNComment() {

			return "";

		}

		public String MRNPattern() {

			return "";

		}

		public String MRNOriginalDbColumnName() {

			return "MRN";

		}

		public String TargetFirstName;

		public String getTargetFirstName() {
			return this.TargetFirstName;
		}

		public Boolean TargetFirstNameIsNullable() {
			return true;
		}

		public Boolean TargetFirstNameIsKey() {
			return false;
		}

		public Integer TargetFirstNameLength() {
			return 16;
		}

		public Integer TargetFirstNamePrecision() {
			return 0;
		}

		public String TargetFirstNameDefault() {

			return null;

		}

		public String TargetFirstNameComment() {

			return "";

		}

		public String TargetFirstNamePattern() {

			return "";

		}

		public String TargetFirstNameOriginalDbColumnName() {

			return "TargetFirstName";

		}

		public String TargetLastName;

		public String getTargetLastName() {
			return this.TargetLastName;
		}

		public Boolean TargetLastNameIsNullable() {
			return true;
		}

		public Boolean TargetLastNameIsKey() {
			return false;
		}

		public Integer TargetLastNameLength() {
			return 10;
		}

		public Integer TargetLastNamePrecision() {
			return 0;
		}

		public String TargetLastNameDefault() {

			return null;

		}

		public String TargetLastNameComment() {

			return "";

		}

		public String TargetLastNamePattern() {

			return "";

		}

		public String TargetLastNameOriginalDbColumnName() {

			return "TargetLastName";

		}

		public String TargetGender;

		public String getTargetGender() {
			return this.TargetGender;
		}

		public Boolean TargetGenderIsNullable() {
			return true;
		}

		public Boolean TargetGenderIsKey() {
			return false;
		}

		public Integer TargetGenderLength() {
			return 6;
		}

		public Integer TargetGenderPrecision() {
			return 0;
		}

		public String TargetGenderDefault() {

			return null;

		}

		public String TargetGenderComment() {

			return "";

		}

		public String TargetGenderPattern() {

			return "";

		}

		public String TargetGenderOriginalDbColumnName() {

			return "TargetGender";

		}

		public String TargetPatientAddress;

		public String getTargetPatientAddress() {
			return this.TargetPatientAddress;
		}

		public Boolean TargetPatientAddressIsNullable() {
			return true;
		}

		public Boolean TargetPatientAddressIsKey() {
			return false;
		}

		public Integer TargetPatientAddressLength() {
			return 38;
		}

		public Integer TargetPatientAddressPrecision() {
			return 0;
		}

		public String TargetPatientAddressDefault() {

			return null;

		}

		public String TargetPatientAddressComment() {

			return "";

		}

		public String TargetPatientAddressPattern() {

			return "";

		}

		public String TargetPatientAddressOriginalDbColumnName() {

			return "TargetPatientAddress";

		}

		public String TargetCity;

		public String getTargetCity() {
			return this.TargetCity;
		}

		public Boolean TargetCityIsNullable() {
			return true;
		}

		public Boolean TargetCityIsKey() {
			return false;
		}

		public Integer TargetCityLength() {
			return 14;
		}

		public Integer TargetCityPrecision() {
			return 0;
		}

		public String TargetCityDefault() {

			return null;

		}

		public String TargetCityComment() {

			return "";

		}

		public String TargetCityPattern() {

			return "";

		}

		public String TargetCityOriginalDbColumnName() {

			return "TargetCity";

		}

		public String TargetState;

		public String getTargetState() {
			return this.TargetState;
		}

		public Boolean TargetStateIsNullable() {
			return true;
		}

		public Boolean TargetStateIsKey() {
			return false;
		}

		public Integer TargetStateLength() {
			return 2;
		}

		public Integer TargetStatePrecision() {
			return 0;
		}

		public String TargetStateDefault() {

			return null;

		}

		public String TargetStateComment() {

			return "";

		}

		public String TargetStatePattern() {

			return "";

		}

		public String TargetStateOriginalDbColumnName() {

			return "TargetState";

		}

		public Integer TargetPostalCode;

		public Integer getTargetPostalCode() {
			return this.TargetPostalCode;
		}

		public Boolean TargetPostalCodeIsNullable() {
			return true;
		}

		public Boolean TargetPostalCodeIsKey() {
			return false;
		}

		public Integer TargetPostalCodeLength() {
			return 10;
		}

		public Integer TargetPostalCodePrecision() {
			return 0;
		}

		public String TargetPostalCodeDefault() {

			return null;

		}

		public String TargetPostalCodeComment() {

			return "";

		}

		public String TargetPostalCodePattern() {

			return "";

		}

		public String TargetPostalCodeOriginalDbColumnName() {

			return "TargetPostalCode";

		}

		public java.util.Date TargetBirthday;

		public java.util.Date getTargetBirthday() {
			return this.TargetBirthday;
		}

		public Boolean TargetBirthdayIsNullable() {
			return true;
		}

		public Boolean TargetBirthdayIsKey() {
			return false;
		}

		public Integer TargetBirthdayLength() {
			return 19;
		}

		public Integer TargetBirthdayPrecision() {
			return 0;
		}

		public String TargetBirthdayDefault() {

			return null;

		}

		public String TargetBirthdayComment() {

			return "";

		}

		public String TargetBirthdayPattern() {

			return "MM/dd/yyyy";

		}

		public String TargetBirthdayOriginalDbColumnName() {

			return "TargetBirthday";

		}

		public String TargetSSN;

		public String getTargetSSN() {
			return this.TargetSSN;
		}

		public Boolean TargetSSNIsNullable() {
			return true;
		}

		public Boolean TargetSSNIsKey() {
			return false;
		}

		public Integer TargetSSNLength() {
			return 11;
		}

		public Integer TargetSSNPrecision() {
			return 0;
		}

		public String TargetSSNDefault() {

			return null;

		}

		public String TargetSSNComment() {

			return "";

		}

		public String TargetSSNPattern() {

			return "";

		}

		public String TargetSSNOriginalDbColumnName() {

			return "TargetSSN";

		}

		public Integer TargetHPLNID;

		public Integer getTargetHPLNID() {
			return this.TargetHPLNID;
		}

		public Boolean TargetHPLNIDIsNullable() {
			return true;
		}

		public Boolean TargetHPLNIDIsKey() {
			return false;
		}

		public Integer TargetHPLNIDLength() {
			return 20;
		}

		public Integer TargetHPLNIDPrecision() {
			return 0;
		}

		public String TargetHPLNIDDefault() {

			return null;

		}

		public String TargetHPLNIDComment() {

			return "";

		}

		public String TargetHPLNIDPattern() {

			return "";

		}

		public String TargetHPLNIDOriginalDbColumnName() {

			return "TargetHPLNID";

		}

		public String TargetNYSIISFirstName;

		public String getTargetNYSIISFirstName() {
			return this.TargetNYSIISFirstName;
		}

		public Boolean TargetNYSIISFirstNameIsNullable() {
			return true;
		}

		public Boolean TargetNYSIISFirstNameIsKey() {
			return false;
		}

		public Integer TargetNYSIISFirstNameLength() {
			return 16;
		}

		public Integer TargetNYSIISFirstNamePrecision() {
			return 0;
		}

		public String TargetNYSIISFirstNameDefault() {

			return null;

		}

		public String TargetNYSIISFirstNameComment() {

			return "";

		}

		public String TargetNYSIISFirstNamePattern() {

			return "";

		}

		public String TargetNYSIISFirstNameOriginalDbColumnName() {

			return "TargetNYSIISFirstName";

		}

		public String TargetNYSIISLastName;

		public String getTargetNYSIISLastName() {
			return this.TargetNYSIISLastName;
		}

		public Boolean TargetNYSIISLastNameIsNullable() {
			return true;
		}

		public Boolean TargetNYSIISLastNameIsKey() {
			return false;
		}

		public Integer TargetNYSIISLastNameLength() {
			return 10;
		}

		public Integer TargetNYSIISLastNamePrecision() {
			return 0;
		}

		public String TargetNYSIISLastNameDefault() {

			return null;

		}

		public String TargetNYSIISLastNameComment() {

			return "";

		}

		public String TargetNYSIISLastNamePattern() {

			return "";

		}

		public String TargetNYSIISLastNameOriginalDbColumnName() {

			return "TargetNYSIISLastName";

		}

		public String TargetHealthPlanID;

		public String getTargetHealthPlanID() {
			return this.TargetHealthPlanID;
		}

		public Boolean TargetHealthPlanIDIsNullable() {
			return true;
		}

		public Boolean TargetHealthPlanIDIsKey() {
			return false;
		}

		public Integer TargetHealthPlanIDLength() {
			return 20;
		}

		public Integer TargetHealthPlanIDPrecision() {
			return 0;
		}

		public String TargetHealthPlanIDDefault() {

			return null;

		}

		public String TargetHealthPlanIDComment() {

			return "";

		}

		public String TargetHealthPlanIDPattern() {

			return "";

		}

		public String TargetHealthPlanIDOriginalDbColumnName() {

			return "TargetHealthPlanID";

		}

		public Integer TargetMRN;

		public Integer getTargetMRN() {
			return this.TargetMRN;
		}

		public Boolean TargetMRNIsNullable() {
			return true;
		}

		public Boolean TargetMRNIsKey() {
			return false;
		}

		public Integer TargetMRNLength() {
			return 10;
		}

		public Integer TargetMRNPrecision() {
			return 0;
		}

		public String TargetMRNDefault() {

			return null;

		}

		public String TargetMRNComment() {

			return "";

		}

		public String TargetMRNPattern() {

			return "";

		}

		public String TargetMRNOriginalDbColumnName() {

			return "TargetMRN";

		}

		public String SSNBlockingKey;

		public String getSSNBlockingKey() {
			return this.SSNBlockingKey;
		}

		public Boolean SSNBlockingKeyIsNullable() {
			return true;
		}

		public Boolean SSNBlockingKeyIsKey() {
			return false;
		}

		public Integer SSNBlockingKeyLength() {
			return 20;
		}

		public Integer SSNBlockingKeyPrecision() {
			return 0;
		}

		public String SSNBlockingKeyDefault() {

			return null;

		}

		public String SSNBlockingKeyComment() {

			return "";

		}

		public String SSNBlockingKeyPattern() {

			return "";

		}

		public String SSNBlockingKeyOriginalDbColumnName() {

			return "SSNBlockingKey";

		}

		public String FNDOBBlockingKey;

		public String getFNDOBBlockingKey() {
			return this.FNDOBBlockingKey;
		}

		public Boolean FNDOBBlockingKeyIsNullable() {
			return true;
		}

		public Boolean FNDOBBlockingKeyIsKey() {
			return false;
		}

		public Integer FNDOBBlockingKeyLength() {
			return 25;
		}

		public Integer FNDOBBlockingKeyPrecision() {
			return 0;
		}

		public String FNDOBBlockingKeyDefault() {

			return null;

		}

		public String FNDOBBlockingKeyComment() {

			return "";

		}

		public String FNDOBBlockingKeyPattern() {

			return "";

		}

		public String FNDOBBlockingKeyOriginalDbColumnName() {

			return "FNDOBBlockingKey";

		}

		public String LNPCBlockingKey;

		public String getLNPCBlockingKey() {
			return this.LNPCBlockingKey;
		}

		public Boolean LNPCBlockingKeyIsNullable() {
			return true;
		}

		public Boolean LNPCBlockingKeyIsKey() {
			return false;
		}

		public Integer LNPCBlockingKeyLength() {
			return 20;
		}

		public Integer LNPCBlockingKeyPrecision() {
			return 0;
		}

		public String LNPCBlockingKeyDefault() {

			return null;

		}

		public String LNPCBlockingKeyComment() {

			return "";

		}

		public String LNPCBlockingKeyPattern() {

			return "";

		}

		public String LNPCBlockingKeyOriginalDbColumnName() {

			return "LNPCBlockingKey";

		}

		public String NYSIISFNLNBlockingKey;

		public String getNYSIISFNLNBlockingKey() {
			return this.NYSIISFNLNBlockingKey;
		}

		public Boolean NYSIISFNLNBlockingKeyIsNullable() {
			return true;
		}

		public Boolean NYSIISFNLNBlockingKeyIsKey() {
			return false;
		}

		public Integer NYSIISFNLNBlockingKeyLength() {
			return 20;
		}

		public Integer NYSIISFNLNBlockingKeyPrecision() {
			return 0;
		}

		public String NYSIISFNLNBlockingKeyDefault() {

			return null;

		}

		public String NYSIISFNLNBlockingKeyComment() {

			return "";

		}

		public String NYSIISFNLNBlockingKeyPattern() {

			return "";

		}

		public String NYSIISFNLNBlockingKeyOriginalDbColumnName() {

			return "NYSIISFNLNBlockingKey";

		}

		public String DOBPCBlockingKey;

		public String getDOBPCBlockingKey() {
			return this.DOBPCBlockingKey;
		}

		public Boolean DOBPCBlockingKeyIsNullable() {
			return true;
		}

		public Boolean DOBPCBlockingKeyIsKey() {
			return false;
		}

		public Integer DOBPCBlockingKeyLength() {
			return 20;
		}

		public Integer DOBPCBlockingKeyPrecision() {
			return 0;
		}

		public String DOBPCBlockingKeyDefault() {

			return null;

		}

		public String DOBPCBlockingKeyComment() {

			return "";

		}

		public String DOBPCBlockingKeyPattern() {

			return "";

		}

		public String DOBPCBlockingKeyOriginalDbColumnName() {

			return "DOBPCBlockingKey";

		}

		public String MRNBlockingKey;

		public String getMRNBlockingKey() {
			return this.MRNBlockingKey;
		}

		public Boolean MRNBlockingKeyIsNullable() {
			return true;
		}

		public Boolean MRNBlockingKeyIsKey() {
			return false;
		}

		public Integer MRNBlockingKeyLength() {
			return 20;
		}

		public Integer MRNBlockingKeyPrecision() {
			return 0;
		}

		public String MRNBlockingKeyDefault() {

			return null;

		}

		public String MRNBlockingKeyComment() {

			return "";

		}

		public String MRNBlockingKeyPattern() {

			return "";

		}

		public String MRNBlockingKeyOriginalDbColumnName() {

			return "MRNBlockingKey";

		}

		public String HealthPlanIDBlockingKey;

		public String getHealthPlanIDBlockingKey() {
			return this.HealthPlanIDBlockingKey;
		}

		public Boolean HealthPlanIDBlockingKeyIsNullable() {
			return true;
		}

		public Boolean HealthPlanIDBlockingKeyIsKey() {
			return false;
		}

		public Integer HealthPlanIDBlockingKeyLength() {
			return 20;
		}

		public Integer HealthPlanIDBlockingKeyPrecision() {
			return 0;
		}

		public String HealthPlanIDBlockingKeyDefault() {

			return null;

		}

		public String HealthPlanIDBlockingKeyComment() {

			return "";

		}

		public String HealthPlanIDBlockingKeyPattern() {

			return "";

		}

		public String HealthPlanIDBlockingKeyOriginalDbColumnName() {

			return "HealthPlanIDBlockingKey";

		}

		public String MATCHING_DISTANCES;

		public String getMATCHING_DISTANCES() {
			return this.MATCHING_DISTANCES;
		}

		public Boolean MATCHING_DISTANCESIsNullable() {
			return true;
		}

		public Boolean MATCHING_DISTANCESIsKey() {
			return false;
		}

		public Integer MATCHING_DISTANCESLength() {
			return 255;
		}

		public Integer MATCHING_DISTANCESPrecision() {
			return 0;
		}

		public String MATCHING_DISTANCESDefault() {

			return null;

		}

		public String MATCHING_DISTANCESComment() {

			return null;

		}

		public String MATCHING_DISTANCESPattern() {

			return null;

		}

		public String MATCHING_DISTANCESOriginalDbColumnName() {

			return "MATCHING_DISTANCES";

		}

		public Double MATCHING_WEIGHT;

		public Double getMATCHING_WEIGHT() {
			return this.MATCHING_WEIGHT;
		}

		public Boolean MATCHING_WEIGHTIsNullable() {
			return true;
		}

		public Boolean MATCHING_WEIGHTIsKey() {
			return false;
		}

		public Integer MATCHING_WEIGHTLength() {
			return 20;
		}

		public Integer MATCHING_WEIGHTPrecision() {
			return 0;
		}

		public String MATCHING_WEIGHTDefault() {

			return "";

		}

		public String MATCHING_WEIGHTComment() {

			return null;

		}

		public String MATCHING_WEIGHTPattern() {

			return null;

		}

		public String MATCHING_WEIGHTOriginalDbColumnName() {

			return "MATCHING_WEIGHT";

		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Matching_Distances_2.length) {
					if (length < 1024 && commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Matching_Distances_2.length == 0) {
						commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Matching_Distances_2 = new byte[1024];
					} else {
						commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Matching_Distances_2 = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Matching_Distances_2, 0, length);
				strReturn = new String(commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Matching_Distances_2, 0, length,
						utf8Charset);
			}
			return strReturn;
		}

		private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException {
			String strReturn = null;
			int length = 0;
			length = unmarshaller.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Matching_Distances_2.length) {
					if (length < 1024 && commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Matching_Distances_2.length == 0) {
						commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Matching_Distances_2 = new byte[1024];
					} else {
						commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Matching_Distances_2 = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Matching_Distances_2, 0, length);
				strReturn = new String(commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Matching_Distances_2, 0, length,
						utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		private Integer readInteger(ObjectInputStream dis) throws IOException {
			Integer intReturn;
			int length = 0;
			length = dis.readByte();
			if (length == -1) {
				intReturn = null;
			} else {
				intReturn = dis.readInt();
			}
			return intReturn;
		}

		private Integer readInteger(org.jboss.marshalling.Unmarshaller dis) throws IOException {
			Integer intReturn;
			int length = 0;
			length = dis.readByte();
			if (length == -1) {
				intReturn = null;
			} else {
				intReturn = dis.readInt();
			}
			return intReturn;
		}

		private void writeInteger(Integer intNum, ObjectOutputStream dos) throws IOException {
			if (intNum == null) {
				dos.writeByte(-1);
			} else {
				dos.writeByte(0);
				dos.writeInt(intNum);
			}
		}

		private void writeInteger(Integer intNum, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (intNum == null) {
				marshaller.writeByte(-1);
			} else {
				marshaller.writeByte(0);
				marshaller.writeInt(intNum);
			}
		}

		private java.util.Date readDate(ObjectInputStream dis) throws IOException {
			java.util.Date dateReturn = null;
			int length = 0;
			length = dis.readByte();
			if (length == -1) {
				dateReturn = null;
			} else {
				dateReturn = new Date(dis.readLong());
			}
			return dateReturn;
		}

		private java.util.Date readDate(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException {
			java.util.Date dateReturn = null;
			int length = 0;
			length = unmarshaller.readByte();
			if (length == -1) {
				dateReturn = null;
			} else {
				dateReturn = new Date(unmarshaller.readLong());
			}
			return dateReturn;
		}

		private void writeDate(java.util.Date date1, ObjectOutputStream dos) throws IOException {
			if (date1 == null) {
				dos.writeByte(-1);
			} else {
				dos.writeByte(0);
				dos.writeLong(date1.getTime());
			}
		}

		private void writeDate(java.util.Date date1, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (date1 == null) {
				marshaller.writeByte(-1);
			} else {
				marshaller.writeByte(0);
				marshaller.writeLong(date1.getTime());
			}
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_TALENDCLOUDDEMOBANK_CHIA_Matching_Distances_2) {

				try {

					int length = 0;

					this.FirstName = readString(dis);

					this.LastName = readString(dis);

					this.Gender = readString(dis);

					this.PatientAddress = readString(dis);

					this.City = readString(dis);

					this.State = readString(dis);

					this.PostalCode = readInteger(dis);

					this.Birthday = readDate(dis);

					this.SSN = readString(dis);

					this.HPLNID = readInteger(dis);

					this.NYSIISFirstName = readString(dis);

					this.NYSIISLastName = readString(dis);

					this.HealthPlanID = readString(dis);

					this.MRN = readInteger(dis);

					this.TargetFirstName = readString(dis);

					this.TargetLastName = readString(dis);

					this.TargetGender = readString(dis);

					this.TargetPatientAddress = readString(dis);

					this.TargetCity = readString(dis);

					this.TargetState = readString(dis);

					this.TargetPostalCode = readInteger(dis);

					this.TargetBirthday = readDate(dis);

					this.TargetSSN = readString(dis);

					this.TargetHPLNID = readInteger(dis);

					this.TargetNYSIISFirstName = readString(dis);

					this.TargetNYSIISLastName = readString(dis);

					this.TargetHealthPlanID = readString(dis);

					this.TargetMRN = readInteger(dis);

					this.SSNBlockingKey = readString(dis);

					this.FNDOBBlockingKey = readString(dis);

					this.LNPCBlockingKey = readString(dis);

					this.NYSIISFNLNBlockingKey = readString(dis);

					this.DOBPCBlockingKey = readString(dis);

					this.MRNBlockingKey = readString(dis);

					this.HealthPlanIDBlockingKey = readString(dis);

					this.MATCHING_DISTANCES = readString(dis);

					length = dis.readByte();
					if (length == -1) {
						this.MATCHING_WEIGHT = null;
					} else {
						this.MATCHING_WEIGHT = dis.readDouble();
					}

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_TALENDCLOUDDEMOBANK_CHIA_Matching_Distances_2) {

				try {

					int length = 0;

					this.FirstName = readString(dis);

					this.LastName = readString(dis);

					this.Gender = readString(dis);

					this.PatientAddress = readString(dis);

					this.City = readString(dis);

					this.State = readString(dis);

					this.PostalCode = readInteger(dis);

					this.Birthday = readDate(dis);

					this.SSN = readString(dis);

					this.HPLNID = readInteger(dis);

					this.NYSIISFirstName = readString(dis);

					this.NYSIISLastName = readString(dis);

					this.HealthPlanID = readString(dis);

					this.MRN = readInteger(dis);

					this.TargetFirstName = readString(dis);

					this.TargetLastName = readString(dis);

					this.TargetGender = readString(dis);

					this.TargetPatientAddress = readString(dis);

					this.TargetCity = readString(dis);

					this.TargetState = readString(dis);

					this.TargetPostalCode = readInteger(dis);

					this.TargetBirthday = readDate(dis);

					this.TargetSSN = readString(dis);

					this.TargetHPLNID = readInteger(dis);

					this.TargetNYSIISFirstName = readString(dis);

					this.TargetNYSIISLastName = readString(dis);

					this.TargetHealthPlanID = readString(dis);

					this.TargetMRN = readInteger(dis);

					this.SSNBlockingKey = readString(dis);

					this.FNDOBBlockingKey = readString(dis);

					this.LNPCBlockingKey = readString(dis);

					this.NYSIISFNLNBlockingKey = readString(dis);

					this.DOBPCBlockingKey = readString(dis);

					this.MRNBlockingKey = readString(dis);

					this.HealthPlanIDBlockingKey = readString(dis);

					this.MATCHING_DISTANCES = readString(dis);

					length = dis.readByte();
					if (length == -1) {
						this.MATCHING_WEIGHT = null;
					} else {
						this.MATCHING_WEIGHT = dis.readDouble();
					}

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// String

				writeString(this.FirstName, dos);

				// String

				writeString(this.LastName, dos);

				// String

				writeString(this.Gender, dos);

				// String

				writeString(this.PatientAddress, dos);

				// String

				writeString(this.City, dos);

				// String

				writeString(this.State, dos);

				// Integer

				writeInteger(this.PostalCode, dos);

				// java.util.Date

				writeDate(this.Birthday, dos);

				// String

				writeString(this.SSN, dos);

				// Integer

				writeInteger(this.HPLNID, dos);

				// String

				writeString(this.NYSIISFirstName, dos);

				// String

				writeString(this.NYSIISLastName, dos);

				// String

				writeString(this.HealthPlanID, dos);

				// Integer

				writeInteger(this.MRN, dos);

				// String

				writeString(this.TargetFirstName, dos);

				// String

				writeString(this.TargetLastName, dos);

				// String

				writeString(this.TargetGender, dos);

				// String

				writeString(this.TargetPatientAddress, dos);

				// String

				writeString(this.TargetCity, dos);

				// String

				writeString(this.TargetState, dos);

				// Integer

				writeInteger(this.TargetPostalCode, dos);

				// java.util.Date

				writeDate(this.TargetBirthday, dos);

				// String

				writeString(this.TargetSSN, dos);

				// Integer

				writeInteger(this.TargetHPLNID, dos);

				// String

				writeString(this.TargetNYSIISFirstName, dos);

				// String

				writeString(this.TargetNYSIISLastName, dos);

				// String

				writeString(this.TargetHealthPlanID, dos);

				// Integer

				writeInteger(this.TargetMRN, dos);

				// String

				writeString(this.SSNBlockingKey, dos);

				// String

				writeString(this.FNDOBBlockingKey, dos);

				// String

				writeString(this.LNPCBlockingKey, dos);

				// String

				writeString(this.NYSIISFNLNBlockingKey, dos);

				// String

				writeString(this.DOBPCBlockingKey, dos);

				// String

				writeString(this.MRNBlockingKey, dos);

				// String

				writeString(this.HealthPlanIDBlockingKey, dos);

				// String

				writeString(this.MATCHING_DISTANCES, dos);

				// Double

				if (this.MATCHING_WEIGHT == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeDouble(this.MATCHING_WEIGHT);
				}

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// String

				writeString(this.FirstName, dos);

				// String

				writeString(this.LastName, dos);

				// String

				writeString(this.Gender, dos);

				// String

				writeString(this.PatientAddress, dos);

				// String

				writeString(this.City, dos);

				// String

				writeString(this.State, dos);

				// Integer

				writeInteger(this.PostalCode, dos);

				// java.util.Date

				writeDate(this.Birthday, dos);

				// String

				writeString(this.SSN, dos);

				// Integer

				writeInteger(this.HPLNID, dos);

				// String

				writeString(this.NYSIISFirstName, dos);

				// String

				writeString(this.NYSIISLastName, dos);

				// String

				writeString(this.HealthPlanID, dos);

				// Integer

				writeInteger(this.MRN, dos);

				// String

				writeString(this.TargetFirstName, dos);

				// String

				writeString(this.TargetLastName, dos);

				// String

				writeString(this.TargetGender, dos);

				// String

				writeString(this.TargetPatientAddress, dos);

				// String

				writeString(this.TargetCity, dos);

				// String

				writeString(this.TargetState, dos);

				// Integer

				writeInteger(this.TargetPostalCode, dos);

				// java.util.Date

				writeDate(this.TargetBirthday, dos);

				// String

				writeString(this.TargetSSN, dos);

				// Integer

				writeInteger(this.TargetHPLNID, dos);

				// String

				writeString(this.TargetNYSIISFirstName, dos);

				// String

				writeString(this.TargetNYSIISLastName, dos);

				// String

				writeString(this.TargetHealthPlanID, dos);

				// Integer

				writeInteger(this.TargetMRN, dos);

				// String

				writeString(this.SSNBlockingKey, dos);

				// String

				writeString(this.FNDOBBlockingKey, dos);

				// String

				writeString(this.LNPCBlockingKey, dos);

				// String

				writeString(this.NYSIISFNLNBlockingKey, dos);

				// String

				writeString(this.DOBPCBlockingKey, dos);

				// String

				writeString(this.MRNBlockingKey, dos);

				// String

				writeString(this.HealthPlanIDBlockingKey, dos);

				// String

				writeString(this.MATCHING_DISTANCES, dos);

				// Double

				if (this.MATCHING_WEIGHT == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeDouble(this.MATCHING_WEIGHT);
				}

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("FirstName=" + FirstName);
			sb.append(",LastName=" + LastName);
			sb.append(",Gender=" + Gender);
			sb.append(",PatientAddress=" + PatientAddress);
			sb.append(",City=" + City);
			sb.append(",State=" + State);
			sb.append(",PostalCode=" + String.valueOf(PostalCode));
			sb.append(",Birthday=" + String.valueOf(Birthday));
			sb.append(",SSN=" + SSN);
			sb.append(",HPLNID=" + String.valueOf(HPLNID));
			sb.append(",NYSIISFirstName=" + NYSIISFirstName);
			sb.append(",NYSIISLastName=" + NYSIISLastName);
			sb.append(",HealthPlanID=" + HealthPlanID);
			sb.append(",MRN=" + String.valueOf(MRN));
			sb.append(",TargetFirstName=" + TargetFirstName);
			sb.append(",TargetLastName=" + TargetLastName);
			sb.append(",TargetGender=" + TargetGender);
			sb.append(",TargetPatientAddress=" + TargetPatientAddress);
			sb.append(",TargetCity=" + TargetCity);
			sb.append(",TargetState=" + TargetState);
			sb.append(",TargetPostalCode=" + String.valueOf(TargetPostalCode));
			sb.append(",TargetBirthday=" + String.valueOf(TargetBirthday));
			sb.append(",TargetSSN=" + TargetSSN);
			sb.append(",TargetHPLNID=" + String.valueOf(TargetHPLNID));
			sb.append(",TargetNYSIISFirstName=" + TargetNYSIISFirstName);
			sb.append(",TargetNYSIISLastName=" + TargetNYSIISLastName);
			sb.append(",TargetHealthPlanID=" + TargetHealthPlanID);
			sb.append(",TargetMRN=" + String.valueOf(TargetMRN));
			sb.append(",SSNBlockingKey=" + SSNBlockingKey);
			sb.append(",FNDOBBlockingKey=" + FNDOBBlockingKey);
			sb.append(",LNPCBlockingKey=" + LNPCBlockingKey);
			sb.append(",NYSIISFNLNBlockingKey=" + NYSIISFNLNBlockingKey);
			sb.append(",DOBPCBlockingKey=" + DOBPCBlockingKey);
			sb.append(",MRNBlockingKey=" + MRNBlockingKey);
			sb.append(",HealthPlanIDBlockingKey=" + HealthPlanIDBlockingKey);
			sb.append(",MATCHING_DISTANCES=" + MATCHING_DISTANCES);
			sb.append(",MATCHING_WEIGHT=" + String.valueOf(MATCHING_WEIGHT));
			sb.append("]");

			return sb.toString();
		}

		public String toLogString() {
			StringBuilder sb = new StringBuilder();

			if (FirstName == null) {
				sb.append("<null>");
			} else {
				sb.append(FirstName);
			}

			sb.append("|");

			if (LastName == null) {
				sb.append("<null>");
			} else {
				sb.append(LastName);
			}

			sb.append("|");

			if (Gender == null) {
				sb.append("<null>");
			} else {
				sb.append(Gender);
			}

			sb.append("|");

			if (PatientAddress == null) {
				sb.append("<null>");
			} else {
				sb.append(PatientAddress);
			}

			sb.append("|");

			if (City == null) {
				sb.append("<null>");
			} else {
				sb.append(City);
			}

			sb.append("|");

			if (State == null) {
				sb.append("<null>");
			} else {
				sb.append(State);
			}

			sb.append("|");

			if (PostalCode == null) {
				sb.append("<null>");
			} else {
				sb.append(PostalCode);
			}

			sb.append("|");

			if (Birthday == null) {
				sb.append("<null>");
			} else {
				sb.append(Birthday);
			}

			sb.append("|");

			if (SSN == null) {
				sb.append("<null>");
			} else {
				sb.append(SSN);
			}

			sb.append("|");

			if (HPLNID == null) {
				sb.append("<null>");
			} else {
				sb.append(HPLNID);
			}

			sb.append("|");

			if (NYSIISFirstName == null) {
				sb.append("<null>");
			} else {
				sb.append(NYSIISFirstName);
			}

			sb.append("|");

			if (NYSIISLastName == null) {
				sb.append("<null>");
			} else {
				sb.append(NYSIISLastName);
			}

			sb.append("|");

			if (HealthPlanID == null) {
				sb.append("<null>");
			} else {
				sb.append(HealthPlanID);
			}

			sb.append("|");

			if (MRN == null) {
				sb.append("<null>");
			} else {
				sb.append(MRN);
			}

			sb.append("|");

			if (TargetFirstName == null) {
				sb.append("<null>");
			} else {
				sb.append(TargetFirstName);
			}

			sb.append("|");

			if (TargetLastName == null) {
				sb.append("<null>");
			} else {
				sb.append(TargetLastName);
			}

			sb.append("|");

			if (TargetGender == null) {
				sb.append("<null>");
			} else {
				sb.append(TargetGender);
			}

			sb.append("|");

			if (TargetPatientAddress == null) {
				sb.append("<null>");
			} else {
				sb.append(TargetPatientAddress);
			}

			sb.append("|");

			if (TargetCity == null) {
				sb.append("<null>");
			} else {
				sb.append(TargetCity);
			}

			sb.append("|");

			if (TargetState == null) {
				sb.append("<null>");
			} else {
				sb.append(TargetState);
			}

			sb.append("|");

			if (TargetPostalCode == null) {
				sb.append("<null>");
			} else {
				sb.append(TargetPostalCode);
			}

			sb.append("|");

			if (TargetBirthday == null) {
				sb.append("<null>");
			} else {
				sb.append(TargetBirthday);
			}

			sb.append("|");

			if (TargetSSN == null) {
				sb.append("<null>");
			} else {
				sb.append(TargetSSN);
			}

			sb.append("|");

			if (TargetHPLNID == null) {
				sb.append("<null>");
			} else {
				sb.append(TargetHPLNID);
			}

			sb.append("|");

			if (TargetNYSIISFirstName == null) {
				sb.append("<null>");
			} else {
				sb.append(TargetNYSIISFirstName);
			}

			sb.append("|");

			if (TargetNYSIISLastName == null) {
				sb.append("<null>");
			} else {
				sb.append(TargetNYSIISLastName);
			}

			sb.append("|");

			if (TargetHealthPlanID == null) {
				sb.append("<null>");
			} else {
				sb.append(TargetHealthPlanID);
			}

			sb.append("|");

			if (TargetMRN == null) {
				sb.append("<null>");
			} else {
				sb.append(TargetMRN);
			}

			sb.append("|");

			if (SSNBlockingKey == null) {
				sb.append("<null>");
			} else {
				sb.append(SSNBlockingKey);
			}

			sb.append("|");

			if (FNDOBBlockingKey == null) {
				sb.append("<null>");
			} else {
				sb.append(FNDOBBlockingKey);
			}

			sb.append("|");

			if (LNPCBlockingKey == null) {
				sb.append("<null>");
			} else {
				sb.append(LNPCBlockingKey);
			}

			sb.append("|");

			if (NYSIISFNLNBlockingKey == null) {
				sb.append("<null>");
			} else {
				sb.append(NYSIISFNLNBlockingKey);
			}

			sb.append("|");

			if (DOBPCBlockingKey == null) {
				sb.append("<null>");
			} else {
				sb.append(DOBPCBlockingKey);
			}

			sb.append("|");

			if (MRNBlockingKey == null) {
				sb.append("<null>");
			} else {
				sb.append(MRNBlockingKey);
			}

			sb.append("|");

			if (HealthPlanIDBlockingKey == null) {
				sb.append("<null>");
			} else {
				sb.append(HealthPlanIDBlockingKey);
			}

			sb.append("|");

			if (MATCHING_DISTANCES == null) {
				sb.append("<null>");
			} else {
				sb.append(MATCHING_DISTANCES);
			}

			sb.append("|");

			if (MATCHING_WEIGHT == null) {
				sb.append("<null>");
			} else {
				sb.append(MATCHING_WEIGHT);
			}

			sb.append("|");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(PossibleMatchesStruct other) {

			int returnValue = -1;

			return returnValue;
		}

		private int checkNullsAndCompare(Object object1, Object object2) {
			int returnValue = 0;
			if (object1 instanceof Comparable && object2 instanceof Comparable) {
				returnValue = ((Comparable) object1).compareTo(object2);
			} else if (object1 != null && object2 != null) {
				returnValue = compareStrings(object1.toString(), object2.toString());
			} else if (object1 == null && object2 != null) {
				returnValue = 1;
			} else if (object1 != null && object2 == null) {
				returnValue = -1;
			} else {
				returnValue = 0;
			}

			return returnValue;
		}

		private int compareStrings(String string1, String string2) {
			return string1.compareTo(string2);
		}

	}

	public static class SourceStruct implements routines.system.IPersistableRow<SourceStruct> {
		final static byte[] commonByteArrayLock_TALENDCLOUDDEMOBANK_CHIA_Matching_Distances_2 = new byte[0];
		static byte[] commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Matching_Distances_2 = new byte[0];

		public String FirstName;

		public String getFirstName() {
			return this.FirstName;
		}

		public Boolean FirstNameIsNullable() {
			return true;
		}

		public Boolean FirstNameIsKey() {
			return false;
		}

		public Integer FirstNameLength() {
			return 16;
		}

		public Integer FirstNamePrecision() {
			return 0;
		}

		public String FirstNameDefault() {

			return null;

		}

		public String FirstNameComment() {

			return "";

		}

		public String FirstNamePattern() {

			return "";

		}

		public String FirstNameOriginalDbColumnName() {

			return "FirstName";

		}

		public String LastName;

		public String getLastName() {
			return this.LastName;
		}

		public Boolean LastNameIsNullable() {
			return true;
		}

		public Boolean LastNameIsKey() {
			return false;
		}

		public Integer LastNameLength() {
			return 10;
		}

		public Integer LastNamePrecision() {
			return 0;
		}

		public String LastNameDefault() {

			return null;

		}

		public String LastNameComment() {

			return "";

		}

		public String LastNamePattern() {

			return "";

		}

		public String LastNameOriginalDbColumnName() {

			return "LastName";

		}

		public String Gender;

		public String getGender() {
			return this.Gender;
		}

		public Boolean GenderIsNullable() {
			return true;
		}

		public Boolean GenderIsKey() {
			return false;
		}

		public Integer GenderLength() {
			return 6;
		}

		public Integer GenderPrecision() {
			return 0;
		}

		public String GenderDefault() {

			return null;

		}

		public String GenderComment() {

			return "";

		}

		public String GenderPattern() {

			return "";

		}

		public String GenderOriginalDbColumnName() {

			return "Gender";

		}

		public String PatientAddress;

		public String getPatientAddress() {
			return this.PatientAddress;
		}

		public Boolean PatientAddressIsNullable() {
			return true;
		}

		public Boolean PatientAddressIsKey() {
			return false;
		}

		public Integer PatientAddressLength() {
			return 38;
		}

		public Integer PatientAddressPrecision() {
			return 0;
		}

		public String PatientAddressDefault() {

			return null;

		}

		public String PatientAddressComment() {

			return "";

		}

		public String PatientAddressPattern() {

			return "";

		}

		public String PatientAddressOriginalDbColumnName() {

			return "PatientAddress";

		}

		public String City;

		public String getCity() {
			return this.City;
		}

		public Boolean CityIsNullable() {
			return true;
		}

		public Boolean CityIsKey() {
			return false;
		}

		public Integer CityLength() {
			return 14;
		}

		public Integer CityPrecision() {
			return 0;
		}

		public String CityDefault() {

			return null;

		}

		public String CityComment() {

			return "";

		}

		public String CityPattern() {

			return "";

		}

		public String CityOriginalDbColumnName() {

			return "City";

		}

		public String State;

		public String getState() {
			return this.State;
		}

		public Boolean StateIsNullable() {
			return true;
		}

		public Boolean StateIsKey() {
			return false;
		}

		public Integer StateLength() {
			return 2;
		}

		public Integer StatePrecision() {
			return 0;
		}

		public String StateDefault() {

			return null;

		}

		public String StateComment() {

			return "";

		}

		public String StatePattern() {

			return "";

		}

		public String StateOriginalDbColumnName() {

			return "State";

		}

		public Integer PostalCode;

		public Integer getPostalCode() {
			return this.PostalCode;
		}

		public Boolean PostalCodeIsNullable() {
			return true;
		}

		public Boolean PostalCodeIsKey() {
			return false;
		}

		public Integer PostalCodeLength() {
			return 10;
		}

		public Integer PostalCodePrecision() {
			return 0;
		}

		public String PostalCodeDefault() {

			return null;

		}

		public String PostalCodeComment() {

			return "";

		}

		public String PostalCodePattern() {

			return "";

		}

		public String PostalCodeOriginalDbColumnName() {

			return "PostalCode";

		}

		public java.util.Date Birthday;

		public java.util.Date getBirthday() {
			return this.Birthday;
		}

		public Boolean BirthdayIsNullable() {
			return true;
		}

		public Boolean BirthdayIsKey() {
			return false;
		}

		public Integer BirthdayLength() {
			return 19;
		}

		public Integer BirthdayPrecision() {
			return 0;
		}

		public String BirthdayDefault() {

			return null;

		}

		public String BirthdayComment() {

			return "";

		}

		public String BirthdayPattern() {

			return "dd-MM-yyyy";

		}

		public String BirthdayOriginalDbColumnName() {

			return "Birthday";

		}

		public String SSN;

		public String getSSN() {
			return this.SSN;
		}

		public Boolean SSNIsNullable() {
			return true;
		}

		public Boolean SSNIsKey() {
			return false;
		}

		public Integer SSNLength() {
			return 11;
		}

		public Integer SSNPrecision() {
			return 0;
		}

		public String SSNDefault() {

			return null;

		}

		public String SSNComment() {

			return "";

		}

		public String SSNPattern() {

			return "";

		}

		public String SSNOriginalDbColumnName() {

			return "SSN";

		}

		public Integer HPLNID;

		public Integer getHPLNID() {
			return this.HPLNID;
		}

		public Boolean HPLNIDIsNullable() {
			return true;
		}

		public Boolean HPLNIDIsKey() {
			return false;
		}

		public Integer HPLNIDLength() {
			return 10;
		}

		public Integer HPLNIDPrecision() {
			return 0;
		}

		public String HPLNIDDefault() {

			return null;

		}

		public String HPLNIDComment() {

			return "";

		}

		public String HPLNIDPattern() {

			return "";

		}

		public String HPLNIDOriginalDbColumnName() {

			return "HPLNID";

		}

		public String NYSIISFirstName;

		public String getNYSIISFirstName() {
			return this.NYSIISFirstName;
		}

		public Boolean NYSIISFirstNameIsNullable() {
			return true;
		}

		public Boolean NYSIISFirstNameIsKey() {
			return false;
		}

		public Integer NYSIISFirstNameLength() {
			return 16;
		}

		public Integer NYSIISFirstNamePrecision() {
			return 0;
		}

		public String NYSIISFirstNameDefault() {

			return null;

		}

		public String NYSIISFirstNameComment() {

			return "";

		}

		public String NYSIISFirstNamePattern() {

			return "";

		}

		public String NYSIISFirstNameOriginalDbColumnName() {

			return "NYSIISFirstName";

		}

		public String NYSIISLastName;

		public String getNYSIISLastName() {
			return this.NYSIISLastName;
		}

		public Boolean NYSIISLastNameIsNullable() {
			return true;
		}

		public Boolean NYSIISLastNameIsKey() {
			return false;
		}

		public Integer NYSIISLastNameLength() {
			return 10;
		}

		public Integer NYSIISLastNamePrecision() {
			return 0;
		}

		public String NYSIISLastNameDefault() {

			return null;

		}

		public String NYSIISLastNameComment() {

			return "";

		}

		public String NYSIISLastNamePattern() {

			return "";

		}

		public String NYSIISLastNameOriginalDbColumnName() {

			return "NYSIISLastName";

		}

		public String HealthPlanID;

		public String getHealthPlanID() {
			return this.HealthPlanID;
		}

		public Boolean HealthPlanIDIsNullable() {
			return true;
		}

		public Boolean HealthPlanIDIsKey() {
			return false;
		}

		public Integer HealthPlanIDLength() {
			return 8;
		}

		public Integer HealthPlanIDPrecision() {
			return 0;
		}

		public String HealthPlanIDDefault() {

			return null;

		}

		public String HealthPlanIDComment() {

			return "";

		}

		public String HealthPlanIDPattern() {

			return "";

		}

		public String HealthPlanIDOriginalDbColumnName() {

			return "HealthPlanID";

		}

		public Integer MRN;

		public Integer getMRN() {
			return this.MRN;
		}

		public Boolean MRNIsNullable() {
			return true;
		}

		public Boolean MRNIsKey() {
			return false;
		}

		public Integer MRNLength() {
			return 10;
		}

		public Integer MRNPrecision() {
			return 0;
		}

		public String MRNDefault() {

			return null;

		}

		public String MRNComment() {

			return "";

		}

		public String MRNPattern() {

			return "";

		}

		public String MRNOriginalDbColumnName() {

			return "MRN";

		}

		public String SSNBlockingKey;

		public String getSSNBlockingKey() {
			return this.SSNBlockingKey;
		}

		public Boolean SSNBlockingKeyIsNullable() {
			return true;
		}

		public Boolean SSNBlockingKeyIsKey() {
			return false;
		}

		public Integer SSNBlockingKeyLength() {
			return 20;
		}

		public Integer SSNBlockingKeyPrecision() {
			return 0;
		}

		public String SSNBlockingKeyDefault() {

			return null;

		}

		public String SSNBlockingKeyComment() {

			return "";

		}

		public String SSNBlockingKeyPattern() {

			return "";

		}

		public String SSNBlockingKeyOriginalDbColumnName() {

			return "SSNBlockingKey";

		}

		public String FNDOBBlockingKey;

		public String getFNDOBBlockingKey() {
			return this.FNDOBBlockingKey;
		}

		public Boolean FNDOBBlockingKeyIsNullable() {
			return true;
		}

		public Boolean FNDOBBlockingKeyIsKey() {
			return false;
		}

		public Integer FNDOBBlockingKeyLength() {
			return 25;
		}

		public Integer FNDOBBlockingKeyPrecision() {
			return 0;
		}

		public String FNDOBBlockingKeyDefault() {

			return null;

		}

		public String FNDOBBlockingKeyComment() {

			return "";

		}

		public String FNDOBBlockingKeyPattern() {

			return "";

		}

		public String FNDOBBlockingKeyOriginalDbColumnName() {

			return "FNDOBBlockingKey";

		}

		public String LNPCBlockingKey;

		public String getLNPCBlockingKey() {
			return this.LNPCBlockingKey;
		}

		public Boolean LNPCBlockingKeyIsNullable() {
			return true;
		}

		public Boolean LNPCBlockingKeyIsKey() {
			return false;
		}

		public Integer LNPCBlockingKeyLength() {
			return 20;
		}

		public Integer LNPCBlockingKeyPrecision() {
			return 0;
		}

		public String LNPCBlockingKeyDefault() {

			return null;

		}

		public String LNPCBlockingKeyComment() {

			return "";

		}

		public String LNPCBlockingKeyPattern() {

			return "";

		}

		public String LNPCBlockingKeyOriginalDbColumnName() {

			return "LNPCBlockingKey";

		}

		public String NYSIISFNLNBlockingKey;

		public String getNYSIISFNLNBlockingKey() {
			return this.NYSIISFNLNBlockingKey;
		}

		public Boolean NYSIISFNLNBlockingKeyIsNullable() {
			return true;
		}

		public Boolean NYSIISFNLNBlockingKeyIsKey() {
			return false;
		}

		public Integer NYSIISFNLNBlockingKeyLength() {
			return 20;
		}

		public Integer NYSIISFNLNBlockingKeyPrecision() {
			return 0;
		}

		public String NYSIISFNLNBlockingKeyDefault() {

			return null;

		}

		public String NYSIISFNLNBlockingKeyComment() {

			return "";

		}

		public String NYSIISFNLNBlockingKeyPattern() {

			return "";

		}

		public String NYSIISFNLNBlockingKeyOriginalDbColumnName() {

			return "NYSIISFNLNBlockingKey";

		}

		public String DOBPCBlockingKey;

		public String getDOBPCBlockingKey() {
			return this.DOBPCBlockingKey;
		}

		public Boolean DOBPCBlockingKeyIsNullable() {
			return true;
		}

		public Boolean DOBPCBlockingKeyIsKey() {
			return false;
		}

		public Integer DOBPCBlockingKeyLength() {
			return 20;
		}

		public Integer DOBPCBlockingKeyPrecision() {
			return 0;
		}

		public String DOBPCBlockingKeyDefault() {

			return null;

		}

		public String DOBPCBlockingKeyComment() {

			return "";

		}

		public String DOBPCBlockingKeyPattern() {

			return "";

		}

		public String DOBPCBlockingKeyOriginalDbColumnName() {

			return "DOBPCBlockingKey";

		}

		public String MRNBlockingKey;

		public String getMRNBlockingKey() {
			return this.MRNBlockingKey;
		}

		public Boolean MRNBlockingKeyIsNullable() {
			return true;
		}

		public Boolean MRNBlockingKeyIsKey() {
			return false;
		}

		public Integer MRNBlockingKeyLength() {
			return 20;
		}

		public Integer MRNBlockingKeyPrecision() {
			return 0;
		}

		public String MRNBlockingKeyDefault() {

			return null;

		}

		public String MRNBlockingKeyComment() {

			return "";

		}

		public String MRNBlockingKeyPattern() {

			return "";

		}

		public String MRNBlockingKeyOriginalDbColumnName() {

			return "MRNBlockingKey";

		}

		public String HealthPlanIDBlockingKey;

		public String getHealthPlanIDBlockingKey() {
			return this.HealthPlanIDBlockingKey;
		}

		public Boolean HealthPlanIDBlockingKeyIsNullable() {
			return true;
		}

		public Boolean HealthPlanIDBlockingKeyIsKey() {
			return false;
		}

		public Integer HealthPlanIDBlockingKeyLength() {
			return 20;
		}

		public Integer HealthPlanIDBlockingKeyPrecision() {
			return 0;
		}

		public String HealthPlanIDBlockingKeyDefault() {

			return null;

		}

		public String HealthPlanIDBlockingKeyComment() {

			return "";

		}

		public String HealthPlanIDBlockingKeyPattern() {

			return "";

		}

		public String HealthPlanIDBlockingKeyOriginalDbColumnName() {

			return "HealthPlanIDBlockingKey";

		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Matching_Distances_2.length) {
					if (length < 1024 && commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Matching_Distances_2.length == 0) {
						commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Matching_Distances_2 = new byte[1024];
					} else {
						commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Matching_Distances_2 = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Matching_Distances_2, 0, length);
				strReturn = new String(commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Matching_Distances_2, 0, length,
						utf8Charset);
			}
			return strReturn;
		}

		private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException {
			String strReturn = null;
			int length = 0;
			length = unmarshaller.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Matching_Distances_2.length) {
					if (length < 1024 && commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Matching_Distances_2.length == 0) {
						commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Matching_Distances_2 = new byte[1024];
					} else {
						commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Matching_Distances_2 = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Matching_Distances_2, 0, length);
				strReturn = new String(commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Matching_Distances_2, 0, length,
						utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		private Integer readInteger(ObjectInputStream dis) throws IOException {
			Integer intReturn;
			int length = 0;
			length = dis.readByte();
			if (length == -1) {
				intReturn = null;
			} else {
				intReturn = dis.readInt();
			}
			return intReturn;
		}

		private Integer readInteger(org.jboss.marshalling.Unmarshaller dis) throws IOException {
			Integer intReturn;
			int length = 0;
			length = dis.readByte();
			if (length == -1) {
				intReturn = null;
			} else {
				intReturn = dis.readInt();
			}
			return intReturn;
		}

		private void writeInteger(Integer intNum, ObjectOutputStream dos) throws IOException {
			if (intNum == null) {
				dos.writeByte(-1);
			} else {
				dos.writeByte(0);
				dos.writeInt(intNum);
			}
		}

		private void writeInteger(Integer intNum, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (intNum == null) {
				marshaller.writeByte(-1);
			} else {
				marshaller.writeByte(0);
				marshaller.writeInt(intNum);
			}
		}

		private java.util.Date readDate(ObjectInputStream dis) throws IOException {
			java.util.Date dateReturn = null;
			int length = 0;
			length = dis.readByte();
			if (length == -1) {
				dateReturn = null;
			} else {
				dateReturn = new Date(dis.readLong());
			}
			return dateReturn;
		}

		private java.util.Date readDate(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException {
			java.util.Date dateReturn = null;
			int length = 0;
			length = unmarshaller.readByte();
			if (length == -1) {
				dateReturn = null;
			} else {
				dateReturn = new Date(unmarshaller.readLong());
			}
			return dateReturn;
		}

		private void writeDate(java.util.Date date1, ObjectOutputStream dos) throws IOException {
			if (date1 == null) {
				dos.writeByte(-1);
			} else {
				dos.writeByte(0);
				dos.writeLong(date1.getTime());
			}
		}

		private void writeDate(java.util.Date date1, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (date1 == null) {
				marshaller.writeByte(-1);
			} else {
				marshaller.writeByte(0);
				marshaller.writeLong(date1.getTime());
			}
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_TALENDCLOUDDEMOBANK_CHIA_Matching_Distances_2) {

				try {

					int length = 0;

					this.FirstName = readString(dis);

					this.LastName = readString(dis);

					this.Gender = readString(dis);

					this.PatientAddress = readString(dis);

					this.City = readString(dis);

					this.State = readString(dis);

					this.PostalCode = readInteger(dis);

					this.Birthday = readDate(dis);

					this.SSN = readString(dis);

					this.HPLNID = readInteger(dis);

					this.NYSIISFirstName = readString(dis);

					this.NYSIISLastName = readString(dis);

					this.HealthPlanID = readString(dis);

					this.MRN = readInteger(dis);

					this.SSNBlockingKey = readString(dis);

					this.FNDOBBlockingKey = readString(dis);

					this.LNPCBlockingKey = readString(dis);

					this.NYSIISFNLNBlockingKey = readString(dis);

					this.DOBPCBlockingKey = readString(dis);

					this.MRNBlockingKey = readString(dis);

					this.HealthPlanIDBlockingKey = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_TALENDCLOUDDEMOBANK_CHIA_Matching_Distances_2) {

				try {

					int length = 0;

					this.FirstName = readString(dis);

					this.LastName = readString(dis);

					this.Gender = readString(dis);

					this.PatientAddress = readString(dis);

					this.City = readString(dis);

					this.State = readString(dis);

					this.PostalCode = readInteger(dis);

					this.Birthday = readDate(dis);

					this.SSN = readString(dis);

					this.HPLNID = readInteger(dis);

					this.NYSIISFirstName = readString(dis);

					this.NYSIISLastName = readString(dis);

					this.HealthPlanID = readString(dis);

					this.MRN = readInteger(dis);

					this.SSNBlockingKey = readString(dis);

					this.FNDOBBlockingKey = readString(dis);

					this.LNPCBlockingKey = readString(dis);

					this.NYSIISFNLNBlockingKey = readString(dis);

					this.DOBPCBlockingKey = readString(dis);

					this.MRNBlockingKey = readString(dis);

					this.HealthPlanIDBlockingKey = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// String

				writeString(this.FirstName, dos);

				// String

				writeString(this.LastName, dos);

				// String

				writeString(this.Gender, dos);

				// String

				writeString(this.PatientAddress, dos);

				// String

				writeString(this.City, dos);

				// String

				writeString(this.State, dos);

				// Integer

				writeInteger(this.PostalCode, dos);

				// java.util.Date

				writeDate(this.Birthday, dos);

				// String

				writeString(this.SSN, dos);

				// Integer

				writeInteger(this.HPLNID, dos);

				// String

				writeString(this.NYSIISFirstName, dos);

				// String

				writeString(this.NYSIISLastName, dos);

				// String

				writeString(this.HealthPlanID, dos);

				// Integer

				writeInteger(this.MRN, dos);

				// String

				writeString(this.SSNBlockingKey, dos);

				// String

				writeString(this.FNDOBBlockingKey, dos);

				// String

				writeString(this.LNPCBlockingKey, dos);

				// String

				writeString(this.NYSIISFNLNBlockingKey, dos);

				// String

				writeString(this.DOBPCBlockingKey, dos);

				// String

				writeString(this.MRNBlockingKey, dos);

				// String

				writeString(this.HealthPlanIDBlockingKey, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// String

				writeString(this.FirstName, dos);

				// String

				writeString(this.LastName, dos);

				// String

				writeString(this.Gender, dos);

				// String

				writeString(this.PatientAddress, dos);

				// String

				writeString(this.City, dos);

				// String

				writeString(this.State, dos);

				// Integer

				writeInteger(this.PostalCode, dos);

				// java.util.Date

				writeDate(this.Birthday, dos);

				// String

				writeString(this.SSN, dos);

				// Integer

				writeInteger(this.HPLNID, dos);

				// String

				writeString(this.NYSIISFirstName, dos);

				// String

				writeString(this.NYSIISLastName, dos);

				// String

				writeString(this.HealthPlanID, dos);

				// Integer

				writeInteger(this.MRN, dos);

				// String

				writeString(this.SSNBlockingKey, dos);

				// String

				writeString(this.FNDOBBlockingKey, dos);

				// String

				writeString(this.LNPCBlockingKey, dos);

				// String

				writeString(this.NYSIISFNLNBlockingKey, dos);

				// String

				writeString(this.DOBPCBlockingKey, dos);

				// String

				writeString(this.MRNBlockingKey, dos);

				// String

				writeString(this.HealthPlanIDBlockingKey, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("FirstName=" + FirstName);
			sb.append(",LastName=" + LastName);
			sb.append(",Gender=" + Gender);
			sb.append(",PatientAddress=" + PatientAddress);
			sb.append(",City=" + City);
			sb.append(",State=" + State);
			sb.append(",PostalCode=" + String.valueOf(PostalCode));
			sb.append(",Birthday=" + String.valueOf(Birthday));
			sb.append(",SSN=" + SSN);
			sb.append(",HPLNID=" + String.valueOf(HPLNID));
			sb.append(",NYSIISFirstName=" + NYSIISFirstName);
			sb.append(",NYSIISLastName=" + NYSIISLastName);
			sb.append(",HealthPlanID=" + HealthPlanID);
			sb.append(",MRN=" + String.valueOf(MRN));
			sb.append(",SSNBlockingKey=" + SSNBlockingKey);
			sb.append(",FNDOBBlockingKey=" + FNDOBBlockingKey);
			sb.append(",LNPCBlockingKey=" + LNPCBlockingKey);
			sb.append(",NYSIISFNLNBlockingKey=" + NYSIISFNLNBlockingKey);
			sb.append(",DOBPCBlockingKey=" + DOBPCBlockingKey);
			sb.append(",MRNBlockingKey=" + MRNBlockingKey);
			sb.append(",HealthPlanIDBlockingKey=" + HealthPlanIDBlockingKey);
			sb.append("]");

			return sb.toString();
		}

		public String toLogString() {
			StringBuilder sb = new StringBuilder();

			if (FirstName == null) {
				sb.append("<null>");
			} else {
				sb.append(FirstName);
			}

			sb.append("|");

			if (LastName == null) {
				sb.append("<null>");
			} else {
				sb.append(LastName);
			}

			sb.append("|");

			if (Gender == null) {
				sb.append("<null>");
			} else {
				sb.append(Gender);
			}

			sb.append("|");

			if (PatientAddress == null) {
				sb.append("<null>");
			} else {
				sb.append(PatientAddress);
			}

			sb.append("|");

			if (City == null) {
				sb.append("<null>");
			} else {
				sb.append(City);
			}

			sb.append("|");

			if (State == null) {
				sb.append("<null>");
			} else {
				sb.append(State);
			}

			sb.append("|");

			if (PostalCode == null) {
				sb.append("<null>");
			} else {
				sb.append(PostalCode);
			}

			sb.append("|");

			if (Birthday == null) {
				sb.append("<null>");
			} else {
				sb.append(Birthday);
			}

			sb.append("|");

			if (SSN == null) {
				sb.append("<null>");
			} else {
				sb.append(SSN);
			}

			sb.append("|");

			if (HPLNID == null) {
				sb.append("<null>");
			} else {
				sb.append(HPLNID);
			}

			sb.append("|");

			if (NYSIISFirstName == null) {
				sb.append("<null>");
			} else {
				sb.append(NYSIISFirstName);
			}

			sb.append("|");

			if (NYSIISLastName == null) {
				sb.append("<null>");
			} else {
				sb.append(NYSIISLastName);
			}

			sb.append("|");

			if (HealthPlanID == null) {
				sb.append("<null>");
			} else {
				sb.append(HealthPlanID);
			}

			sb.append("|");

			if (MRN == null) {
				sb.append("<null>");
			} else {
				sb.append(MRN);
			}

			sb.append("|");

			if (SSNBlockingKey == null) {
				sb.append("<null>");
			} else {
				sb.append(SSNBlockingKey);
			}

			sb.append("|");

			if (FNDOBBlockingKey == null) {
				sb.append("<null>");
			} else {
				sb.append(FNDOBBlockingKey);
			}

			sb.append("|");

			if (LNPCBlockingKey == null) {
				sb.append("<null>");
			} else {
				sb.append(LNPCBlockingKey);
			}

			sb.append("|");

			if (NYSIISFNLNBlockingKey == null) {
				sb.append("<null>");
			} else {
				sb.append(NYSIISFNLNBlockingKey);
			}

			sb.append("|");

			if (DOBPCBlockingKey == null) {
				sb.append("<null>");
			} else {
				sb.append(DOBPCBlockingKey);
			}

			sb.append("|");

			if (MRNBlockingKey == null) {
				sb.append("<null>");
			} else {
				sb.append(MRNBlockingKey);
			}

			sb.append("|");

			if (HealthPlanIDBlockingKey == null) {
				sb.append("<null>");
			} else {
				sb.append(HealthPlanIDBlockingKey);
			}

			sb.append("|");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(SourceStruct other) {

			int returnValue = -1;

			return returnValue;
		}

		private int checkNullsAndCompare(Object object1, Object object2) {
			int returnValue = 0;
			if (object1 instanceof Comparable && object2 instanceof Comparable) {
				returnValue = ((Comparable) object1).compareTo(object2);
			} else if (object1 != null && object2 != null) {
				returnValue = compareStrings(object1.toString(), object2.toString());
			} else if (object1 == null && object2 != null) {
				returnValue = 1;
			} else if (object1 != null && object2 == null) {
				returnValue = -1;
			} else {
				returnValue = 0;
			}

			return returnValue;
		}

		private int compareStrings(String string1, String string2) {
			return string1.compareTo(string2);
		}

	}

	public static class after_tDBInput_3Struct implements routines.system.IPersistableRow<after_tDBInput_3Struct> {
		final static byte[] commonByteArrayLock_TALENDCLOUDDEMOBANK_CHIA_Matching_Distances_2 = new byte[0];
		static byte[] commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Matching_Distances_2 = new byte[0];

		public String FirstName;

		public String getFirstName() {
			return this.FirstName;
		}

		public Boolean FirstNameIsNullable() {
			return true;
		}

		public Boolean FirstNameIsKey() {
			return false;
		}

		public Integer FirstNameLength() {
			return 16;
		}

		public Integer FirstNamePrecision() {
			return 0;
		}

		public String FirstNameDefault() {

			return null;

		}

		public String FirstNameComment() {

			return "";

		}

		public String FirstNamePattern() {

			return "";

		}

		public String FirstNameOriginalDbColumnName() {

			return "FirstName";

		}

		public String LastName;

		public String getLastName() {
			return this.LastName;
		}

		public Boolean LastNameIsNullable() {
			return true;
		}

		public Boolean LastNameIsKey() {
			return false;
		}

		public Integer LastNameLength() {
			return 10;
		}

		public Integer LastNamePrecision() {
			return 0;
		}

		public String LastNameDefault() {

			return null;

		}

		public String LastNameComment() {

			return "";

		}

		public String LastNamePattern() {

			return "";

		}

		public String LastNameOriginalDbColumnName() {

			return "LastName";

		}

		public String Gender;

		public String getGender() {
			return this.Gender;
		}

		public Boolean GenderIsNullable() {
			return true;
		}

		public Boolean GenderIsKey() {
			return false;
		}

		public Integer GenderLength() {
			return 6;
		}

		public Integer GenderPrecision() {
			return 0;
		}

		public String GenderDefault() {

			return null;

		}

		public String GenderComment() {

			return "";

		}

		public String GenderPattern() {

			return "";

		}

		public String GenderOriginalDbColumnName() {

			return "Gender";

		}

		public String PatientAddress;

		public String getPatientAddress() {
			return this.PatientAddress;
		}

		public Boolean PatientAddressIsNullable() {
			return true;
		}

		public Boolean PatientAddressIsKey() {
			return false;
		}

		public Integer PatientAddressLength() {
			return 38;
		}

		public Integer PatientAddressPrecision() {
			return 0;
		}

		public String PatientAddressDefault() {

			return null;

		}

		public String PatientAddressComment() {

			return "";

		}

		public String PatientAddressPattern() {

			return "";

		}

		public String PatientAddressOriginalDbColumnName() {

			return "PatientAddress";

		}

		public String City;

		public String getCity() {
			return this.City;
		}

		public Boolean CityIsNullable() {
			return true;
		}

		public Boolean CityIsKey() {
			return false;
		}

		public Integer CityLength() {
			return 14;
		}

		public Integer CityPrecision() {
			return 0;
		}

		public String CityDefault() {

			return null;

		}

		public String CityComment() {

			return "";

		}

		public String CityPattern() {

			return "";

		}

		public String CityOriginalDbColumnName() {

			return "City";

		}

		public String State;

		public String getState() {
			return this.State;
		}

		public Boolean StateIsNullable() {
			return true;
		}

		public Boolean StateIsKey() {
			return false;
		}

		public Integer StateLength() {
			return 2;
		}

		public Integer StatePrecision() {
			return 0;
		}

		public String StateDefault() {

			return null;

		}

		public String StateComment() {

			return "";

		}

		public String StatePattern() {

			return "";

		}

		public String StateOriginalDbColumnName() {

			return "State";

		}

		public Integer PostalCode;

		public Integer getPostalCode() {
			return this.PostalCode;
		}

		public Boolean PostalCodeIsNullable() {
			return true;
		}

		public Boolean PostalCodeIsKey() {
			return false;
		}

		public Integer PostalCodeLength() {
			return 10;
		}

		public Integer PostalCodePrecision() {
			return 0;
		}

		public String PostalCodeDefault() {

			return null;

		}

		public String PostalCodeComment() {

			return "";

		}

		public String PostalCodePattern() {

			return "";

		}

		public String PostalCodeOriginalDbColumnName() {

			return "PostalCode";

		}

		public java.util.Date Birthday;

		public java.util.Date getBirthday() {
			return this.Birthday;
		}

		public Boolean BirthdayIsNullable() {
			return true;
		}

		public Boolean BirthdayIsKey() {
			return false;
		}

		public Integer BirthdayLength() {
			return 19;
		}

		public Integer BirthdayPrecision() {
			return 0;
		}

		public String BirthdayDefault() {

			return null;

		}

		public String BirthdayComment() {

			return "";

		}

		public String BirthdayPattern() {

			return "dd-MM-yyyy";

		}

		public String BirthdayOriginalDbColumnName() {

			return "Birthday";

		}

		public String SSN;

		public String getSSN() {
			return this.SSN;
		}

		public Boolean SSNIsNullable() {
			return true;
		}

		public Boolean SSNIsKey() {
			return false;
		}

		public Integer SSNLength() {
			return 11;
		}

		public Integer SSNPrecision() {
			return 0;
		}

		public String SSNDefault() {

			return null;

		}

		public String SSNComment() {

			return "";

		}

		public String SSNPattern() {

			return "";

		}

		public String SSNOriginalDbColumnName() {

			return "SSN";

		}

		public Integer HPLNID;

		public Integer getHPLNID() {
			return this.HPLNID;
		}

		public Boolean HPLNIDIsNullable() {
			return true;
		}

		public Boolean HPLNIDIsKey() {
			return false;
		}

		public Integer HPLNIDLength() {
			return 10;
		}

		public Integer HPLNIDPrecision() {
			return 0;
		}

		public String HPLNIDDefault() {

			return null;

		}

		public String HPLNIDComment() {

			return "";

		}

		public String HPLNIDPattern() {

			return "";

		}

		public String HPLNIDOriginalDbColumnName() {

			return "HPLNID";

		}

		public String NYSIISFirstName;

		public String getNYSIISFirstName() {
			return this.NYSIISFirstName;
		}

		public Boolean NYSIISFirstNameIsNullable() {
			return true;
		}

		public Boolean NYSIISFirstNameIsKey() {
			return false;
		}

		public Integer NYSIISFirstNameLength() {
			return 16;
		}

		public Integer NYSIISFirstNamePrecision() {
			return 0;
		}

		public String NYSIISFirstNameDefault() {

			return null;

		}

		public String NYSIISFirstNameComment() {

			return "";

		}

		public String NYSIISFirstNamePattern() {

			return "";

		}

		public String NYSIISFirstNameOriginalDbColumnName() {

			return "NYSIISFirstName";

		}

		public String NYSIISLastName;

		public String getNYSIISLastName() {
			return this.NYSIISLastName;
		}

		public Boolean NYSIISLastNameIsNullable() {
			return true;
		}

		public Boolean NYSIISLastNameIsKey() {
			return false;
		}

		public Integer NYSIISLastNameLength() {
			return 10;
		}

		public Integer NYSIISLastNamePrecision() {
			return 0;
		}

		public String NYSIISLastNameDefault() {

			return null;

		}

		public String NYSIISLastNameComment() {

			return "";

		}

		public String NYSIISLastNamePattern() {

			return "";

		}

		public String NYSIISLastNameOriginalDbColumnName() {

			return "NYSIISLastName";

		}

		public String HealthPlanID;

		public String getHealthPlanID() {
			return this.HealthPlanID;
		}

		public Boolean HealthPlanIDIsNullable() {
			return true;
		}

		public Boolean HealthPlanIDIsKey() {
			return false;
		}

		public Integer HealthPlanIDLength() {
			return 8;
		}

		public Integer HealthPlanIDPrecision() {
			return 0;
		}

		public String HealthPlanIDDefault() {

			return null;

		}

		public String HealthPlanIDComment() {

			return "";

		}

		public String HealthPlanIDPattern() {

			return "";

		}

		public String HealthPlanIDOriginalDbColumnName() {

			return "HealthPlanID";

		}

		public Integer MRN;

		public Integer getMRN() {
			return this.MRN;
		}

		public Boolean MRNIsNullable() {
			return true;
		}

		public Boolean MRNIsKey() {
			return false;
		}

		public Integer MRNLength() {
			return 10;
		}

		public Integer MRNPrecision() {
			return 0;
		}

		public String MRNDefault() {

			return null;

		}

		public String MRNComment() {

			return "";

		}

		public String MRNPattern() {

			return "";

		}

		public String MRNOriginalDbColumnName() {

			return "MRN";

		}

		public String SSNBlockingKey;

		public String getSSNBlockingKey() {
			return this.SSNBlockingKey;
		}

		public Boolean SSNBlockingKeyIsNullable() {
			return true;
		}

		public Boolean SSNBlockingKeyIsKey() {
			return false;
		}

		public Integer SSNBlockingKeyLength() {
			return 20;
		}

		public Integer SSNBlockingKeyPrecision() {
			return 0;
		}

		public String SSNBlockingKeyDefault() {

			return null;

		}

		public String SSNBlockingKeyComment() {

			return "";

		}

		public String SSNBlockingKeyPattern() {

			return "";

		}

		public String SSNBlockingKeyOriginalDbColumnName() {

			return "SSNBlockingKey";

		}

		public String FNDOBBlockingKey;

		public String getFNDOBBlockingKey() {
			return this.FNDOBBlockingKey;
		}

		public Boolean FNDOBBlockingKeyIsNullable() {
			return true;
		}

		public Boolean FNDOBBlockingKeyIsKey() {
			return false;
		}

		public Integer FNDOBBlockingKeyLength() {
			return 25;
		}

		public Integer FNDOBBlockingKeyPrecision() {
			return 0;
		}

		public String FNDOBBlockingKeyDefault() {

			return null;

		}

		public String FNDOBBlockingKeyComment() {

			return "";

		}

		public String FNDOBBlockingKeyPattern() {

			return "";

		}

		public String FNDOBBlockingKeyOriginalDbColumnName() {

			return "FNDOBBlockingKey";

		}

		public String LNPCBlockingKey;

		public String getLNPCBlockingKey() {
			return this.LNPCBlockingKey;
		}

		public Boolean LNPCBlockingKeyIsNullable() {
			return true;
		}

		public Boolean LNPCBlockingKeyIsKey() {
			return false;
		}

		public Integer LNPCBlockingKeyLength() {
			return 20;
		}

		public Integer LNPCBlockingKeyPrecision() {
			return 0;
		}

		public String LNPCBlockingKeyDefault() {

			return null;

		}

		public String LNPCBlockingKeyComment() {

			return "";

		}

		public String LNPCBlockingKeyPattern() {

			return "";

		}

		public String LNPCBlockingKeyOriginalDbColumnName() {

			return "LNPCBlockingKey";

		}

		public String NYSIISFNLNBlockingKey;

		public String getNYSIISFNLNBlockingKey() {
			return this.NYSIISFNLNBlockingKey;
		}

		public Boolean NYSIISFNLNBlockingKeyIsNullable() {
			return true;
		}

		public Boolean NYSIISFNLNBlockingKeyIsKey() {
			return false;
		}

		public Integer NYSIISFNLNBlockingKeyLength() {
			return 20;
		}

		public Integer NYSIISFNLNBlockingKeyPrecision() {
			return 0;
		}

		public String NYSIISFNLNBlockingKeyDefault() {

			return null;

		}

		public String NYSIISFNLNBlockingKeyComment() {

			return "";

		}

		public String NYSIISFNLNBlockingKeyPattern() {

			return "";

		}

		public String NYSIISFNLNBlockingKeyOriginalDbColumnName() {

			return "NYSIISFNLNBlockingKey";

		}

		public String DOBPCBlockingKey;

		public String getDOBPCBlockingKey() {
			return this.DOBPCBlockingKey;
		}

		public Boolean DOBPCBlockingKeyIsNullable() {
			return true;
		}

		public Boolean DOBPCBlockingKeyIsKey() {
			return false;
		}

		public Integer DOBPCBlockingKeyLength() {
			return 20;
		}

		public Integer DOBPCBlockingKeyPrecision() {
			return 0;
		}

		public String DOBPCBlockingKeyDefault() {

			return null;

		}

		public String DOBPCBlockingKeyComment() {

			return "";

		}

		public String DOBPCBlockingKeyPattern() {

			return "";

		}

		public String DOBPCBlockingKeyOriginalDbColumnName() {

			return "DOBPCBlockingKey";

		}

		public String MRNBlockingKey;

		public String getMRNBlockingKey() {
			return this.MRNBlockingKey;
		}

		public Boolean MRNBlockingKeyIsNullable() {
			return true;
		}

		public Boolean MRNBlockingKeyIsKey() {
			return false;
		}

		public Integer MRNBlockingKeyLength() {
			return 20;
		}

		public Integer MRNBlockingKeyPrecision() {
			return 0;
		}

		public String MRNBlockingKeyDefault() {

			return null;

		}

		public String MRNBlockingKeyComment() {

			return "";

		}

		public String MRNBlockingKeyPattern() {

			return "";

		}

		public String MRNBlockingKeyOriginalDbColumnName() {

			return "MRNBlockingKey";

		}

		public String HealthPlanIDBlockingKey;

		public String getHealthPlanIDBlockingKey() {
			return this.HealthPlanIDBlockingKey;
		}

		public Boolean HealthPlanIDBlockingKeyIsNullable() {
			return true;
		}

		public Boolean HealthPlanIDBlockingKeyIsKey() {
			return false;
		}

		public Integer HealthPlanIDBlockingKeyLength() {
			return 20;
		}

		public Integer HealthPlanIDBlockingKeyPrecision() {
			return 0;
		}

		public String HealthPlanIDBlockingKeyDefault() {

			return null;

		}

		public String HealthPlanIDBlockingKeyComment() {

			return "";

		}

		public String HealthPlanIDBlockingKeyPattern() {

			return "";

		}

		public String HealthPlanIDBlockingKeyOriginalDbColumnName() {

			return "HealthPlanIDBlockingKey";

		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Matching_Distances_2.length) {
					if (length < 1024 && commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Matching_Distances_2.length == 0) {
						commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Matching_Distances_2 = new byte[1024];
					} else {
						commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Matching_Distances_2 = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Matching_Distances_2, 0, length);
				strReturn = new String(commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Matching_Distances_2, 0, length,
						utf8Charset);
			}
			return strReturn;
		}

		private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException {
			String strReturn = null;
			int length = 0;
			length = unmarshaller.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Matching_Distances_2.length) {
					if (length < 1024 && commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Matching_Distances_2.length == 0) {
						commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Matching_Distances_2 = new byte[1024];
					} else {
						commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Matching_Distances_2 = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Matching_Distances_2, 0, length);
				strReturn = new String(commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Matching_Distances_2, 0, length,
						utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		private Integer readInteger(ObjectInputStream dis) throws IOException {
			Integer intReturn;
			int length = 0;
			length = dis.readByte();
			if (length == -1) {
				intReturn = null;
			} else {
				intReturn = dis.readInt();
			}
			return intReturn;
		}

		private Integer readInteger(org.jboss.marshalling.Unmarshaller dis) throws IOException {
			Integer intReturn;
			int length = 0;
			length = dis.readByte();
			if (length == -1) {
				intReturn = null;
			} else {
				intReturn = dis.readInt();
			}
			return intReturn;
		}

		private void writeInteger(Integer intNum, ObjectOutputStream dos) throws IOException {
			if (intNum == null) {
				dos.writeByte(-1);
			} else {
				dos.writeByte(0);
				dos.writeInt(intNum);
			}
		}

		private void writeInteger(Integer intNum, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (intNum == null) {
				marshaller.writeByte(-1);
			} else {
				marshaller.writeByte(0);
				marshaller.writeInt(intNum);
			}
		}

		private java.util.Date readDate(ObjectInputStream dis) throws IOException {
			java.util.Date dateReturn = null;
			int length = 0;
			length = dis.readByte();
			if (length == -1) {
				dateReturn = null;
			} else {
				dateReturn = new Date(dis.readLong());
			}
			return dateReturn;
		}

		private java.util.Date readDate(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException {
			java.util.Date dateReturn = null;
			int length = 0;
			length = unmarshaller.readByte();
			if (length == -1) {
				dateReturn = null;
			} else {
				dateReturn = new Date(unmarshaller.readLong());
			}
			return dateReturn;
		}

		private void writeDate(java.util.Date date1, ObjectOutputStream dos) throws IOException {
			if (date1 == null) {
				dos.writeByte(-1);
			} else {
				dos.writeByte(0);
				dos.writeLong(date1.getTime());
			}
		}

		private void writeDate(java.util.Date date1, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (date1 == null) {
				marshaller.writeByte(-1);
			} else {
				marshaller.writeByte(0);
				marshaller.writeLong(date1.getTime());
			}
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_TALENDCLOUDDEMOBANK_CHIA_Matching_Distances_2) {

				try {

					int length = 0;

					this.FirstName = readString(dis);

					this.LastName = readString(dis);

					this.Gender = readString(dis);

					this.PatientAddress = readString(dis);

					this.City = readString(dis);

					this.State = readString(dis);

					this.PostalCode = readInteger(dis);

					this.Birthday = readDate(dis);

					this.SSN = readString(dis);

					this.HPLNID = readInteger(dis);

					this.NYSIISFirstName = readString(dis);

					this.NYSIISLastName = readString(dis);

					this.HealthPlanID = readString(dis);

					this.MRN = readInteger(dis);

					this.SSNBlockingKey = readString(dis);

					this.FNDOBBlockingKey = readString(dis);

					this.LNPCBlockingKey = readString(dis);

					this.NYSIISFNLNBlockingKey = readString(dis);

					this.DOBPCBlockingKey = readString(dis);

					this.MRNBlockingKey = readString(dis);

					this.HealthPlanIDBlockingKey = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_TALENDCLOUDDEMOBANK_CHIA_Matching_Distances_2) {

				try {

					int length = 0;

					this.FirstName = readString(dis);

					this.LastName = readString(dis);

					this.Gender = readString(dis);

					this.PatientAddress = readString(dis);

					this.City = readString(dis);

					this.State = readString(dis);

					this.PostalCode = readInteger(dis);

					this.Birthday = readDate(dis);

					this.SSN = readString(dis);

					this.HPLNID = readInteger(dis);

					this.NYSIISFirstName = readString(dis);

					this.NYSIISLastName = readString(dis);

					this.HealthPlanID = readString(dis);

					this.MRN = readInteger(dis);

					this.SSNBlockingKey = readString(dis);

					this.FNDOBBlockingKey = readString(dis);

					this.LNPCBlockingKey = readString(dis);

					this.NYSIISFNLNBlockingKey = readString(dis);

					this.DOBPCBlockingKey = readString(dis);

					this.MRNBlockingKey = readString(dis);

					this.HealthPlanIDBlockingKey = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// String

				writeString(this.FirstName, dos);

				// String

				writeString(this.LastName, dos);

				// String

				writeString(this.Gender, dos);

				// String

				writeString(this.PatientAddress, dos);

				// String

				writeString(this.City, dos);

				// String

				writeString(this.State, dos);

				// Integer

				writeInteger(this.PostalCode, dos);

				// java.util.Date

				writeDate(this.Birthday, dos);

				// String

				writeString(this.SSN, dos);

				// Integer

				writeInteger(this.HPLNID, dos);

				// String

				writeString(this.NYSIISFirstName, dos);

				// String

				writeString(this.NYSIISLastName, dos);

				// String

				writeString(this.HealthPlanID, dos);

				// Integer

				writeInteger(this.MRN, dos);

				// String

				writeString(this.SSNBlockingKey, dos);

				// String

				writeString(this.FNDOBBlockingKey, dos);

				// String

				writeString(this.LNPCBlockingKey, dos);

				// String

				writeString(this.NYSIISFNLNBlockingKey, dos);

				// String

				writeString(this.DOBPCBlockingKey, dos);

				// String

				writeString(this.MRNBlockingKey, dos);

				// String

				writeString(this.HealthPlanIDBlockingKey, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// String

				writeString(this.FirstName, dos);

				// String

				writeString(this.LastName, dos);

				// String

				writeString(this.Gender, dos);

				// String

				writeString(this.PatientAddress, dos);

				// String

				writeString(this.City, dos);

				// String

				writeString(this.State, dos);

				// Integer

				writeInteger(this.PostalCode, dos);

				// java.util.Date

				writeDate(this.Birthday, dos);

				// String

				writeString(this.SSN, dos);

				// Integer

				writeInteger(this.HPLNID, dos);

				// String

				writeString(this.NYSIISFirstName, dos);

				// String

				writeString(this.NYSIISLastName, dos);

				// String

				writeString(this.HealthPlanID, dos);

				// Integer

				writeInteger(this.MRN, dos);

				// String

				writeString(this.SSNBlockingKey, dos);

				// String

				writeString(this.FNDOBBlockingKey, dos);

				// String

				writeString(this.LNPCBlockingKey, dos);

				// String

				writeString(this.NYSIISFNLNBlockingKey, dos);

				// String

				writeString(this.DOBPCBlockingKey, dos);

				// String

				writeString(this.MRNBlockingKey, dos);

				// String

				writeString(this.HealthPlanIDBlockingKey, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("FirstName=" + FirstName);
			sb.append(",LastName=" + LastName);
			sb.append(",Gender=" + Gender);
			sb.append(",PatientAddress=" + PatientAddress);
			sb.append(",City=" + City);
			sb.append(",State=" + State);
			sb.append(",PostalCode=" + String.valueOf(PostalCode));
			sb.append(",Birthday=" + String.valueOf(Birthday));
			sb.append(",SSN=" + SSN);
			sb.append(",HPLNID=" + String.valueOf(HPLNID));
			sb.append(",NYSIISFirstName=" + NYSIISFirstName);
			sb.append(",NYSIISLastName=" + NYSIISLastName);
			sb.append(",HealthPlanID=" + HealthPlanID);
			sb.append(",MRN=" + String.valueOf(MRN));
			sb.append(",SSNBlockingKey=" + SSNBlockingKey);
			sb.append(",FNDOBBlockingKey=" + FNDOBBlockingKey);
			sb.append(",LNPCBlockingKey=" + LNPCBlockingKey);
			sb.append(",NYSIISFNLNBlockingKey=" + NYSIISFNLNBlockingKey);
			sb.append(",DOBPCBlockingKey=" + DOBPCBlockingKey);
			sb.append(",MRNBlockingKey=" + MRNBlockingKey);
			sb.append(",HealthPlanIDBlockingKey=" + HealthPlanIDBlockingKey);
			sb.append("]");

			return sb.toString();
		}

		public String toLogString() {
			StringBuilder sb = new StringBuilder();

			if (FirstName == null) {
				sb.append("<null>");
			} else {
				sb.append(FirstName);
			}

			sb.append("|");

			if (LastName == null) {
				sb.append("<null>");
			} else {
				sb.append(LastName);
			}

			sb.append("|");

			if (Gender == null) {
				sb.append("<null>");
			} else {
				sb.append(Gender);
			}

			sb.append("|");

			if (PatientAddress == null) {
				sb.append("<null>");
			} else {
				sb.append(PatientAddress);
			}

			sb.append("|");

			if (City == null) {
				sb.append("<null>");
			} else {
				sb.append(City);
			}

			sb.append("|");

			if (State == null) {
				sb.append("<null>");
			} else {
				sb.append(State);
			}

			sb.append("|");

			if (PostalCode == null) {
				sb.append("<null>");
			} else {
				sb.append(PostalCode);
			}

			sb.append("|");

			if (Birthday == null) {
				sb.append("<null>");
			} else {
				sb.append(Birthday);
			}

			sb.append("|");

			if (SSN == null) {
				sb.append("<null>");
			} else {
				sb.append(SSN);
			}

			sb.append("|");

			if (HPLNID == null) {
				sb.append("<null>");
			} else {
				sb.append(HPLNID);
			}

			sb.append("|");

			if (NYSIISFirstName == null) {
				sb.append("<null>");
			} else {
				sb.append(NYSIISFirstName);
			}

			sb.append("|");

			if (NYSIISLastName == null) {
				sb.append("<null>");
			} else {
				sb.append(NYSIISLastName);
			}

			sb.append("|");

			if (HealthPlanID == null) {
				sb.append("<null>");
			} else {
				sb.append(HealthPlanID);
			}

			sb.append("|");

			if (MRN == null) {
				sb.append("<null>");
			} else {
				sb.append(MRN);
			}

			sb.append("|");

			if (SSNBlockingKey == null) {
				sb.append("<null>");
			} else {
				sb.append(SSNBlockingKey);
			}

			sb.append("|");

			if (FNDOBBlockingKey == null) {
				sb.append("<null>");
			} else {
				sb.append(FNDOBBlockingKey);
			}

			sb.append("|");

			if (LNPCBlockingKey == null) {
				sb.append("<null>");
			} else {
				sb.append(LNPCBlockingKey);
			}

			sb.append("|");

			if (NYSIISFNLNBlockingKey == null) {
				sb.append("<null>");
			} else {
				sb.append(NYSIISFNLNBlockingKey);
			}

			sb.append("|");

			if (DOBPCBlockingKey == null) {
				sb.append("<null>");
			} else {
				sb.append(DOBPCBlockingKey);
			}

			sb.append("|");

			if (MRNBlockingKey == null) {
				sb.append("<null>");
			} else {
				sb.append(MRNBlockingKey);
			}

			sb.append("|");

			if (HealthPlanIDBlockingKey == null) {
				sb.append("<null>");
			} else {
				sb.append(HealthPlanIDBlockingKey);
			}

			sb.append("|");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(after_tDBInput_3Struct other) {

			int returnValue = -1;

			return returnValue;
		}

		private int checkNullsAndCompare(Object object1, Object object2) {
			int returnValue = 0;
			if (object1 instanceof Comparable && object2 instanceof Comparable) {
				returnValue = ((Comparable) object1).compareTo(object2);
			} else if (object1 != null && object2 != null) {
				returnValue = compareStrings(object1.toString(), object2.toString());
			} else if (object1 == null && object2 != null) {
				returnValue = 1;
			} else if (object1 != null && object2 == null) {
				returnValue = -1;
			} else {
				returnValue = 0;
			}

			return returnValue;
		}

		private int compareStrings(String string1, String string2) {
			return string1.compareTo(string2);
		}

	}

	public void tDBInput_3Process(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("tDBInput_3_SUBPROCESS_STATE", 0);

		final boolean execStat = this.execStat;

		mdc("tDBInput_3", "CjmEVW_");

		String iterateId = "";

		String currentComponent = "";
		s("none");
		String cLabel = null;
		java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

		try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { // start the resume
				globalResumeTicket = true;

				tDBInput_2Process(globalMap);

				SourceStruct Source = new SourceStruct();
				PossibleMatchesStruct PossibleMatches = new PossibleMatchesStruct();
				PossibleMatchesOutputStruct PossibleMatchesOutput = new PossibleMatchesOutputStruct();

				/**
				 * [tLogRow_2 begin ] start
				 */

				sh("tLogRow_2");

				s(currentComponent = "tLogRow_2");

				cLabel = "<b>Matches Distances</b>";

				runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, 0, 0,
						"PossibleMatchesOutput");

				int tos_count_tLogRow_2 = 0;

				if (log.isDebugEnabled())
					log.debug("tLogRow_2 - " + ("Start to work."));
				if (log.isDebugEnabled()) {
					class BytesLimit65535_tLogRow_2 {
						public void limitLog4jByte() throws Exception {
							StringBuilder log4jParamters_tLogRow_2 = new StringBuilder();
							log4jParamters_tLogRow_2.append("Parameters:");
							log4jParamters_tLogRow_2.append("BASIC_MODE" + " = " + "false");
							log4jParamters_tLogRow_2.append(" | ");
							log4jParamters_tLogRow_2.append("TABLE_PRINT" + " = " + "true");
							log4jParamters_tLogRow_2.append(" | ");
							log4jParamters_tLogRow_2.append("VERTICAL" + " = " + "false");
							log4jParamters_tLogRow_2.append(" | ");
							log4jParamters_tLogRow_2.append("PRINT_CONTENT_WITH_LOG4J" + " = " + "true");
							log4jParamters_tLogRow_2.append(" | ");
							if (log.isDebugEnabled())
								log.debug("tLogRow_2 - " + (log4jParamters_tLogRow_2));
						}
					}
					new BytesLimit65535_tLogRow_2().limitLog4jByte();
				}
				if (enableLogStash) {
					talendJobLog.addCM("tLogRow_2", "<b>Matches Distances</b>", "tLogRow");
					talendJobLogProcess(globalMap);
					s(currentComponent);
				}

				///////////////////////

				class Util_tLogRow_2 {

					String[] des_top = { ".", ".", "-", "+" };

					String[] des_head = { "|=", "=|", "-", "+" };

					String[] des_bottom = { "'", "'", "-", "+" };

					String name = "";

					java.util.List<String[]> list = new java.util.ArrayList<String[]>();

					int[] colLengths = new int[37];

					public void addRow(String[] row) {

						for (int i = 0; i < 37; i++) {
							if (row[i] != null) {
								colLengths[i] = Math.max(colLengths[i], row[i].length());
							}
						}
						list.add(row);
					}

					public void setTableName(String name) {

						this.name = name;
					}

					public StringBuilder format() {

						StringBuilder sb = new StringBuilder();

						sb.append(print(des_top));

						int totals = 0;
						for (int i = 0; i < colLengths.length; i++) {
							totals = totals + colLengths[i];
						}

						// name
						sb.append("|");
						int k = 0;
						for (k = 0; k < (totals + 36 - name.length()) / 2; k++) {
							sb.append(' ');
						}
						sb.append(name);
						for (int i = 0; i < totals + 36 - name.length() - k; i++) {
							sb.append(' ');
						}
						sb.append("|\n");

						// head and rows
						sb.append(print(des_head));
						for (int i = 0; i < list.size(); i++) {

							String[] row = list.get(i);

							java.util.Formatter formatter = new java.util.Formatter(new StringBuilder());

							StringBuilder sbformat = new StringBuilder();
							sbformat.append("|%1$-");
							sbformat.append(colLengths[0]);
							sbformat.append("s");

							sbformat.append("|%2$-");
							sbformat.append(colLengths[1]);
							sbformat.append("s");

							sbformat.append("|%3$-");
							sbformat.append(colLengths[2]);
							sbformat.append("s");

							sbformat.append("|%4$-");
							sbformat.append(colLengths[3]);
							sbformat.append("s");

							sbformat.append("|%5$-");
							sbformat.append(colLengths[4]);
							sbformat.append("s");

							sbformat.append("|%6$-");
							sbformat.append(colLengths[5]);
							sbformat.append("s");

							sbformat.append("|%7$-");
							sbformat.append(colLengths[6]);
							sbformat.append("s");

							sbformat.append("|%8$-");
							sbformat.append(colLengths[7]);
							sbformat.append("s");

							sbformat.append("|%9$-");
							sbformat.append(colLengths[8]);
							sbformat.append("s");

							sbformat.append("|%10$-");
							sbformat.append(colLengths[9]);
							sbformat.append("s");

							sbformat.append("|%11$-");
							sbformat.append(colLengths[10]);
							sbformat.append("s");

							sbformat.append("|%12$-");
							sbformat.append(colLengths[11]);
							sbformat.append("s");

							sbformat.append("|%13$-");
							sbformat.append(colLengths[12]);
							sbformat.append("s");

							sbformat.append("|%14$-");
							sbformat.append(colLengths[13]);
							sbformat.append("s");

							sbformat.append("|%15$-");
							sbformat.append(colLengths[14]);
							sbformat.append("s");

							sbformat.append("|%16$-");
							sbformat.append(colLengths[15]);
							sbformat.append("s");

							sbformat.append("|%17$-");
							sbformat.append(colLengths[16]);
							sbformat.append("s");

							sbformat.append("|%18$-");
							sbformat.append(colLengths[17]);
							sbformat.append("s");

							sbformat.append("|%19$-");
							sbformat.append(colLengths[18]);
							sbformat.append("s");

							sbformat.append("|%20$-");
							sbformat.append(colLengths[19]);
							sbformat.append("s");

							sbformat.append("|%21$-");
							sbformat.append(colLengths[20]);
							sbformat.append("s");

							sbformat.append("|%22$-");
							sbformat.append(colLengths[21]);
							sbformat.append("s");

							sbformat.append("|%23$-");
							sbformat.append(colLengths[22]);
							sbformat.append("s");

							sbformat.append("|%24$-");
							sbformat.append(colLengths[23]);
							sbformat.append("s");

							sbformat.append("|%25$-");
							sbformat.append(colLengths[24]);
							sbformat.append("s");

							sbformat.append("|%26$-");
							sbformat.append(colLengths[25]);
							sbformat.append("s");

							sbformat.append("|%27$-");
							sbformat.append(colLengths[26]);
							sbformat.append("s");

							sbformat.append("|%28$-");
							sbformat.append(colLengths[27]);
							sbformat.append("s");

							sbformat.append("|%29$-");
							sbformat.append(colLengths[28]);
							sbformat.append("s");

							sbformat.append("|%30$-");
							sbformat.append(colLengths[29]);
							sbformat.append("s");

							sbformat.append("|%31$-");
							sbformat.append(colLengths[30]);
							sbformat.append("s");

							sbformat.append("|%32$-");
							sbformat.append(colLengths[31]);
							sbformat.append("s");

							sbformat.append("|%33$-");
							sbformat.append(colLengths[32]);
							sbformat.append("s");

							sbformat.append("|%34$-");
							sbformat.append(colLengths[33]);
							sbformat.append("s");

							sbformat.append("|%35$-");
							sbformat.append(colLengths[34]);
							sbformat.append("s");

							sbformat.append("|%36$-");
							sbformat.append(colLengths[35]);
							sbformat.append("s");

							sbformat.append("|%37$-");
							sbformat.append(colLengths[36]);
							sbformat.append("s");

							sbformat.append("|\n");

							formatter.format(sbformat.toString(), (Object[]) row);

							sb.append(formatter.toString());
							if (i == 0)
								sb.append(print(des_head)); // print the head
						}

						// end
						sb.append(print(des_bottom));
						return sb;
					}

					private StringBuilder print(String[] fillChars) {
						StringBuilder sb = new StringBuilder();
						// first column
						sb.append(fillChars[0]);
						for (int i = 0; i < colLengths[0] - fillChars[0].length() + 1; i++) {
							sb.append(fillChars[2]);
						}
						sb.append(fillChars[3]);

						for (int i = 0; i < colLengths[1] - fillChars[3].length() + 1; i++) {
							sb.append(fillChars[2]);
						}
						sb.append(fillChars[3]);
						for (int i = 0; i < colLengths[2] - fillChars[3].length() + 1; i++) {
							sb.append(fillChars[2]);
						}
						sb.append(fillChars[3]);
						for (int i = 0; i < colLengths[3] - fillChars[3].length() + 1; i++) {
							sb.append(fillChars[2]);
						}
						sb.append(fillChars[3]);
						for (int i = 0; i < colLengths[4] - fillChars[3].length() + 1; i++) {
							sb.append(fillChars[2]);
						}
						sb.append(fillChars[3]);
						for (int i = 0; i < colLengths[5] - fillChars[3].length() + 1; i++) {
							sb.append(fillChars[2]);
						}
						sb.append(fillChars[3]);
						for (int i = 0; i < colLengths[6] - fillChars[3].length() + 1; i++) {
							sb.append(fillChars[2]);
						}
						sb.append(fillChars[3]);
						for (int i = 0; i < colLengths[7] - fillChars[3].length() + 1; i++) {
							sb.append(fillChars[2]);
						}
						sb.append(fillChars[3]);
						for (int i = 0; i < colLengths[8] - fillChars[3].length() + 1; i++) {
							sb.append(fillChars[2]);
						}
						sb.append(fillChars[3]);
						for (int i = 0; i < colLengths[9] - fillChars[3].length() + 1; i++) {
							sb.append(fillChars[2]);
						}
						sb.append(fillChars[3]);
						for (int i = 0; i < colLengths[10] - fillChars[3].length() + 1; i++) {
							sb.append(fillChars[2]);
						}
						sb.append(fillChars[3]);
						for (int i = 0; i < colLengths[11] - fillChars[3].length() + 1; i++) {
							sb.append(fillChars[2]);
						}
						sb.append(fillChars[3]);
						for (int i = 0; i < colLengths[12] - fillChars[3].length() + 1; i++) {
							sb.append(fillChars[2]);
						}
						sb.append(fillChars[3]);
						for (int i = 0; i < colLengths[13] - fillChars[3].length() + 1; i++) {
							sb.append(fillChars[2]);
						}
						sb.append(fillChars[3]);
						for (int i = 0; i < colLengths[14] - fillChars[3].length() + 1; i++) {
							sb.append(fillChars[2]);
						}
						sb.append(fillChars[3]);
						for (int i = 0; i < colLengths[15] - fillChars[3].length() + 1; i++) {
							sb.append(fillChars[2]);
						}
						sb.append(fillChars[3]);
						for (int i = 0; i < colLengths[16] - fillChars[3].length() + 1; i++) {
							sb.append(fillChars[2]);
						}
						sb.append(fillChars[3]);
						for (int i = 0; i < colLengths[17] - fillChars[3].length() + 1; i++) {
							sb.append(fillChars[2]);
						}
						sb.append(fillChars[3]);
						for (int i = 0; i < colLengths[18] - fillChars[3].length() + 1; i++) {
							sb.append(fillChars[2]);
						}
						sb.append(fillChars[3]);
						for (int i = 0; i < colLengths[19] - fillChars[3].length() + 1; i++) {
							sb.append(fillChars[2]);
						}
						sb.append(fillChars[3]);
						for (int i = 0; i < colLengths[20] - fillChars[3].length() + 1; i++) {
							sb.append(fillChars[2]);
						}
						sb.append(fillChars[3]);
						for (int i = 0; i < colLengths[21] - fillChars[3].length() + 1; i++) {
							sb.append(fillChars[2]);
						}
						sb.append(fillChars[3]);
						for (int i = 0; i < colLengths[22] - fillChars[3].length() + 1; i++) {
							sb.append(fillChars[2]);
						}
						sb.append(fillChars[3]);
						for (int i = 0; i < colLengths[23] - fillChars[3].length() + 1; i++) {
							sb.append(fillChars[2]);
						}
						sb.append(fillChars[3]);
						for (int i = 0; i < colLengths[24] - fillChars[3].length() + 1; i++) {
							sb.append(fillChars[2]);
						}
						sb.append(fillChars[3]);
						for (int i = 0; i < colLengths[25] - fillChars[3].length() + 1; i++) {
							sb.append(fillChars[2]);
						}
						sb.append(fillChars[3]);
						for (int i = 0; i < colLengths[26] - fillChars[3].length() + 1; i++) {
							sb.append(fillChars[2]);
						}
						sb.append(fillChars[3]);
						for (int i = 0; i < colLengths[27] - fillChars[3].length() + 1; i++) {
							sb.append(fillChars[2]);
						}
						sb.append(fillChars[3]);
						for (int i = 0; i < colLengths[28] - fillChars[3].length() + 1; i++) {
							sb.append(fillChars[2]);
						}
						sb.append(fillChars[3]);
						for (int i = 0; i < colLengths[29] - fillChars[3].length() + 1; i++) {
							sb.append(fillChars[2]);
						}
						sb.append(fillChars[3]);
						for (int i = 0; i < colLengths[30] - fillChars[3].length() + 1; i++) {
							sb.append(fillChars[2]);
						}
						sb.append(fillChars[3]);
						for (int i = 0; i < colLengths[31] - fillChars[3].length() + 1; i++) {
							sb.append(fillChars[2]);
						}
						sb.append(fillChars[3]);
						for (int i = 0; i < colLengths[32] - fillChars[3].length() + 1; i++) {
							sb.append(fillChars[2]);
						}
						sb.append(fillChars[3]);
						for (int i = 0; i < colLengths[33] - fillChars[3].length() + 1; i++) {
							sb.append(fillChars[2]);
						}
						sb.append(fillChars[3]);
						for (int i = 0; i < colLengths[34] - fillChars[3].length() + 1; i++) {
							sb.append(fillChars[2]);
						}
						sb.append(fillChars[3]);
						for (int i = 0; i < colLengths[35] - fillChars[3].length() + 1; i++) {
							sb.append(fillChars[2]);
						}
						sb.append(fillChars[3]);

						// last column
						for (int i = 0; i < colLengths[36] - fillChars[1].length() + 1; i++) {
							sb.append(fillChars[2]);
						}
						sb.append(fillChars[1]);
						sb.append("\n");
						return sb;
					}

					public boolean isTableEmpty() {
						if (list.size() > 1)
							return false;
						return true;
					}
				}
				Util_tLogRow_2 util_tLogRow_2 = new Util_tLogRow_2();
				util_tLogRow_2.setTableName("<b>Matches Distances</b>");
				util_tLogRow_2.addRow(new String[] { "FirstName", "LastName", "Gender", "PatientAddress", "City",
						"State", "PostalCode", "Birthday", "SSN", "HPLNID", "NYSIISFirstName", "NYSIISLastName",
						"HealthPlanID", "MRN", "TargetFirstName", "TargetLastName", "TargetGender",
						"TargetPatientAddress", "TargetCity", "TargetState", "TargetPostalCode", "TargetBirthday",
						"TargetSSN", "TargetHPLNID", "TargetNYSIISFirstName", "TargetNYSIISLastName",
						"TargetHealthPlanID", "TargetMRN", "MATCHINGDISTANCES", "MATCHINGWEIGHT", "SSNBlockingKey",
						"FNDOBBlockingKey", "LNPCBlockingKey", "NYSIISFNLNBlockingKey", "DOBPCBlockingKey",
						"MRNBlockingKey", "HealthPlanIDBlockingKey", });
				StringBuilder strBuffer_tLogRow_2 = null;
				int nb_line_tLogRow_2 = 0;
///////////////////////    			

				/**
				 * [tLogRow_2 begin ] stop
				 */

				/**
				 * [tMap_3 begin ] start
				 */

				sh("tMap_3");

				s(currentComponent = "tMap_3");

				cLabel = "<b>Mapping</b>";

				runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, 0, 0, "PossibleMatches");

				int tos_count_tMap_3 = 0;

				if (log.isDebugEnabled())
					log.debug("tMap_3 - " + ("Start to work."));
				if (log.isDebugEnabled()) {
					class BytesLimit65535_tMap_3 {
						public void limitLog4jByte() throws Exception {
							StringBuilder log4jParamters_tMap_3 = new StringBuilder();
							log4jParamters_tMap_3.append("Parameters:");
							log4jParamters_tMap_3.append("LINK_STYLE" + " = " + "AUTO");
							log4jParamters_tMap_3.append(" | ");
							log4jParamters_tMap_3.append("TEMPORARY_DATA_DIRECTORY" + " = " + "");
							log4jParamters_tMap_3.append(" | ");
							log4jParamters_tMap_3.append("ROWS_BUFFER_SIZE" + " = " + "2000000");
							log4jParamters_tMap_3.append(" | ");
							log4jParamters_tMap_3.append("CHANGE_HASH_AND_EQUALS_FOR_BIGDECIMAL" + " = " + "true");
							log4jParamters_tMap_3.append(" | ");
							if (log.isDebugEnabled())
								log.debug("tMap_3 - " + (log4jParamters_tMap_3));
						}
					}
					new BytesLimit65535_tMap_3().limitLog4jByte();
				}
				if (enableLogStash) {
					talendJobLog.addCM("tMap_3", "<b>Mapping</b>", "tMap");
					talendJobLogProcess(globalMap);
					s(currentComponent);
				}

// ###############################
// # Lookup's keys initialization
				int count_PossibleMatches_tMap_3 = 0;

// ###############################        

// ###############################
// # Vars initialization
				class Var__tMap_3__Struct {
				}
				Var__tMap_3__Struct Var__tMap_3 = new Var__tMap_3__Struct();
// ###############################

// ###############################
// # Outputs initialization
				int count_PossibleMatchesOutput_tMap_3 = 0;

				PossibleMatchesOutputStruct PossibleMatchesOutput_tmp = new PossibleMatchesOutputStruct();
// ###############################

				/**
				 * [tMap_3 begin ] stop
				 */

				/**
				 * [tRecordMatching_2 begin ] start
				 */

				sh("tRecordMatching_2");

				s(currentComponent = "tRecordMatching_2");

				cLabel = "<b>Matching Records</b>";

				runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, 0, 0, "Source");

				int tos_count_tRecordMatching_2 = 0;

				if (log.isDebugEnabled())
					log.debug("tRecordMatching_2 - " + ("Start to work."));
				if (log.isDebugEnabled()) {
					class BytesLimit65535_tRecordMatching_2 {
						public void limitLog4jByte() throws Exception {
							StringBuilder log4jParamters_tRecordMatching_2 = new StringBuilder();
							log4jParamters_tRecordMatching_2.append("Parameters:");
							log4jParamters_tRecordMatching_2.append("REPLACED_BY_LOOKUPCOL" + " = " + "false");
							log4jParamters_tRecordMatching_2.append(" | ");
							log4jParamters_tRecordMatching_2.append("JOIN_KEY" + " = " + "[{MATCHING_TYPE=" + ("Exact")
									+ ", HANDLE_NULL=" + ("nullMatchNull") + ", CONFIDENCE_WEIGHT=" + ("1")
									+ ", INPUT_COLUMN=" + ("SSN") + ", LOOKUP_COLUMN=" + ("TargetSSN")
									+ ", CUSTOM_MATCHER=" + ("\"\"") + ", TOKENIZATION_TYPE=" + ("No")
									+ "}, {MATCHING_TYPE=" + ("Exact") + ", HANDLE_NULL=" + ("nullMatchNull")
									+ ", CONFIDENCE_WEIGHT=" + ("1") + ", INPUT_COLUMN=" + ("Birthday")
									+ ", LOOKUP_COLUMN=" + ("TargetBirthday") + ", CUSTOM_MATCHER=" + ("\"\"")
									+ ", TOKENIZATION_TYPE=" + ("No") + "}, {MATCHING_TYPE=" + ("Exact")
									+ ", HANDLE_NULL=" + ("nullMatchNull") + ", CONFIDENCE_WEIGHT=" + ("1")
									+ ", INPUT_COLUMN=" + ("Gender") + ", LOOKUP_COLUMN=" + ("TargetGender")
									+ ", CUSTOM_MATCHER=" + ("\"\"") + ", TOKENIZATION_TYPE=" + ("No")
									+ "}, {MATCHING_TYPE=" + ("Exact") + ", HANDLE_NULL=" + ("nullMatchNull")
									+ ", CONFIDENCE_WEIGHT=" + ("1") + ", INPUT_COLUMN=" + ("PostalCode")
									+ ", LOOKUP_COLUMN=" + ("TargetPostalCode") + ", CUSTOM_MATCHER=" + ("\"\"")
									+ ", TOKENIZATION_TYPE=" + ("No") + "}, {MATCHING_TYPE=" + ("Exact")
									+ ", HANDLE_NULL=" + ("nullMatchNull") + ", CONFIDENCE_WEIGHT=" + ("1")
									+ ", INPUT_COLUMN=" + ("HPLNID") + ", LOOKUP_COLUMN=" + ("TargetHPLNID")
									+ ", CUSTOM_MATCHER=" + ("\"\"") + ", TOKENIZATION_TYPE=" + ("No")
									+ "}, {MATCHING_TYPE=" + ("Exact") + ", HANDLE_NULL=" + ("nullMatchNull")
									+ ", CONFIDENCE_WEIGHT=" + ("1") + ", INPUT_COLUMN=" + ("FirstName")
									+ ", LOOKUP_COLUMN=" + ("TargetFirstName") + ", CUSTOM_MATCHER=" + ("\"\"")
									+ ", TOKENIZATION_TYPE=" + ("No") + "}, {MATCHING_TYPE=" + ("Exact")
									+ ", HANDLE_NULL=" + ("nullMatchNull") + ", CONFIDENCE_WEIGHT=" + ("1")
									+ ", INPUT_COLUMN=" + ("LastName") + ", LOOKUP_COLUMN=" + ("TargetLastName")
									+ ", CUSTOM_MATCHER=" + ("\"\"") + ", TOKENIZATION_TYPE=" + ("No")
									+ "}, {MATCHING_TYPE=" + ("Exact") + ", HANDLE_NULL=" + ("nullMatchNull")
									+ ", CONFIDENCE_WEIGHT=" + ("1") + ", INPUT_COLUMN=" + ("PatientAddress")
									+ ", LOOKUP_COLUMN=" + ("TargetPatientAddress") + ", CUSTOM_MATCHER=" + ("\"\"")
									+ ", TOKENIZATION_TYPE=" + ("No") + "}]");
							log4jParamters_tRecordMatching_2.append(" | ");
							log4jParamters_tRecordMatching_2.append("BLOCKING_DEFINITION" + " = " + "[{INPUT_COLUMN="
									+ ("SSNBlockingKey") + ", LOOKUP_COLUMN=" + ("SSNBlockingKey") + "}]");
							log4jParamters_tRecordMatching_2.append(" | ");
							log4jParamters_tRecordMatching_2.append("OUTPUT_STAT" + " = " + "ALL_MATCHES");
							log4jParamters_tRecordMatching_2.append(" | ");
							log4jParamters_tRecordMatching_2
									.append("MATCHING_ALGORITHM" + " = " + "Simple VSR Matcher");
							log4jParamters_tRecordMatching_2.append(" | ");
							log4jParamters_tRecordMatching_2.append("MINIMUM" + " = " + "-1");
							log4jParamters_tRecordMatching_2.append(" | ");
							log4jParamters_tRecordMatching_2.append("MAXIMUM" + " = " + "1.01");
							log4jParamters_tRecordMatching_2.append(" | ");
							log4jParamters_tRecordMatching_2.append("IS_VIRTUAL_COMPONENT" + " = " + "false");
							log4jParamters_tRecordMatching_2.append(" | ");
							if (log.isDebugEnabled())
								log.debug("tRecordMatching_2 - " + (log4jParamters_tRecordMatching_2));
						}
					}
					new BytesLimit65535_tRecordMatching_2().limitLog4jByte();
				}
				if (enableLogStash) {
					talendJobLog.addCM("tRecordMatching_2", "<b>Matching Records</b>", "tRecordMatching");
					talendJobLogProcess(globalMap);
					s(currentComponent);
				}

				// # Lookup's keys initialization
				org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<TargetStruct> tHash_Target = (org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<TargetStruct>) globalMap
						.get("tHash_Lookup_Target");
				tHash_Target.initGet();
				TargetStruct TargetHashKey = new TargetStruct();
				// ###############################
				int nb_matches_tRecordMatching_2 = 0;
				int nb_pMatches_tRecordMatching_2 = 0;
				int nb_nMatches_tRecordMatching_2 = 0;
				double[] arrAttrWeights_tRecordMatching_2 = new double[8];
				String[][] arrMatcherAlgoName_tRecordMatching_2 = new String[8][2];
				org.talend.dataquality.record.linkage.constant.TokenizedResolutionMethod[] tokenizationMethod_tRecordMatching_2 = new org.talend.dataquality.record.linkage.constant.TokenizedResolutionMethod[8];

				Object cfWeight_tRecordMatching_2 = null;
				org.talend.dataquality.record.linkage.attribute.IAttributeMatcher.NullOption[] arrMatchHandleNull_tRecordMatching_2 = new org.talend.dataquality.record.linkage.attribute.IAttributeMatcher.NullOption[8];

				tokenizationMethod_tRecordMatching_2[0] = org.talend.dataquality.record.linkage.constant.TokenizedResolutionMethod
						.getTypeByValue("No");

				cfWeight_tRecordMatching_2 = 1;
				if (cfWeight_tRecordMatching_2 != null) {
					arrAttrWeights_tRecordMatching_2[0] = Double.valueOf(1);
				} else {
					throw new Exception("Confidence Weight should not be null.");
				}

				arrMatcherAlgoName_tRecordMatching_2[0][0] = "Exact";
				arrMatchHandleNull_tRecordMatching_2[0] = org.talend.dataquality.record.linkage.attribute.IAttributeMatcher.NullOption.nullMatchNull;
				tokenizationMethod_tRecordMatching_2[1] = org.talend.dataquality.record.linkage.constant.TokenizedResolutionMethod
						.getTypeByValue("No");

				cfWeight_tRecordMatching_2 = 1;
				if (cfWeight_tRecordMatching_2 != null) {
					arrAttrWeights_tRecordMatching_2[1] = Double.valueOf(1);
				} else {
					throw new Exception("Confidence Weight should not be null.");
				}

				arrMatcherAlgoName_tRecordMatching_2[1][0] = "Exact";
				arrMatchHandleNull_tRecordMatching_2[1] = org.talend.dataquality.record.linkage.attribute.IAttributeMatcher.NullOption.nullMatchNull;
				tokenizationMethod_tRecordMatching_2[2] = org.talend.dataquality.record.linkage.constant.TokenizedResolutionMethod
						.getTypeByValue("No");

				cfWeight_tRecordMatching_2 = 1;
				if (cfWeight_tRecordMatching_2 != null) {
					arrAttrWeights_tRecordMatching_2[2] = Double.valueOf(1);
				} else {
					throw new Exception("Confidence Weight should not be null.");
				}

				arrMatcherAlgoName_tRecordMatching_2[2][0] = "Exact";
				arrMatchHandleNull_tRecordMatching_2[2] = org.talend.dataquality.record.linkage.attribute.IAttributeMatcher.NullOption.nullMatchNull;
				tokenizationMethod_tRecordMatching_2[3] = org.talend.dataquality.record.linkage.constant.TokenizedResolutionMethod
						.getTypeByValue("No");

				cfWeight_tRecordMatching_2 = 1;
				if (cfWeight_tRecordMatching_2 != null) {
					arrAttrWeights_tRecordMatching_2[3] = Double.valueOf(1);
				} else {
					throw new Exception("Confidence Weight should not be null.");
				}

				arrMatcherAlgoName_tRecordMatching_2[3][0] = "Exact";
				arrMatchHandleNull_tRecordMatching_2[3] = org.talend.dataquality.record.linkage.attribute.IAttributeMatcher.NullOption.nullMatchNull;
				tokenizationMethod_tRecordMatching_2[4] = org.talend.dataquality.record.linkage.constant.TokenizedResolutionMethod
						.getTypeByValue("No");

				cfWeight_tRecordMatching_2 = 1;
				if (cfWeight_tRecordMatching_2 != null) {
					arrAttrWeights_tRecordMatching_2[4] = Double.valueOf(1);
				} else {
					throw new Exception("Confidence Weight should not be null.");
				}

				arrMatcherAlgoName_tRecordMatching_2[4][0] = "Exact";
				arrMatchHandleNull_tRecordMatching_2[4] = org.talend.dataquality.record.linkage.attribute.IAttributeMatcher.NullOption.nullMatchNull;
				tokenizationMethod_tRecordMatching_2[5] = org.talend.dataquality.record.linkage.constant.TokenizedResolutionMethod
						.getTypeByValue("No");

				cfWeight_tRecordMatching_2 = 1;
				if (cfWeight_tRecordMatching_2 != null) {
					arrAttrWeights_tRecordMatching_2[5] = Double.valueOf(1);
				} else {
					throw new Exception("Confidence Weight should not be null.");
				}

				arrMatcherAlgoName_tRecordMatching_2[5][0] = "Exact";
				arrMatchHandleNull_tRecordMatching_2[5] = org.talend.dataquality.record.linkage.attribute.IAttributeMatcher.NullOption.nullMatchNull;
				tokenizationMethod_tRecordMatching_2[6] = org.talend.dataquality.record.linkage.constant.TokenizedResolutionMethod
						.getTypeByValue("No");

				cfWeight_tRecordMatching_2 = 1;
				if (cfWeight_tRecordMatching_2 != null) {
					arrAttrWeights_tRecordMatching_2[6] = Double.valueOf(1);
				} else {
					throw new Exception("Confidence Weight should not be null.");
				}

				arrMatcherAlgoName_tRecordMatching_2[6][0] = "Exact";
				arrMatchHandleNull_tRecordMatching_2[6] = org.talend.dataquality.record.linkage.attribute.IAttributeMatcher.NullOption.nullMatchNull;
				tokenizationMethod_tRecordMatching_2[7] = org.talend.dataquality.record.linkage.constant.TokenizedResolutionMethod
						.getTypeByValue("No");

				cfWeight_tRecordMatching_2 = 1;
				if (cfWeight_tRecordMatching_2 != null) {
					arrAttrWeights_tRecordMatching_2[7] = Double.valueOf(1);
				} else {
					throw new Exception("Confidence Weight should not be null.");
				}

				arrMatcherAlgoName_tRecordMatching_2[7][0] = "Exact";
				arrMatchHandleNull_tRecordMatching_2[7] = org.talend.dataquality.record.linkage.attribute.IAttributeMatcher.NullOption.nullMatchNull;
				org.talend.dataquality.record.linkage.attribute.IAttributeMatcher[] attributeMatchers_tRecordMatching_2 = new org.talend.dataquality.record.linkage.attribute.IAttributeMatcher[8];

				for (int i_tRecordMatching_2 = 0; i_tRecordMatching_2 < 8; i_tRecordMatching_2++) {
					org.talend.dataquality.record.linkage.constant.AttributeMatcherType type_tRecordMatching_2 = org.talend.dataquality.record.linkage.constant.AttributeMatcherType
							.get(arrMatcherAlgoName_tRecordMatching_2[i_tRecordMatching_2][0]);
					attributeMatchers_tRecordMatching_2[i_tRecordMatching_2] = org.talend.dataquality.record.linkage.attribute.AttributeMatcherFactory
							.createMatcher(type_tRecordMatching_2,
									arrMatcherAlgoName_tRecordMatching_2[i_tRecordMatching_2][1]);
					attributeMatchers_tRecordMatching_2[i_tRecordMatching_2]
							.setNullOption(arrMatchHandleNull_tRecordMatching_2[i_tRecordMatching_2]);
					if (attributeMatchers_tRecordMatching_2[i_tRecordMatching_2] instanceof org.talend.dataquality.record.linkage.attribute.AbstractAttributeMatcher)
						((org.talend.dataquality.record.linkage.attribute.AbstractAttributeMatcher) attributeMatchers_tRecordMatching_2[i_tRecordMatching_2])
								.setTokenMethod(tokenizationMethod_tRecordMatching_2[i_tRecordMatching_2]);

				}
				org.talend.dataquality.record.linkage.record.IRecordMatcher recordMatcher_tRecordMatching_2 = org.talend.dataquality.record.linkage.record.RecordMatcherFactory
						.createMatcher(
								org.talend.dataquality.record.linkage.constant.RecordMatcherType.simpleVSRMatcher);
				recordMatcher_tRecordMatching_2.setRecordSize(8);
				recordMatcher_tRecordMatching_2.setAttributeWeights(arrAttrWeights_tRecordMatching_2);
				recordMatcher_tRecordMatching_2.setAttributeMatchers(attributeMatchers_tRecordMatching_2);

				/**
				 * [tRecordMatching_2 begin ] stop
				 */

				/**
				 * [tDBInput_3 begin ] start
				 */

				sh("tDBInput_3");

				s(currentComponent = "tDBInput_3");

				cLabel = "<b>Data Sources</b>";

				int tos_count_tDBInput_3 = 0;

				if (log.isDebugEnabled())
					log.debug("tDBInput_3 - " + ("Start to work."));
				if (log.isDebugEnabled()) {
					class BytesLimit65535_tDBInput_3 {
						public void limitLog4jByte() throws Exception {
							StringBuilder log4jParamters_tDBInput_3 = new StringBuilder();
							log4jParamters_tDBInput_3.append("Parameters:");
							log4jParamters_tDBInput_3.append("DB_VERSION" + " = " + "MYSQL_8");
							log4jParamters_tDBInput_3.append(" | ");
							log4jParamters_tDBInput_3.append("USE_EXISTING_CONNECTION" + " = " + "false");
							log4jParamters_tDBInput_3.append(" | ");
							log4jParamters_tDBInput_3.append("HOST" + " = " + "\"localhost\"");
							log4jParamters_tDBInput_3.append(" | ");
							log4jParamters_tDBInput_3.append("PORT" + " = " + "\"3306\"");
							log4jParamters_tDBInput_3.append(" | ");
							log4jParamters_tDBInput_3.append("DBNAME" + " = " + "\"CHIA\"");
							log4jParamters_tDBInput_3.append(" | ");
							log4jParamters_tDBInput_3.append("USER" + " = " + "\"root\"");
							log4jParamters_tDBInput_3.append(" | ");
							log4jParamters_tDBInput_3.append("PASS" + " = " + String.valueOf(
									"enc:routine.encryption.key.v2:QAR8CnVJOsLCymZrSNDTB81Jc19VTavFtluejqI4VlUJG2UUbQ==")
									.substring(0, 4) + "...");
							log4jParamters_tDBInput_3.append(" | ");
							log4jParamters_tDBInput_3.append("TABLE" + " = " + "\"CHIAStage\"");
							log4jParamters_tDBInput_3.append(" | ");
							log4jParamters_tDBInput_3.append("QUERYSTORE" + " = " + "\"\"");
							log4jParamters_tDBInput_3.append(" | ");
							log4jParamters_tDBInput_3.append("QUERY" + " = "
									+ "\"SELECT    `CHIAStage`.`FirstName`,    `CHIAStage`.`LastName`,    `CHIAStage`.`Gender`,    `CHIAStage`.`PatientAddress`,    `CHIAStage`.`City`,    `CHIAStage`.`State`,    `CHIAStage`.`PostalCode`,    `CHIAStage`.`Birthday`,    `CHIAStage`.`SSN`,    `CHIAStage`.`HPLNID`,    `CHIAStage`.`NYSIISFirstName`,    `CHIAStage`.`NYSIISLastName`,    `CHIAStage`.`HealthPlanID`,    `CHIAStage`.`MRN`,    `CHIAStage`.`SSNBlockingKey`,    `CHIAStage`.`FNDOBBlockingKey`,    `CHIAStage`.`LNPCBlockingKey`,    `CHIAStage`.`NYSIISFNLNBlockingKey`,    `CHIAStage`.`DOBPCBlockingKey`,    `CHIAStage`.`MRNBlockingKey`,    `CHIAStage`.`HealthPlanIDBlockingKey`  FROM `CHIAStage`\"");
							log4jParamters_tDBInput_3.append(" | ");
							log4jParamters_tDBInput_3.append("SPECIFY_DATASOURCE_ALIAS" + " = " + "false");
							log4jParamters_tDBInput_3.append(" | ");
							log4jParamters_tDBInput_3.append("PROPERTIES" + " = "
									+ "\"noDatetimeStringSync=true&enabledTLSProtocols=TLSv1.2,TLSv1.1,TLSv1\"");
							log4jParamters_tDBInput_3.append(" | ");
							log4jParamters_tDBInput_3.append("ENABLE_STREAM" + " = " + "false");
							log4jParamters_tDBInput_3.append(" | ");
							log4jParamters_tDBInput_3.append("TRIM_ALL_COLUMN" + " = " + "false");
							log4jParamters_tDBInput_3.append(" | ");
							log4jParamters_tDBInput_3.append("TRIM_COLUMN" + " = " + "[{TRIM=" + ("false")
									+ ", SCHEMA_COLUMN=" + ("FirstName") + "}, {TRIM=" + ("false") + ", SCHEMA_COLUMN="
									+ ("LastName") + "}, {TRIM=" + ("false") + ", SCHEMA_COLUMN=" + ("Gender")
									+ "}, {TRIM=" + ("false") + ", SCHEMA_COLUMN=" + ("PatientAddress") + "}, {TRIM="
									+ ("false") + ", SCHEMA_COLUMN=" + ("City") + "}, {TRIM=" + ("false")
									+ ", SCHEMA_COLUMN=" + ("State") + "}, {TRIM=" + ("false") + ", SCHEMA_COLUMN="
									+ ("PostalCode") + "}, {TRIM=" + ("false") + ", SCHEMA_COLUMN=" + ("Birthday")
									+ "}, {TRIM=" + ("false") + ", SCHEMA_COLUMN=" + ("SSN") + "}, {TRIM=" + ("false")
									+ ", SCHEMA_COLUMN=" + ("HPLNID") + "}, {TRIM=" + ("false") + ", SCHEMA_COLUMN="
									+ ("NYSIISFirstName") + "}, {TRIM=" + ("false") + ", SCHEMA_COLUMN="
									+ ("NYSIISLastName") + "}, {TRIM=" + ("false") + ", SCHEMA_COLUMN="
									+ ("HealthPlanID") + "}, {TRIM=" + ("false") + ", SCHEMA_COLUMN=" + ("MRN")
									+ "}, {TRIM=" + ("false") + ", SCHEMA_COLUMN=" + ("SSNBlockingKey") + "}, {TRIM="
									+ ("false") + ", SCHEMA_COLUMN=" + ("FNDOBBlockingKey") + "}, {TRIM=" + ("false")
									+ ", SCHEMA_COLUMN=" + ("LNPCBlockingKey") + "}, {TRIM=" + ("false")
									+ ", SCHEMA_COLUMN=" + ("NYSIISFNLNBlockingKey") + "}, {TRIM=" + ("false")
									+ ", SCHEMA_COLUMN=" + ("DOBPCBlockingKey") + "}, {TRIM=" + ("false")
									+ ", SCHEMA_COLUMN=" + ("MRNBlockingKey") + "}, {TRIM=" + ("false")
									+ ", SCHEMA_COLUMN=" + ("HealthPlanIDBlockingKey") + "}]");
							log4jParamters_tDBInput_3.append(" | ");
							log4jParamters_tDBInput_3.append("UNIFIED_COMPONENTS" + " = " + "tMysqlInput");
							log4jParamters_tDBInput_3.append(" | ");
							if (log.isDebugEnabled())
								log.debug("tDBInput_3 - " + (log4jParamters_tDBInput_3));
						}
					}
					new BytesLimit65535_tDBInput_3().limitLog4jByte();
				}
				if (enableLogStash) {
					talendJobLog.addCM("tDBInput_3", "<b>Data Sources</b>", "tMysqlInput");
					talendJobLogProcess(globalMap);
					s(currentComponent);
				}

				java.util.Calendar calendar_tDBInput_3 = java.util.Calendar.getInstance();
				calendar_tDBInput_3.set(0, 0, 0, 0, 0, 0);
				java.util.Date year0_tDBInput_3 = calendar_tDBInput_3.getTime();
				int nb_line_tDBInput_3 = 0;
				java.sql.Connection conn_tDBInput_3 = null;
				String driverClass_tDBInput_3 = "com.mysql.cj.jdbc.Driver";
				java.lang.Class jdbcclazz_tDBInput_3 = java.lang.Class.forName(driverClass_tDBInput_3);
				String dbUser_tDBInput_3 = "root";

				final String decryptedPassword_tDBInput_3 = routines.system.PasswordEncryptUtil.decryptPassword(
						"enc:routine.encryption.key.v2:SNoMtjaEilo4SLnyoqm95tNHji/Y0aYFvJEYjZgRNGc5P8O1pw==");

				String dbPwd_tDBInput_3 = decryptedPassword_tDBInput_3;

				String properties_tDBInput_3 = "noDatetimeStringSync=true&enabledTLSProtocols=TLSv1.2,TLSv1.1,TLSv1";
				if (properties_tDBInput_3 == null || properties_tDBInput_3.trim().length() == 0) {
					properties_tDBInput_3 = "";
				}
				String url_tDBInput_3 = "jdbc:mysql://" + "localhost" + ":" + "3306" + "/" + "CHIA" + "?"
						+ properties_tDBInput_3;

				log.debug("tDBInput_3 - Driver ClassName: " + driverClass_tDBInput_3 + ".");

				log.debug("tDBInput_3 - Connection attempt to '"
						+ url_tDBInput_3.replaceAll("(?<=trustStorePassword=)[^;]*", "********")
						+ "' with the username '" + dbUser_tDBInput_3 + "'.");

				conn_tDBInput_3 = java.sql.DriverManager.getConnection(url_tDBInput_3, dbUser_tDBInput_3,
						dbPwd_tDBInput_3);
				log.debug("tDBInput_3 - Connection to '"
						+ url_tDBInput_3.replaceAll("(?<=trustStorePassword=)[^;]*", "********") + "' has succeeded.");

				java.sql.Statement stmt_tDBInput_3 = conn_tDBInput_3.createStatement();

				String dbquery_tDBInput_3 = new StringBuilder().append(
						"SELECT \n  `CHIAStage`.`FirstName`, \n  `CHIAStage`.`LastName`, \n  `CHIAStage`.`Gender`, \n  `CHIAStage`.`PatientAddress`,"
								+ " \n  `CHIAStage`.`City`, \n  `CHIAStage`.`State`, \n  `CHIAStage`.`PostalCode`, \n  `CHIAStage`.`Birthday`, \n  `CHIAStage`.`"
								+ "SSN`, \n  `CHIAStage`.`HPLNID`, \n  `CHIAStage`.`NYSIISFirstName`, \n  `CHIAStage`.`NYSIISLastName`, \n  `CHIAStage`.`Health"
								+ "PlanID`, \n  `CHIAStage`.`MRN`, \n  `CHIAStage`.`SSNBlockingKey`, \n  `CHIAStage`.`FNDOBBlockingKey`, \n  `CHIAStage`.`LNPCB"
								+ "lockingKey`, \n  `CHIAStage`.`NYSIISFNLNBlockingKey`, \n  `CHIAStage`.`DOBPCBlockingKey`, \n  `CHIAStage`.`MRNBlockingKey`,"
								+ " \n  `CHIAStage`.`HealthPlanIDBlockingKey`\n FROM `CHIAStage`")
						.toString();

				log.debug("tDBInput_3 - Executing the query: '" + dbquery_tDBInput_3 + "'.");

				globalMap.put("tDBInput_3_QUERY", dbquery_tDBInput_3);

				java.sql.ResultSet rs_tDBInput_3 = null;

				try {
					rs_tDBInput_3 = stmt_tDBInput_3.executeQuery(dbquery_tDBInput_3);
					java.sql.ResultSetMetaData rsmd_tDBInput_3 = rs_tDBInput_3.getMetaData();
					int colQtyInRs_tDBInput_3 = rsmd_tDBInput_3.getColumnCount();

					String tmpContent_tDBInput_3 = null;

					log.debug("tDBInput_3 - Retrieving records from the database.");

					while (rs_tDBInput_3.next()) {
						nb_line_tDBInput_3++;

						if (colQtyInRs_tDBInput_3 < 1) {
							Source.FirstName = null;
						} else {

							Source.FirstName = routines.system.JDBCUtil.getString(rs_tDBInput_3, 1, false);
						}
						if (colQtyInRs_tDBInput_3 < 2) {
							Source.LastName = null;
						} else {

							Source.LastName = routines.system.JDBCUtil.getString(rs_tDBInput_3, 2, false);
						}
						if (colQtyInRs_tDBInput_3 < 3) {
							Source.Gender = null;
						} else {

							Source.Gender = routines.system.JDBCUtil.getString(rs_tDBInput_3, 3, false);
						}
						if (colQtyInRs_tDBInput_3 < 4) {
							Source.PatientAddress = null;
						} else {

							Source.PatientAddress = routines.system.JDBCUtil.getString(rs_tDBInput_3, 4, false);
						}
						if (colQtyInRs_tDBInput_3 < 5) {
							Source.City = null;
						} else {

							Source.City = routines.system.JDBCUtil.getString(rs_tDBInput_3, 5, false);
						}
						if (colQtyInRs_tDBInput_3 < 6) {
							Source.State = null;
						} else {

							Source.State = routines.system.JDBCUtil.getString(rs_tDBInput_3, 6, false);
						}
						if (colQtyInRs_tDBInput_3 < 7) {
							Source.PostalCode = null;
						} else {

							Source.PostalCode = rs_tDBInput_3.getInt(7);
							if (rs_tDBInput_3.wasNull()) {
								Source.PostalCode = null;
							}
						}
						if (colQtyInRs_tDBInput_3 < 8) {
							Source.Birthday = null;
						} else {

							if (rs_tDBInput_3.getString(8) != null) {
								String dateString_tDBInput_3 = rs_tDBInput_3.getString(8);
								if (!("0000-00-00").equals(dateString_tDBInput_3)
										&& !("0000-00-00 00:00:00").equals(dateString_tDBInput_3)) {
									Source.Birthday = rs_tDBInput_3.getTimestamp(8);
								} else {
									Source.Birthday = (java.util.Date) year0_tDBInput_3.clone();
								}
							} else {
								Source.Birthday = null;
							}
						}
						if (colQtyInRs_tDBInput_3 < 9) {
							Source.SSN = null;
						} else {

							Source.SSN = routines.system.JDBCUtil.getString(rs_tDBInput_3, 9, false);
						}
						if (colQtyInRs_tDBInput_3 < 10) {
							Source.HPLNID = null;
						} else {

							Source.HPLNID = rs_tDBInput_3.getInt(10);
							if (rs_tDBInput_3.wasNull()) {
								Source.HPLNID = null;
							}
						}
						if (colQtyInRs_tDBInput_3 < 11) {
							Source.NYSIISFirstName = null;
						} else {

							Source.NYSIISFirstName = routines.system.JDBCUtil.getString(rs_tDBInput_3, 11, false);
						}
						if (colQtyInRs_tDBInput_3 < 12) {
							Source.NYSIISLastName = null;
						} else {

							Source.NYSIISLastName = routines.system.JDBCUtil.getString(rs_tDBInput_3, 12, false);
						}
						if (colQtyInRs_tDBInput_3 < 13) {
							Source.HealthPlanID = null;
						} else {

							Source.HealthPlanID = routines.system.JDBCUtil.getString(rs_tDBInput_3, 13, false);
						}
						if (colQtyInRs_tDBInput_3 < 14) {
							Source.MRN = null;
						} else {

							Source.MRN = rs_tDBInput_3.getInt(14);
							if (rs_tDBInput_3.wasNull()) {
								Source.MRN = null;
							}
						}
						if (colQtyInRs_tDBInput_3 < 15) {
							Source.SSNBlockingKey = null;
						} else {

							Source.SSNBlockingKey = routines.system.JDBCUtil.getString(rs_tDBInput_3, 15, false);
						}
						if (colQtyInRs_tDBInput_3 < 16) {
							Source.FNDOBBlockingKey = null;
						} else {

							Source.FNDOBBlockingKey = routines.system.JDBCUtil.getString(rs_tDBInput_3, 16, false);
						}
						if (colQtyInRs_tDBInput_3 < 17) {
							Source.LNPCBlockingKey = null;
						} else {

							Source.LNPCBlockingKey = routines.system.JDBCUtil.getString(rs_tDBInput_3, 17, false);
						}
						if (colQtyInRs_tDBInput_3 < 18) {
							Source.NYSIISFNLNBlockingKey = null;
						} else {

							Source.NYSIISFNLNBlockingKey = routines.system.JDBCUtil.getString(rs_tDBInput_3, 18, false);
						}
						if (colQtyInRs_tDBInput_3 < 19) {
							Source.DOBPCBlockingKey = null;
						} else {

							Source.DOBPCBlockingKey = routines.system.JDBCUtil.getString(rs_tDBInput_3, 19, false);
						}
						if (colQtyInRs_tDBInput_3 < 20) {
							Source.MRNBlockingKey = null;
						} else {

							Source.MRNBlockingKey = routines.system.JDBCUtil.getString(rs_tDBInput_3, 20, false);
						}
						if (colQtyInRs_tDBInput_3 < 21) {
							Source.HealthPlanIDBlockingKey = null;
						} else {

							Source.HealthPlanIDBlockingKey = routines.system.JDBCUtil.getString(rs_tDBInput_3, 21,
									false);
						}

						log.debug("tDBInput_3 - Retrieving the record " + nb_line_tDBInput_3 + ".");

						/**
						 * [tDBInput_3 begin ] stop
						 */

						/**
						 * [tDBInput_3 main ] start
						 */

						s(currentComponent = "tDBInput_3");

						cLabel = "<b>Data Sources</b>";

						tos_count_tDBInput_3++;

						/**
						 * [tDBInput_3 main ] stop
						 */

						/**
						 * [tDBInput_3 process_data_begin ] start
						 */

						s(currentComponent = "tDBInput_3");

						cLabel = "<b>Data Sources</b>";

						/**
						 * [tDBInput_3 process_data_begin ] stop
						 */

						/**
						 * [tRecordMatching_2 main ] start
						 */

						s(currentComponent = "tRecordMatching_2");

						cLabel = "<b>Matching Records</b>";

						if (runStat.update(execStat, enableLogStash, iterateId, 1, 1

								, "Source", "tDBInput_3", "<b>Data Sources</b>", "tMysqlInput", "tRecordMatching_2",
								"<b>Matching Records</b>", "tRecordMatching"

						)) {
							talendJobLogProcess(globalMap);
						}

						if (log.isTraceEnabled()) {
							log.trace("Source - " + (Source == null ? "" : Source.toLogString()));
						}

						String[] arrMainData_tRecordMatching_2 = new String[8];
						String[] arrLookupData_tRecordMatching_2 = new String[8];
						final double UNACCEPTABLE_THRESHOLD_tRecordMatching_2 = Double.valueOf(-1 + "");
						final double ACCEPTABLE_THRESHOLD_tRecordMatching_2 = Double.valueOf(1.01 + "");
						TargetStruct currentLookupRow_Target = null;
						TargetStruct savedMatchRow_Target = null;
						TargetStruct savedPMatchRow_Target = null;
						String sMatchingDists_tRecordMatching_2 = null, savedRowDists_tRecordMatching_2 = null,
								savedPRowDists_tRecordMatching_2 = null;
						double matchingProba_tRecordMatching_2 = 0, savedRowProba_tRecordMatching_2 = 0,
								savedPRowProba_tRecordMatching_2 = 0;
						boolean bMatch_tRecordMatching_2 = false, bPMatch_tRecordMatching_2 = false,
								bHasMatchRec_tRecordMatching_2 = false, bPHasMatchRec_tRecordMatching_2 = false;
						boolean forceLoopTarget = true;
						// not primitive type case
						arrMainData_tRecordMatching_2[0] = Source.SSN == null ? null : String.valueOf(Source.SSN);

						arrMainData_tRecordMatching_2[1] = FormatterUtils.format_Date(Source.Birthday, "dd-MM-yyyy");

						// not primitive type case
						arrMainData_tRecordMatching_2[2] = Source.Gender == null ? null : String.valueOf(Source.Gender);

						// not primitive type case
						arrMainData_tRecordMatching_2[3] = Source.PostalCode == null ? null
								: String.valueOf(Source.PostalCode);

						// not primitive type case
						arrMainData_tRecordMatching_2[4] = Source.HPLNID == null ? null : String.valueOf(Source.HPLNID);

						// not primitive type case
						arrMainData_tRecordMatching_2[5] = Source.FirstName == null ? null
								: String.valueOf(Source.FirstName);

						// not primitive type case
						arrMainData_tRecordMatching_2[6] = Source.LastName == null ? null
								: String.valueOf(Source.LastName);

						// not primitive type case
						arrMainData_tRecordMatching_2[7] = Source.PatientAddress == null ? null
								: String.valueOf(Source.PatientAddress);

						TargetHashKey.SSNBlockingKey = Source.SSNBlockingKey;
						TargetHashKey.hashCodeDirty = true;
						tHash_Target.lookup(TargetHashKey);

						while (tHash_Target.hasNext() || forceLoopTarget) {
							PossibleMatches = null;

							if (tHash_Target.hasNext()) {
								forceLoopTarget = false;
								currentLookupRow_Target = tHash_Target.next();

								// not primitive type case
								arrLookupData_tRecordMatching_2[0] = currentLookupRow_Target.TargetSSN == null ? null
										: String.valueOf(currentLookupRow_Target.TargetSSN);

								arrLookupData_tRecordMatching_2[1] = FormatterUtils
										.format_Date(currentLookupRow_Target.TargetBirthday, "dd-MM-yyyy");

								// not primitive type case
								arrLookupData_tRecordMatching_2[2] = currentLookupRow_Target.TargetGender == null ? null
										: String.valueOf(currentLookupRow_Target.TargetGender);

								// not primitive type case
								arrLookupData_tRecordMatching_2[3] = currentLookupRow_Target.TargetPostalCode == null
										? null
										: String.valueOf(currentLookupRow_Target.TargetPostalCode);

								// not primitive type case
								arrLookupData_tRecordMatching_2[4] = currentLookupRow_Target.TargetHPLNID == null ? null
										: String.valueOf(currentLookupRow_Target.TargetHPLNID);

								// not primitive type case
								arrLookupData_tRecordMatching_2[5] = currentLookupRow_Target.TargetFirstName == null
										? null
										: String.valueOf(currentLookupRow_Target.TargetFirstName);

								// not primitive type case
								arrLookupData_tRecordMatching_2[6] = currentLookupRow_Target.TargetLastName == null
										? null
										: String.valueOf(currentLookupRow_Target.TargetLastName);

								// not primitive type case
								arrLookupData_tRecordMatching_2[7] = currentLookupRow_Target.TargetPatientAddress == null
										? null
										: String.valueOf(currentLookupRow_Target.TargetPatientAddress);

								matchingProba_tRecordMatching_2 = recordMatcher_tRecordMatching_2.getMatchingWeight(
										arrMainData_tRecordMatching_2, arrLookupData_tRecordMatching_2);
								bMatch_tRecordMatching_2 = bPMatch_tRecordMatching_2 = true;
								if (ACCEPTABLE_THRESHOLD_tRecordMatching_2 <= matchingProba_tRecordMatching_2) {
									bPMatch_tRecordMatching_2 = false;
								} else if (UNACCEPTABLE_THRESHOLD_tRecordMatching_2 < matchingProba_tRecordMatching_2
										&& matchingProba_tRecordMatching_2 < ACCEPTABLE_THRESHOLD_tRecordMatching_2) {
									bMatch_tRecordMatching_2 = false;
								} else if (matchingProba_tRecordMatching_2 <= UNACCEPTABLE_THRESHOLD_tRecordMatching_2) {
									bMatch_tRecordMatching_2 = bPMatch_tRecordMatching_2 = false;
								}

								if (bMatch_tRecordMatching_2 || bPMatch_tRecordMatching_2) {
									StringBuffer sb_tRecordMatching_2 = new StringBuffer(10);
									for (double v_tRecordMatching_2 : recordMatcher_tRecordMatching_2
											.getCurrentAttributeMatchingWeights())
										sb_tRecordMatching_2.append(Double.toString(v_tRecordMatching_2)).append("|");
									sb_tRecordMatching_2.deleteCharAt(sb_tRecordMatching_2.length() - 1);
									sMatchingDists_tRecordMatching_2 = new String(sb_tRecordMatching_2);
								}

								// save current match or possible match row for output
								if (bMatch_tRecordMatching_2) {
									// note: no additional condition needed for last match strategy
									/* save the match row of lookup flow */
									savedMatchRow_Target = new TargetStruct();
									savedMatchRow_Target.TargetFirstName = currentLookupRow_Target.TargetFirstName;
									savedMatchRow_Target.TargetLastName = currentLookupRow_Target.TargetLastName;
									savedMatchRow_Target.TargetGender = currentLookupRow_Target.TargetGender;
									savedMatchRow_Target.TargetPatientAddress = currentLookupRow_Target.TargetPatientAddress;
									savedMatchRow_Target.TargetCity = currentLookupRow_Target.TargetCity;
									savedMatchRow_Target.TargetState = currentLookupRow_Target.TargetState;
									savedMatchRow_Target.TargetPostalCode = currentLookupRow_Target.TargetPostalCode;
									savedMatchRow_Target.TargetBirthday = currentLookupRow_Target.TargetBirthday;
									savedMatchRow_Target.TargetSSN = currentLookupRow_Target.TargetSSN;
									savedMatchRow_Target.TargetHPLNID = currentLookupRow_Target.TargetHPLNID;
									savedMatchRow_Target.TargetNYSIISFirstName = currentLookupRow_Target.TargetNYSIISFirstName;
									savedMatchRow_Target.TargetNYSIISLastName = currentLookupRow_Target.TargetNYSIISLastName;
									savedMatchRow_Target.TargetHealthPlanID = currentLookupRow_Target.TargetHealthPlanID;
									savedMatchRow_Target.TargetMRN = currentLookupRow_Target.TargetMRN;
									savedMatchRow_Target.SSNBlockingKey = currentLookupRow_Target.SSNBlockingKey;
									savedMatchRow_Target.FNDOBBlockingKey = currentLookupRow_Target.FNDOBBlockingKey;
									savedMatchRow_Target.LNPCBlockingKey = currentLookupRow_Target.LNPCBlockingKey;
									savedMatchRow_Target.NYSIISFNLNBlockingKey = currentLookupRow_Target.NYSIISFNLNBlockingKey;
									savedMatchRow_Target.DOBPCBlockingKey = currentLookupRow_Target.DOBPCBlockingKey;
									savedMatchRow_Target.MRNBlockingKey = currentLookupRow_Target.MRNBlockingKey;
									savedMatchRow_Target.HealthPlanIDBlockingKey = currentLookupRow_Target.HealthPlanIDBlockingKey;
									/* save the MATCHING_DISTANCES */
									savedRowDists_tRecordMatching_2 = sMatchingDists_tRecordMatching_2;
									/* save the MATCHING_WEIGHT */
									savedRowProba_tRecordMatching_2 = matchingProba_tRecordMatching_2;
									bHasMatchRec_tRecordMatching_2 = true;
								}

								if (bPMatch_tRecordMatching_2 && !bMatch_tRecordMatching_2) {
									/* save the possible match row of lookup flow */
									savedPMatchRow_Target = new TargetStruct();
									savedPMatchRow_Target.TargetFirstName = currentLookupRow_Target.TargetFirstName;
									savedPMatchRow_Target.TargetLastName = currentLookupRow_Target.TargetLastName;
									savedPMatchRow_Target.TargetGender = currentLookupRow_Target.TargetGender;
									savedPMatchRow_Target.TargetPatientAddress = currentLookupRow_Target.TargetPatientAddress;
									savedPMatchRow_Target.TargetCity = currentLookupRow_Target.TargetCity;
									savedPMatchRow_Target.TargetState = currentLookupRow_Target.TargetState;
									savedPMatchRow_Target.TargetPostalCode = currentLookupRow_Target.TargetPostalCode;
									savedPMatchRow_Target.TargetBirthday = currentLookupRow_Target.TargetBirthday;
									savedPMatchRow_Target.TargetSSN = currentLookupRow_Target.TargetSSN;
									savedPMatchRow_Target.TargetHPLNID = currentLookupRow_Target.TargetHPLNID;
									savedPMatchRow_Target.TargetNYSIISFirstName = currentLookupRow_Target.TargetNYSIISFirstName;
									savedPMatchRow_Target.TargetNYSIISLastName = currentLookupRow_Target.TargetNYSIISLastName;
									savedPMatchRow_Target.TargetHealthPlanID = currentLookupRow_Target.TargetHealthPlanID;
									savedPMatchRow_Target.TargetMRN = currentLookupRow_Target.TargetMRN;
									savedPMatchRow_Target.SSNBlockingKey = currentLookupRow_Target.SSNBlockingKey;
									savedPMatchRow_Target.FNDOBBlockingKey = currentLookupRow_Target.FNDOBBlockingKey;
									savedPMatchRow_Target.LNPCBlockingKey = currentLookupRow_Target.LNPCBlockingKey;
									savedPMatchRow_Target.NYSIISFNLNBlockingKey = currentLookupRow_Target.NYSIISFNLNBlockingKey;
									savedPMatchRow_Target.DOBPCBlockingKey = currentLookupRow_Target.DOBPCBlockingKey;
									savedPMatchRow_Target.MRNBlockingKey = currentLookupRow_Target.MRNBlockingKey;
									savedPMatchRow_Target.HealthPlanIDBlockingKey = currentLookupRow_Target.HealthPlanIDBlockingKey;
									/* save the MATCHING_DISTANCES */
									savedPRowDists_tRecordMatching_2 = sMatchingDists_tRecordMatching_2;
									/* save the MATCHING_WEIGHT */
									savedPRowProba_tRecordMatching_2 = matchingProba_tRecordMatching_2;
									bPHasMatchRec_tRecordMatching_2 = true;
								}
							}
							// } to be suitable for IS_MULTIPLYING_OUTPUTS

							// output matched rows

							// output possibly matched rows
							if (bPMatch_tRecordMatching_2) {
								PossibleMatches = new PossibleMatchesStruct();
								PossibleMatches.FirstName = Source.FirstName;
								PossibleMatches.LastName = Source.LastName;
								PossibleMatches.Gender = Source.Gender;
								PossibleMatches.PatientAddress = Source.PatientAddress;
								PossibleMatches.City = Source.City;
								PossibleMatches.State = Source.State;
								PossibleMatches.PostalCode = Source.PostalCode;
								PossibleMatches.Birthday = Source.Birthday;
								PossibleMatches.SSN = Source.SSN;
								PossibleMatches.HPLNID = Source.HPLNID;
								PossibleMatches.NYSIISFirstName = Source.NYSIISFirstName;
								PossibleMatches.NYSIISLastName = Source.NYSIISLastName;
								PossibleMatches.HealthPlanID = Source.HealthPlanID;
								PossibleMatches.MRN = Source.MRN;
								PossibleMatches.TargetFirstName = currentLookupRow_Target.TargetFirstName;
								PossibleMatches.TargetLastName = currentLookupRow_Target.TargetLastName;
								PossibleMatches.TargetGender = currentLookupRow_Target.TargetGender;
								PossibleMatches.TargetPatientAddress = currentLookupRow_Target.TargetPatientAddress;
								PossibleMatches.TargetCity = currentLookupRow_Target.TargetCity;
								PossibleMatches.TargetState = currentLookupRow_Target.TargetState;
								PossibleMatches.TargetPostalCode = currentLookupRow_Target.TargetPostalCode;
								PossibleMatches.TargetBirthday = currentLookupRow_Target.TargetBirthday;
								PossibleMatches.TargetSSN = currentLookupRow_Target.TargetSSN;
								PossibleMatches.TargetHPLNID = currentLookupRow_Target.TargetHPLNID;
								PossibleMatches.TargetNYSIISFirstName = currentLookupRow_Target.TargetNYSIISFirstName;
								PossibleMatches.TargetNYSIISLastName = currentLookupRow_Target.TargetNYSIISLastName;
								PossibleMatches.TargetHealthPlanID = currentLookupRow_Target.TargetHealthPlanID;
								PossibleMatches.TargetMRN = currentLookupRow_Target.TargetMRN;
								PossibleMatches.SSNBlockingKey = Source.SSNBlockingKey;
								PossibleMatches.FNDOBBlockingKey = Source.FNDOBBlockingKey;
								PossibleMatches.LNPCBlockingKey = Source.LNPCBlockingKey;
								PossibleMatches.NYSIISFNLNBlockingKey = Source.NYSIISFNLNBlockingKey;
								PossibleMatches.DOBPCBlockingKey = Source.DOBPCBlockingKey;
								PossibleMatches.MRNBlockingKey = Source.MRNBlockingKey;
								PossibleMatches.HealthPlanIDBlockingKey = Source.HealthPlanIDBlockingKey;
								PossibleMatches.MATCHING_DISTANCES = sMatchingDists_tRecordMatching_2;
								PossibleMatches.MATCHING_WEIGHT = matchingProba_tRecordMatching_2;
								nb_pMatches_tRecordMatching_2++;
							}

							/*
							 * none matches output, no lookup record or at the end of the loop and no
							 * matches record outputted and no possible matches record outputted
							 */
							if ((forceLoopTarget) || (!tHash_Target.hasNext() && !bHasMatchRec_tRecordMatching_2
									&& !bPHasMatchRec_tRecordMatching_2)) {
								forceLoopTarget = false;
								nb_nMatches_tRecordMatching_2++;
							}

							tos_count_tRecordMatching_2++;

							/**
							 * [tRecordMatching_2 main ] stop
							 */

							/**
							 * [tRecordMatching_2 process_data_begin ] start
							 */

							s(currentComponent = "tRecordMatching_2");

							cLabel = "<b>Matching Records</b>";

							/**
							 * [tRecordMatching_2 process_data_begin ] stop
							 */

// Start of branch "PossibleMatches"
							if (PossibleMatches != null) {

								/**
								 * [tMap_3 main ] start
								 */

								s(currentComponent = "tMap_3");

								cLabel = "<b>Mapping</b>";

								if (runStat.update(execStat, enableLogStash, iterateId, 1, 1

										, "PossibleMatches", "tRecordMatching_2", "<b>Matching Records</b>",
										"tRecordMatching", "tMap_3", "<b>Mapping</b>", "tMap"

								)) {
									talendJobLogProcess(globalMap);
								}

								if (log.isTraceEnabled()) {
									log.trace("PossibleMatches - "
											+ (PossibleMatches == null ? "" : PossibleMatches.toLogString()));
								}

								boolean hasCasePrimitiveKeyWithNull_tMap_3 = false;

								// ###############################
								// # Input tables (lookups)

								boolean rejectedInnerJoin_tMap_3 = false;
								boolean mainRowRejected_tMap_3 = false;
								// ###############################
								{ // start of Var scope

									// ###############################
									// # Vars tables

									Var__tMap_3__Struct Var = Var__tMap_3;// ###############################
									// ###############################
									// # Output tables

									PossibleMatchesOutput = null;

// # Output table : 'PossibleMatchesOutput'
									count_PossibleMatchesOutput_tMap_3++;

									PossibleMatchesOutput_tmp.FirstName = PossibleMatches.FirstName;
									PossibleMatchesOutput_tmp.LastName = PossibleMatches.LastName;
									PossibleMatchesOutput_tmp.Gender = PossibleMatches.Gender;
									PossibleMatchesOutput_tmp.PatientAddress = PossibleMatches.PatientAddress;
									PossibleMatchesOutput_tmp.City = PossibleMatches.City;
									PossibleMatchesOutput_tmp.State = PossibleMatches.State;
									PossibleMatchesOutput_tmp.PostalCode = PossibleMatches.PostalCode;
									PossibleMatchesOutput_tmp.Birthday = PossibleMatches.Birthday;
									PossibleMatchesOutput_tmp.SSN = PossibleMatches.SSN;
									PossibleMatchesOutput_tmp.HPLNID = PossibleMatches.HPLNID;
									PossibleMatchesOutput_tmp.NYSIISFirstName = PossibleMatches.NYSIISFirstName;
									PossibleMatchesOutput_tmp.NYSIISLastName = PossibleMatches.NYSIISLastName;
									PossibleMatchesOutput_tmp.HealthPlanID = PossibleMatches.HealthPlanID;
									PossibleMatchesOutput_tmp.MRN = PossibleMatches.MRN;
									PossibleMatchesOutput_tmp.TargetFirstName = PossibleMatches.TargetFirstName;
									PossibleMatchesOutput_tmp.TargetLastName = PossibleMatches.TargetLastName;
									PossibleMatchesOutput_tmp.TargetGender = PossibleMatches.TargetGender;
									PossibleMatchesOutput_tmp.TargetPatientAddress = PossibleMatches.TargetPatientAddress;
									PossibleMatchesOutput_tmp.TargetCity = PossibleMatches.TargetCity;
									PossibleMatchesOutput_tmp.TargetState = PossibleMatches.TargetState;
									PossibleMatchesOutput_tmp.TargetPostalCode = PossibleMatches.TargetPostalCode;
									PossibleMatchesOutput_tmp.TargetBirthday = PossibleMatches.TargetBirthday;
									PossibleMatchesOutput_tmp.TargetSSN = PossibleMatches.TargetSSN;
									PossibleMatchesOutput_tmp.TargetHPLNID = PossibleMatches.TargetHPLNID;
									PossibleMatchesOutput_tmp.TargetNYSIISFirstName = PossibleMatches.TargetNYSIISFirstName;
									PossibleMatchesOutput_tmp.TargetNYSIISLastName = PossibleMatches.TargetNYSIISLastName;
									PossibleMatchesOutput_tmp.TargetHealthPlanID = PossibleMatches.TargetHealthPlanID;
									PossibleMatchesOutput_tmp.TargetMRN = PossibleMatches.TargetMRN;
									PossibleMatchesOutput_tmp.MATCHINGDISTANCES = PossibleMatches.MATCHING_DISTANCES;
									PossibleMatchesOutput_tmp.MATCHINGWEIGHT = PossibleMatches.MATCHING_WEIGHT;
									PossibleMatchesOutput_tmp.SSNBlockingKey = PossibleMatches.SSNBlockingKey;
									PossibleMatchesOutput_tmp.FNDOBBlockingKey = PossibleMatches.FNDOBBlockingKey;
									PossibleMatchesOutput_tmp.LNPCBlockingKey = PossibleMatches.LNPCBlockingKey;
									PossibleMatchesOutput_tmp.NYSIISFNLNBlockingKey = PossibleMatches.NYSIISFNLNBlockingKey;
									PossibleMatchesOutput_tmp.DOBPCBlockingKey = PossibleMatches.DOBPCBlockingKey;
									PossibleMatchesOutput_tmp.MRNBlockingKey = PossibleMatches.MRNBlockingKey;
									PossibleMatchesOutput_tmp.HealthPlanIDBlockingKey = PossibleMatches.HealthPlanIDBlockingKey;
									PossibleMatchesOutput = PossibleMatchesOutput_tmp;
									log.debug("tMap_3 - Outputting the record " + count_PossibleMatchesOutput_tMap_3
											+ " of the output table 'PossibleMatchesOutput'.");

// ###############################

								} // end of Var scope

								rejectedInnerJoin_tMap_3 = false;

								tos_count_tMap_3++;

								/**
								 * [tMap_3 main ] stop
								 */

								/**
								 * [tMap_3 process_data_begin ] start
								 */

								s(currentComponent = "tMap_3");

								cLabel = "<b>Mapping</b>";

								/**
								 * [tMap_3 process_data_begin ] stop
								 */

// Start of branch "PossibleMatchesOutput"
								if (PossibleMatchesOutput != null) {

									/**
									 * [tLogRow_2 main ] start
									 */

									s(currentComponent = "tLogRow_2");

									cLabel = "<b>Matches Distances</b>";

									if (runStat.update(execStat, enableLogStash, iterateId, 1, 1

											, "PossibleMatchesOutput", "tMap_3", "<b>Mapping</b>", "tMap", "tLogRow_2",
											"<b>Matches Distances</b>", "tLogRow"

									)) {
										talendJobLogProcess(globalMap);
									}

									if (log.isTraceEnabled()) {
										log.trace("PossibleMatchesOutput - " + (PossibleMatchesOutput == null ? ""
												: PossibleMatchesOutput.toLogString()));
									}

///////////////////////		

									String[] row_tLogRow_2 = new String[37];

									if (PossibleMatchesOutput.FirstName != null) { //
										row_tLogRow_2[0] = String.valueOf(PossibleMatchesOutput.FirstName);

									} //

									if (PossibleMatchesOutput.LastName != null) { //
										row_tLogRow_2[1] = String.valueOf(PossibleMatchesOutput.LastName);

									} //

									if (PossibleMatchesOutput.Gender != null) { //
										row_tLogRow_2[2] = String.valueOf(PossibleMatchesOutput.Gender);

									} //

									if (PossibleMatchesOutput.PatientAddress != null) { //
										row_tLogRow_2[3] = String.valueOf(PossibleMatchesOutput.PatientAddress);

									} //

									if (PossibleMatchesOutput.City != null) { //
										row_tLogRow_2[4] = String.valueOf(PossibleMatchesOutput.City);

									} //

									if (PossibleMatchesOutput.State != null) { //
										row_tLogRow_2[5] = String.valueOf(PossibleMatchesOutput.State);

									} //

									if (PossibleMatchesOutput.PostalCode != null) { //
										row_tLogRow_2[6] = String.valueOf(PossibleMatchesOutput.PostalCode);

									} //

									if (PossibleMatchesOutput.Birthday != null) { //
										row_tLogRow_2[7] = FormatterUtils.format_Date(PossibleMatchesOutput.Birthday,
												"yyyy-MM-dd");

									} //

									if (PossibleMatchesOutput.SSN != null) { //
										row_tLogRow_2[8] = String.valueOf(PossibleMatchesOutput.SSN);

									} //

									if (PossibleMatchesOutput.HPLNID != null) { //
										row_tLogRow_2[9] = String.valueOf(PossibleMatchesOutput.HPLNID);

									} //

									if (PossibleMatchesOutput.NYSIISFirstName != null) { //
										row_tLogRow_2[10] = String.valueOf(PossibleMatchesOutput.NYSIISFirstName);

									} //

									if (PossibleMatchesOutput.NYSIISLastName != null) { //
										row_tLogRow_2[11] = String.valueOf(PossibleMatchesOutput.NYSIISLastName);

									} //

									if (PossibleMatchesOutput.HealthPlanID != null) { //
										row_tLogRow_2[12] = String.valueOf(PossibleMatchesOutput.HealthPlanID);

									} //

									if (PossibleMatchesOutput.MRN != null) { //
										row_tLogRow_2[13] = String.valueOf(PossibleMatchesOutput.MRN);

									} //

									if (PossibleMatchesOutput.TargetFirstName != null) { //
										row_tLogRow_2[14] = String.valueOf(PossibleMatchesOutput.TargetFirstName);

									} //

									if (PossibleMatchesOutput.TargetLastName != null) { //
										row_tLogRow_2[15] = String.valueOf(PossibleMatchesOutput.TargetLastName);

									} //

									if (PossibleMatchesOutput.TargetGender != null) { //
										row_tLogRow_2[16] = String.valueOf(PossibleMatchesOutput.TargetGender);

									} //

									if (PossibleMatchesOutput.TargetPatientAddress != null) { //
										row_tLogRow_2[17] = String.valueOf(PossibleMatchesOutput.TargetPatientAddress);

									} //

									if (PossibleMatchesOutput.TargetCity != null) { //
										row_tLogRow_2[18] = String.valueOf(PossibleMatchesOutput.TargetCity);

									} //

									if (PossibleMatchesOutput.TargetState != null) { //
										row_tLogRow_2[19] = String.valueOf(PossibleMatchesOutput.TargetState);

									} //

									if (PossibleMatchesOutput.TargetPostalCode != null) { //
										row_tLogRow_2[20] = String.valueOf(PossibleMatchesOutput.TargetPostalCode);

									} //

									if (PossibleMatchesOutput.TargetBirthday != null) { //
										row_tLogRow_2[21] = FormatterUtils
												.format_Date(PossibleMatchesOutput.TargetBirthday, "MM/dd/yyyy");

									} //

									if (PossibleMatchesOutput.TargetSSN != null) { //
										row_tLogRow_2[22] = String.valueOf(PossibleMatchesOutput.TargetSSN);

									} //

									if (PossibleMatchesOutput.TargetHPLNID != null) { //
										row_tLogRow_2[23] = String.valueOf(PossibleMatchesOutput.TargetHPLNID);

									} //

									if (PossibleMatchesOutput.TargetNYSIISFirstName != null) { //
										row_tLogRow_2[24] = String.valueOf(PossibleMatchesOutput.TargetNYSIISFirstName);

									} //

									if (PossibleMatchesOutput.TargetNYSIISLastName != null) { //
										row_tLogRow_2[25] = String.valueOf(PossibleMatchesOutput.TargetNYSIISLastName);

									} //

									if (PossibleMatchesOutput.TargetHealthPlanID != null) { //
										row_tLogRow_2[26] = String.valueOf(PossibleMatchesOutput.TargetHealthPlanID);

									} //

									if (PossibleMatchesOutput.TargetMRN != null) { //
										row_tLogRow_2[27] = String.valueOf(PossibleMatchesOutput.TargetMRN);

									} //

									if (PossibleMatchesOutput.MATCHINGDISTANCES != null) { //
										row_tLogRow_2[28] = String.valueOf(PossibleMatchesOutput.MATCHINGDISTANCES);

									} //

									if (PossibleMatchesOutput.MATCHINGWEIGHT != null) { //
										row_tLogRow_2[29] = FormatterUtils
												.formatUnwithE(PossibleMatchesOutput.MATCHINGWEIGHT);

									} //

									if (PossibleMatchesOutput.SSNBlockingKey != null) { //
										row_tLogRow_2[30] = String.valueOf(PossibleMatchesOutput.SSNBlockingKey);

									} //

									if (PossibleMatchesOutput.FNDOBBlockingKey != null) { //
										row_tLogRow_2[31] = String.valueOf(PossibleMatchesOutput.FNDOBBlockingKey);

									} //

									if (PossibleMatchesOutput.LNPCBlockingKey != null) { //
										row_tLogRow_2[32] = String.valueOf(PossibleMatchesOutput.LNPCBlockingKey);

									} //

									if (PossibleMatchesOutput.NYSIISFNLNBlockingKey != null) { //
										row_tLogRow_2[33] = String.valueOf(PossibleMatchesOutput.NYSIISFNLNBlockingKey);

									} //

									if (PossibleMatchesOutput.DOBPCBlockingKey != null) { //
										row_tLogRow_2[34] = String.valueOf(PossibleMatchesOutput.DOBPCBlockingKey);

									} //

									if (PossibleMatchesOutput.MRNBlockingKey != null) { //
										row_tLogRow_2[35] = String.valueOf(PossibleMatchesOutput.MRNBlockingKey);

									} //

									if (PossibleMatchesOutput.HealthPlanIDBlockingKey != null) { //
										row_tLogRow_2[36] = String
												.valueOf(PossibleMatchesOutput.HealthPlanIDBlockingKey);

									} //

									util_tLogRow_2.addRow(row_tLogRow_2);
									nb_line_tLogRow_2++;
									log.info("tLogRow_2 - Content of row " + nb_line_tLogRow_2 + ": "
											+ TalendString.unionString("|", row_tLogRow_2));
//////

//////                    

///////////////////////    			

									tos_count_tLogRow_2++;

									/**
									 * [tLogRow_2 main ] stop
									 */

									/**
									 * [tLogRow_2 process_data_begin ] start
									 */

									s(currentComponent = "tLogRow_2");

									cLabel = "<b>Matches Distances</b>";

									/**
									 * [tLogRow_2 process_data_begin ] stop
									 */

									/**
									 * [tLogRow_2 process_data_end ] start
									 */

									s(currentComponent = "tLogRow_2");

									cLabel = "<b>Matches Distances</b>";

									/**
									 * [tLogRow_2 process_data_end ] stop
									 */

								} // End of branch "PossibleMatchesOutput"

								/**
								 * [tMap_3 process_data_end ] start
								 */

								s(currentComponent = "tMap_3");

								cLabel = "<b>Mapping</b>";

								/**
								 * [tMap_3 process_data_end ] stop
								 */

							} // End of branch "PossibleMatches"

							// end for
						}

						/**
						 * [tRecordMatching_2 process_data_end ] start
						 */

						s(currentComponent = "tRecordMatching_2");

						cLabel = "<b>Matching Records</b>";

						/**
						 * [tRecordMatching_2 process_data_end ] stop
						 */

						/**
						 * [tDBInput_3 process_data_end ] start
						 */

						s(currentComponent = "tDBInput_3");

						cLabel = "<b>Data Sources</b>";

						/**
						 * [tDBInput_3 process_data_end ] stop
						 */

						/**
						 * [tDBInput_3 end ] start
						 */

						s(currentComponent = "tDBInput_3");

						cLabel = "<b>Data Sources</b>";

					}
				} finally {
					if (rs_tDBInput_3 != null) {
						rs_tDBInput_3.close();
					}
					if (stmt_tDBInput_3 != null) {
						stmt_tDBInput_3.close();
					}
					if (conn_tDBInput_3 != null && !conn_tDBInput_3.isClosed()) {

						log.debug("tDBInput_3 - Closing the connection to the database.");

						conn_tDBInput_3.close();

						if ("com.mysql.cj.jdbc.Driver".equals((String) globalMap.get("driverClass_"))
								&& routines.system.BundleUtils.inOSGi()) {
							Class.forName("com.mysql.cj.jdbc.AbandonedConnectionCleanupThread")
									.getMethod("checkedShutdown").invoke(null, (Object[]) null);
						}

						log.debug("tDBInput_3 - Connection to the database closed.");

					}

				}
				globalMap.put("tDBInput_3_NB_LINE", nb_line_tDBInput_3);
				log.debug("tDBInput_3 - Retrieved records count: " + nb_line_tDBInput_3 + " .");

				if (log.isDebugEnabled())
					log.debug("tDBInput_3 - " + ("Done."));

				ok_Hash.put("tDBInput_3", true);
				end_Hash.put("tDBInput_3", System.currentTimeMillis());

				/**
				 * [tDBInput_3 end ] stop
				 */

				/**
				 * [tRecordMatching_2 end ] start
				 */

				s(currentComponent = "tRecordMatching_2");

				cLabel = "<b>Matching Records</b>";

				globalMap.put("tRecordMatching_2_NB_MATCH_LINE", nb_matches_tRecordMatching_2);
				globalMap.put("tRecordMatching_2_NB_POSSIBLE_MATCH_LINE", nb_pMatches_tRecordMatching_2);
				globalMap.put("tRecordMatching_2_NB_NONE_MATCH_LINE", nb_nMatches_tRecordMatching_2);
				if (runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, "Source", 2, 0,
						"tDBInput_3", "<b>Data Sources</b>", "tMysqlInput", "tRecordMatching_2",
						"<b>Matching Records</b>", "tRecordMatching", "output")) {
					talendJobLogProcess(globalMap);
				}

				if (log.isDebugEnabled())
					log.debug("tRecordMatching_2 - " + ("Done."));

				ok_Hash.put("tRecordMatching_2", true);
				end_Hash.put("tRecordMatching_2", System.currentTimeMillis());

				/**
				 * [tRecordMatching_2 end ] stop
				 */

				/**
				 * [tMap_3 end ] start
				 */

				s(currentComponent = "tMap_3");

				cLabel = "<b>Mapping</b>";

// ###############################
// # Lookup hashes releasing
// ###############################      
				log.debug("tMap_3 - Written records count in the table 'PossibleMatchesOutput': "
						+ count_PossibleMatchesOutput_tMap_3 + ".");

				if (runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, "PossibleMatches", 2, 0,
						"tRecordMatching_2", "<b>Matching Records</b>", "tRecordMatching", "tMap_3", "<b>Mapping</b>",
						"tMap", "output")) {
					talendJobLogProcess(globalMap);
				}

				if (log.isDebugEnabled())
					log.debug("tMap_3 - " + ("Done."));

				ok_Hash.put("tMap_3", true);
				end_Hash.put("tMap_3", System.currentTimeMillis());

				/**
				 * [tMap_3 end ] stop
				 */

				/**
				 * [tLogRow_2 end ] start
				 */

				s(currentComponent = "tLogRow_2");

				cLabel = "<b>Matches Distances</b>";

//////

				java.io.PrintStream consoleOut_tLogRow_2 = null;
				if (globalMap.get("tLogRow_CONSOLE") != null) {
					consoleOut_tLogRow_2 = (java.io.PrintStream) globalMap.get("tLogRow_CONSOLE");
				} else {
					consoleOut_tLogRow_2 = new java.io.PrintStream(new java.io.BufferedOutputStream(System.out));
					globalMap.put("tLogRow_CONSOLE", consoleOut_tLogRow_2);
				}

				consoleOut_tLogRow_2.println(util_tLogRow_2.format().toString());
				consoleOut_tLogRow_2.flush();
//////
				globalMap.put("tLogRow_2_NB_LINE", nb_line_tLogRow_2);
				if (log.isInfoEnabled())
					log.info("tLogRow_2 - " + ("Printed row count: ") + (nb_line_tLogRow_2) + ("."));

///////////////////////    			

				if (runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, "PossibleMatchesOutput",
						2, 0, "tMap_3", "<b>Mapping</b>", "tMap", "tLogRow_2", "<b>Matches Distances</b>", "tLogRow",
						"output")) {
					talendJobLogProcess(globalMap);
				}

				if (log.isDebugEnabled())
					log.debug("tLogRow_2 - " + ("Done."));

				ok_Hash.put("tLogRow_2", true);
				end_Hash.put("tLogRow_2", System.currentTimeMillis());

				/**
				 * [tLogRow_2 end ] stop
				 */

			} // end the resume

		} catch (java.lang.Exception e) {

			if (!(e instanceof TalendException)) {
				log.fatal(currentComponent + " " + e.getMessage(), e);
			}

			TalendException te = new TalendException(e, currentComponent, cLabel, globalMap);

			throw te;
		} catch (java.lang.Error error) {

			runStat.stopThreadStat();

			throw error;
		} finally {

			// free memory for "tRecordMatching_2"
			globalMap.remove("tHash_Target");

			try {

				/**
				 * [tDBInput_3 finally ] start
				 */

				s(currentComponent = "tDBInput_3");

				cLabel = "<b>Data Sources</b>";

				/**
				 * [tDBInput_3 finally ] stop
				 */

				/**
				 * [tRecordMatching_2 finally ] start
				 */

				s(currentComponent = "tRecordMatching_2");

				cLabel = "<b>Matching Records</b>";

				/**
				 * [tRecordMatching_2 finally ] stop
				 */

				/**
				 * [tMap_3 finally ] start
				 */

				s(currentComponent = "tMap_3");

				cLabel = "<b>Mapping</b>";

				/**
				 * [tMap_3 finally ] stop
				 */

				/**
				 * [tLogRow_2 finally ] start
				 */

				s(currentComponent = "tLogRow_2");

				cLabel = "<b>Matches Distances</b>";

				/**
				 * [tLogRow_2 finally ] stop
				 */

			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tDBInput_3_SUBPROCESS_STATE", 1);
	}

	public static class TargetStruct implements routines.system.IPersistableComparableLookupRow<TargetStruct> {
		final static byte[] commonByteArrayLock_TALENDCLOUDDEMOBANK_CHIA_Matching_Distances_2 = new byte[0];
		static byte[] commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Matching_Distances_2 = new byte[0];
		protected static final int DEFAULT_HASHCODE = 1;
		protected static final int PRIME = 31;
		protected int hashCode = DEFAULT_HASHCODE;
		public boolean hashCodeDirty = true;

		public String loopKey;

		public String TargetFirstName;

		public String getTargetFirstName() {
			return this.TargetFirstName;
		}

		public Boolean TargetFirstNameIsNullable() {
			return true;
		}

		public Boolean TargetFirstNameIsKey() {
			return false;
		}

		public Integer TargetFirstNameLength() {
			return 16;
		}

		public Integer TargetFirstNamePrecision() {
			return 0;
		}

		public String TargetFirstNameDefault() {

			return null;

		}

		public String TargetFirstNameComment() {

			return "";

		}

		public String TargetFirstNamePattern() {

			return "";

		}

		public String TargetFirstNameOriginalDbColumnName() {

			return "TargetFirstName";

		}

		public String TargetLastName;

		public String getTargetLastName() {
			return this.TargetLastName;
		}

		public Boolean TargetLastNameIsNullable() {
			return true;
		}

		public Boolean TargetLastNameIsKey() {
			return false;
		}

		public Integer TargetLastNameLength() {
			return 10;
		}

		public Integer TargetLastNamePrecision() {
			return 0;
		}

		public String TargetLastNameDefault() {

			return null;

		}

		public String TargetLastNameComment() {

			return "";

		}

		public String TargetLastNamePattern() {

			return "";

		}

		public String TargetLastNameOriginalDbColumnName() {

			return "TargetLastName";

		}

		public String TargetGender;

		public String getTargetGender() {
			return this.TargetGender;
		}

		public Boolean TargetGenderIsNullable() {
			return true;
		}

		public Boolean TargetGenderIsKey() {
			return false;
		}

		public Integer TargetGenderLength() {
			return 6;
		}

		public Integer TargetGenderPrecision() {
			return 0;
		}

		public String TargetGenderDefault() {

			return null;

		}

		public String TargetGenderComment() {

			return "";

		}

		public String TargetGenderPattern() {

			return "";

		}

		public String TargetGenderOriginalDbColumnName() {

			return "TargetGender";

		}

		public String TargetPatientAddress;

		public String getTargetPatientAddress() {
			return this.TargetPatientAddress;
		}

		public Boolean TargetPatientAddressIsNullable() {
			return true;
		}

		public Boolean TargetPatientAddressIsKey() {
			return false;
		}

		public Integer TargetPatientAddressLength() {
			return 38;
		}

		public Integer TargetPatientAddressPrecision() {
			return 0;
		}

		public String TargetPatientAddressDefault() {

			return null;

		}

		public String TargetPatientAddressComment() {

			return "";

		}

		public String TargetPatientAddressPattern() {

			return "";

		}

		public String TargetPatientAddressOriginalDbColumnName() {

			return "TargetPatientAddress";

		}

		public String TargetCity;

		public String getTargetCity() {
			return this.TargetCity;
		}

		public Boolean TargetCityIsNullable() {
			return true;
		}

		public Boolean TargetCityIsKey() {
			return false;
		}

		public Integer TargetCityLength() {
			return 14;
		}

		public Integer TargetCityPrecision() {
			return 0;
		}

		public String TargetCityDefault() {

			return null;

		}

		public String TargetCityComment() {

			return "";

		}

		public String TargetCityPattern() {

			return "";

		}

		public String TargetCityOriginalDbColumnName() {

			return "TargetCity";

		}

		public String TargetState;

		public String getTargetState() {
			return this.TargetState;
		}

		public Boolean TargetStateIsNullable() {
			return true;
		}

		public Boolean TargetStateIsKey() {
			return false;
		}

		public Integer TargetStateLength() {
			return 2;
		}

		public Integer TargetStatePrecision() {
			return 0;
		}

		public String TargetStateDefault() {

			return null;

		}

		public String TargetStateComment() {

			return "";

		}

		public String TargetStatePattern() {

			return "";

		}

		public String TargetStateOriginalDbColumnName() {

			return "TargetState";

		}

		public Integer TargetPostalCode;

		public Integer getTargetPostalCode() {
			return this.TargetPostalCode;
		}

		public Boolean TargetPostalCodeIsNullable() {
			return true;
		}

		public Boolean TargetPostalCodeIsKey() {
			return false;
		}

		public Integer TargetPostalCodeLength() {
			return 10;
		}

		public Integer TargetPostalCodePrecision() {
			return 0;
		}

		public String TargetPostalCodeDefault() {

			return null;

		}

		public String TargetPostalCodeComment() {

			return "";

		}

		public String TargetPostalCodePattern() {

			return "";

		}

		public String TargetPostalCodeOriginalDbColumnName() {

			return "TargetPostalCode";

		}

		public java.util.Date TargetBirthday;

		public java.util.Date getTargetBirthday() {
			return this.TargetBirthday;
		}

		public Boolean TargetBirthdayIsNullable() {
			return true;
		}

		public Boolean TargetBirthdayIsKey() {
			return false;
		}

		public Integer TargetBirthdayLength() {
			return 19;
		}

		public Integer TargetBirthdayPrecision() {
			return 0;
		}

		public String TargetBirthdayDefault() {

			return null;

		}

		public String TargetBirthdayComment() {

			return "";

		}

		public String TargetBirthdayPattern() {

			return "dd-MM-yyyy";

		}

		public String TargetBirthdayOriginalDbColumnName() {

			return "TargetBirthday";

		}

		public String TargetSSN;

		public String getTargetSSN() {
			return this.TargetSSN;
		}

		public Boolean TargetSSNIsNullable() {
			return true;
		}

		public Boolean TargetSSNIsKey() {
			return false;
		}

		public Integer TargetSSNLength() {
			return 11;
		}

		public Integer TargetSSNPrecision() {
			return 0;
		}

		public String TargetSSNDefault() {

			return null;

		}

		public String TargetSSNComment() {

			return "";

		}

		public String TargetSSNPattern() {

			return "";

		}

		public String TargetSSNOriginalDbColumnName() {

			return "TargetSSN";

		}

		public Integer TargetHPLNID;

		public Integer getTargetHPLNID() {
			return this.TargetHPLNID;
		}

		public Boolean TargetHPLNIDIsNullable() {
			return true;
		}

		public Boolean TargetHPLNIDIsKey() {
			return false;
		}

		public Integer TargetHPLNIDLength() {
			return 10;
		}

		public Integer TargetHPLNIDPrecision() {
			return 0;
		}

		public String TargetHPLNIDDefault() {

			return null;

		}

		public String TargetHPLNIDComment() {

			return "";

		}

		public String TargetHPLNIDPattern() {

			return "";

		}

		public String TargetHPLNIDOriginalDbColumnName() {

			return "TargetHPLNID";

		}

		public String TargetNYSIISFirstName;

		public String getTargetNYSIISFirstName() {
			return this.TargetNYSIISFirstName;
		}

		public Boolean TargetNYSIISFirstNameIsNullable() {
			return true;
		}

		public Boolean TargetNYSIISFirstNameIsKey() {
			return false;
		}

		public Integer TargetNYSIISFirstNameLength() {
			return 16;
		}

		public Integer TargetNYSIISFirstNamePrecision() {
			return 0;
		}

		public String TargetNYSIISFirstNameDefault() {

			return null;

		}

		public String TargetNYSIISFirstNameComment() {

			return "";

		}

		public String TargetNYSIISFirstNamePattern() {

			return "";

		}

		public String TargetNYSIISFirstNameOriginalDbColumnName() {

			return "TargetNYSIISFirstName";

		}

		public String TargetNYSIISLastName;

		public String getTargetNYSIISLastName() {
			return this.TargetNYSIISLastName;
		}

		public Boolean TargetNYSIISLastNameIsNullable() {
			return true;
		}

		public Boolean TargetNYSIISLastNameIsKey() {
			return false;
		}

		public Integer TargetNYSIISLastNameLength() {
			return 10;
		}

		public Integer TargetNYSIISLastNamePrecision() {
			return 0;
		}

		public String TargetNYSIISLastNameDefault() {

			return null;

		}

		public String TargetNYSIISLastNameComment() {

			return "";

		}

		public String TargetNYSIISLastNamePattern() {

			return "";

		}

		public String TargetNYSIISLastNameOriginalDbColumnName() {

			return "TargetNYSIISLastName";

		}

		public String TargetHealthPlanID;

		public String getTargetHealthPlanID() {
			return this.TargetHealthPlanID;
		}

		public Boolean TargetHealthPlanIDIsNullable() {
			return true;
		}

		public Boolean TargetHealthPlanIDIsKey() {
			return false;
		}

		public Integer TargetHealthPlanIDLength() {
			return 8;
		}

		public Integer TargetHealthPlanIDPrecision() {
			return 0;
		}

		public String TargetHealthPlanIDDefault() {

			return null;

		}

		public String TargetHealthPlanIDComment() {

			return "";

		}

		public String TargetHealthPlanIDPattern() {

			return "";

		}

		public String TargetHealthPlanIDOriginalDbColumnName() {

			return "TargetHealthPlanID";

		}

		public Integer TargetMRN;

		public Integer getTargetMRN() {
			return this.TargetMRN;
		}

		public Boolean TargetMRNIsNullable() {
			return true;
		}

		public Boolean TargetMRNIsKey() {
			return false;
		}

		public Integer TargetMRNLength() {
			return 10;
		}

		public Integer TargetMRNPrecision() {
			return 0;
		}

		public String TargetMRNDefault() {

			return null;

		}

		public String TargetMRNComment() {

			return "";

		}

		public String TargetMRNPattern() {

			return "";

		}

		public String TargetMRNOriginalDbColumnName() {

			return "TargetMRN";

		}

		public String SSNBlockingKey;

		public String getSSNBlockingKey() {
			return this.SSNBlockingKey;
		}

		public Boolean SSNBlockingKeyIsNullable() {
			return true;
		}

		public Boolean SSNBlockingKeyIsKey() {
			return false;
		}

		public Integer SSNBlockingKeyLength() {
			return 20;
		}

		public Integer SSNBlockingKeyPrecision() {
			return 0;
		}

		public String SSNBlockingKeyDefault() {

			return null;

		}

		public String SSNBlockingKeyComment() {

			return "";

		}

		public String SSNBlockingKeyPattern() {

			return "";

		}

		public String SSNBlockingKeyOriginalDbColumnName() {

			return "SSNBlockingKey";

		}

		public String FNDOBBlockingKey;

		public String getFNDOBBlockingKey() {
			return this.FNDOBBlockingKey;
		}

		public Boolean FNDOBBlockingKeyIsNullable() {
			return true;
		}

		public Boolean FNDOBBlockingKeyIsKey() {
			return false;
		}

		public Integer FNDOBBlockingKeyLength() {
			return 25;
		}

		public Integer FNDOBBlockingKeyPrecision() {
			return 0;
		}

		public String FNDOBBlockingKeyDefault() {

			return null;

		}

		public String FNDOBBlockingKeyComment() {

			return "";

		}

		public String FNDOBBlockingKeyPattern() {

			return "";

		}

		public String FNDOBBlockingKeyOriginalDbColumnName() {

			return "FNDOBBlockingKey";

		}

		public String LNPCBlockingKey;

		public String getLNPCBlockingKey() {
			return this.LNPCBlockingKey;
		}

		public Boolean LNPCBlockingKeyIsNullable() {
			return true;
		}

		public Boolean LNPCBlockingKeyIsKey() {
			return false;
		}

		public Integer LNPCBlockingKeyLength() {
			return 20;
		}

		public Integer LNPCBlockingKeyPrecision() {
			return 0;
		}

		public String LNPCBlockingKeyDefault() {

			return null;

		}

		public String LNPCBlockingKeyComment() {

			return "";

		}

		public String LNPCBlockingKeyPattern() {

			return "";

		}

		public String LNPCBlockingKeyOriginalDbColumnName() {

			return "LNPCBlockingKey";

		}

		public String NYSIISFNLNBlockingKey;

		public String getNYSIISFNLNBlockingKey() {
			return this.NYSIISFNLNBlockingKey;
		}

		public Boolean NYSIISFNLNBlockingKeyIsNullable() {
			return true;
		}

		public Boolean NYSIISFNLNBlockingKeyIsKey() {
			return false;
		}

		public Integer NYSIISFNLNBlockingKeyLength() {
			return 20;
		}

		public Integer NYSIISFNLNBlockingKeyPrecision() {
			return 0;
		}

		public String NYSIISFNLNBlockingKeyDefault() {

			return null;

		}

		public String NYSIISFNLNBlockingKeyComment() {

			return "";

		}

		public String NYSIISFNLNBlockingKeyPattern() {

			return "";

		}

		public String NYSIISFNLNBlockingKeyOriginalDbColumnName() {

			return "NYSIISFNLNBlockingKey";

		}

		public String DOBPCBlockingKey;

		public String getDOBPCBlockingKey() {
			return this.DOBPCBlockingKey;
		}

		public Boolean DOBPCBlockingKeyIsNullable() {
			return true;
		}

		public Boolean DOBPCBlockingKeyIsKey() {
			return false;
		}

		public Integer DOBPCBlockingKeyLength() {
			return 20;
		}

		public Integer DOBPCBlockingKeyPrecision() {
			return 0;
		}

		public String DOBPCBlockingKeyDefault() {

			return null;

		}

		public String DOBPCBlockingKeyComment() {

			return "";

		}

		public String DOBPCBlockingKeyPattern() {

			return "";

		}

		public String DOBPCBlockingKeyOriginalDbColumnName() {

			return "DOBPCBlockingKey";

		}

		public String MRNBlockingKey;

		public String getMRNBlockingKey() {
			return this.MRNBlockingKey;
		}

		public Boolean MRNBlockingKeyIsNullable() {
			return true;
		}

		public Boolean MRNBlockingKeyIsKey() {
			return false;
		}

		public Integer MRNBlockingKeyLength() {
			return 20;
		}

		public Integer MRNBlockingKeyPrecision() {
			return 0;
		}

		public String MRNBlockingKeyDefault() {

			return null;

		}

		public String MRNBlockingKeyComment() {

			return "";

		}

		public String MRNBlockingKeyPattern() {

			return "";

		}

		public String MRNBlockingKeyOriginalDbColumnName() {

			return "MRNBlockingKey";

		}

		public String HealthPlanIDBlockingKey;

		public String getHealthPlanIDBlockingKey() {
			return this.HealthPlanIDBlockingKey;
		}

		public Boolean HealthPlanIDBlockingKeyIsNullable() {
			return true;
		}

		public Boolean HealthPlanIDBlockingKeyIsKey() {
			return false;
		}

		public Integer HealthPlanIDBlockingKeyLength() {
			return 20;
		}

		public Integer HealthPlanIDBlockingKeyPrecision() {
			return 0;
		}

		public String HealthPlanIDBlockingKeyDefault() {

			return null;

		}

		public String HealthPlanIDBlockingKeyComment() {

			return "";

		}

		public String HealthPlanIDBlockingKeyPattern() {

			return "";

		}

		public String HealthPlanIDBlockingKeyOriginalDbColumnName() {

			return "HealthPlanIDBlockingKey";

		}

		@Override
		public int hashCode() {
			if (this.hashCodeDirty) {
				final int prime = PRIME;
				int result = DEFAULT_HASHCODE;

				result = prime * result + ((this.SSNBlockingKey == null) ? 0 : this.SSNBlockingKey.hashCode());

				this.hashCode = result;
				this.hashCodeDirty = false;
			}
			return this.hashCode;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			final TargetStruct other = (TargetStruct) obj;

			if (this.SSNBlockingKey == null) {
				if (other.SSNBlockingKey != null)
					return false;

			} else if (!this.SSNBlockingKey.equals(other.SSNBlockingKey))

				return false;

			return true;
		}

		public void copyDataTo(TargetStruct other) {

			other.TargetFirstName = this.TargetFirstName;
			other.TargetLastName = this.TargetLastName;
			other.TargetGender = this.TargetGender;
			other.TargetPatientAddress = this.TargetPatientAddress;
			other.TargetCity = this.TargetCity;
			other.TargetState = this.TargetState;
			other.TargetPostalCode = this.TargetPostalCode;
			other.TargetBirthday = this.TargetBirthday;
			other.TargetSSN = this.TargetSSN;
			other.TargetHPLNID = this.TargetHPLNID;
			other.TargetNYSIISFirstName = this.TargetNYSIISFirstName;
			other.TargetNYSIISLastName = this.TargetNYSIISLastName;
			other.TargetHealthPlanID = this.TargetHealthPlanID;
			other.TargetMRN = this.TargetMRN;
			other.SSNBlockingKey = this.SSNBlockingKey;
			other.FNDOBBlockingKey = this.FNDOBBlockingKey;
			other.LNPCBlockingKey = this.LNPCBlockingKey;
			other.NYSIISFNLNBlockingKey = this.NYSIISFNLNBlockingKey;
			other.DOBPCBlockingKey = this.DOBPCBlockingKey;
			other.MRNBlockingKey = this.MRNBlockingKey;
			other.HealthPlanIDBlockingKey = this.HealthPlanIDBlockingKey;

		}

		public void copyKeysDataTo(TargetStruct other) {

			other.SSNBlockingKey = this.SSNBlockingKey;

		}

		private String readString(DataInputStream dis, ObjectInputStream ois) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				byte[] byteArray = new byte[length];
				dis.read(byteArray);
				strReturn = new String(byteArray, utf8Charset);
			}
			return strReturn;
		}

		private String readString(DataInputStream dis, org.jboss.marshalling.Unmarshaller unmarshaller)
				throws IOException {
			String strReturn = null;
			int length = 0;
			length = unmarshaller.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				byte[] byteArray = new byte[length];
				unmarshaller.read(byteArray);
				strReturn = new String(byteArray, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, DataOutputStream dos, org.jboss.marshalling.Marshaller marshaller)
				throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		private void writeString(String str, DataOutputStream dos, ObjectOutputStream oos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private Integer readInteger(DataInputStream dis, ObjectInputStream ois) throws IOException {
			Integer intReturn;
			int length = 0;
			length = dis.readByte();
			if (length == -1) {
				intReturn = null;
			} else {
				intReturn = dis.readInt();
			}
			return intReturn;
		}

		private Integer readInteger(DataInputStream dis, org.jboss.marshalling.Unmarshaller unmarshaller)
				throws IOException {
			Integer intReturn;
			int length = 0;
			length = unmarshaller.readByte();
			if (length == -1) {
				intReturn = null;
			} else {
				intReturn = unmarshaller.readInt();
			}
			return intReturn;
		}

		private void writeInteger(Integer intNum, DataOutputStream dos, ObjectOutputStream oos) throws IOException {
			if (intNum == null) {
				dos.writeByte(-1);
			} else {
				dos.writeByte(0);
				dos.writeInt(intNum);
			}
		}

		private void writeInteger(Integer intNum, DataOutputStream dos, org.jboss.marshalling.Marshaller marshaller)
				throws IOException {
			if (intNum == null) {
				marshaller.writeByte(-1);
			} else {
				marshaller.writeByte(0);
				marshaller.writeInt(intNum);
			}
		}

		private java.util.Date readDate(DataInputStream dis, ObjectInputStream ois) throws IOException {
			java.util.Date dateReturn = null;
			int length = 0;
			length = dis.readByte();
			if (length == -1) {
				dateReturn = null;
			} else {
				dateReturn = new Date(dis.readLong());
			}
			return dateReturn;
		}

		private java.util.Date readDate(DataInputStream dis, org.jboss.marshalling.Unmarshaller unmarshaller)
				throws IOException {
			java.util.Date dateReturn = null;
			int length = 0;
			length = unmarshaller.readByte();
			if (length == -1) {
				dateReturn = null;
			} else {
				dateReturn = new Date(unmarshaller.readLong());
			}
			return dateReturn;
		}

		private void writeDate(java.util.Date date1, DataOutputStream dos, ObjectOutputStream oos) throws IOException {
			if (date1 == null) {
				dos.writeByte(-1);
			} else {
				dos.writeByte(0);
				dos.writeLong(date1.getTime());
			}
		}

		private void writeDate(java.util.Date date1, DataOutputStream dos, org.jboss.marshalling.Marshaller marshaller)
				throws IOException {
			if (date1 == null) {
				marshaller.writeByte(-1);
			} else {
				marshaller.writeByte(0);
				marshaller.writeLong(date1.getTime());
			}
		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Matching_Distances_2.length) {
					if (length < 1024 && commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Matching_Distances_2.length == 0) {
						commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Matching_Distances_2 = new byte[1024];
					} else {
						commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Matching_Distances_2 = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Matching_Distances_2, 0, length);
				strReturn = new String(commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Matching_Distances_2, 0, length,
						utf8Charset);
			}
			return strReturn;
		}

		private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException {
			String strReturn = null;
			int length = 0;
			length = unmarshaller.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Matching_Distances_2.length) {
					if (length < 1024 && commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Matching_Distances_2.length == 0) {
						commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Matching_Distances_2 = new byte[1024];
					} else {
						commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Matching_Distances_2 = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Matching_Distances_2, 0, length);
				strReturn = new String(commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Matching_Distances_2, 0, length,
						utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		public void readKeysData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_TALENDCLOUDDEMOBANK_CHIA_Matching_Distances_2) {

				try {

					int length = 0;

					this.SSNBlockingKey = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readKeysData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_TALENDCLOUDDEMOBANK_CHIA_Matching_Distances_2) {

				try {

					int length = 0;

					this.SSNBlockingKey = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeKeysData(ObjectOutputStream dos) {
			try {

				// String

				writeString(this.SSNBlockingKey, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeKeysData(org.jboss.marshalling.Marshaller dos) {
			try {

				// String

				writeString(this.SSNBlockingKey, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		/**
		 * Fill Values data by reading ObjectInputStream.
		 */
		public void readValuesData(DataInputStream dis, ObjectInputStream ois) {
			try {

				int length = 0;

				this.TargetFirstName = readString(dis, ois);

				this.TargetLastName = readString(dis, ois);

				this.TargetGender = readString(dis, ois);

				this.TargetPatientAddress = readString(dis, ois);

				this.TargetCity = readString(dis, ois);

				this.TargetState = readString(dis, ois);

				this.TargetPostalCode = readInteger(dis, ois);

				this.TargetBirthday = readDate(dis, ois);

				this.TargetSSN = readString(dis, ois);

				this.TargetHPLNID = readInteger(dis, ois);

				this.TargetNYSIISFirstName = readString(dis, ois);

				this.TargetNYSIISLastName = readString(dis, ois);

				this.TargetHealthPlanID = readString(dis, ois);

				this.TargetMRN = readInteger(dis, ois);

				this.FNDOBBlockingKey = readString(dis, ois);

				this.LNPCBlockingKey = readString(dis, ois);

				this.NYSIISFNLNBlockingKey = readString(dis, ois);

				this.DOBPCBlockingKey = readString(dis, ois);

				this.MRNBlockingKey = readString(dis, ois);

				this.HealthPlanIDBlockingKey = readString(dis, ois);

			} catch (IOException e) {
				throw new RuntimeException(e);

			}

		}

		public void readValuesData(DataInputStream dis, org.jboss.marshalling.Unmarshaller objectIn) {
			try {
				int length = 0;

				this.TargetFirstName = readString(dis, objectIn);

				this.TargetLastName = readString(dis, objectIn);

				this.TargetGender = readString(dis, objectIn);

				this.TargetPatientAddress = readString(dis, objectIn);

				this.TargetCity = readString(dis, objectIn);

				this.TargetState = readString(dis, objectIn);

				this.TargetPostalCode = readInteger(dis, objectIn);

				this.TargetBirthday = readDate(dis, objectIn);

				this.TargetSSN = readString(dis, objectIn);

				this.TargetHPLNID = readInteger(dis, objectIn);

				this.TargetNYSIISFirstName = readString(dis, objectIn);

				this.TargetNYSIISLastName = readString(dis, objectIn);

				this.TargetHealthPlanID = readString(dis, objectIn);

				this.TargetMRN = readInteger(dis, objectIn);

				this.FNDOBBlockingKey = readString(dis, objectIn);

				this.LNPCBlockingKey = readString(dis, objectIn);

				this.NYSIISFNLNBlockingKey = readString(dis, objectIn);

				this.DOBPCBlockingKey = readString(dis, objectIn);

				this.MRNBlockingKey = readString(dis, objectIn);

				this.HealthPlanIDBlockingKey = readString(dis, objectIn);

			} catch (IOException e) {
				throw new RuntimeException(e);

			}

		}

		/**
		 * Return a byte array which represents Values data.
		 */
		public void writeValuesData(DataOutputStream dos, ObjectOutputStream oos) {
			try {

				writeString(this.TargetFirstName, dos, oos);

				writeString(this.TargetLastName, dos, oos);

				writeString(this.TargetGender, dos, oos);

				writeString(this.TargetPatientAddress, dos, oos);

				writeString(this.TargetCity, dos, oos);

				writeString(this.TargetState, dos, oos);

				writeInteger(this.TargetPostalCode, dos, oos);

				writeDate(this.TargetBirthday, dos, oos);

				writeString(this.TargetSSN, dos, oos);

				writeInteger(this.TargetHPLNID, dos, oos);

				writeString(this.TargetNYSIISFirstName, dos, oos);

				writeString(this.TargetNYSIISLastName, dos, oos);

				writeString(this.TargetHealthPlanID, dos, oos);

				writeInteger(this.TargetMRN, dos, oos);

				writeString(this.FNDOBBlockingKey, dos, oos);

				writeString(this.LNPCBlockingKey, dos, oos);

				writeString(this.NYSIISFNLNBlockingKey, dos, oos);

				writeString(this.DOBPCBlockingKey, dos, oos);

				writeString(this.MRNBlockingKey, dos, oos);

				writeString(this.HealthPlanIDBlockingKey, dos, oos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeValuesData(DataOutputStream dos, org.jboss.marshalling.Marshaller objectOut) {
			try {

				writeString(this.TargetFirstName, dos, objectOut);

				writeString(this.TargetLastName, dos, objectOut);

				writeString(this.TargetGender, dos, objectOut);

				writeString(this.TargetPatientAddress, dos, objectOut);

				writeString(this.TargetCity, dos, objectOut);

				writeString(this.TargetState, dos, objectOut);

				writeInteger(this.TargetPostalCode, dos, objectOut);

				writeDate(this.TargetBirthday, dos, objectOut);

				writeString(this.TargetSSN, dos, objectOut);

				writeInteger(this.TargetHPLNID, dos, objectOut);

				writeString(this.TargetNYSIISFirstName, dos, objectOut);

				writeString(this.TargetNYSIISLastName, dos, objectOut);

				writeString(this.TargetHealthPlanID, dos, objectOut);

				writeInteger(this.TargetMRN, dos, objectOut);

				writeString(this.FNDOBBlockingKey, dos, objectOut);

				writeString(this.LNPCBlockingKey, dos, objectOut);

				writeString(this.NYSIISFNLNBlockingKey, dos, objectOut);

				writeString(this.DOBPCBlockingKey, dos, objectOut);

				writeString(this.MRNBlockingKey, dos, objectOut);

				writeString(this.HealthPlanIDBlockingKey, dos, objectOut);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}

		public boolean supportMarshaller() {
			return true;
		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("TargetFirstName=" + TargetFirstName);
			sb.append(",TargetLastName=" + TargetLastName);
			sb.append(",TargetGender=" + TargetGender);
			sb.append(",TargetPatientAddress=" + TargetPatientAddress);
			sb.append(",TargetCity=" + TargetCity);
			sb.append(",TargetState=" + TargetState);
			sb.append(",TargetPostalCode=" + String.valueOf(TargetPostalCode));
			sb.append(",TargetBirthday=" + String.valueOf(TargetBirthday));
			sb.append(",TargetSSN=" + TargetSSN);
			sb.append(",TargetHPLNID=" + String.valueOf(TargetHPLNID));
			sb.append(",TargetNYSIISFirstName=" + TargetNYSIISFirstName);
			sb.append(",TargetNYSIISLastName=" + TargetNYSIISLastName);
			sb.append(",TargetHealthPlanID=" + TargetHealthPlanID);
			sb.append(",TargetMRN=" + String.valueOf(TargetMRN));
			sb.append(",SSNBlockingKey=" + SSNBlockingKey);
			sb.append(",FNDOBBlockingKey=" + FNDOBBlockingKey);
			sb.append(",LNPCBlockingKey=" + LNPCBlockingKey);
			sb.append(",NYSIISFNLNBlockingKey=" + NYSIISFNLNBlockingKey);
			sb.append(",DOBPCBlockingKey=" + DOBPCBlockingKey);
			sb.append(",MRNBlockingKey=" + MRNBlockingKey);
			sb.append(",HealthPlanIDBlockingKey=" + HealthPlanIDBlockingKey);
			sb.append("]");

			return sb.toString();
		}

		public String toLogString() {
			StringBuilder sb = new StringBuilder();

			if (TargetFirstName == null) {
				sb.append("<null>");
			} else {
				sb.append(TargetFirstName);
			}

			sb.append("|");

			if (TargetLastName == null) {
				sb.append("<null>");
			} else {
				sb.append(TargetLastName);
			}

			sb.append("|");

			if (TargetGender == null) {
				sb.append("<null>");
			} else {
				sb.append(TargetGender);
			}

			sb.append("|");

			if (TargetPatientAddress == null) {
				sb.append("<null>");
			} else {
				sb.append(TargetPatientAddress);
			}

			sb.append("|");

			if (TargetCity == null) {
				sb.append("<null>");
			} else {
				sb.append(TargetCity);
			}

			sb.append("|");

			if (TargetState == null) {
				sb.append("<null>");
			} else {
				sb.append(TargetState);
			}

			sb.append("|");

			if (TargetPostalCode == null) {
				sb.append("<null>");
			} else {
				sb.append(TargetPostalCode);
			}

			sb.append("|");

			if (TargetBirthday == null) {
				sb.append("<null>");
			} else {
				sb.append(TargetBirthday);
			}

			sb.append("|");

			if (TargetSSN == null) {
				sb.append("<null>");
			} else {
				sb.append(TargetSSN);
			}

			sb.append("|");

			if (TargetHPLNID == null) {
				sb.append("<null>");
			} else {
				sb.append(TargetHPLNID);
			}

			sb.append("|");

			if (TargetNYSIISFirstName == null) {
				sb.append("<null>");
			} else {
				sb.append(TargetNYSIISFirstName);
			}

			sb.append("|");

			if (TargetNYSIISLastName == null) {
				sb.append("<null>");
			} else {
				sb.append(TargetNYSIISLastName);
			}

			sb.append("|");

			if (TargetHealthPlanID == null) {
				sb.append("<null>");
			} else {
				sb.append(TargetHealthPlanID);
			}

			sb.append("|");

			if (TargetMRN == null) {
				sb.append("<null>");
			} else {
				sb.append(TargetMRN);
			}

			sb.append("|");

			if (SSNBlockingKey == null) {
				sb.append("<null>");
			} else {
				sb.append(SSNBlockingKey);
			}

			sb.append("|");

			if (FNDOBBlockingKey == null) {
				sb.append("<null>");
			} else {
				sb.append(FNDOBBlockingKey);
			}

			sb.append("|");

			if (LNPCBlockingKey == null) {
				sb.append("<null>");
			} else {
				sb.append(LNPCBlockingKey);
			}

			sb.append("|");

			if (NYSIISFNLNBlockingKey == null) {
				sb.append("<null>");
			} else {
				sb.append(NYSIISFNLNBlockingKey);
			}

			sb.append("|");

			if (DOBPCBlockingKey == null) {
				sb.append("<null>");
			} else {
				sb.append(DOBPCBlockingKey);
			}

			sb.append("|");

			if (MRNBlockingKey == null) {
				sb.append("<null>");
			} else {
				sb.append(MRNBlockingKey);
			}

			sb.append("|");

			if (HealthPlanIDBlockingKey == null) {
				sb.append("<null>");
			} else {
				sb.append(HealthPlanIDBlockingKey);
			}

			sb.append("|");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(TargetStruct other) {

			int returnValue = -1;

			returnValue = checkNullsAndCompare(this.SSNBlockingKey, other.SSNBlockingKey);
			if (returnValue != 0) {
				return returnValue;
			}

			return returnValue;
		}

		private int checkNullsAndCompare(Object object1, Object object2) {
			int returnValue = 0;
			if (object1 instanceof Comparable && object2 instanceof Comparable) {
				returnValue = ((Comparable) object1).compareTo(object2);
			} else if (object1 != null && object2 != null) {
				returnValue = compareStrings(object1.toString(), object2.toString());
			} else if (object1 == null && object2 != null) {
				returnValue = 1;
			} else if (object1 != null && object2 == null) {
				returnValue = -1;
			} else {
				returnValue = 0;
			}

			return returnValue;
		}

		private int compareStrings(String string1, String string2) {
			return string1.compareTo(string2);
		}

	}

	public void tDBInput_2Process(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("tDBInput_2_SUBPROCESS_STATE", 0);

		final boolean execStat = this.execStat;

		mdc("tDBInput_2", "329TX2_");

		String iterateId = "";

		String currentComponent = "";
		s("none");
		String cLabel = null;
		java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

		try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { // start the resume
				globalResumeTicket = true;

				TargetStruct Target = new TargetStruct();

				/**
				 * [tAdvancedHash_Target begin ] start
				 */

				sh("tAdvancedHash_Target");

				s(currentComponent = "tAdvancedHash_Target");

				runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, 0, 0, "Target");

				int tos_count_tAdvancedHash_Target = 0;

				if (enableLogStash) {
					talendJobLog.addCM("tAdvancedHash_Target", "tAdvancedHash_Target", "tAdvancedHash");
					talendJobLogProcess(globalMap);
					s(currentComponent);
				}

				// connection name:Target
				// source node:tDBInput_2 - inputs:(after_tDBInput_3) outputs:(Target,Target) |
				// target node:tAdvancedHash_Target - inputs:(Target) outputs:()
				// linked node: tRecordMatching_2 - inputs:(Source,Target)
				// outputs:(PossibleMatches)

				org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE matchingModeEnum_Target = org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE.ALL_MATCHES;

				org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<TargetStruct> tHash_Lookup_Target = org.talend.designer.components.lookup.memory.AdvancedMemoryLookup
						.<TargetStruct>getLookup(matchingModeEnum_Target);

				globalMap.put("tHash_Lookup_Target", tHash_Lookup_Target);

				/**
				 * [tAdvancedHash_Target begin ] stop
				 */

				/**
				 * [tDBInput_2 begin ] start
				 */

				sh("tDBInput_2");

				s(currentComponent = "tDBInput_2");

				cLabel = "<b>Reference Source</b>";

				int tos_count_tDBInput_2 = 0;

				if (log.isDebugEnabled())
					log.debug("tDBInput_2 - " + ("Start to work."));
				if (log.isDebugEnabled()) {
					class BytesLimit65535_tDBInput_2 {
						public void limitLog4jByte() throws Exception {
							StringBuilder log4jParamters_tDBInput_2 = new StringBuilder();
							log4jParamters_tDBInput_2.append("Parameters:");
							log4jParamters_tDBInput_2.append("DB_VERSION" + " = " + "MYSQL_8");
							log4jParamters_tDBInput_2.append(" | ");
							log4jParamters_tDBInput_2.append("USE_EXISTING_CONNECTION" + " = " + "false");
							log4jParamters_tDBInput_2.append(" | ");
							log4jParamters_tDBInput_2.append("HOST" + " = " + "\"localhost\"");
							log4jParamters_tDBInput_2.append(" | ");
							log4jParamters_tDBInput_2.append("PORT" + " = " + "\"3306\"");
							log4jParamters_tDBInput_2.append(" | ");
							log4jParamters_tDBInput_2.append("DBNAME" + " = " + "\"CHIA\"");
							log4jParamters_tDBInput_2.append(" | ");
							log4jParamters_tDBInput_2.append("USER" + " = " + "\"root\"");
							log4jParamters_tDBInput_2.append(" | ");
							log4jParamters_tDBInput_2.append("PASS" + " = " + String.valueOf(
									"enc:routine.encryption.key.v2:anJs+U4jVvOsX4d37euVA2d21I+Y43qc29ZTLxmhKKW4i64F8w==")
									.substring(0, 4) + "...");
							log4jParamters_tDBInput_2.append(" | ");
							log4jParamters_tDBInput_2.append("TABLE" + " = " + "\"CHIATargetSource\"");
							log4jParamters_tDBInput_2.append(" | ");
							log4jParamters_tDBInput_2.append("QUERYSTORE" + " = " + "\"\"");
							log4jParamters_tDBInput_2.append(" | ");
							log4jParamters_tDBInput_2.append("QUERY" + " = "
									+ "\"SELECT    `CHIATargetSource`.`TargetFirstName`,    `CHIATargetSource`.`TargetLastName`,    `CHIATargetSource`.`TargetGender`,    `CHIATargetSource`.`TargetPatientAddress`,    `CHIATargetSource`.`TargetCity`,    `CHIATargetSource`.`TargetState`,    `CHIATargetSource`.`TargetPostalCode`,    `CHIATargetSource`.`TargetBirthday`,    `CHIATargetSource`.`TargetSSN`,    `CHIATargetSource`.`TargetHPLNID`,    `CHIATargetSource`.`TargetNYSIISFirstName`,    `CHIATargetSource`.`TargetNYSIISLastName`,    `CHIATargetSource`.`TargetHealthPlanID`,    `CHIATargetSource`.`TargetMRN`,    `CHIATargetSource`.`SSNBlockingKey`,    `CHIATargetSource`.`FNDOBBlockingKey`,    `CHIATargetSource`.`LNPCBlockingKey`,    `CHIATargetSource`.`NYSIISFNLNBlockingKey`,    `CHIATargetSource`.`DOBPCBlockingKey`,    `CHIATargetSource`.`MRNBlockingKey`,    `CHIATargetSource`.`HealthPlanIDBlockingKey`  FROM `CHIATargetSource`\"");
							log4jParamters_tDBInput_2.append(" | ");
							log4jParamters_tDBInput_2.append("SPECIFY_DATASOURCE_ALIAS" + " = " + "false");
							log4jParamters_tDBInput_2.append(" | ");
							log4jParamters_tDBInput_2.append("PROPERTIES" + " = "
									+ "\"noDatetimeStringSync=true&enabledTLSProtocols=TLSv1.2,TLSv1.1,TLSv1\"");
							log4jParamters_tDBInput_2.append(" | ");
							log4jParamters_tDBInput_2.append("ENABLE_STREAM" + " = " + "false");
							log4jParamters_tDBInput_2.append(" | ");
							log4jParamters_tDBInput_2.append("TRIM_ALL_COLUMN" + " = " + "false");
							log4jParamters_tDBInput_2.append(" | ");
							log4jParamters_tDBInput_2.append("TRIM_COLUMN" + " = " + "[{TRIM=" + ("false")
									+ ", SCHEMA_COLUMN=" + ("TargetFirstName") + "}, {TRIM=" + ("false")
									+ ", SCHEMA_COLUMN=" + ("TargetLastName") + "}, {TRIM=" + ("false")
									+ ", SCHEMA_COLUMN=" + ("TargetGender") + "}, {TRIM=" + ("false")
									+ ", SCHEMA_COLUMN=" + ("TargetPatientAddress") + "}, {TRIM=" + ("false")
									+ ", SCHEMA_COLUMN=" + ("TargetCity") + "}, {TRIM=" + ("false") + ", SCHEMA_COLUMN="
									+ ("TargetState") + "}, {TRIM=" + ("false") + ", SCHEMA_COLUMN="
									+ ("TargetPostalCode") + "}, {TRIM=" + ("false") + ", SCHEMA_COLUMN="
									+ ("TargetBirthday") + "}, {TRIM=" + ("false") + ", SCHEMA_COLUMN=" + ("TargetSSN")
									+ "}, {TRIM=" + ("false") + ", SCHEMA_COLUMN=" + ("TargetHPLNID") + "}, {TRIM="
									+ ("false") + ", SCHEMA_COLUMN=" + ("TargetNYSIISFirstName") + "}, {TRIM="
									+ ("false") + ", SCHEMA_COLUMN=" + ("TargetNYSIISLastName") + "}, {TRIM="
									+ ("false") + ", SCHEMA_COLUMN=" + ("TargetHealthPlanID") + "}, {TRIM=" + ("false")
									+ ", SCHEMA_COLUMN=" + ("TargetMRN") + "}, {TRIM=" + ("false") + ", SCHEMA_COLUMN="
									+ ("SSNBlockingKey") + "}, {TRIM=" + ("false") + ", SCHEMA_COLUMN="
									+ ("FNDOBBlockingKey") + "}, {TRIM=" + ("false") + ", SCHEMA_COLUMN="
									+ ("LNPCBlockingKey") + "}, {TRIM=" + ("false") + ", SCHEMA_COLUMN="
									+ ("NYSIISFNLNBlockingKey") + "}, {TRIM=" + ("false") + ", SCHEMA_COLUMN="
									+ ("DOBPCBlockingKey") + "}, {TRIM=" + ("false") + ", SCHEMA_COLUMN="
									+ ("MRNBlockingKey") + "}, {TRIM=" + ("false") + ", SCHEMA_COLUMN="
									+ ("HealthPlanIDBlockingKey") + "}]");
							log4jParamters_tDBInput_2.append(" | ");
							log4jParamters_tDBInput_2.append("UNIFIED_COMPONENTS" + " = " + "tMysqlInput");
							log4jParamters_tDBInput_2.append(" | ");
							if (log.isDebugEnabled())
								log.debug("tDBInput_2 - " + (log4jParamters_tDBInput_2));
						}
					}
					new BytesLimit65535_tDBInput_2().limitLog4jByte();
				}
				if (enableLogStash) {
					talendJobLog.addCM("tDBInput_2", "<b>Reference Source</b>", "tMysqlInput");
					talendJobLogProcess(globalMap);
					s(currentComponent);
				}

				java.util.Calendar calendar_tDBInput_2 = java.util.Calendar.getInstance();
				calendar_tDBInput_2.set(0, 0, 0, 0, 0, 0);
				java.util.Date year0_tDBInput_2 = calendar_tDBInput_2.getTime();
				int nb_line_tDBInput_2 = 0;
				java.sql.Connection conn_tDBInput_2 = null;
				String driverClass_tDBInput_2 = "com.mysql.cj.jdbc.Driver";
				java.lang.Class jdbcclazz_tDBInput_2 = java.lang.Class.forName(driverClass_tDBInput_2);
				String dbUser_tDBInput_2 = "root";

				final String decryptedPassword_tDBInput_2 = routines.system.PasswordEncryptUtil.decryptPassword(
						"enc:routine.encryption.key.v2:Rj3viMgFC1umXdF4mAfwvhK4zb0qpdgC2/C/mf2qiMRUSyy0pw==");

				String dbPwd_tDBInput_2 = decryptedPassword_tDBInput_2;

				String properties_tDBInput_2 = "noDatetimeStringSync=true&enabledTLSProtocols=TLSv1.2,TLSv1.1,TLSv1";
				if (properties_tDBInput_2 == null || properties_tDBInput_2.trim().length() == 0) {
					properties_tDBInput_2 = "";
				}
				String url_tDBInput_2 = "jdbc:mysql://" + "localhost" + ":" + "3306" + "/" + "CHIA" + "?"
						+ properties_tDBInput_2;

				log.debug("tDBInput_2 - Driver ClassName: " + driverClass_tDBInput_2 + ".");

				log.debug("tDBInput_2 - Connection attempt to '"
						+ url_tDBInput_2.replaceAll("(?<=trustStorePassword=)[^;]*", "********")
						+ "' with the username '" + dbUser_tDBInput_2 + "'.");

				conn_tDBInput_2 = java.sql.DriverManager.getConnection(url_tDBInput_2, dbUser_tDBInput_2,
						dbPwd_tDBInput_2);
				log.debug("tDBInput_2 - Connection to '"
						+ url_tDBInput_2.replaceAll("(?<=trustStorePassword=)[^;]*", "********") + "' has succeeded.");

				java.sql.Statement stmt_tDBInput_2 = conn_tDBInput_2.createStatement();

				String dbquery_tDBInput_2 = new StringBuilder().append(
						"SELECT \n  `CHIATargetSource`.`TargetFirstName`, \n  `CHIATargetSource`.`TargetLastName`, \n  `CHIATargetSource`.`TargetGe"
								+ "nder`, \n  `CHIATargetSource`.`TargetPatientAddress`, \n  `CHIATargetSource`.`TargetCity`, \n  `CHIATargetSource`.`TargetSt"
								+ "ate`, \n  `CHIATargetSource`.`TargetPostalCode`, \n  `CHIATargetSource`.`TargetBirthday`, \n  `CHIATargetSource`.`TargetSSN"
								+ "`, \n  `CHIATargetSource`.`TargetHPLNID`, \n  `CHIATargetSource`.`TargetNYSIISFirstName`, \n  `CHIATargetSource`.`TargetNYS"
								+ "IISLastName`, \n  `CHIATargetSource`.`TargetHealthPlanID`, \n  `CHIATargetSource`.`TargetMRN`, \n  `CHIATargetSource`.`SSNB"
								+ "lockingKey`, \n  `CHIATargetSource`.`FNDOBBlockingKey`, \n  `CHIATargetSource`.`LNPCBlockingKey`, \n  `CHIATargetSource`.`N"
								+ "YSIISFNLNBlockingKey`, \n  `CHIATargetSource`.`DOBPCBlockingKey`, \n  `CHIATargetSource`.`MRNBlockingKey`, \n  `CHIATargetS"
								+ "ource`.`HealthPlanIDBlockingKey`\n FROM `CHIATargetSource`")
						.toString();

				log.debug("tDBInput_2 - Executing the query: '" + dbquery_tDBInput_2 + "'.");

				globalMap.put("tDBInput_2_QUERY", dbquery_tDBInput_2);

				java.sql.ResultSet rs_tDBInput_2 = null;

				try {
					rs_tDBInput_2 = stmt_tDBInput_2.executeQuery(dbquery_tDBInput_2);
					java.sql.ResultSetMetaData rsmd_tDBInput_2 = rs_tDBInput_2.getMetaData();
					int colQtyInRs_tDBInput_2 = rsmd_tDBInput_2.getColumnCount();

					String tmpContent_tDBInput_2 = null;

					log.debug("tDBInput_2 - Retrieving records from the database.");

					while (rs_tDBInput_2.next()) {
						nb_line_tDBInput_2++;

						if (colQtyInRs_tDBInput_2 < 1) {
							Target.TargetFirstName = null;
						} else {

							Target.TargetFirstName = routines.system.JDBCUtil.getString(rs_tDBInput_2, 1, false);
						}
						if (colQtyInRs_tDBInput_2 < 2) {
							Target.TargetLastName = null;
						} else {

							Target.TargetLastName = routines.system.JDBCUtil.getString(rs_tDBInput_2, 2, false);
						}
						if (colQtyInRs_tDBInput_2 < 3) {
							Target.TargetGender = null;
						} else {

							Target.TargetGender = routines.system.JDBCUtil.getString(rs_tDBInput_2, 3, false);
						}
						if (colQtyInRs_tDBInput_2 < 4) {
							Target.TargetPatientAddress = null;
						} else {

							Target.TargetPatientAddress = routines.system.JDBCUtil.getString(rs_tDBInput_2, 4, false);
						}
						if (colQtyInRs_tDBInput_2 < 5) {
							Target.TargetCity = null;
						} else {

							Target.TargetCity = routines.system.JDBCUtil.getString(rs_tDBInput_2, 5, false);
						}
						if (colQtyInRs_tDBInput_2 < 6) {
							Target.TargetState = null;
						} else {

							Target.TargetState = routines.system.JDBCUtil.getString(rs_tDBInput_2, 6, false);
						}
						if (colQtyInRs_tDBInput_2 < 7) {
							Target.TargetPostalCode = null;
						} else {

							Target.TargetPostalCode = rs_tDBInput_2.getInt(7);
							if (rs_tDBInput_2.wasNull()) {
								Target.TargetPostalCode = null;
							}
						}
						if (colQtyInRs_tDBInput_2 < 8) {
							Target.TargetBirthday = null;
						} else {

							if (rs_tDBInput_2.getString(8) != null) {
								String dateString_tDBInput_2 = rs_tDBInput_2.getString(8);
								if (!("0000-00-00").equals(dateString_tDBInput_2)
										&& !("0000-00-00 00:00:00").equals(dateString_tDBInput_2)) {
									Target.TargetBirthday = rs_tDBInput_2.getTimestamp(8);
								} else {
									Target.TargetBirthday = (java.util.Date) year0_tDBInput_2.clone();
								}
							} else {
								Target.TargetBirthday = null;
							}
						}
						if (colQtyInRs_tDBInput_2 < 9) {
							Target.TargetSSN = null;
						} else {

							Target.TargetSSN = routines.system.JDBCUtil.getString(rs_tDBInput_2, 9, false);
						}
						if (colQtyInRs_tDBInput_2 < 10) {
							Target.TargetHPLNID = null;
						} else {

							Target.TargetHPLNID = rs_tDBInput_2.getInt(10);
							if (rs_tDBInput_2.wasNull()) {
								Target.TargetHPLNID = null;
							}
						}
						if (colQtyInRs_tDBInput_2 < 11) {
							Target.TargetNYSIISFirstName = null;
						} else {

							Target.TargetNYSIISFirstName = routines.system.JDBCUtil.getString(rs_tDBInput_2, 11, false);
						}
						if (colQtyInRs_tDBInput_2 < 12) {
							Target.TargetNYSIISLastName = null;
						} else {

							Target.TargetNYSIISLastName = routines.system.JDBCUtil.getString(rs_tDBInput_2, 12, false);
						}
						if (colQtyInRs_tDBInput_2 < 13) {
							Target.TargetHealthPlanID = null;
						} else {

							Target.TargetHealthPlanID = routines.system.JDBCUtil.getString(rs_tDBInput_2, 13, false);
						}
						if (colQtyInRs_tDBInput_2 < 14) {
							Target.TargetMRN = null;
						} else {

							Target.TargetMRN = rs_tDBInput_2.getInt(14);
							if (rs_tDBInput_2.wasNull()) {
								Target.TargetMRN = null;
							}
						}
						if (colQtyInRs_tDBInput_2 < 15) {
							Target.SSNBlockingKey = null;
						} else {

							Target.SSNBlockingKey = routines.system.JDBCUtil.getString(rs_tDBInput_2, 15, false);
						}
						if (colQtyInRs_tDBInput_2 < 16) {
							Target.FNDOBBlockingKey = null;
						} else {

							Target.FNDOBBlockingKey = routines.system.JDBCUtil.getString(rs_tDBInput_2, 16, false);
						}
						if (colQtyInRs_tDBInput_2 < 17) {
							Target.LNPCBlockingKey = null;
						} else {

							Target.LNPCBlockingKey = routines.system.JDBCUtil.getString(rs_tDBInput_2, 17, false);
						}
						if (colQtyInRs_tDBInput_2 < 18) {
							Target.NYSIISFNLNBlockingKey = null;
						} else {

							Target.NYSIISFNLNBlockingKey = routines.system.JDBCUtil.getString(rs_tDBInput_2, 18, false);
						}
						if (colQtyInRs_tDBInput_2 < 19) {
							Target.DOBPCBlockingKey = null;
						} else {

							Target.DOBPCBlockingKey = routines.system.JDBCUtil.getString(rs_tDBInput_2, 19, false);
						}
						if (colQtyInRs_tDBInput_2 < 20) {
							Target.MRNBlockingKey = null;
						} else {

							Target.MRNBlockingKey = routines.system.JDBCUtil.getString(rs_tDBInput_2, 20, false);
						}
						if (colQtyInRs_tDBInput_2 < 21) {
							Target.HealthPlanIDBlockingKey = null;
						} else {

							Target.HealthPlanIDBlockingKey = routines.system.JDBCUtil.getString(rs_tDBInput_2, 21,
									false);
						}

						log.debug("tDBInput_2 - Retrieving the record " + nb_line_tDBInput_2 + ".");

						/**
						 * [tDBInput_2 begin ] stop
						 */

						/**
						 * [tDBInput_2 main ] start
						 */

						s(currentComponent = "tDBInput_2");

						cLabel = "<b>Reference Source</b>";

						tos_count_tDBInput_2++;

						/**
						 * [tDBInput_2 main ] stop
						 */

						/**
						 * [tDBInput_2 process_data_begin ] start
						 */

						s(currentComponent = "tDBInput_2");

						cLabel = "<b>Reference Source</b>";

						/**
						 * [tDBInput_2 process_data_begin ] stop
						 */

						/**
						 * [tAdvancedHash_Target main ] start
						 */

						s(currentComponent = "tAdvancedHash_Target");

						if (runStat.update(execStat, enableLogStash, iterateId, 1, 1

								, "Target", "tDBInput_2", "<b>Reference Source</b>", "tMysqlInput",
								"tAdvancedHash_Target", "tAdvancedHash_Target", "tAdvancedHash"

						)) {
							talendJobLogProcess(globalMap);
						}

						if (log.isTraceEnabled()) {
							log.trace("Target - " + (Target == null ? "" : Target.toLogString()));
						}

						TargetStruct Target_HashRow = new TargetStruct();

						Target_HashRow.TargetFirstName = Target.TargetFirstName;

						Target_HashRow.TargetLastName = Target.TargetLastName;

						Target_HashRow.TargetGender = Target.TargetGender;

						Target_HashRow.TargetPatientAddress = Target.TargetPatientAddress;

						Target_HashRow.TargetCity = Target.TargetCity;

						Target_HashRow.TargetState = Target.TargetState;

						Target_HashRow.TargetPostalCode = Target.TargetPostalCode;

						Target_HashRow.TargetBirthday = Target.TargetBirthday;

						Target_HashRow.TargetSSN = Target.TargetSSN;

						Target_HashRow.TargetHPLNID = Target.TargetHPLNID;

						Target_HashRow.TargetNYSIISFirstName = Target.TargetNYSIISFirstName;

						Target_HashRow.TargetNYSIISLastName = Target.TargetNYSIISLastName;

						Target_HashRow.TargetHealthPlanID = Target.TargetHealthPlanID;

						Target_HashRow.TargetMRN = Target.TargetMRN;

						Target_HashRow.SSNBlockingKey = Target.SSNBlockingKey;

						Target_HashRow.FNDOBBlockingKey = Target.FNDOBBlockingKey;

						Target_HashRow.LNPCBlockingKey = Target.LNPCBlockingKey;

						Target_HashRow.NYSIISFNLNBlockingKey = Target.NYSIISFNLNBlockingKey;

						Target_HashRow.DOBPCBlockingKey = Target.DOBPCBlockingKey;

						Target_HashRow.MRNBlockingKey = Target.MRNBlockingKey;

						Target_HashRow.HealthPlanIDBlockingKey = Target.HealthPlanIDBlockingKey;

						tHash_Lookup_Target.put(Target_HashRow);

						tos_count_tAdvancedHash_Target++;

						/**
						 * [tAdvancedHash_Target main ] stop
						 */

						/**
						 * [tAdvancedHash_Target process_data_begin ] start
						 */

						s(currentComponent = "tAdvancedHash_Target");

						/**
						 * [tAdvancedHash_Target process_data_begin ] stop
						 */

						/**
						 * [tAdvancedHash_Target process_data_end ] start
						 */

						s(currentComponent = "tAdvancedHash_Target");

						/**
						 * [tAdvancedHash_Target process_data_end ] stop
						 */

						/**
						 * [tDBInput_2 process_data_end ] start
						 */

						s(currentComponent = "tDBInput_2");

						cLabel = "<b>Reference Source</b>";

						/**
						 * [tDBInput_2 process_data_end ] stop
						 */

						/**
						 * [tDBInput_2 end ] start
						 */

						s(currentComponent = "tDBInput_2");

						cLabel = "<b>Reference Source</b>";

					}
				} finally {
					if (rs_tDBInput_2 != null) {
						rs_tDBInput_2.close();
					}
					if (stmt_tDBInput_2 != null) {
						stmt_tDBInput_2.close();
					}
					if (conn_tDBInput_2 != null && !conn_tDBInput_2.isClosed()) {

						log.debug("tDBInput_2 - Closing the connection to the database.");

						conn_tDBInput_2.close();

						if ("com.mysql.cj.jdbc.Driver".equals((String) globalMap.get("driverClass_"))
								&& routines.system.BundleUtils.inOSGi()) {
							Class.forName("com.mysql.cj.jdbc.AbandonedConnectionCleanupThread")
									.getMethod("checkedShutdown").invoke(null, (Object[]) null);
						}

						log.debug("tDBInput_2 - Connection to the database closed.");

					}

				}
				globalMap.put("tDBInput_2_NB_LINE", nb_line_tDBInput_2);
				log.debug("tDBInput_2 - Retrieved records count: " + nb_line_tDBInput_2 + " .");

				if (log.isDebugEnabled())
					log.debug("tDBInput_2 - " + ("Done."));

				ok_Hash.put("tDBInput_2", true);
				end_Hash.put("tDBInput_2", System.currentTimeMillis());

				/**
				 * [tDBInput_2 end ] stop
				 */

				/**
				 * [tAdvancedHash_Target end ] start
				 */

				s(currentComponent = "tAdvancedHash_Target");

				tHash_Lookup_Target.endPut();

				if (runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, "Target", 2, 0,
						"tDBInput_2", "<b>Reference Source</b>", "tMysqlInput", "tAdvancedHash_Target",
						"tAdvancedHash_Target", "tAdvancedHash", "output")) {
					talendJobLogProcess(globalMap);
				}

				ok_Hash.put("tAdvancedHash_Target", true);
				end_Hash.put("tAdvancedHash_Target", System.currentTimeMillis());

				/**
				 * [tAdvancedHash_Target end ] stop
				 */

			} // end the resume

		} catch (java.lang.Exception e) {

			if (!(e instanceof TalendException)) {
				log.fatal(currentComponent + " " + e.getMessage(), e);
			}

			TalendException te = new TalendException(e, currentComponent, cLabel, globalMap);

			throw te;
		} catch (java.lang.Error error) {

			runStat.stopThreadStat();

			throw error;
		} finally {

			try {

				/**
				 * [tDBInput_2 finally ] start
				 */

				s(currentComponent = "tDBInput_2");

				cLabel = "<b>Reference Source</b>";

				/**
				 * [tDBInput_2 finally ] stop
				 */

				/**
				 * [tAdvancedHash_Target finally ] start
				 */

				s(currentComponent = "tAdvancedHash_Target");

				/**
				 * [tAdvancedHash_Target finally ] stop
				 */

			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tDBInput_2_SUBPROCESS_STATE", 1);
	}

	public void talendJobLogProcess(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("talendJobLog_SUBPROCESS_STATE", 0);

		final boolean execStat = this.execStat;

		String iterateId = "";

		String currentComponent = "";
		s("none");
		String cLabel = null;
		java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

		try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { // start the resume
				globalResumeTicket = true;

				/**
				 * [talendJobLog begin ] start
				 */

				sh("talendJobLog");

				s(currentComponent = "talendJobLog");

				int tos_count_talendJobLog = 0;

				for (JobStructureCatcherUtils.JobStructureCatcherMessage jcm : talendJobLog.getMessages()) {
					org.talend.job.audit.JobContextBuilder builder_talendJobLog = org.talend.job.audit.JobContextBuilder
							.create().jobName(jcm.job_name).jobId(jcm.job_id).jobVersion(jcm.job_version)
							.custom("process_id", jcm.pid).custom("thread_id", jcm.tid).custom("pid", pid)
							.custom("father_pid", fatherPid).custom("root_pid", rootPid);
					org.talend.logging.audit.Context log_context_talendJobLog = null;

					if (jcm.log_type == JobStructureCatcherUtils.LogType.PERFORMANCE) {
						long timeMS = jcm.end_time - jcm.start_time;
						String duration = String.valueOf(timeMS);

						log_context_talendJobLog = builder_talendJobLog.sourceId(jcm.sourceId)
								.sourceLabel(jcm.sourceLabel).sourceConnectorType(jcm.sourceComponentName)
								.targetId(jcm.targetId).targetLabel(jcm.targetLabel)
								.targetConnectorType(jcm.targetComponentName).connectionName(jcm.current_connector)
								.rows(jcm.row_count).duration(duration).build();
						auditLogger_talendJobLog.flowExecution(log_context_talendJobLog);
					} else if (jcm.log_type == JobStructureCatcherUtils.LogType.JOBSTART) {
						log_context_talendJobLog = builder_talendJobLog.timestamp(jcm.moment).build();
						auditLogger_talendJobLog.jobstart(log_context_talendJobLog);
					} else if (jcm.log_type == JobStructureCatcherUtils.LogType.JOBEND) {
						long timeMS = jcm.end_time - jcm.start_time;
						String duration = String.valueOf(timeMS);

						log_context_talendJobLog = builder_talendJobLog.timestamp(jcm.moment).duration(duration)
								.status(jcm.status).build();
						auditLogger_talendJobLog.jobstop(log_context_talendJobLog);
					} else if (jcm.log_type == JobStructureCatcherUtils.LogType.RUNCOMPONENT) {
						log_context_talendJobLog = builder_talendJobLog.timestamp(jcm.moment)
								.connectorType(jcm.component_name).connectorId(jcm.component_id)
								.connectorLabel(jcm.component_label).build();
						auditLogger_talendJobLog.runcomponent(log_context_talendJobLog);
					} else if (jcm.log_type == JobStructureCatcherUtils.LogType.FLOWINPUT) {// log current component
																							// input line
						long timeMS = jcm.end_time - jcm.start_time;
						String duration = String.valueOf(timeMS);

						log_context_talendJobLog = builder_talendJobLog.connectorType(jcm.component_name)
								.connectorId(jcm.component_id).connectorLabel(jcm.component_label)
								.connectionName(jcm.current_connector).connectionType(jcm.current_connector_type)
								.rows(jcm.total_row_number).duration(duration).build();
						auditLogger_talendJobLog.flowInput(log_context_talendJobLog);
					} else if (jcm.log_type == JobStructureCatcherUtils.LogType.FLOWOUTPUT) {// log current component
																								// output/reject line
						long timeMS = jcm.end_time - jcm.start_time;
						String duration = String.valueOf(timeMS);

						log_context_talendJobLog = builder_talendJobLog.connectorType(jcm.component_name)
								.connectorId(jcm.component_id).connectorLabel(jcm.component_label)
								.connectionName(jcm.current_connector).connectionType(jcm.current_connector_type)
								.rows(jcm.total_row_number).duration(duration).build();
						auditLogger_talendJobLog.flowOutput(log_context_talendJobLog);
					} else if (jcm.log_type == JobStructureCatcherUtils.LogType.JOBERROR) {
						java.lang.Exception e_talendJobLog = jcm.exception;
						if (e_talendJobLog != null) {
							try (java.io.StringWriter sw_talendJobLog = new java.io.StringWriter();
									java.io.PrintWriter pw_talendJobLog = new java.io.PrintWriter(sw_talendJobLog)) {
								e_talendJobLog.printStackTrace(pw_talendJobLog);
								builder_talendJobLog.custom("stacktrace", sw_talendJobLog.getBuffer().substring(0,
										java.lang.Math.min(sw_talendJobLog.getBuffer().length(), 512)));
							}
						}

						if (jcm.extra_info != null) {
							builder_talendJobLog.connectorId(jcm.component_id).custom("extra_info", jcm.extra_info);
						}

						log_context_talendJobLog = builder_talendJobLog
								.connectorType(jcm.component_id.substring(0, jcm.component_id.lastIndexOf('_')))
								.connectorId(jcm.component_id)
								.connectorLabel(jcm.component_label == null ? jcm.component_id : jcm.component_label)
								.build();

						auditLogger_talendJobLog.exception(log_context_talendJobLog);
					}

				}

				/**
				 * [talendJobLog begin ] stop
				 */

				/**
				 * [talendJobLog main ] start
				 */

				s(currentComponent = "talendJobLog");

				tos_count_talendJobLog++;

				/**
				 * [talendJobLog main ] stop
				 */

				/**
				 * [talendJobLog process_data_begin ] start
				 */

				s(currentComponent = "talendJobLog");

				/**
				 * [talendJobLog process_data_begin ] stop
				 */

				/**
				 * [talendJobLog process_data_end ] start
				 */

				s(currentComponent = "talendJobLog");

				/**
				 * [talendJobLog process_data_end ] stop
				 */

				/**
				 * [talendJobLog end ] start
				 */

				s(currentComponent = "talendJobLog");

				ok_Hash.put("talendJobLog", true);
				end_Hash.put("talendJobLog", System.currentTimeMillis());

				/**
				 * [talendJobLog end ] stop
				 */

			} // end the resume

		} catch (java.lang.Exception e) {

			if (!(e instanceof TalendException)) {
				log.fatal(currentComponent + " " + e.getMessage(), e);
			}

			TalendException te = new TalendException(e, currentComponent, cLabel, globalMap);

			throw te;
		} catch (java.lang.Error error) {

			runStat.stopThreadStat();

			throw error;
		} finally {

			try {

				/**
				 * [talendJobLog finally ] start
				 */

				s(currentComponent = "talendJobLog");

				/**
				 * [talendJobLog finally ] stop
				 */

			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("talendJobLog_SUBPROCESS_STATE", 1);
	}

	public String resuming_logs_dir_path = null;
	public String resuming_checkpoint_path = null;
	public String parent_part_launcher = null;
	private String resumeEntryMethodName = null;
	private boolean globalResumeTicket = false;

	public boolean watch = false;
	// portStats is null, it means don't execute the statistics
	public Integer portStats = null;
	public int portTraces = 4334;
	public String clientHost;
	public String defaultClientHost = "localhost";
	public String contextStr = "Default";
	public boolean isDefaultContext = true;
	public String pid = "0";
	public String rootPid = null;
	public String fatherPid = null;
	public String fatherNode = null;
	public long startTime = 0;
	public boolean isChildJob = false;
	public String log4jLevel = "";

	private boolean enableLogStash;
	private boolean enableLineage;

	private boolean execStat = true;

	private ThreadLocal<java.util.Map<String, String>> threadLocal = new ThreadLocal<java.util.Map<String, String>>() {
		protected java.util.Map<String, String> initialValue() {
			java.util.Map<String, String> threadRunResultMap = new java.util.HashMap<String, String>();
			threadRunResultMap.put("errorCode", null);
			threadRunResultMap.put("status", "");
			return threadRunResultMap;
		};
	};

	protected PropertiesWithType context_param = new PropertiesWithType();
	public java.util.Map<String, Object> parentContextMap = new java.util.HashMap<String, Object>();

	public String status = "";

	private final static java.util.Properties jobInfo = new java.util.Properties();
	private final static java.util.Map<String, String> mdcInfo = new java.util.HashMap<>();
	private final static java.util.concurrent.atomic.AtomicLong subJobPidCounter = new java.util.concurrent.atomic.AtomicLong();

	public static void main(String[] args) {
		final CHIA_Matching_Distances_2 CHIA_Matching_Distances_2Class = new CHIA_Matching_Distances_2();

		int exitCode = CHIA_Matching_Distances_2Class.runJobInTOS(args);
		if (exitCode == 0) {
			log.info("TalendJob: 'CHIA_Matching_Distances_2' - Done.");
		}

		System.exit(exitCode);
	}

	private void getjobInfo() {
		final String TEMPLATE_PATH = "src/main/templates/jobInfo_template.properties";
		final String BUILD_PATH = "../jobInfo.properties";
		final String path = this.getClass().getResource("").getPath();
		if (path.lastIndexOf("target") > 0) {
			final java.io.File templateFile = new java.io.File(
					path.substring(0, path.lastIndexOf("target")).concat(TEMPLATE_PATH));
			if (templateFile.exists()) {
				readJobInfo(templateFile);
				return;
			}
		}
		readJobInfo(new java.io.File(BUILD_PATH));
	}

	private void readJobInfo(java.io.File jobInfoFile) {

		if (jobInfoFile.exists()) {
			try (java.io.InputStream is = new java.io.FileInputStream(jobInfoFile)) {
				jobInfo.load(is);
			} catch (IOException e) {

				log.debug("Read jobInfo.properties file fail: " + e.getMessage());

			}
		}
		log.info(String.format("Project name: %s\tJob name: %s\tGIT Commit ID: %s\tTalend Version: %s", projectName,
				jobName, jobInfo.getProperty("gitCommitId"), "8.0.1.20250704_1436-patch"));

	}

	public String[][] runJob(String[] args) {

		int exitCode = runJobInTOS(args);
		String[][] bufferValue = new String[][] { { Integer.toString(exitCode) } };

		return bufferValue;
	}

	public boolean hastBufferOutputComponent() {
		boolean hastBufferOutput = false;

		return hastBufferOutput;
	}

	public int runJobInTOS(String[] args) {
		// reset status
		status = "";

		String lastStr = "";
		for (String arg : args) {
			if (arg.equalsIgnoreCase("--context_param")) {
				lastStr = arg;
			} else if (lastStr.equals("")) {
				evalParam(arg);
			} else {
				evalParam(lastStr + " " + arg);
				lastStr = "";
			}
		}

		final boolean enableCBP = false;
		boolean inOSGi = routines.system.BundleUtils.inOSGi();

		if (!inOSGi && isCBPClientPresent) {
			if (org.talend.metrics.CBPClient.getInstanceForCurrentVM() == null) {
				try {
					org.talend.metrics.CBPClient.startListenIfNotStarted(enableCBP, true);
				} catch (java.lang.Exception e) {
					errorCode = 1;
					status = "failure";
					e.printStackTrace();
					return 1;
				}
			}
		}

		enableLogStash = "true".equalsIgnoreCase(System.getProperty("audit.enabled"));

		if (!"".equals(log4jLevel)) {

			if ("trace".equalsIgnoreCase(log4jLevel)) {
				org.apache.logging.log4j.core.config.Configurator.setLevel(log.getName(),
						org.apache.logging.log4j.Level.TRACE);
			} else if ("debug".equalsIgnoreCase(log4jLevel)) {
				org.apache.logging.log4j.core.config.Configurator.setLevel(log.getName(),
						org.apache.logging.log4j.Level.DEBUG);
			} else if ("info".equalsIgnoreCase(log4jLevel)) {
				org.apache.logging.log4j.core.config.Configurator.setLevel(log.getName(),
						org.apache.logging.log4j.Level.INFO);
			} else if ("warn".equalsIgnoreCase(log4jLevel)) {
				org.apache.logging.log4j.core.config.Configurator.setLevel(log.getName(),
						org.apache.logging.log4j.Level.WARN);
			} else if ("error".equalsIgnoreCase(log4jLevel)) {
				org.apache.logging.log4j.core.config.Configurator.setLevel(log.getName(),
						org.apache.logging.log4j.Level.ERROR);
			} else if ("fatal".equalsIgnoreCase(log4jLevel)) {
				org.apache.logging.log4j.core.config.Configurator.setLevel(log.getName(),
						org.apache.logging.log4j.Level.FATAL);
			} else if ("off".equalsIgnoreCase(log4jLevel)) {
				org.apache.logging.log4j.core.config.Configurator.setLevel(log.getName(),
						org.apache.logging.log4j.Level.OFF);
			}
			org.apache.logging.log4j.core.config.Configurator
					.setLevel(org.apache.logging.log4j.LogManager.getRootLogger().getName(), log.getLevel());

		}

		getjobInfo();
		log.info("TalendJob: 'CHIA_Matching_Distances_2' - Start.");

		java.util.Set<Object> jobInfoKeys = jobInfo.keySet();
		for (Object jobInfoKey : jobInfoKeys) {
			org.slf4j.MDC.put("_" + jobInfoKey.toString(), jobInfo.get(jobInfoKey).toString());
		}
		org.slf4j.MDC.put("_pid", pid);
		org.slf4j.MDC.put("_rootPid", rootPid);
		org.slf4j.MDC.put("_fatherPid", fatherPid);
		org.slf4j.MDC.put("_projectName", projectName);
		org.slf4j.MDC.put("_startTimestamp", java.time.ZonedDateTime.now(java.time.ZoneOffset.UTC)
				.format(java.time.format.DateTimeFormatter.ISO_INSTANT));
		org.slf4j.MDC.put("_jobRepositoryId", "_D2ItsLx2Ee-ILekM8jCPpA");
		org.slf4j.MDC.put("_compiledAtTimestamp", "2025-07-20T22:51:42.763607Z");

		java.lang.management.RuntimeMXBean mx = java.lang.management.ManagementFactory.getRuntimeMXBean();
		String[] mxNameTable = mx.getName().split("@"); //$NON-NLS-1$
		if (mxNameTable.length == 2) {
			org.slf4j.MDC.put("_systemPid", mxNameTable[0]);
		} else {
			org.slf4j.MDC.put("_systemPid", String.valueOf(java.lang.Thread.currentThread().getId()));
		}

		if (enableLogStash) {
			java.util.Properties properties_talendJobLog = new java.util.Properties();
			properties_talendJobLog.setProperty("root.logger", "audit");
			properties_talendJobLog.setProperty("encoding", "UTF-8");
			properties_talendJobLog.setProperty("application.name", "Talend Studio");
			properties_talendJobLog.setProperty("service.name", "Talend Studio Job");
			properties_talendJobLog.setProperty("instance.name", "Talend Studio Job Instance");
			properties_talendJobLog.setProperty("propagate.appender.exceptions", "none");
			properties_talendJobLog.setProperty("log.appender", "file");
			properties_talendJobLog.setProperty("appender.file.path", "audit.json");
			properties_talendJobLog.setProperty("appender.file.maxsize", "52428800");
			properties_talendJobLog.setProperty("appender.file.maxbackup", "20");
			properties_talendJobLog.setProperty("host", "false");

			System.getProperties().stringPropertyNames().stream().filter(it -> it.startsWith("audit.logger."))
					.forEach(key -> properties_talendJobLog.setProperty(key.substring("audit.logger.".length()),
							System.getProperty(key)));

			org.apache.logging.log4j.core.config.Configurator
					.setLevel(properties_talendJobLog.getProperty("root.logger"), org.apache.logging.log4j.Level.DEBUG);

			auditLogger_talendJobLog = org.talend.job.audit.JobEventAuditLoggerFactory
					.createJobAuditLogger(properties_talendJobLog);
		}

		if (clientHost == null) {
			clientHost = defaultClientHost;
		}

		if (pid == null || "0".equals(pid)) {
			pid = TalendString.getAsciiRandomString(6);
		}

		org.slf4j.MDC.put("_pid", pid);

		if (rootPid == null) {
			rootPid = pid;
		}

		org.slf4j.MDC.put("_rootPid", rootPid);

		if (fatherPid == null) {
			fatherPid = pid;
		} else {
			isChildJob = true;
		}
		org.slf4j.MDC.put("_fatherPid", fatherPid);

		if (portStats != null) {
			// portStats = -1; //for testing
			if (portStats < 0 || portStats > 65535) {
				// issue:10869, the portStats is invalid, so this client socket can't open
				System.err.println("The statistics socket port " + portStats + " is invalid.");
				execStat = false;
			}
		} else {
			execStat = false;
		}

		try {
			java.util.Dictionary<String, Object> jobProperties = null;
			if (inOSGi) {
				jobProperties = routines.system.BundleUtils.getJobProperties(jobName);

				if (jobProperties != null && jobProperties.get("context") != null) {
					contextStr = (String) jobProperties.get("context");
				}

				if (jobProperties != null && jobProperties.get("taskExecutionId") != null) {
					taskExecutionId = (String) jobProperties.get("taskExecutionId");
				}

				// extract ids from parent route
				if (null == taskExecutionId || taskExecutionId.isEmpty()) {
					for (String arg : args) {
						if (arg.startsWith("--context_param")
								&& (arg.contains("taskExecutionId") || arg.contains("jobExecutionId"))) {

							String keyValue = arg.replace("--context_param", "");
							String[] parts = keyValue.split("=");
							String[] cleanParts = java.util.Arrays.stream(parts).filter(s -> !s.isEmpty())
									.toArray(String[]::new);
							if (cleanParts.length == 2) {
								String key = cleanParts[0];
								String value = cleanParts[1];
								if ("taskExecutionId".equals(key.trim()) && null != value) {
									taskExecutionId = value.trim();
								} else if ("jobExecutionId".equals(key.trim()) && null != value) {
									jobExecutionId = value.trim();
								}
							}
						}
					}
				}
			}

			// first load default key-value pairs from application.properties
			if (isStandaloneMS) {
				context.putAll(this.getDefaultProperties());
			}
			// call job/subjob with an existing context, like: --context=production. if
			// without this parameter, there will use the default context instead.
			java.io.InputStream inContext = CHIA_Matching_Distances_2.class.getClassLoader().getResourceAsStream(
					"talendclouddemobank/chia_matching_distances_2_0_1/contexts/" + contextStr + ".properties");
			if (inContext == null) {
				inContext = CHIA_Matching_Distances_2.class.getClassLoader()
						.getResourceAsStream("config/contexts/" + contextStr + ".properties");
			}
			if (inContext != null) {
				try {
					// defaultProps is in order to keep the original context value
					if (context != null && context.isEmpty()) {
						defaultProps.load(inContext);
						if (inOSGi && jobProperties != null) {
							java.util.Enumeration<String> keys = jobProperties.keys();
							while (keys.hasMoreElements()) {
								String propKey = keys.nextElement();
								if (defaultProps.containsKey(propKey)) {
									defaultProps.put(propKey, (String) jobProperties.get(propKey));
								}
							}
						}
						context = new ContextProperties(defaultProps);
					}
					if (isStandaloneMS) {
						// override context key-value pairs if provided using --context=contextName
						defaultProps.load(inContext);
						context.putAll(defaultProps);
					}
				} finally {
					inContext.close();
				}
			} else if (!isDefaultContext) {
				// print info and job continue to run, for case: context_param is not empty.
				System.err.println("Could not find the context " + contextStr);
			}
			// override key-value pairs if provided via --config.location=file1.file2 OR
			// --config.additional-location=file1,file2
			if (isStandaloneMS) {
				context.putAll(this.getAdditionalProperties());
			}

			// override key-value pairs if provide via command line like
			// --key1=value1,--key2=value2
			if (!context_param.isEmpty()) {
				context.putAll(context_param);
				// set types for params from parentJobs
				for (Object key : context_param.keySet()) {
					String context_key = key.toString();
					String context_type = context_param.getContextType(context_key);
					context.setContextType(context_key, context_type);

				}
			}
			class ContextProcessing {
				private void processContext_0() {
					context.setContextType("MySQL_CDCF_Password", "id_Password");
					if (context.getStringValue("MySQL_CDCF_Password") == null) {
						context.MySQL_CDCF_Password = null;
					} else {
						String pwd_MySQL_CDCF_Password_value = context.getProperty("MySQL_CDCF_Password");
						context.MySQL_CDCF_Password = null;
						if (pwd_MySQL_CDCF_Password_value != null) {
							if (context_param.containsKey("MySQL_CDCF_Password")) {// no need to decrypt if it come from
																					// program argument or parent job
																					// runtime
								context.MySQL_CDCF_Password = pwd_MySQL_CDCF_Password_value;
							} else if (!pwd_MySQL_CDCF_Password_value.isEmpty()) {
								try {
									context.MySQL_CDCF_Password = routines.system.PasswordEncryptUtil
											.decryptPassword(pwd_MySQL_CDCF_Password_value);
									context.put("MySQL_CDCF_Password", context.MySQL_CDCF_Password);
								} catch (java.lang.RuntimeException e) {
									// do nothing
								}
							}
						}
					}
					context.setContextType("MySQL_CDCF_Port", "id_String");
					if (context.getStringValue("MySQL_CDCF_Port") == null) {
						context.MySQL_CDCF_Port = null;
					} else {
						context.MySQL_CDCF_Port = (String) context.getProperty("MySQL_CDCF_Port");
					}
					context.setContextType("MySQL_CDCF_Server", "id_String");
					if (context.getStringValue("MySQL_CDCF_Server") == null) {
						context.MySQL_CDCF_Server = null;
					} else {
						context.MySQL_CDCF_Server = (String) context.getProperty("MySQL_CDCF_Server");
					}
					context.setContextType("MySQL_CDCF_Database", "id_String");
					if (context.getStringValue("MySQL_CDCF_Database") == null) {
						context.MySQL_CDCF_Database = null;
					} else {
						context.MySQL_CDCF_Database = (String) context.getProperty("MySQL_CDCF_Database");
					}
					context.setContextType("MySQL_CDCF_AdditionalParams", "id_String");
					if (context.getStringValue("MySQL_CDCF_AdditionalParams") == null) {
						context.MySQL_CDCF_AdditionalParams = null;
					} else {
						context.MySQL_CDCF_AdditionalParams = (String) context
								.getProperty("MySQL_CDCF_AdditionalParams");
					}
					context.setContextType("MySQL_CDCF_Login", "id_String");
					if (context.getStringValue("MySQL_CDCF_Login") == null) {
						context.MySQL_CDCF_Login = null;
					} else {
						context.MySQL_CDCF_Login = (String) context.getProperty("MySQL_CDCF_Login");
					}
				}

				public void processAllContext() {
					processContext_0();
				}
			}

			new ContextProcessing().processAllContext();
		} catch (java.io.IOException ie) {
			System.err.println("Could not load context " + contextStr);
			ie.printStackTrace();
		}

		// get context value from parent directly
		if (parentContextMap != null && !parentContextMap.isEmpty()) {
			if (parentContextMap.containsKey("MySQL_CDCF_Password")) {
				context.MySQL_CDCF_Password = (java.lang.String) parentContextMap.get("MySQL_CDCF_Password");
			}
			if (parentContextMap.containsKey("MySQL_CDCF_Port")) {
				context.MySQL_CDCF_Port = (String) parentContextMap.get("MySQL_CDCF_Port");
			}
			if (parentContextMap.containsKey("MySQL_CDCF_Server")) {
				context.MySQL_CDCF_Server = (String) parentContextMap.get("MySQL_CDCF_Server");
			}
			if (parentContextMap.containsKey("MySQL_CDCF_Database")) {
				context.MySQL_CDCF_Database = (String) parentContextMap.get("MySQL_CDCF_Database");
			}
			if (parentContextMap.containsKey("MySQL_CDCF_AdditionalParams")) {
				context.MySQL_CDCF_AdditionalParams = (String) parentContextMap.get("MySQL_CDCF_AdditionalParams");
			}
			if (parentContextMap.containsKey("MySQL_CDCF_Login")) {
				context.MySQL_CDCF_Login = (String) parentContextMap.get("MySQL_CDCF_Login");
			}
		}

		// Resume: init the resumeUtil
		resumeEntryMethodName = ResumeUtil.getResumeEntryMethodName(resuming_checkpoint_path);
		resumeUtil = new ResumeUtil(resuming_logs_dir_path, isChildJob, rootPid);
		resumeUtil.initCommonInfo(pid, rootPid, fatherPid, projectName, jobName, contextStr, jobVersion);

		List<String> parametersToEncrypt = new java.util.ArrayList<String>();
		parametersToEncrypt.add("MySQL_CDCF_Password");
		// Resume: jobStart
		resumeUtil.addLog("JOB_STARTED", "JOB:" + jobName, parent_part_launcher, Thread.currentThread().getId() + "",
				"", "", "", "", resumeUtil.convertToJsonText(context, ContextProperties.class, parametersToEncrypt));

		org.slf4j.MDC.put("_context", contextStr);
		log.info("TalendJob: 'CHIA_Matching_Distances_2' - Started.");
		java.util.Optional.ofNullable(org.slf4j.MDC.getCopyOfContextMap()).ifPresent(mdcInfo::putAll);

		if (execStat) {
			try {
				runStat.openSocket(!isChildJob);
				runStat.setAllPID(rootPid, fatherPid, pid, jobName);
				runStat.startThreadStat(clientHost, portStats);
				runStat.updateStatOnJob(RunStat.JOBSTART, fatherNode);
			} catch (java.io.IOException ioException) {
				ioException.printStackTrace();
			}
		}

		java.util.concurrent.ConcurrentHashMap<Object, Object> concurrentHashMap = new java.util.concurrent.ConcurrentHashMap<Object, Object>();
		globalMap.put("concurrentHashMap", concurrentHashMap);

		long startUsedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
		long endUsedMemory = 0;
		long end = 0;

		startTime = System.currentTimeMillis();

		this.globalResumeTicket = true;// to run tPreJob

		if (enableLogStash) {
			talendJobLog.addJobStartMessage();
			try {
				talendJobLogProcess(globalMap);
			} catch (java.lang.Exception e) {
				e.printStackTrace();
			}
		}

		this.globalResumeTicket = false;// to run others jobs

		try {
			errorCode = null;
			tDBInput_3Process(globalMap);
			if (!"failure".equals(status)) {
				status = "end";
			}
		} catch (TalendException e_tDBInput_3) {
			globalMap.put("tDBInput_3_SUBPROCESS_STATE", -1);

			e_tDBInput_3.printStackTrace();

		}

		this.globalResumeTicket = true;// to run tPostJob

		end = System.currentTimeMillis();

		if (watch) {
			System.out.println((end - startTime) + " milliseconds");
		}

		endUsedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
		if (false) {
			System.out.println((endUsedMemory - startUsedMemory)
					+ " bytes memory increase when running : CHIA_Matching_Distances_2");
		}
		if (enableLogStash) {
			talendJobLog.addJobEndMessage(startTime, end, status);
			try {
				talendJobLogProcess(globalMap);
			} catch (java.lang.Exception e) {
				e.printStackTrace();
			}
		}

		if (execStat) {
			runStat.updateStatOnJob(RunStat.JOBEND, fatherNode);
			runStat.stopThreadStat();
		}
		if (!inOSGi && isCBPClientPresent) {
			if (org.talend.metrics.CBPClient.getInstanceForCurrentVM() != null) {
				s("none");
				org.talend.metrics.CBPClient.getInstanceForCurrentVM().sendData();
			}
		}

		int returnCode = 0;

		if (errorCode == null) {
			returnCode = status != null && status.equals("failure") ? 1 : 0;
		} else {
			returnCode = errorCode.intValue();
		}
		resumeUtil.addLog("JOB_ENDED", "JOB:" + jobName, parent_part_launcher, Thread.currentThread().getId() + "", "",
				"" + returnCode, "", "", "");
		resumeUtil.flush();

		org.slf4j.MDC.remove("_subJobName");
		org.slf4j.MDC.remove("_subJobPid");
		org.slf4j.MDC.remove("_systemPid");
		log.info(
				"TalendJob: 'CHIA_Matching_Distances_2' - Finished - status: " + status + " returnCode: " + returnCode);

		return returnCode;

	}

	// only for OSGi env
	public void destroy() {
		// add CBP code for OSGI Executions
		if (null != taskExecutionId && !taskExecutionId.isEmpty()) {
			try {
				org.talend.metrics.DataReadTracker.setExecutionId(taskExecutionId, jobExecutionId, false);
				org.talend.metrics.DataReadTracker.sealCounter();
				org.talend.metrics.DataReadTracker.reset();
			} catch (Exception | NoClassDefFoundError e) {
				// ignore
			}
		}

	}

	private java.util.Map<String, Object> getSharedConnections4REST() {
		java.util.Map<String, Object> connections = new java.util.HashMap<String, Object>();

		return connections;
	}

	private void evalParam(String arg) {
		if (arg.startsWith("--resuming_logs_dir_path")) {
			resuming_logs_dir_path = arg.substring(25);
		} else if (arg.startsWith("--resuming_checkpoint_path")) {
			resuming_checkpoint_path = arg.substring(27);
		} else if (arg.startsWith("--parent_part_launcher")) {
			parent_part_launcher = arg.substring(23);
		} else if (arg.startsWith("--watch")) {
			watch = true;
		} else if (arg.startsWith("--stat_port=")) {
			String portStatsStr = arg.substring(12);
			if (portStatsStr != null && !portStatsStr.equals("null")) {
				portStats = Integer.parseInt(portStatsStr);
			}
		} else if (arg.startsWith("--trace_port=")) {
			portTraces = Integer.parseInt(arg.substring(13));
		} else if (arg.startsWith("--client_host=")) {
			clientHost = arg.substring(14);
		} else if (arg.startsWith("--context=")) {
			contextStr = arg.substring(10);
			isDefaultContext = false;
		} else if (arg.startsWith("--father_pid=")) {
			fatherPid = arg.substring(13);
		} else if (arg.startsWith("--root_pid=")) {
			rootPid = arg.substring(11);
		} else if (arg.startsWith("--father_node=")) {
			fatherNode = arg.substring(14);
		} else if (arg.startsWith("--pid=")) {
			pid = arg.substring(6);
		} else if (arg.startsWith("--context_type")) {
			String keyValue = arg.substring(15);
			int index = -1;
			if (keyValue != null && (index = keyValue.indexOf('=')) > -1) {
				if (fatherPid == null) {
					context_param.setContextType(keyValue.substring(0, index),
							replaceEscapeChars(keyValue.substring(index + 1)));
				} else { // the subjob won't escape the especial chars
					context_param.setContextType(keyValue.substring(0, index), keyValue.substring(index + 1));
				}

			}

		} else if (arg.startsWith("--context_param")) {
			String keyValue = arg.substring(16);
			int index = -1;
			if (keyValue != null && (index = keyValue.indexOf('=')) > -1) {
				if (fatherPid == null) {
					context_param.put(keyValue.substring(0, index), replaceEscapeChars(keyValue.substring(index + 1)));
				} else { // the subjob won't escape the especial chars
					context_param.put(keyValue.substring(0, index), keyValue.substring(index + 1));
				}
			}
		} else if (arg.startsWith("--context_file")) {
			String keyValue = arg.substring(15);
			String filePath = new String(java.util.Base64.getDecoder().decode(keyValue));
			java.nio.file.Path contextFile = java.nio.file.Paths.get(filePath);
			try (java.io.BufferedReader reader = java.nio.file.Files.newBufferedReader(contextFile)) {
				String line;
				while ((line = reader.readLine()) != null) {
					int index = -1;
					if ((index = line.indexOf('=')) > -1) {
						if (line.startsWith("--context_param")) {
							if ("id_Password".equals(context_param.getContextType(line.substring(16, index)))) {
								context_param.put(line.substring(16, index),
										routines.system.PasswordEncryptUtil.decryptPassword(line.substring(index + 1)));
							} else {
								context_param.put(line.substring(16, index), line.substring(index + 1));
							}
						} else {// --context_type
							context_param.setContextType(line.substring(15, index), line.substring(index + 1));
						}
					}
				}
			} catch (java.io.IOException e) {
				System.err.println("Could not load the context file: " + filePath);
				e.printStackTrace();
			}
		} else if (arg.startsWith("--log4jLevel=")) {
			log4jLevel = arg.substring(13);
		} else if (arg.startsWith("--audit.enabled") && arg.contains("=")) {// for trunjob call
			final int equal = arg.indexOf('=');
			final String key = arg.substring("--".length(), equal);
			System.setProperty(key, arg.substring(equal + 1));
		}
	}

	private static final String NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY = "<TALEND_NULL>";

	private final String[][] escapeChars = { { "\\\\", "\\" }, { "\\n", "\n" }, { "\\'", "\'" }, { "\\r", "\r" },
			{ "\\f", "\f" }, { "\\b", "\b" }, { "\\t", "\t" } };

	private String replaceEscapeChars(String keyValue) {

		if (keyValue == null || ("").equals(keyValue.trim())) {
			return keyValue;
		}

		StringBuilder result = new StringBuilder();
		int currIndex = 0;
		while (currIndex < keyValue.length()) {
			int index = -1;
			// judege if the left string includes escape chars
			for (String[] strArray : escapeChars) {
				index = keyValue.indexOf(strArray[0], currIndex);
				if (index >= 0) {

					result.append(keyValue.substring(currIndex, index + strArray[0].length()).replace(strArray[0],
							strArray[1]));
					currIndex = index + strArray[0].length();
					break;
				}
			}
			// if the left string doesn't include escape chars, append the left into the
			// result
			if (index < 0) {
				result.append(keyValue.substring(currIndex));
				currIndex = currIndex + keyValue.length();
			}
		}

		return result.toString();
	}

	public Integer getErrorCode() {
		return errorCode;
	}

	public String getStatus() {
		return status;
	}

	ResumeUtil resumeUtil = null;
}
/************************************************************************************************
 * 391288 characters generated by Talend Cloud Data Fabric on the July 20, 2025
 * at 6:51:42 PM EDT
 ************************************************************************************************/