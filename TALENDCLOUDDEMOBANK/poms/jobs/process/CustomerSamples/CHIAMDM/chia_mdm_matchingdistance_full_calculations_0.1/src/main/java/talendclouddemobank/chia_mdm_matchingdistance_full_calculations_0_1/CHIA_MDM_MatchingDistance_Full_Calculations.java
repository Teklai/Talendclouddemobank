
package talendclouddemobank.chia_mdm_matchingdistance_full_calculations_0_1;

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
 * Job: CHIA_MDM_MatchingDistance_Full_Calculations Purpose: <br>
 * Description: <br>
 * 
 * @author Teklai, Hailemichael
 * @version 8.0.1.20250704_1436-patch
 * @status
 */
public class CHIA_MDM_MatchingDistance_Full_Calculations implements TalendJob {
	static {
		System.setProperty("TalendJob.log", "CHIA_MDM_MatchingDistance_Full_Calculations.log");
	}

	private static org.apache.logging.log4j.Logger log = org.apache.logging.log4j.LogManager
			.getLogger(CHIA_MDM_MatchingDistance_Full_Calculations.class);

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

			if (MySQL_CRM_Password != null) {

				this.setProperty("MySQL_CRM_Password", MySQL_CRM_Password.toString());

			}

			if (MySQL_CRM_Port != null) {

				this.setProperty("MySQL_CRM_Port", MySQL_CRM_Port.toString());

			}

			if (MySQL_CRM_Server != null) {

				this.setProperty("MySQL_CRM_Server", MySQL_CRM_Server.toString());

			}

			if (MySQL_CRM_Database != null) {

				this.setProperty("MySQL_CRM_Database", MySQL_CRM_Database.toString());

			}

			if (MySQL_CRM_AdditionalParams != null) {

				this.setProperty("MySQL_CRM_AdditionalParams", MySQL_CRM_AdditionalParams.toString());

			}

			if (MySQL_CRM_Login != null) {

				this.setProperty("MySQL_CRM_Login", MySQL_CRM_Login.toString());

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

		public java.lang.String MySQL_CRM_Password;

		public java.lang.String getMySQL_CRM_Password() {
			return this.MySQL_CRM_Password;
		}

		public String MySQL_CRM_Port;

		public String getMySQL_CRM_Port() {
			return this.MySQL_CRM_Port;
		}

		public String MySQL_CRM_Server;

		public String getMySQL_CRM_Server() {
			return this.MySQL_CRM_Server;
		}

		public String MySQL_CRM_Database;

		public String getMySQL_CRM_Database() {
			return this.MySQL_CRM_Database;
		}

		public String MySQL_CRM_AdditionalParams;

		public String getMySQL_CRM_AdditionalParams() {
			return this.MySQL_CRM_AdditionalParams;
		}

		public String MySQL_CRM_Login;

		public String getMySQL_CRM_Login() {
			return this.MySQL_CRM_Login;
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
	private final String jobName = "CHIA_MDM_MatchingDistance_Full_Calculations";
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
			"_Ed-q0Pb3Ee6gXdUuqyUjQQ", "0.1");
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
				CHIA_MDM_MatchingDistance_Full_Calculations.this.exception = e;
			}
			if (!(e instanceof TalendException)) {
				try {
					for (java.lang.reflect.Method m : this.getClass().getEnclosingClass().getMethods()) {
						if (m.getName().compareTo(currentComponent + "_error") == 0) {
							m.invoke(CHIA_MDM_MatchingDistance_Full_Calculations.this,
									new Object[] { e, currentComponent, globalMap });
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

	public void tDBInput_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tRecordMatching_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tMap_2_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap)
			throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tLogRow_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tFileOutputExcel_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tDBInput_3_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tAdvancedHash_Target_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void talendJobLog_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		talendJobLog_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tDBInput_1_onSubJobError(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public void talendJobLog_onSubJobError(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public static class SSNStruct implements routines.system.IPersistableRow<SSNStruct> {
		final static byte[] commonByteArrayLock_TALENDCLOUDDEMOBANK_CHIA_MDM_MatchingDistance_Full_Calculations = new byte[0];
		static byte[] commonByteArray_TALENDCLOUDDEMOBANK_CHIA_MDM_MatchingDistance_Full_Calculations = new byte[0];

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

		public Integer SSNSCORE;

		public Integer getSSNSCORE() {
			return this.SSNSCORE;
		}

		public Boolean SSNSCOREIsNullable() {
			return true;
		}

		public Boolean SSNSCOREIsKey() {
			return false;
		}

		public Integer SSNSCORELength() {
			return null;
		}

		public Integer SSNSCOREPrecision() {
			return null;
		}

		public String SSNSCOREDefault() {

			return null;

		}

		public String SSNSCOREComment() {

			return "";

		}

		public String SSNSCOREPattern() {

			return "";

		}

		public String SSNSCOREOriginalDbColumnName() {

			return "SSNSCORE";

		}

		public Integer DOBSCORE;

		public Integer getDOBSCORE() {
			return this.DOBSCORE;
		}

		public Boolean DOBSCOREIsNullable() {
			return true;
		}

		public Boolean DOBSCOREIsKey() {
			return false;
		}

		public Integer DOBSCORELength() {
			return null;
		}

		public Integer DOBSCOREPrecision() {
			return null;
		}

		public String DOBSCOREDefault() {

			return null;

		}

		public String DOBSCOREComment() {

			return "";

		}

		public String DOBSCOREPattern() {

			return "";

		}

		public String DOBSCOREOriginalDbColumnName() {

			return "DOBSCORE";

		}

		public Integer GENDER_SCORE;

		public Integer getGENDER_SCORE() {
			return this.GENDER_SCORE;
		}

		public Boolean GENDER_SCOREIsNullable() {
			return true;
		}

		public Boolean GENDER_SCOREIsKey() {
			return false;
		}

		public Integer GENDER_SCORELength() {
			return null;
		}

		public Integer GENDER_SCOREPrecision() {
			return null;
		}

		public String GENDER_SCOREDefault() {

			return null;

		}

		public String GENDER_SCOREComment() {

			return "";

		}

		public String GENDER_SCOREPattern() {

			return "";

		}

		public String GENDER_SCOREOriginalDbColumnName() {

			return "GENDER_SCORE";

		}

		public Integer POSTALCODESCORE;

		public Integer getPOSTALCODESCORE() {
			return this.POSTALCODESCORE;
		}

		public Boolean POSTALCODESCOREIsNullable() {
			return true;
		}

		public Boolean POSTALCODESCOREIsKey() {
			return false;
		}

		public Integer POSTALCODESCORELength() {
			return null;
		}

		public Integer POSTALCODESCOREPrecision() {
			return null;
		}

		public String POSTALCODESCOREDefault() {

			return "";

		}

		public String POSTALCODESCOREComment() {

			return "";

		}

		public String POSTALCODESCOREPattern() {

			return "";

		}

		public String POSTALCODESCOREOriginalDbColumnName() {

			return "POSTALCODESCORE";

		}

		public Integer HPLNIDSCORE;

		public Integer getHPLNIDSCORE() {
			return this.HPLNIDSCORE;
		}

		public Boolean HPLNIDSCOREIsNullable() {
			return true;
		}

		public Boolean HPLNIDSCOREIsKey() {
			return false;
		}

		public Integer HPLNIDSCORELength() {
			return null;
		}

		public Integer HPLNIDSCOREPrecision() {
			return null;
		}

		public String HPLNIDSCOREDefault() {

			return null;

		}

		public String HPLNIDSCOREComment() {

			return "";

		}

		public String HPLNIDSCOREPattern() {

			return "";

		}

		public String HPLNIDSCOREOriginalDbColumnName() {

			return "HPLNIDSCORE";

		}

		public Integer FIRSTNAMESCORE;

		public Integer getFIRSTNAMESCORE() {
			return this.FIRSTNAMESCORE;
		}

		public Boolean FIRSTNAMESCOREIsNullable() {
			return true;
		}

		public Boolean FIRSTNAMESCOREIsKey() {
			return false;
		}

		public Integer FIRSTNAMESCORELength() {
			return null;
		}

		public Integer FIRSTNAMESCOREPrecision() {
			return null;
		}

		public String FIRSTNAMESCOREDefault() {

			return null;

		}

		public String FIRSTNAMESCOREComment() {

			return "";

		}

		public String FIRSTNAMESCOREPattern() {

			return "";

		}

		public String FIRSTNAMESCOREOriginalDbColumnName() {

			return "FIRSTNAMESCORE";

		}

		public Integer LASTNAMESCORE;

		public Integer getLASTNAMESCORE() {
			return this.LASTNAMESCORE;
		}

		public Boolean LASTNAMESCOREIsNullable() {
			return true;
		}

		public Boolean LASTNAMESCOREIsKey() {
			return false;
		}

		public Integer LASTNAMESCORELength() {
			return null;
		}

		public Integer LASTNAMESCOREPrecision() {
			return null;
		}

		public String LASTNAMESCOREDefault() {

			return null;

		}

		public String LASTNAMESCOREComment() {

			return "";

		}

		public String LASTNAMESCOREPattern() {

			return "";

		}

		public String LASTNAMESCOREOriginalDbColumnName() {

			return "LASTNAMESCORE";

		}

		public Integer PATIENTADDRESSSCORE;

		public Integer getPATIENTADDRESSSCORE() {
			return this.PATIENTADDRESSSCORE;
		}

		public Boolean PATIENTADDRESSSCOREIsNullable() {
			return true;
		}

		public Boolean PATIENTADDRESSSCOREIsKey() {
			return false;
		}

		public Integer PATIENTADDRESSSCORELength() {
			return null;
		}

		public Integer PATIENTADDRESSSCOREPrecision() {
			return null;
		}

		public String PATIENTADDRESSSCOREDefault() {

			return null;

		}

		public String PATIENTADDRESSSCOREComment() {

			return "";

		}

		public String PATIENTADDRESSSCOREPattern() {

			return "";

		}

		public String PATIENTADDRESSSCOREOriginalDbColumnName() {

			return "PATIENTADDRESSSCORE";

		}

		public Integer SUBTOTAL;

		public Integer getSUBTOTAL() {
			return this.SUBTOTAL;
		}

		public Boolean SUBTOTALIsNullable() {
			return true;
		}

		public Boolean SUBTOTALIsKey() {
			return false;
		}

		public Integer SUBTOTALLength() {
			return null;
		}

		public Integer SUBTOTALPrecision() {
			return null;
		}

		public String SUBTOTALDefault() {

			return null;

		}

		public String SUBTOTALComment() {

			return "";

		}

		public String SUBTOTALPattern() {

			return "";

		}

		public String SUBTOTALOriginalDbColumnName() {

			return "SUBTOTAL";

		}

		public Double TOTALSCORE;

		public Double getTOTALSCORE() {
			return this.TOTALSCORE;
		}

		public Boolean TOTALSCOREIsNullable() {
			return true;
		}

		public Boolean TOTALSCOREIsKey() {
			return false;
		}

		public Integer TOTALSCORELength() {
			return null;
		}

		public Integer TOTALSCOREPrecision() {
			return null;
		}

		public String TOTALSCOREDefault() {

			return null;

		}

		public String TOTALSCOREComment() {

			return "";

		}

		public String TOTALSCOREPattern() {

			return "";

		}

		public String TOTALSCOREOriginalDbColumnName() {

			return "TOTALSCORE";

		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_TALENDCLOUDDEMOBANK_CHIA_MDM_MatchingDistance_Full_Calculations.length) {
					if (length < 1024
							&& commonByteArray_TALENDCLOUDDEMOBANK_CHIA_MDM_MatchingDistance_Full_Calculations.length == 0) {
						commonByteArray_TALENDCLOUDDEMOBANK_CHIA_MDM_MatchingDistance_Full_Calculations = new byte[1024];
					} else {
						commonByteArray_TALENDCLOUDDEMOBANK_CHIA_MDM_MatchingDistance_Full_Calculations = new byte[2
								* length];
					}
				}
				dis.readFully(commonByteArray_TALENDCLOUDDEMOBANK_CHIA_MDM_MatchingDistance_Full_Calculations, 0,
						length);
				strReturn = new String(commonByteArray_TALENDCLOUDDEMOBANK_CHIA_MDM_MatchingDistance_Full_Calculations,
						0, length, utf8Charset);
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
				if (length > commonByteArray_TALENDCLOUDDEMOBANK_CHIA_MDM_MatchingDistance_Full_Calculations.length) {
					if (length < 1024
							&& commonByteArray_TALENDCLOUDDEMOBANK_CHIA_MDM_MatchingDistance_Full_Calculations.length == 0) {
						commonByteArray_TALENDCLOUDDEMOBANK_CHIA_MDM_MatchingDistance_Full_Calculations = new byte[1024];
					} else {
						commonByteArray_TALENDCLOUDDEMOBANK_CHIA_MDM_MatchingDistance_Full_Calculations = new byte[2
								* length];
					}
				}
				unmarshaller.readFully(commonByteArray_TALENDCLOUDDEMOBANK_CHIA_MDM_MatchingDistance_Full_Calculations,
						0, length);
				strReturn = new String(commonByteArray_TALENDCLOUDDEMOBANK_CHIA_MDM_MatchingDistance_Full_Calculations,
						0, length, utf8Charset);
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

			synchronized (commonByteArrayLock_TALENDCLOUDDEMOBANK_CHIA_MDM_MatchingDistance_Full_Calculations) {

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

					this.MATCHINGDISTANCES = readString(dis);

					length = dis.readByte();
					if (length == -1) {
						this.MATCHINGWEIGHT = null;
					} else {
						this.MATCHINGWEIGHT = dis.readDouble();
					}

					this.SSNSCORE = readInteger(dis);

					this.DOBSCORE = readInteger(dis);

					this.GENDER_SCORE = readInteger(dis);

					this.POSTALCODESCORE = readInteger(dis);

					this.HPLNIDSCORE = readInteger(dis);

					this.FIRSTNAMESCORE = readInteger(dis);

					this.LASTNAMESCORE = readInteger(dis);

					this.PATIENTADDRESSSCORE = readInteger(dis);

					this.SUBTOTAL = readInteger(dis);

					length = dis.readByte();
					if (length == -1) {
						this.TOTALSCORE = null;
					} else {
						this.TOTALSCORE = dis.readDouble();
					}

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_TALENDCLOUDDEMOBANK_CHIA_MDM_MatchingDistance_Full_Calculations) {

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

					this.MATCHINGDISTANCES = readString(dis);

					length = dis.readByte();
					if (length == -1) {
						this.MATCHINGWEIGHT = null;
					} else {
						this.MATCHINGWEIGHT = dis.readDouble();
					}

					this.SSNSCORE = readInteger(dis);

					this.DOBSCORE = readInteger(dis);

					this.GENDER_SCORE = readInteger(dis);

					this.POSTALCODESCORE = readInteger(dis);

					this.HPLNIDSCORE = readInteger(dis);

					this.FIRSTNAMESCORE = readInteger(dis);

					this.LASTNAMESCORE = readInteger(dis);

					this.PATIENTADDRESSSCORE = readInteger(dis);

					this.SUBTOTAL = readInteger(dis);

					length = dis.readByte();
					if (length == -1) {
						this.TOTALSCORE = null;
					} else {
						this.TOTALSCORE = dis.readDouble();
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

				writeString(this.MATCHINGDISTANCES, dos);

				// Double

				if (this.MATCHINGWEIGHT == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeDouble(this.MATCHINGWEIGHT);
				}

				// Integer

				writeInteger(this.SSNSCORE, dos);

				// Integer

				writeInteger(this.DOBSCORE, dos);

				// Integer

				writeInteger(this.GENDER_SCORE, dos);

				// Integer

				writeInteger(this.POSTALCODESCORE, dos);

				// Integer

				writeInteger(this.HPLNIDSCORE, dos);

				// Integer

				writeInteger(this.FIRSTNAMESCORE, dos);

				// Integer

				writeInteger(this.LASTNAMESCORE, dos);

				// Integer

				writeInteger(this.PATIENTADDRESSSCORE, dos);

				// Integer

				writeInteger(this.SUBTOTAL, dos);

				// Double

				if (this.TOTALSCORE == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeDouble(this.TOTALSCORE);
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

				writeString(this.MATCHINGDISTANCES, dos);

				// Double

				if (this.MATCHINGWEIGHT == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeDouble(this.MATCHINGWEIGHT);
				}

				// Integer

				writeInteger(this.SSNSCORE, dos);

				// Integer

				writeInteger(this.DOBSCORE, dos);

				// Integer

				writeInteger(this.GENDER_SCORE, dos);

				// Integer

				writeInteger(this.POSTALCODESCORE, dos);

				// Integer

				writeInteger(this.HPLNIDSCORE, dos);

				// Integer

				writeInteger(this.FIRSTNAMESCORE, dos);

				// Integer

				writeInteger(this.LASTNAMESCORE, dos);

				// Integer

				writeInteger(this.PATIENTADDRESSSCORE, dos);

				// Integer

				writeInteger(this.SUBTOTAL, dos);

				// Double

				if (this.TOTALSCORE == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeDouble(this.TOTALSCORE);
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
			sb.append(",MATCHINGDISTANCES=" + MATCHINGDISTANCES);
			sb.append(",MATCHINGWEIGHT=" + String.valueOf(MATCHINGWEIGHT));
			sb.append(",SSNSCORE=" + String.valueOf(SSNSCORE));
			sb.append(",DOBSCORE=" + String.valueOf(DOBSCORE));
			sb.append(",GENDER_SCORE=" + String.valueOf(GENDER_SCORE));
			sb.append(",POSTALCODESCORE=" + String.valueOf(POSTALCODESCORE));
			sb.append(",HPLNIDSCORE=" + String.valueOf(HPLNIDSCORE));
			sb.append(",FIRSTNAMESCORE=" + String.valueOf(FIRSTNAMESCORE));
			sb.append(",LASTNAMESCORE=" + String.valueOf(LASTNAMESCORE));
			sb.append(",PATIENTADDRESSSCORE=" + String.valueOf(PATIENTADDRESSSCORE));
			sb.append(",SUBTOTAL=" + String.valueOf(SUBTOTAL));
			sb.append(",TOTALSCORE=" + String.valueOf(TOTALSCORE));
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

			if (SSNSCORE == null) {
				sb.append("<null>");
			} else {
				sb.append(SSNSCORE);
			}

			sb.append("|");

			if (DOBSCORE == null) {
				sb.append("<null>");
			} else {
				sb.append(DOBSCORE);
			}

			sb.append("|");

			if (GENDER_SCORE == null) {
				sb.append("<null>");
			} else {
				sb.append(GENDER_SCORE);
			}

			sb.append("|");

			if (POSTALCODESCORE == null) {
				sb.append("<null>");
			} else {
				sb.append(POSTALCODESCORE);
			}

			sb.append("|");

			if (HPLNIDSCORE == null) {
				sb.append("<null>");
			} else {
				sb.append(HPLNIDSCORE);
			}

			sb.append("|");

			if (FIRSTNAMESCORE == null) {
				sb.append("<null>");
			} else {
				sb.append(FIRSTNAMESCORE);
			}

			sb.append("|");

			if (LASTNAMESCORE == null) {
				sb.append("<null>");
			} else {
				sb.append(LASTNAMESCORE);
			}

			sb.append("|");

			if (PATIENTADDRESSSCORE == null) {
				sb.append("<null>");
			} else {
				sb.append(PATIENTADDRESSSCORE);
			}

			sb.append("|");

			if (SUBTOTAL == null) {
				sb.append("<null>");
			} else {
				sb.append(SUBTOTAL);
			}

			sb.append("|");

			if (TOTALSCORE == null) {
				sb.append("<null>");
			} else {
				sb.append(TOTALSCORE);
			}

			sb.append("|");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(SSNStruct other) {

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

	public static class PM_OutputStruct implements routines.system.IPersistableRow<PM_OutputStruct> {
		final static byte[] commonByteArrayLock_TALENDCLOUDDEMOBANK_CHIA_MDM_MatchingDistance_Full_Calculations = new byte[0];
		static byte[] commonByteArray_TALENDCLOUDDEMOBANK_CHIA_MDM_MatchingDistance_Full_Calculations = new byte[0];

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

		public Integer SSNSCORE;

		public Integer getSSNSCORE() {
			return this.SSNSCORE;
		}

		public Boolean SSNSCOREIsNullable() {
			return true;
		}

		public Boolean SSNSCOREIsKey() {
			return false;
		}

		public Integer SSNSCORELength() {
			return null;
		}

		public Integer SSNSCOREPrecision() {
			return null;
		}

		public String SSNSCOREDefault() {

			return null;

		}

		public String SSNSCOREComment() {

			return "";

		}

		public String SSNSCOREPattern() {

			return "";

		}

		public String SSNSCOREOriginalDbColumnName() {

			return "SSNSCORE";

		}

		public Integer DOBSCORE;

		public Integer getDOBSCORE() {
			return this.DOBSCORE;
		}

		public Boolean DOBSCOREIsNullable() {
			return true;
		}

		public Boolean DOBSCOREIsKey() {
			return false;
		}

		public Integer DOBSCORELength() {
			return null;
		}

		public Integer DOBSCOREPrecision() {
			return null;
		}

		public String DOBSCOREDefault() {

			return null;

		}

		public String DOBSCOREComment() {

			return "";

		}

		public String DOBSCOREPattern() {

			return "";

		}

		public String DOBSCOREOriginalDbColumnName() {

			return "DOBSCORE";

		}

		public Integer GENDER_SCORE;

		public Integer getGENDER_SCORE() {
			return this.GENDER_SCORE;
		}

		public Boolean GENDER_SCOREIsNullable() {
			return true;
		}

		public Boolean GENDER_SCOREIsKey() {
			return false;
		}

		public Integer GENDER_SCORELength() {
			return null;
		}

		public Integer GENDER_SCOREPrecision() {
			return null;
		}

		public String GENDER_SCOREDefault() {

			return null;

		}

		public String GENDER_SCOREComment() {

			return "";

		}

		public String GENDER_SCOREPattern() {

			return "";

		}

		public String GENDER_SCOREOriginalDbColumnName() {

			return "GENDER_SCORE";

		}

		public Integer POSTALCODESCORE;

		public Integer getPOSTALCODESCORE() {
			return this.POSTALCODESCORE;
		}

		public Boolean POSTALCODESCOREIsNullable() {
			return true;
		}

		public Boolean POSTALCODESCOREIsKey() {
			return false;
		}

		public Integer POSTALCODESCORELength() {
			return null;
		}

		public Integer POSTALCODESCOREPrecision() {
			return null;
		}

		public String POSTALCODESCOREDefault() {

			return "";

		}

		public String POSTALCODESCOREComment() {

			return "";

		}

		public String POSTALCODESCOREPattern() {

			return "";

		}

		public String POSTALCODESCOREOriginalDbColumnName() {

			return "POSTALCODESCORE";

		}

		public Integer HPLNIDSCORE;

		public Integer getHPLNIDSCORE() {
			return this.HPLNIDSCORE;
		}

		public Boolean HPLNIDSCOREIsNullable() {
			return true;
		}

		public Boolean HPLNIDSCOREIsKey() {
			return false;
		}

		public Integer HPLNIDSCORELength() {
			return null;
		}

		public Integer HPLNIDSCOREPrecision() {
			return null;
		}

		public String HPLNIDSCOREDefault() {

			return null;

		}

		public String HPLNIDSCOREComment() {

			return "";

		}

		public String HPLNIDSCOREPattern() {

			return "";

		}

		public String HPLNIDSCOREOriginalDbColumnName() {

			return "HPLNIDSCORE";

		}

		public Integer FIRSTNAMESCORE;

		public Integer getFIRSTNAMESCORE() {
			return this.FIRSTNAMESCORE;
		}

		public Boolean FIRSTNAMESCOREIsNullable() {
			return true;
		}

		public Boolean FIRSTNAMESCOREIsKey() {
			return false;
		}

		public Integer FIRSTNAMESCORELength() {
			return null;
		}

		public Integer FIRSTNAMESCOREPrecision() {
			return null;
		}

		public String FIRSTNAMESCOREDefault() {

			return null;

		}

		public String FIRSTNAMESCOREComment() {

			return "";

		}

		public String FIRSTNAMESCOREPattern() {

			return "";

		}

		public String FIRSTNAMESCOREOriginalDbColumnName() {

			return "FIRSTNAMESCORE";

		}

		public Integer LASTNAMESCORE;

		public Integer getLASTNAMESCORE() {
			return this.LASTNAMESCORE;
		}

		public Boolean LASTNAMESCOREIsNullable() {
			return true;
		}

		public Boolean LASTNAMESCOREIsKey() {
			return false;
		}

		public Integer LASTNAMESCORELength() {
			return null;
		}

		public Integer LASTNAMESCOREPrecision() {
			return null;
		}

		public String LASTNAMESCOREDefault() {

			return null;

		}

		public String LASTNAMESCOREComment() {

			return "";

		}

		public String LASTNAMESCOREPattern() {

			return "";

		}

		public String LASTNAMESCOREOriginalDbColumnName() {

			return "LASTNAMESCORE";

		}

		public Integer PATIENTADDRESSSCORE;

		public Integer getPATIENTADDRESSSCORE() {
			return this.PATIENTADDRESSSCORE;
		}

		public Boolean PATIENTADDRESSSCOREIsNullable() {
			return true;
		}

		public Boolean PATIENTADDRESSSCOREIsKey() {
			return false;
		}

		public Integer PATIENTADDRESSSCORELength() {
			return null;
		}

		public Integer PATIENTADDRESSSCOREPrecision() {
			return null;
		}

		public String PATIENTADDRESSSCOREDefault() {

			return null;

		}

		public String PATIENTADDRESSSCOREComment() {

			return "";

		}

		public String PATIENTADDRESSSCOREPattern() {

			return "";

		}

		public String PATIENTADDRESSSCOREOriginalDbColumnName() {

			return "PATIENTADDRESSSCORE";

		}

		public Integer SUBTOTAL;

		public Integer getSUBTOTAL() {
			return this.SUBTOTAL;
		}

		public Boolean SUBTOTALIsNullable() {
			return true;
		}

		public Boolean SUBTOTALIsKey() {
			return false;
		}

		public Integer SUBTOTALLength() {
			return null;
		}

		public Integer SUBTOTALPrecision() {
			return null;
		}

		public String SUBTOTALDefault() {

			return null;

		}

		public String SUBTOTALComment() {

			return "";

		}

		public String SUBTOTALPattern() {

			return "";

		}

		public String SUBTOTALOriginalDbColumnName() {

			return "SUBTOTAL";

		}

		public Double TOTALSCORE;

		public Double getTOTALSCORE() {
			return this.TOTALSCORE;
		}

		public Boolean TOTALSCOREIsNullable() {
			return true;
		}

		public Boolean TOTALSCOREIsKey() {
			return false;
		}

		public Integer TOTALSCORELength() {
			return null;
		}

		public Integer TOTALSCOREPrecision() {
			return null;
		}

		public String TOTALSCOREDefault() {

			return null;

		}

		public String TOTALSCOREComment() {

			return "";

		}

		public String TOTALSCOREPattern() {

			return "";

		}

		public String TOTALSCOREOriginalDbColumnName() {

			return "TOTALSCORE";

		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_TALENDCLOUDDEMOBANK_CHIA_MDM_MatchingDistance_Full_Calculations.length) {
					if (length < 1024
							&& commonByteArray_TALENDCLOUDDEMOBANK_CHIA_MDM_MatchingDistance_Full_Calculations.length == 0) {
						commonByteArray_TALENDCLOUDDEMOBANK_CHIA_MDM_MatchingDistance_Full_Calculations = new byte[1024];
					} else {
						commonByteArray_TALENDCLOUDDEMOBANK_CHIA_MDM_MatchingDistance_Full_Calculations = new byte[2
								* length];
					}
				}
				dis.readFully(commonByteArray_TALENDCLOUDDEMOBANK_CHIA_MDM_MatchingDistance_Full_Calculations, 0,
						length);
				strReturn = new String(commonByteArray_TALENDCLOUDDEMOBANK_CHIA_MDM_MatchingDistance_Full_Calculations,
						0, length, utf8Charset);
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
				if (length > commonByteArray_TALENDCLOUDDEMOBANK_CHIA_MDM_MatchingDistance_Full_Calculations.length) {
					if (length < 1024
							&& commonByteArray_TALENDCLOUDDEMOBANK_CHIA_MDM_MatchingDistance_Full_Calculations.length == 0) {
						commonByteArray_TALENDCLOUDDEMOBANK_CHIA_MDM_MatchingDistance_Full_Calculations = new byte[1024];
					} else {
						commonByteArray_TALENDCLOUDDEMOBANK_CHIA_MDM_MatchingDistance_Full_Calculations = new byte[2
								* length];
					}
				}
				unmarshaller.readFully(commonByteArray_TALENDCLOUDDEMOBANK_CHIA_MDM_MatchingDistance_Full_Calculations,
						0, length);
				strReturn = new String(commonByteArray_TALENDCLOUDDEMOBANK_CHIA_MDM_MatchingDistance_Full_Calculations,
						0, length, utf8Charset);
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

			synchronized (commonByteArrayLock_TALENDCLOUDDEMOBANK_CHIA_MDM_MatchingDistance_Full_Calculations) {

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

					this.MATCHINGDISTANCES = readString(dis);

					length = dis.readByte();
					if (length == -1) {
						this.MATCHINGWEIGHT = null;
					} else {
						this.MATCHINGWEIGHT = dis.readDouble();
					}

					this.SSNSCORE = readInteger(dis);

					this.DOBSCORE = readInteger(dis);

					this.GENDER_SCORE = readInteger(dis);

					this.POSTALCODESCORE = readInteger(dis);

					this.HPLNIDSCORE = readInteger(dis);

					this.FIRSTNAMESCORE = readInteger(dis);

					this.LASTNAMESCORE = readInteger(dis);

					this.PATIENTADDRESSSCORE = readInteger(dis);

					this.SUBTOTAL = readInteger(dis);

					length = dis.readByte();
					if (length == -1) {
						this.TOTALSCORE = null;
					} else {
						this.TOTALSCORE = dis.readDouble();
					}

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_TALENDCLOUDDEMOBANK_CHIA_MDM_MatchingDistance_Full_Calculations) {

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

					this.MATCHINGDISTANCES = readString(dis);

					length = dis.readByte();
					if (length == -1) {
						this.MATCHINGWEIGHT = null;
					} else {
						this.MATCHINGWEIGHT = dis.readDouble();
					}

					this.SSNSCORE = readInteger(dis);

					this.DOBSCORE = readInteger(dis);

					this.GENDER_SCORE = readInteger(dis);

					this.POSTALCODESCORE = readInteger(dis);

					this.HPLNIDSCORE = readInteger(dis);

					this.FIRSTNAMESCORE = readInteger(dis);

					this.LASTNAMESCORE = readInteger(dis);

					this.PATIENTADDRESSSCORE = readInteger(dis);

					this.SUBTOTAL = readInteger(dis);

					length = dis.readByte();
					if (length == -1) {
						this.TOTALSCORE = null;
					} else {
						this.TOTALSCORE = dis.readDouble();
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

				writeString(this.MATCHINGDISTANCES, dos);

				// Double

				if (this.MATCHINGWEIGHT == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeDouble(this.MATCHINGWEIGHT);
				}

				// Integer

				writeInteger(this.SSNSCORE, dos);

				// Integer

				writeInteger(this.DOBSCORE, dos);

				// Integer

				writeInteger(this.GENDER_SCORE, dos);

				// Integer

				writeInteger(this.POSTALCODESCORE, dos);

				// Integer

				writeInteger(this.HPLNIDSCORE, dos);

				// Integer

				writeInteger(this.FIRSTNAMESCORE, dos);

				// Integer

				writeInteger(this.LASTNAMESCORE, dos);

				// Integer

				writeInteger(this.PATIENTADDRESSSCORE, dos);

				// Integer

				writeInteger(this.SUBTOTAL, dos);

				// Double

				if (this.TOTALSCORE == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeDouble(this.TOTALSCORE);
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

				writeString(this.MATCHINGDISTANCES, dos);

				// Double

				if (this.MATCHINGWEIGHT == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeDouble(this.MATCHINGWEIGHT);
				}

				// Integer

				writeInteger(this.SSNSCORE, dos);

				// Integer

				writeInteger(this.DOBSCORE, dos);

				// Integer

				writeInteger(this.GENDER_SCORE, dos);

				// Integer

				writeInteger(this.POSTALCODESCORE, dos);

				// Integer

				writeInteger(this.HPLNIDSCORE, dos);

				// Integer

				writeInteger(this.FIRSTNAMESCORE, dos);

				// Integer

				writeInteger(this.LASTNAMESCORE, dos);

				// Integer

				writeInteger(this.PATIENTADDRESSSCORE, dos);

				// Integer

				writeInteger(this.SUBTOTAL, dos);

				// Double

				if (this.TOTALSCORE == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeDouble(this.TOTALSCORE);
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
			sb.append(",MATCHINGDISTANCES=" + MATCHINGDISTANCES);
			sb.append(",MATCHINGWEIGHT=" + String.valueOf(MATCHINGWEIGHT));
			sb.append(",SSNSCORE=" + String.valueOf(SSNSCORE));
			sb.append(",DOBSCORE=" + String.valueOf(DOBSCORE));
			sb.append(",GENDER_SCORE=" + String.valueOf(GENDER_SCORE));
			sb.append(",POSTALCODESCORE=" + String.valueOf(POSTALCODESCORE));
			sb.append(",HPLNIDSCORE=" + String.valueOf(HPLNIDSCORE));
			sb.append(",FIRSTNAMESCORE=" + String.valueOf(FIRSTNAMESCORE));
			sb.append(",LASTNAMESCORE=" + String.valueOf(LASTNAMESCORE));
			sb.append(",PATIENTADDRESSSCORE=" + String.valueOf(PATIENTADDRESSSCORE));
			sb.append(",SUBTOTAL=" + String.valueOf(SUBTOTAL));
			sb.append(",TOTALSCORE=" + String.valueOf(TOTALSCORE));
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

			if (SSNSCORE == null) {
				sb.append("<null>");
			} else {
				sb.append(SSNSCORE);
			}

			sb.append("|");

			if (DOBSCORE == null) {
				sb.append("<null>");
			} else {
				sb.append(DOBSCORE);
			}

			sb.append("|");

			if (GENDER_SCORE == null) {
				sb.append("<null>");
			} else {
				sb.append(GENDER_SCORE);
			}

			sb.append("|");

			if (POSTALCODESCORE == null) {
				sb.append("<null>");
			} else {
				sb.append(POSTALCODESCORE);
			}

			sb.append("|");

			if (HPLNIDSCORE == null) {
				sb.append("<null>");
			} else {
				sb.append(HPLNIDSCORE);
			}

			sb.append("|");

			if (FIRSTNAMESCORE == null) {
				sb.append("<null>");
			} else {
				sb.append(FIRSTNAMESCORE);
			}

			sb.append("|");

			if (LASTNAMESCORE == null) {
				sb.append("<null>");
			} else {
				sb.append(LASTNAMESCORE);
			}

			sb.append("|");

			if (PATIENTADDRESSSCORE == null) {
				sb.append("<null>");
			} else {
				sb.append(PATIENTADDRESSSCORE);
			}

			sb.append("|");

			if (SUBTOTAL == null) {
				sb.append("<null>");
			} else {
				sb.append(SUBTOTAL);
			}

			sb.append("|");

			if (TOTALSCORE == null) {
				sb.append("<null>");
			} else {
				sb.append(TOTALSCORE);
			}

			sb.append("|");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(PM_OutputStruct other) {

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

	public static class PMStruct implements routines.system.IPersistableRow<PMStruct> {
		final static byte[] commonByteArrayLock_TALENDCLOUDDEMOBANK_CHIA_MDM_MatchingDistance_Full_Calculations = new byte[0];
		static byte[] commonByteArray_TALENDCLOUDDEMOBANK_CHIA_MDM_MatchingDistance_Full_Calculations = new byte[0];

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

			return "yyyy-MM-dd";

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
				if (length > commonByteArray_TALENDCLOUDDEMOBANK_CHIA_MDM_MatchingDistance_Full_Calculations.length) {
					if (length < 1024
							&& commonByteArray_TALENDCLOUDDEMOBANK_CHIA_MDM_MatchingDistance_Full_Calculations.length == 0) {
						commonByteArray_TALENDCLOUDDEMOBANK_CHIA_MDM_MatchingDistance_Full_Calculations = new byte[1024];
					} else {
						commonByteArray_TALENDCLOUDDEMOBANK_CHIA_MDM_MatchingDistance_Full_Calculations = new byte[2
								* length];
					}
				}
				dis.readFully(commonByteArray_TALENDCLOUDDEMOBANK_CHIA_MDM_MatchingDistance_Full_Calculations, 0,
						length);
				strReturn = new String(commonByteArray_TALENDCLOUDDEMOBANK_CHIA_MDM_MatchingDistance_Full_Calculations,
						0, length, utf8Charset);
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
				if (length > commonByteArray_TALENDCLOUDDEMOBANK_CHIA_MDM_MatchingDistance_Full_Calculations.length) {
					if (length < 1024
							&& commonByteArray_TALENDCLOUDDEMOBANK_CHIA_MDM_MatchingDistance_Full_Calculations.length == 0) {
						commonByteArray_TALENDCLOUDDEMOBANK_CHIA_MDM_MatchingDistance_Full_Calculations = new byte[1024];
					} else {
						commonByteArray_TALENDCLOUDDEMOBANK_CHIA_MDM_MatchingDistance_Full_Calculations = new byte[2
								* length];
					}
				}
				unmarshaller.readFully(commonByteArray_TALENDCLOUDDEMOBANK_CHIA_MDM_MatchingDistance_Full_Calculations,
						0, length);
				strReturn = new String(commonByteArray_TALENDCLOUDDEMOBANK_CHIA_MDM_MatchingDistance_Full_Calculations,
						0, length, utf8Charset);
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

			synchronized (commonByteArrayLock_TALENDCLOUDDEMOBANK_CHIA_MDM_MatchingDistance_Full_Calculations) {

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

			synchronized (commonByteArrayLock_TALENDCLOUDDEMOBANK_CHIA_MDM_MatchingDistance_Full_Calculations) {

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
		public int compareTo(PMStruct other) {

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

	public static class row1Struct implements routines.system.IPersistableRow<row1Struct> {
		final static byte[] commonByteArrayLock_TALENDCLOUDDEMOBANK_CHIA_MDM_MatchingDistance_Full_Calculations = new byte[0];
		static byte[] commonByteArray_TALENDCLOUDDEMOBANK_CHIA_MDM_MatchingDistance_Full_Calculations = new byte[0];

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
				if (length > commonByteArray_TALENDCLOUDDEMOBANK_CHIA_MDM_MatchingDistance_Full_Calculations.length) {
					if (length < 1024
							&& commonByteArray_TALENDCLOUDDEMOBANK_CHIA_MDM_MatchingDistance_Full_Calculations.length == 0) {
						commonByteArray_TALENDCLOUDDEMOBANK_CHIA_MDM_MatchingDistance_Full_Calculations = new byte[1024];
					} else {
						commonByteArray_TALENDCLOUDDEMOBANK_CHIA_MDM_MatchingDistance_Full_Calculations = new byte[2
								* length];
					}
				}
				dis.readFully(commonByteArray_TALENDCLOUDDEMOBANK_CHIA_MDM_MatchingDistance_Full_Calculations, 0,
						length);
				strReturn = new String(commonByteArray_TALENDCLOUDDEMOBANK_CHIA_MDM_MatchingDistance_Full_Calculations,
						0, length, utf8Charset);
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
				if (length > commonByteArray_TALENDCLOUDDEMOBANK_CHIA_MDM_MatchingDistance_Full_Calculations.length) {
					if (length < 1024
							&& commonByteArray_TALENDCLOUDDEMOBANK_CHIA_MDM_MatchingDistance_Full_Calculations.length == 0) {
						commonByteArray_TALENDCLOUDDEMOBANK_CHIA_MDM_MatchingDistance_Full_Calculations = new byte[1024];
					} else {
						commonByteArray_TALENDCLOUDDEMOBANK_CHIA_MDM_MatchingDistance_Full_Calculations = new byte[2
								* length];
					}
				}
				unmarshaller.readFully(commonByteArray_TALENDCLOUDDEMOBANK_CHIA_MDM_MatchingDistance_Full_Calculations,
						0, length);
				strReturn = new String(commonByteArray_TALENDCLOUDDEMOBANK_CHIA_MDM_MatchingDistance_Full_Calculations,
						0, length, utf8Charset);
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

			synchronized (commonByteArrayLock_TALENDCLOUDDEMOBANK_CHIA_MDM_MatchingDistance_Full_Calculations) {

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

			synchronized (commonByteArrayLock_TALENDCLOUDDEMOBANK_CHIA_MDM_MatchingDistance_Full_Calculations) {

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
		public int compareTo(row1Struct other) {

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

	public static class after_tDBInput_1Struct implements routines.system.IPersistableRow<after_tDBInput_1Struct> {
		final static byte[] commonByteArrayLock_TALENDCLOUDDEMOBANK_CHIA_MDM_MatchingDistance_Full_Calculations = new byte[0];
		static byte[] commonByteArray_TALENDCLOUDDEMOBANK_CHIA_MDM_MatchingDistance_Full_Calculations = new byte[0];

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
				if (length > commonByteArray_TALENDCLOUDDEMOBANK_CHIA_MDM_MatchingDistance_Full_Calculations.length) {
					if (length < 1024
							&& commonByteArray_TALENDCLOUDDEMOBANK_CHIA_MDM_MatchingDistance_Full_Calculations.length == 0) {
						commonByteArray_TALENDCLOUDDEMOBANK_CHIA_MDM_MatchingDistance_Full_Calculations = new byte[1024];
					} else {
						commonByteArray_TALENDCLOUDDEMOBANK_CHIA_MDM_MatchingDistance_Full_Calculations = new byte[2
								* length];
					}
				}
				dis.readFully(commonByteArray_TALENDCLOUDDEMOBANK_CHIA_MDM_MatchingDistance_Full_Calculations, 0,
						length);
				strReturn = new String(commonByteArray_TALENDCLOUDDEMOBANK_CHIA_MDM_MatchingDistance_Full_Calculations,
						0, length, utf8Charset);
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
				if (length > commonByteArray_TALENDCLOUDDEMOBANK_CHIA_MDM_MatchingDistance_Full_Calculations.length) {
					if (length < 1024
							&& commonByteArray_TALENDCLOUDDEMOBANK_CHIA_MDM_MatchingDistance_Full_Calculations.length == 0) {
						commonByteArray_TALENDCLOUDDEMOBANK_CHIA_MDM_MatchingDistance_Full_Calculations = new byte[1024];
					} else {
						commonByteArray_TALENDCLOUDDEMOBANK_CHIA_MDM_MatchingDistance_Full_Calculations = new byte[2
								* length];
					}
				}
				unmarshaller.readFully(commonByteArray_TALENDCLOUDDEMOBANK_CHIA_MDM_MatchingDistance_Full_Calculations,
						0, length);
				strReturn = new String(commonByteArray_TALENDCLOUDDEMOBANK_CHIA_MDM_MatchingDistance_Full_Calculations,
						0, length, utf8Charset);
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

			synchronized (commonByteArrayLock_TALENDCLOUDDEMOBANK_CHIA_MDM_MatchingDistance_Full_Calculations) {

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

			synchronized (commonByteArrayLock_TALENDCLOUDDEMOBANK_CHIA_MDM_MatchingDistance_Full_Calculations) {

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
		public int compareTo(after_tDBInput_1Struct other) {

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

	public void tDBInput_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("tDBInput_1_SUBPROCESS_STATE", 0);

		final boolean execStat = this.execStat;

		mdc("tDBInput_1", "6rEtdq_");

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

				tDBInput_3Process(globalMap);

				row1Struct row1 = new row1Struct();
				PMStruct PM = new PMStruct();
				PM_OutputStruct PM_Output = new PM_OutputStruct();
				PM_OutputStruct SSN = PM_Output;

				/**
				 * [tFileOutputExcel_1 begin ] start
				 */

				sh("tFileOutputExcel_1");

				s(currentComponent = "tFileOutputExcel_1");

				cLabel = "<b>CHIA MDM SCORING</b>";

				runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, 0, 0, "SSN");

				int tos_count_tFileOutputExcel_1 = 0;

				if (log.isDebugEnabled())
					log.debug("tFileOutputExcel_1 - " + ("Start to work."));
				if (log.isDebugEnabled()) {
					class BytesLimit65535_tFileOutputExcel_1 {
						public void limitLog4jByte() throws Exception {
							StringBuilder log4jParamters_tFileOutputExcel_1 = new StringBuilder();
							log4jParamters_tFileOutputExcel_1.append("Parameters:");
							log4jParamters_tFileOutputExcel_1.append("VERSION_2007" + " = " + "true");
							log4jParamters_tFileOutputExcel_1.append(" | ");
							log4jParamters_tFileOutputExcel_1.append("USESTREAM" + " = " + "false");
							log4jParamters_tFileOutputExcel_1.append(" | ");
							log4jParamters_tFileOutputExcel_1.append("FILENAME" + " = "
									+ "\"C:/Users/hteklai/Desktop/SE/DataOutPut/CHIAMDMScoring/ChiaMDMScoring.xlsx\"");
							log4jParamters_tFileOutputExcel_1.append(" | ");
							log4jParamters_tFileOutputExcel_1.append("SHEETNAME" + " = " + "\"CHIA_MDM_SCORING\"");
							log4jParamters_tFileOutputExcel_1.append(" | ");
							log4jParamters_tFileOutputExcel_1.append("INCLUDEHEADER" + " = " + "true");
							log4jParamters_tFileOutputExcel_1.append(" | ");
							log4jParamters_tFileOutputExcel_1.append("APPEND_FILE" + " = " + "false");
							log4jParamters_tFileOutputExcel_1.append(" | ");
							log4jParamters_tFileOutputExcel_1.append("FIRST_CELL_Y_ABSOLUTE" + " = " + "false");
							log4jParamters_tFileOutputExcel_1.append(" | ");
							log4jParamters_tFileOutputExcel_1.append("FONT" + " = " + "");
							log4jParamters_tFileOutputExcel_1.append(" | ");
							log4jParamters_tFileOutputExcel_1.append("IS_ALL_AUTO_SZIE" + " = " + "false");
							log4jParamters_tFileOutputExcel_1.append(" | ");
							log4jParamters_tFileOutputExcel_1.append("AUTO_SZIE_SETTING" + " = " + "[{IS_AUTO_SIZE="
									+ ("false") + ", SCHEMA_COLUMN=" + ("FirstName") + "}, {IS_AUTO_SIZE=" + ("false")
									+ ", SCHEMA_COLUMN=" + ("LastName") + "}, {IS_AUTO_SIZE=" + ("false")
									+ ", SCHEMA_COLUMN=" + ("Gender") + "}, {IS_AUTO_SIZE=" + ("false")
									+ ", SCHEMA_COLUMN=" + ("PatientAddress") + "}, {IS_AUTO_SIZE=" + ("false")
									+ ", SCHEMA_COLUMN=" + ("City") + "}, {IS_AUTO_SIZE=" + ("false")
									+ ", SCHEMA_COLUMN=" + ("State") + "}, {IS_AUTO_SIZE=" + ("false")
									+ ", SCHEMA_COLUMN=" + ("PostalCode") + "}, {IS_AUTO_SIZE=" + ("false")
									+ ", SCHEMA_COLUMN=" + ("Birthday") + "}, {IS_AUTO_SIZE=" + ("false")
									+ ", SCHEMA_COLUMN=" + ("SSN") + "}, {IS_AUTO_SIZE=" + ("false")
									+ ", SCHEMA_COLUMN=" + ("HPLNID") + "}, {IS_AUTO_SIZE=" + ("false")
									+ ", SCHEMA_COLUMN=" + ("NYSIISFirstName") + "}, {IS_AUTO_SIZE=" + ("false")
									+ ", SCHEMA_COLUMN=" + ("NYSIISLastName") + "}, {IS_AUTO_SIZE=" + ("false")
									+ ", SCHEMA_COLUMN=" + ("HealthPlanID") + "}, {IS_AUTO_SIZE=" + ("false")
									+ ", SCHEMA_COLUMN=" + ("MRN") + "}, {IS_AUTO_SIZE=" + ("false")
									+ ", SCHEMA_COLUMN=" + ("TargetFirstName") + "}, {IS_AUTO_SIZE=" + ("false")
									+ ", SCHEMA_COLUMN=" + ("TargetLastName") + "}, {IS_AUTO_SIZE=" + ("false")
									+ ", SCHEMA_COLUMN=" + ("TargetGender") + "}, {IS_AUTO_SIZE=" + ("false")
									+ ", SCHEMA_COLUMN=" + ("TargetPatientAddress") + "}, {IS_AUTO_SIZE=" + ("false")
									+ ", SCHEMA_COLUMN=" + ("TargetCity") + "}, {IS_AUTO_SIZE=" + ("false")
									+ ", SCHEMA_COLUMN=" + ("TargetState") + "}, {IS_AUTO_SIZE=" + ("false")
									+ ", SCHEMA_COLUMN=" + ("TargetPostalCode") + "}, {IS_AUTO_SIZE=" + ("false")
									+ ", SCHEMA_COLUMN=" + ("TargetBirthday") + "}, {IS_AUTO_SIZE=" + ("false")
									+ ", SCHEMA_COLUMN=" + ("TargetSSN") + "}, {IS_AUTO_SIZE=" + ("false")
									+ ", SCHEMA_COLUMN=" + ("TargetHPLNID") + "}, {IS_AUTO_SIZE=" + ("false")
									+ ", SCHEMA_COLUMN=" + ("TargetNYSIISFirstName") + "}, {IS_AUTO_SIZE=" + ("false")
									+ ", SCHEMA_COLUMN=" + ("TargetNYSIISLastName") + "}, {IS_AUTO_SIZE=" + ("false")
									+ ", SCHEMA_COLUMN=" + ("TargetHealthPlanID") + "}, {IS_AUTO_SIZE=" + ("false")
									+ ", SCHEMA_COLUMN=" + ("TargetMRN") + "}, {IS_AUTO_SIZE=" + ("false")
									+ ", SCHEMA_COLUMN=" + ("SSNBlockingKey") + "}, {IS_AUTO_SIZE=" + ("false")
									+ ", SCHEMA_COLUMN=" + ("FNDOBBlockingKey") + "}, {IS_AUTO_SIZE=" + ("false")
									+ ", SCHEMA_COLUMN=" + ("LNPCBlockingKey") + "}, {IS_AUTO_SIZE=" + ("false")
									+ ", SCHEMA_COLUMN=" + ("NYSIISFNLNBlockingKey") + "}, {IS_AUTO_SIZE=" + ("false")
									+ ", SCHEMA_COLUMN=" + ("DOBPCBlockingKey") + "}, {IS_AUTO_SIZE=" + ("false")
									+ ", SCHEMA_COLUMN=" + ("MRNBlockingKey") + "}, {IS_AUTO_SIZE=" + ("false")
									+ ", SCHEMA_COLUMN=" + ("HealthPlanIDBlockingKey") + "}, {IS_AUTO_SIZE=" + ("false")
									+ ", SCHEMA_COLUMN=" + ("MATCHINGDISTANCES") + "}, {IS_AUTO_SIZE=" + ("false")
									+ ", SCHEMA_COLUMN=" + ("MATCHINGWEIGHT") + "}, {IS_AUTO_SIZE=" + ("false")
									+ ", SCHEMA_COLUMN=" + ("SSNSCORE") + "}, {IS_AUTO_SIZE=" + ("false")
									+ ", SCHEMA_COLUMN=" + ("DOBSCORE") + "}, {IS_AUTO_SIZE=" + ("false")
									+ ", SCHEMA_COLUMN=" + ("GENDER_SCORE") + "}, {IS_AUTO_SIZE=" + ("false")
									+ ", SCHEMA_COLUMN=" + ("POSTALCODESCORE") + "}, {IS_AUTO_SIZE=" + ("false")
									+ ", SCHEMA_COLUMN=" + ("HPLNIDSCORE") + "}, {IS_AUTO_SIZE=" + ("false")
									+ ", SCHEMA_COLUMN=" + ("FIRSTNAMESCORE") + "}, {IS_AUTO_SIZE=" + ("false")
									+ ", SCHEMA_COLUMN=" + ("LASTNAMESCORE") + "}, {IS_AUTO_SIZE=" + ("false")
									+ ", SCHEMA_COLUMN=" + ("PATIENTADDRESSSCORE") + "}, {IS_AUTO_SIZE=" + ("false")
									+ ", SCHEMA_COLUMN=" + ("SUBTOTAL") + "}, {IS_AUTO_SIZE=" + ("false")
									+ ", SCHEMA_COLUMN=" + ("TOTALSCORE") + "}]");
							log4jParamters_tFileOutputExcel_1.append(" | ");
							log4jParamters_tFileOutputExcel_1.append("PROTECT_FILE" + " = " + "false");
							log4jParamters_tFileOutputExcel_1.append(" | ");
							log4jParamters_tFileOutputExcel_1.append("CREATE" + " = " + "true");
							log4jParamters_tFileOutputExcel_1.append(" | ");
							log4jParamters_tFileOutputExcel_1.append("FLUSHONROW" + " = " + "false");
							log4jParamters_tFileOutputExcel_1.append(" | ");
							log4jParamters_tFileOutputExcel_1.append("ADVANCED_SEPARATOR" + " = " + "false");
							log4jParamters_tFileOutputExcel_1.append(" | ");
							log4jParamters_tFileOutputExcel_1.append("TRUNCATE_EXCEEDING_CHARACTERS" + " = " + "false");
							log4jParamters_tFileOutputExcel_1.append(" | ");
							log4jParamters_tFileOutputExcel_1.append("ENCODING" + " = " + "\"ISO-8859-15\"");
							log4jParamters_tFileOutputExcel_1.append(" | ");
							log4jParamters_tFileOutputExcel_1.append("DELETE_EMPTYFILE" + " = " + "false");
							log4jParamters_tFileOutputExcel_1.append(" | ");
							log4jParamters_tFileOutputExcel_1.append("USE_SHARED_STRINGS_TABLE" + " = " + "false");
							log4jParamters_tFileOutputExcel_1.append(" | ");
							if (log.isDebugEnabled())
								log.debug("tFileOutputExcel_1 - " + (log4jParamters_tFileOutputExcel_1));
						}
					}
					new BytesLimit65535_tFileOutputExcel_1().limitLog4jByte();
				}
				if (enableLogStash) {
					talendJobLog.addCM("tFileOutputExcel_1", "<b>CHIA MDM SCORING</b>", "tFileOutputExcel");
					talendJobLogProcess(globalMap);
					s(currentComponent);
				}

				int columnIndex_tFileOutputExcel_1 = 0;
				boolean headerIsInserted_tFileOutputExcel_1 = false;

				String fileName_tFileOutputExcel_1 = "C:/Users/hteklai/Desktop/SE/DataOutPut/CHIAMDMScoring/ChiaMDMScoring.xlsx";
				int nb_line_tFileOutputExcel_1 = 0;
				org.talend.ExcelTool xlsxTool_tFileOutputExcel_1 = new org.talend.ExcelTool();
				xlsxTool_tFileOutputExcel_1.setUseSharedStringTable(false);

				xlsxTool_tFileOutputExcel_1.setTruncateExceedingCharacters(false);
				xlsxTool_tFileOutputExcel_1.setSheet("CHIA_MDM_SCORING");
				xlsxTool_tFileOutputExcel_1.setAppend(false, false, false);
				xlsxTool_tFileOutputExcel_1.setRecalculateFormula(false);
				xlsxTool_tFileOutputExcel_1.setXY(false, 0, 0, false);

				java.util.concurrent.ConcurrentHashMap<java.lang.Object, java.lang.Object> chm_tFileOutputExcel_1 = (java.util.concurrent.ConcurrentHashMap<java.lang.Object, java.lang.Object>) globalMap
						.get("concurrentHashMap");
				java.lang.Object lockObj_tFileOutputExcel_1 = chm_tFileOutputExcel_1
						.computeIfAbsent("EXCEL_OUTPUT_LOCK_OBJ_tFileOutputExcel_1", k -> new Object());
				synchronized (lockObj_tFileOutputExcel_1) {

					xlsxTool_tFileOutputExcel_1.prepareXlsxFile(fileName_tFileOutputExcel_1);

				}

				xlsxTool_tFileOutputExcel_1.setFont("");

				if (xlsxTool_tFileOutputExcel_1.getStartRow() == 0) {

					xlsxTool_tFileOutputExcel_1.addRow();

					xlsxTool_tFileOutputExcel_1.addCellValue("FirstName");

					xlsxTool_tFileOutputExcel_1.addCellValue("LastName");

					xlsxTool_tFileOutputExcel_1.addCellValue("Gender");

					xlsxTool_tFileOutputExcel_1.addCellValue("PatientAddress");

					xlsxTool_tFileOutputExcel_1.addCellValue("City");

					xlsxTool_tFileOutputExcel_1.addCellValue("State");

					xlsxTool_tFileOutputExcel_1.addCellValue("PostalCode");

					xlsxTool_tFileOutputExcel_1.addCellValue("Birthday");

					xlsxTool_tFileOutputExcel_1.addCellValue("SSN");

					xlsxTool_tFileOutputExcel_1.addCellValue("HPLNID");

					xlsxTool_tFileOutputExcel_1.addCellValue("NYSIISFirstName");

					xlsxTool_tFileOutputExcel_1.addCellValue("NYSIISLastName");

					xlsxTool_tFileOutputExcel_1.addCellValue("HealthPlanID");

					xlsxTool_tFileOutputExcel_1.addCellValue("MRN");

					xlsxTool_tFileOutputExcel_1.addCellValue("TargetFirstName");

					xlsxTool_tFileOutputExcel_1.addCellValue("TargetLastName");

					xlsxTool_tFileOutputExcel_1.addCellValue("TargetGender");

					xlsxTool_tFileOutputExcel_1.addCellValue("TargetPatientAddress");

					xlsxTool_tFileOutputExcel_1.addCellValue("TargetCity");

					xlsxTool_tFileOutputExcel_1.addCellValue("TargetState");

					xlsxTool_tFileOutputExcel_1.addCellValue("TargetPostalCode");

					xlsxTool_tFileOutputExcel_1.addCellValue("TargetBirthday");

					xlsxTool_tFileOutputExcel_1.addCellValue("TargetSSN");

					xlsxTool_tFileOutputExcel_1.addCellValue("TargetHPLNID");

					xlsxTool_tFileOutputExcel_1.addCellValue("TargetNYSIISFirstName");

					xlsxTool_tFileOutputExcel_1.addCellValue("TargetNYSIISLastName");

					xlsxTool_tFileOutputExcel_1.addCellValue("TargetHealthPlanID");

					xlsxTool_tFileOutputExcel_1.addCellValue("TargetMRN");

					xlsxTool_tFileOutputExcel_1.addCellValue("SSNBlockingKey");

					xlsxTool_tFileOutputExcel_1.addCellValue("FNDOBBlockingKey");

					xlsxTool_tFileOutputExcel_1.addCellValue("LNPCBlockingKey");

					xlsxTool_tFileOutputExcel_1.addCellValue("NYSIISFNLNBlockingKey");

					xlsxTool_tFileOutputExcel_1.addCellValue("DOBPCBlockingKey");

					xlsxTool_tFileOutputExcel_1.addCellValue("MRNBlockingKey");

					xlsxTool_tFileOutputExcel_1.addCellValue("HealthPlanIDBlockingKey");

					xlsxTool_tFileOutputExcel_1.addCellValue("MATCHINGDISTANCES");

					xlsxTool_tFileOutputExcel_1.addCellValue("MATCHINGWEIGHT");

					xlsxTool_tFileOutputExcel_1.addCellValue("SSNSCORE");

					xlsxTool_tFileOutputExcel_1.addCellValue("DOBSCORE");

					xlsxTool_tFileOutputExcel_1.addCellValue("GENDER_SCORE");

					xlsxTool_tFileOutputExcel_1.addCellValue("POSTALCODESCORE");

					xlsxTool_tFileOutputExcel_1.addCellValue("HPLNIDSCORE");

					xlsxTool_tFileOutputExcel_1.addCellValue("FIRSTNAMESCORE");

					xlsxTool_tFileOutputExcel_1.addCellValue("LASTNAMESCORE");

					xlsxTool_tFileOutputExcel_1.addCellValue("PATIENTADDRESSSCORE");

					xlsxTool_tFileOutputExcel_1.addCellValue("SUBTOTAL");

					xlsxTool_tFileOutputExcel_1.addCellValue("TOTALSCORE");

					nb_line_tFileOutputExcel_1++;
					headerIsInserted_tFileOutputExcel_1 = true;

				}

				/**
				 * [tFileOutputExcel_1 begin ] stop
				 */

				/**
				 * [tLogRow_1 begin ] start
				 */

				sh("tLogRow_1");

				s(currentComponent = "tLogRow_1");

				cLabel = "<b>Console</b>";

				runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, 0, 0, "PM_Output");

				int tos_count_tLogRow_1 = 0;

				if (log.isDebugEnabled())
					log.debug("tLogRow_1 - " + ("Start to work."));
				if (log.isDebugEnabled()) {
					class BytesLimit65535_tLogRow_1 {
						public void limitLog4jByte() throws Exception {
							StringBuilder log4jParamters_tLogRow_1 = new StringBuilder();
							log4jParamters_tLogRow_1.append("Parameters:");
							log4jParamters_tLogRow_1.append("BASIC_MODE" + " = " + "false");
							log4jParamters_tLogRow_1.append(" | ");
							log4jParamters_tLogRow_1.append("TABLE_PRINT" + " = " + "true");
							log4jParamters_tLogRow_1.append(" | ");
							log4jParamters_tLogRow_1.append("VERTICAL" + " = " + "false");
							log4jParamters_tLogRow_1.append(" | ");
							log4jParamters_tLogRow_1.append("PRINT_CONTENT_WITH_LOG4J" + " = " + "true");
							log4jParamters_tLogRow_1.append(" | ");
							if (log.isDebugEnabled())
								log.debug("tLogRow_1 - " + (log4jParamters_tLogRow_1));
						}
					}
					new BytesLimit65535_tLogRow_1().limitLog4jByte();
				}
				if (enableLogStash) {
					talendJobLog.addCM("tLogRow_1", "<b>Console</b>", "tLogRow");
					talendJobLogProcess(globalMap);
					s(currentComponent);
				}

				///////////////////////

				class Util_tLogRow_1 {

					String[] des_top = { ".", ".", "-", "+" };

					String[] des_head = { "|=", "=|", "-", "+" };

					String[] des_bottom = { "'", "'", "-", "+" };

					String name = "";

					java.util.List<String[]> list = new java.util.ArrayList<String[]>();

					int[] colLengths = new int[47];

					public void addRow(String[] row) {

						for (int i = 0; i < 47; i++) {
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
						for (k = 0; k < (totals + 46 - name.length()) / 2; k++) {
							sb.append(' ');
						}
						sb.append(name);
						for (int i = 0; i < totals + 46 - name.length() - k; i++) {
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

							sbformat.append("|%38$-");
							sbformat.append(colLengths[37]);
							sbformat.append("s");

							sbformat.append("|%39$-");
							sbformat.append(colLengths[38]);
							sbformat.append("s");

							sbformat.append("|%40$-");
							sbformat.append(colLengths[39]);
							sbformat.append("s");

							sbformat.append("|%41$-");
							sbformat.append(colLengths[40]);
							sbformat.append("s");

							sbformat.append("|%42$-");
							sbformat.append(colLengths[41]);
							sbformat.append("s");

							sbformat.append("|%43$-");
							sbformat.append(colLengths[42]);
							sbformat.append("s");

							sbformat.append("|%44$-");
							sbformat.append(colLengths[43]);
							sbformat.append("s");

							sbformat.append("|%45$-");
							sbformat.append(colLengths[44]);
							sbformat.append("s");

							sbformat.append("|%46$-");
							sbformat.append(colLengths[45]);
							sbformat.append("s");

							sbformat.append("|%47$-");
							sbformat.append(colLengths[46]);
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
						for (int i = 0; i < colLengths[36] - fillChars[3].length() + 1; i++) {
							sb.append(fillChars[2]);
						}
						sb.append(fillChars[3]);
						for (int i = 0; i < colLengths[37] - fillChars[3].length() + 1; i++) {
							sb.append(fillChars[2]);
						}
						sb.append(fillChars[3]);
						for (int i = 0; i < colLengths[38] - fillChars[3].length() + 1; i++) {
							sb.append(fillChars[2]);
						}
						sb.append(fillChars[3]);
						for (int i = 0; i < colLengths[39] - fillChars[3].length() + 1; i++) {
							sb.append(fillChars[2]);
						}
						sb.append(fillChars[3]);
						for (int i = 0; i < colLengths[40] - fillChars[3].length() + 1; i++) {
							sb.append(fillChars[2]);
						}
						sb.append(fillChars[3]);
						for (int i = 0; i < colLengths[41] - fillChars[3].length() + 1; i++) {
							sb.append(fillChars[2]);
						}
						sb.append(fillChars[3]);
						for (int i = 0; i < colLengths[42] - fillChars[3].length() + 1; i++) {
							sb.append(fillChars[2]);
						}
						sb.append(fillChars[3]);
						for (int i = 0; i < colLengths[43] - fillChars[3].length() + 1; i++) {
							sb.append(fillChars[2]);
						}
						sb.append(fillChars[3]);
						for (int i = 0; i < colLengths[44] - fillChars[3].length() + 1; i++) {
							sb.append(fillChars[2]);
						}
						sb.append(fillChars[3]);
						for (int i = 0; i < colLengths[45] - fillChars[3].length() + 1; i++) {
							sb.append(fillChars[2]);
						}
						sb.append(fillChars[3]);

						// last column
						for (int i = 0; i < colLengths[46] - fillChars[1].length() + 1; i++) {
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
				Util_tLogRow_1 util_tLogRow_1 = new Util_tLogRow_1();
				util_tLogRow_1.setTableName("<b>Console</b>");
				util_tLogRow_1.addRow(new String[] { "FirstName", "LastName", "Gender", "PatientAddress", "City",
						"State", "PostalCode", "Birthday", "SSN", "HPLNID", "NYSIISFirstName", "NYSIISLastName",
						"HealthPlanID", "MRN", "TargetFirstName", "TargetLastName", "TargetGender",
						"TargetPatientAddress", "TargetCity", "TargetState", "TargetPostalCode", "TargetBirthday",
						"TargetSSN", "TargetHPLNID", "TargetNYSIISFirstName", "TargetNYSIISLastName",
						"TargetHealthPlanID", "TargetMRN", "SSNBlockingKey", "FNDOBBlockingKey", "LNPCBlockingKey",
						"NYSIISFNLNBlockingKey", "DOBPCBlockingKey", "MRNBlockingKey", "HealthPlanIDBlockingKey",
						"MATCHINGDISTANCES", "MATCHINGWEIGHT", "SSNSCORE", "DOBSCORE", "GENDER_SCORE",
						"POSTALCODESCORE", "HPLNIDSCORE", "FIRSTNAMESCORE", "LASTNAMESCORE", "PATIENTADDRESSSCORE",
						"SUBTOTAL", "TOTALSCORE", });
				StringBuilder strBuffer_tLogRow_1 = null;
				int nb_line_tLogRow_1 = 0;
///////////////////////    			

				/**
				 * [tLogRow_1 begin ] stop
				 */

				/**
				 * [tMap_2 begin ] start
				 */

				sh("tMap_2");

				s(currentComponent = "tMap_2");

				cLabel = "<b>tMap</b>";

				runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, 0, 0, "PM");

				int tos_count_tMap_2 = 0;

				if (log.isDebugEnabled())
					log.debug("tMap_2 - " + ("Start to work."));
				if (log.isDebugEnabled()) {
					class BytesLimit65535_tMap_2 {
						public void limitLog4jByte() throws Exception {
							StringBuilder log4jParamters_tMap_2 = new StringBuilder();
							log4jParamters_tMap_2.append("Parameters:");
							log4jParamters_tMap_2.append("LINK_STYLE" + " = " + "AUTO");
							log4jParamters_tMap_2.append(" | ");
							log4jParamters_tMap_2.append("TEMPORARY_DATA_DIRECTORY" + " = " + "");
							log4jParamters_tMap_2.append(" | ");
							log4jParamters_tMap_2.append("ROWS_BUFFER_SIZE" + " = " + "2000000");
							log4jParamters_tMap_2.append(" | ");
							log4jParamters_tMap_2.append("CHANGE_HASH_AND_EQUALS_FOR_BIGDECIMAL" + " = " + "true");
							log4jParamters_tMap_2.append(" | ");
							if (log.isDebugEnabled())
								log.debug("tMap_2 - " + (log4jParamters_tMap_2));
						}
					}
					new BytesLimit65535_tMap_2().limitLog4jByte();
				}
				if (enableLogStash) {
					talendJobLog.addCM("tMap_2", "<b>tMap</b>", "tMap");
					talendJobLogProcess(globalMap);
					s(currentComponent);
				}

// ###############################
// # Lookup's keys initialization
				int count_PM_tMap_2 = 0;

// ###############################        

// ###############################
// # Vars initialization
				class Var__tMap_2__Struct {
					int SSN_SCORE;
					int DOB_SCORE;
					int GENDER_SCORE;
					int POSTALCODE_SCORE;
					int HPLNID_SCORE;
					int FIRSTNAME;
					int LASTNAME_SCORE;
					int PATIENTADDRESS_SCORE;
				}
				Var__tMap_2__Struct Var__tMap_2 = new Var__tMap_2__Struct();
// ###############################

// ###############################
// # Outputs initialization
				int count_PM_Output_tMap_2 = 0;

				PM_OutputStruct PM_Output_tmp = new PM_OutputStruct();
// ###############################

				/**
				 * [tMap_2 begin ] stop
				 */

				/**
				 * [tRecordMatching_1 begin ] start
				 */

				sh("tRecordMatching_1");

				s(currentComponent = "tRecordMatching_1");

				cLabel = "<b>Recording Matching</b>";

				runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, 0, 0, "row1");

				int tos_count_tRecordMatching_1 = 0;

				if (log.isDebugEnabled())
					log.debug("tRecordMatching_1 - " + ("Start to work."));
				if (log.isDebugEnabled()) {
					class BytesLimit65535_tRecordMatching_1 {
						public void limitLog4jByte() throws Exception {
							StringBuilder log4jParamters_tRecordMatching_1 = new StringBuilder();
							log4jParamters_tRecordMatching_1.append("Parameters:");
							log4jParamters_tRecordMatching_1.append("REPLACED_BY_LOOKUPCOL" + " = " + "false");
							log4jParamters_tRecordMatching_1.append(" | ");
							log4jParamters_tRecordMatching_1.append("JOIN_KEY" + " = " + "[{MATCHING_TYPE=" + ("Exact")
									+ ", HANDLE_NULL=" + ("nullMatchNone") + ", CONFIDENCE_WEIGHT=" + ("1")
									+ ", INPUT_COLUMN=" + ("SSN") + ", LOOKUP_COLUMN=" + ("TargetSSN")
									+ ", CUSTOM_MATCHER=" + ("\"\"") + ", TOKENIZATION_TYPE=" + ("No")
									+ "}, {MATCHING_TYPE=" + ("Exact") + ", HANDLE_NULL=" + ("nullMatchNone")
									+ ", CONFIDENCE_WEIGHT=" + ("1") + ", INPUT_COLUMN=" + ("Birthday")
									+ ", LOOKUP_COLUMN=" + ("TargetBirthday") + ", CUSTOM_MATCHER=" + ("\"\"")
									+ ", TOKENIZATION_TYPE=" + ("No") + "}, {MATCHING_TYPE=" + ("Exact")
									+ ", HANDLE_NULL=" + ("nullMatchNone") + ", CONFIDENCE_WEIGHT=" + ("1")
									+ ", INPUT_COLUMN=" + ("Gender") + ", LOOKUP_COLUMN=" + ("TargetGender")
									+ ", CUSTOM_MATCHER=" + ("\"\"") + ", TOKENIZATION_TYPE=" + ("No")
									+ "}, {MATCHING_TYPE=" + ("Exact") + ", HANDLE_NULL=" + ("nullMatchNone")
									+ ", CONFIDENCE_WEIGHT=" + ("1") + ", INPUT_COLUMN=" + ("PostalCode")
									+ ", LOOKUP_COLUMN=" + ("TargetPostalCode") + ", CUSTOM_MATCHER=" + ("\"\"")
									+ ", TOKENIZATION_TYPE=" + ("No") + "}, {MATCHING_TYPE=" + ("Exact")
									+ ", HANDLE_NULL=" + ("nullMatchNone") + ", CONFIDENCE_WEIGHT=" + ("1")
									+ ", INPUT_COLUMN=" + ("HPLNID") + ", LOOKUP_COLUMN=" + ("TargetHPLNID")
									+ ", CUSTOM_MATCHER=" + ("\"\"") + ", TOKENIZATION_TYPE=" + ("No")
									+ "}, {MATCHING_TYPE=" + ("Exact") + ", HANDLE_NULL=" + ("nullMatchNone")
									+ ", CONFIDENCE_WEIGHT=" + ("1") + ", INPUT_COLUMN=" + ("FirstName")
									+ ", LOOKUP_COLUMN=" + ("TargetFirstName") + ", CUSTOM_MATCHER=" + ("\"\"")
									+ ", TOKENIZATION_TYPE=" + ("No") + "}, {MATCHING_TYPE=" + ("Exact")
									+ ", HANDLE_NULL=" + ("nullMatchNone") + ", CONFIDENCE_WEIGHT=" + ("1")
									+ ", INPUT_COLUMN=" + ("LastName") + ", LOOKUP_COLUMN=" + ("TargetLastName")
									+ ", CUSTOM_MATCHER=" + ("\"\"") + ", TOKENIZATION_TYPE=" + ("No")
									+ "}, {MATCHING_TYPE=" + ("Exact") + ", HANDLE_NULL=" + ("nullMatchNone")
									+ ", CONFIDENCE_WEIGHT=" + ("1") + ", INPUT_COLUMN=" + ("PatientAddress")
									+ ", LOOKUP_COLUMN=" + ("TargetPatientAddress") + ", CUSTOM_MATCHER=" + ("\"\"")
									+ ", TOKENIZATION_TYPE=" + ("No") + "}]");
							log4jParamters_tRecordMatching_1.append(" | ");
							log4jParamters_tRecordMatching_1.append("BLOCKING_DEFINITION" + " = " + "[{INPUT_COLUMN="
									+ ("SSNBlockingKey") + ", LOOKUP_COLUMN=" + ("SSNBlockingKey") + "}]");
							log4jParamters_tRecordMatching_1.append(" | ");
							log4jParamters_tRecordMatching_1.append("OUTPUT_STAT" + " = " + "ALL_MATCHES");
							log4jParamters_tRecordMatching_1.append(" | ");
							log4jParamters_tRecordMatching_1
									.append("MATCHING_ALGORITHM" + " = " + "Simple VSR Matcher");
							log4jParamters_tRecordMatching_1.append(" | ");
							log4jParamters_tRecordMatching_1.append("MINIMUM" + " = " + "-1");
							log4jParamters_tRecordMatching_1.append(" | ");
							log4jParamters_tRecordMatching_1.append("MAXIMUM" + " = " + "1.01");
							log4jParamters_tRecordMatching_1.append(" | ");
							log4jParamters_tRecordMatching_1.append("IS_VIRTUAL_COMPONENT" + " = " + "false");
							log4jParamters_tRecordMatching_1.append(" | ");
							if (log.isDebugEnabled())
								log.debug("tRecordMatching_1 - " + (log4jParamters_tRecordMatching_1));
						}
					}
					new BytesLimit65535_tRecordMatching_1().limitLog4jByte();
				}
				if (enableLogStash) {
					talendJobLog.addCM("tRecordMatching_1", "<b>Recording Matching</b>", "tRecordMatching");
					talendJobLogProcess(globalMap);
					s(currentComponent);
				}

				// # Lookup's keys initialization
				org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<TargetStruct> tHash_Target = (org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<TargetStruct>) globalMap
						.get("tHash_Lookup_Target");
				tHash_Target.initGet();
				TargetStruct TargetHashKey = new TargetStruct();
				// ###############################
				int nb_matches_tRecordMatching_1 = 0;
				int nb_pMatches_tRecordMatching_1 = 0;
				int nb_nMatches_tRecordMatching_1 = 0;
				double[] arrAttrWeights_tRecordMatching_1 = new double[8];
				String[][] arrMatcherAlgoName_tRecordMatching_1 = new String[8][2];
				org.talend.dataquality.record.linkage.constant.TokenizedResolutionMethod[] tokenizationMethod_tRecordMatching_1 = new org.talend.dataquality.record.linkage.constant.TokenizedResolutionMethod[8];

				Object cfWeight_tRecordMatching_1 = null;
				org.talend.dataquality.record.linkage.attribute.IAttributeMatcher.NullOption[] arrMatchHandleNull_tRecordMatching_1 = new org.talend.dataquality.record.linkage.attribute.IAttributeMatcher.NullOption[8];

				tokenizationMethod_tRecordMatching_1[0] = org.talend.dataquality.record.linkage.constant.TokenizedResolutionMethod
						.getTypeByValue("No");

				cfWeight_tRecordMatching_1 = 1;
				if (cfWeight_tRecordMatching_1 != null) {
					arrAttrWeights_tRecordMatching_1[0] = Double.valueOf(1);
				} else {
					throw new Exception("Confidence Weight should not be null.");
				}

				arrMatcherAlgoName_tRecordMatching_1[0][0] = "Exact";
				arrMatchHandleNull_tRecordMatching_1[0] = org.talend.dataquality.record.linkage.attribute.IAttributeMatcher.NullOption.nullMatchNone;
				tokenizationMethod_tRecordMatching_1[1] = org.talend.dataquality.record.linkage.constant.TokenizedResolutionMethod
						.getTypeByValue("No");

				cfWeight_tRecordMatching_1 = 1;
				if (cfWeight_tRecordMatching_1 != null) {
					arrAttrWeights_tRecordMatching_1[1] = Double.valueOf(1);
				} else {
					throw new Exception("Confidence Weight should not be null.");
				}

				arrMatcherAlgoName_tRecordMatching_1[1][0] = "Exact";
				arrMatchHandleNull_tRecordMatching_1[1] = org.talend.dataquality.record.linkage.attribute.IAttributeMatcher.NullOption.nullMatchNone;
				tokenizationMethod_tRecordMatching_1[2] = org.talend.dataquality.record.linkage.constant.TokenizedResolutionMethod
						.getTypeByValue("No");

				cfWeight_tRecordMatching_1 = 1;
				if (cfWeight_tRecordMatching_1 != null) {
					arrAttrWeights_tRecordMatching_1[2] = Double.valueOf(1);
				} else {
					throw new Exception("Confidence Weight should not be null.");
				}

				arrMatcherAlgoName_tRecordMatching_1[2][0] = "Exact";
				arrMatchHandleNull_tRecordMatching_1[2] = org.talend.dataquality.record.linkage.attribute.IAttributeMatcher.NullOption.nullMatchNone;
				tokenizationMethod_tRecordMatching_1[3] = org.talend.dataquality.record.linkage.constant.TokenizedResolutionMethod
						.getTypeByValue("No");

				cfWeight_tRecordMatching_1 = 1;
				if (cfWeight_tRecordMatching_1 != null) {
					arrAttrWeights_tRecordMatching_1[3] = Double.valueOf(1);
				} else {
					throw new Exception("Confidence Weight should not be null.");
				}

				arrMatcherAlgoName_tRecordMatching_1[3][0] = "Exact";
				arrMatchHandleNull_tRecordMatching_1[3] = org.talend.dataquality.record.linkage.attribute.IAttributeMatcher.NullOption.nullMatchNone;
				tokenizationMethod_tRecordMatching_1[4] = org.talend.dataquality.record.linkage.constant.TokenizedResolutionMethod
						.getTypeByValue("No");

				cfWeight_tRecordMatching_1 = 1;
				if (cfWeight_tRecordMatching_1 != null) {
					arrAttrWeights_tRecordMatching_1[4] = Double.valueOf(1);
				} else {
					throw new Exception("Confidence Weight should not be null.");
				}

				arrMatcherAlgoName_tRecordMatching_1[4][0] = "Exact";
				arrMatchHandleNull_tRecordMatching_1[4] = org.talend.dataquality.record.linkage.attribute.IAttributeMatcher.NullOption.nullMatchNone;
				tokenizationMethod_tRecordMatching_1[5] = org.talend.dataquality.record.linkage.constant.TokenizedResolutionMethod
						.getTypeByValue("No");

				cfWeight_tRecordMatching_1 = 1;
				if (cfWeight_tRecordMatching_1 != null) {
					arrAttrWeights_tRecordMatching_1[5] = Double.valueOf(1);
				} else {
					throw new Exception("Confidence Weight should not be null.");
				}

				arrMatcherAlgoName_tRecordMatching_1[5][0] = "Exact";
				arrMatchHandleNull_tRecordMatching_1[5] = org.talend.dataquality.record.linkage.attribute.IAttributeMatcher.NullOption.nullMatchNone;
				tokenizationMethod_tRecordMatching_1[6] = org.talend.dataquality.record.linkage.constant.TokenizedResolutionMethod
						.getTypeByValue("No");

				cfWeight_tRecordMatching_1 = 1;
				if (cfWeight_tRecordMatching_1 != null) {
					arrAttrWeights_tRecordMatching_1[6] = Double.valueOf(1);
				} else {
					throw new Exception("Confidence Weight should not be null.");
				}

				arrMatcherAlgoName_tRecordMatching_1[6][0] = "Exact";
				arrMatchHandleNull_tRecordMatching_1[6] = org.talend.dataquality.record.linkage.attribute.IAttributeMatcher.NullOption.nullMatchNone;
				tokenizationMethod_tRecordMatching_1[7] = org.talend.dataquality.record.linkage.constant.TokenizedResolutionMethod
						.getTypeByValue("No");

				cfWeight_tRecordMatching_1 = 1;
				if (cfWeight_tRecordMatching_1 != null) {
					arrAttrWeights_tRecordMatching_1[7] = Double.valueOf(1);
				} else {
					throw new Exception("Confidence Weight should not be null.");
				}

				arrMatcherAlgoName_tRecordMatching_1[7][0] = "Exact";
				arrMatchHandleNull_tRecordMatching_1[7] = org.talend.dataquality.record.linkage.attribute.IAttributeMatcher.NullOption.nullMatchNone;
				org.talend.dataquality.record.linkage.attribute.IAttributeMatcher[] attributeMatchers_tRecordMatching_1 = new org.talend.dataquality.record.linkage.attribute.IAttributeMatcher[8];

				for (int i_tRecordMatching_1 = 0; i_tRecordMatching_1 < 8; i_tRecordMatching_1++) {
					org.talend.dataquality.record.linkage.constant.AttributeMatcherType type_tRecordMatching_1 = org.talend.dataquality.record.linkage.constant.AttributeMatcherType
							.get(arrMatcherAlgoName_tRecordMatching_1[i_tRecordMatching_1][0]);
					attributeMatchers_tRecordMatching_1[i_tRecordMatching_1] = org.talend.dataquality.record.linkage.attribute.AttributeMatcherFactory
							.createMatcher(type_tRecordMatching_1,
									arrMatcherAlgoName_tRecordMatching_1[i_tRecordMatching_1][1]);
					attributeMatchers_tRecordMatching_1[i_tRecordMatching_1]
							.setNullOption(arrMatchHandleNull_tRecordMatching_1[i_tRecordMatching_1]);
					if (attributeMatchers_tRecordMatching_1[i_tRecordMatching_1] instanceof org.talend.dataquality.record.linkage.attribute.AbstractAttributeMatcher)
						((org.talend.dataquality.record.linkage.attribute.AbstractAttributeMatcher) attributeMatchers_tRecordMatching_1[i_tRecordMatching_1])
								.setTokenMethod(tokenizationMethod_tRecordMatching_1[i_tRecordMatching_1]);

				}
				org.talend.dataquality.record.linkage.record.IRecordMatcher recordMatcher_tRecordMatching_1 = org.talend.dataquality.record.linkage.record.RecordMatcherFactory
						.createMatcher(
								org.talend.dataquality.record.linkage.constant.RecordMatcherType.simpleVSRMatcher);
				recordMatcher_tRecordMatching_1.setRecordSize(8);
				recordMatcher_tRecordMatching_1.setAttributeWeights(arrAttrWeights_tRecordMatching_1);
				recordMatcher_tRecordMatching_1.setAttributeMatchers(attributeMatchers_tRecordMatching_1);

				/**
				 * [tRecordMatching_1 begin ] stop
				 */

				/**
				 * [tDBInput_1 begin ] start
				 */

				sh("tDBInput_1");

				s(currentComponent = "tDBInput_1");

				cLabel = "<b>Data Source</b>";

				int tos_count_tDBInput_1 = 0;

				if (log.isDebugEnabled())
					log.debug("tDBInput_1 - " + ("Start to work."));
				if (log.isDebugEnabled()) {
					class BytesLimit65535_tDBInput_1 {
						public void limitLog4jByte() throws Exception {
							StringBuilder log4jParamters_tDBInput_1 = new StringBuilder();
							log4jParamters_tDBInput_1.append("Parameters:");
							log4jParamters_tDBInput_1.append("DB_VERSION" + " = " + "MYSQL_8");
							log4jParamters_tDBInput_1.append(" | ");
							log4jParamters_tDBInput_1.append("USE_EXISTING_CONNECTION" + " = " + "false");
							log4jParamters_tDBInput_1.append(" | ");
							log4jParamters_tDBInput_1.append("HOST" + " = " + "\"localhost\"");
							log4jParamters_tDBInput_1.append(" | ");
							log4jParamters_tDBInput_1.append("PORT" + " = " + "\"3306\"");
							log4jParamters_tDBInput_1.append(" | ");
							log4jParamters_tDBInput_1.append("DBNAME" + " = " + "\"CHIA\"");
							log4jParamters_tDBInput_1.append(" | ");
							log4jParamters_tDBInput_1.append("USER" + " = " + "\"root\"");
							log4jParamters_tDBInput_1.append(" | ");
							log4jParamters_tDBInput_1.append("PASS" + " = " + String.valueOf(
									"enc:routine.encryption.key.v2:q9F1YvTocfY29bU0QiIwkH+CYieFFLRraC2TQnF4AtFuRt1XBQ==")
									.substring(0, 4) + "...");
							log4jParamters_tDBInput_1.append(" | ");
							log4jParamters_tDBInput_1.append("TABLE" + " = " + "\"CHIAStage\"");
							log4jParamters_tDBInput_1.append(" | ");
							log4jParamters_tDBInput_1.append("QUERYSTORE" + " = " + "\"\"");
							log4jParamters_tDBInput_1.append(" | ");
							log4jParamters_tDBInput_1.append("QUERY" + " = "
									+ "\"SELECT    `CHIAStage`.`FirstName`,    `CHIAStage`.`LastName`,    `CHIAStage`.`Gender`,    `CHIAStage`.`PatientAddress`,    `CHIAStage`.`City`,    `CHIAStage`.`State`,    `CHIAStage`.`PostalCode`,    `CHIAStage`.`Birthday`,    `CHIAStage`.`SSN`,    `CHIAStage`.`HPLNID`,    `CHIAStage`.`NYSIISFirstName`,    `CHIAStage`.`NYSIISLastName`,    `CHIAStage`.`HealthPlanID`,    `CHIAStage`.`MRN`,    `CHIAStage`.`SSNBlockingKey`,    `CHIAStage`.`FNDOBBlockingKey`,    `CHIAStage`.`LNPCBlockingKey`,    `CHIAStage`.`NYSIISFNLNBlockingKey`,    `CHIAStage`.`DOBPCBlockingKey`,    `CHIAStage`.`MRNBlockingKey`,    `CHIAStage`.`HealthPlanIDBlockingKey`  FROM `CHIAStage`\"");
							log4jParamters_tDBInput_1.append(" | ");
							log4jParamters_tDBInput_1.append("SPECIFY_DATASOURCE_ALIAS" + " = " + "false");
							log4jParamters_tDBInput_1.append(" | ");
							log4jParamters_tDBInput_1.append("PROPERTIES" + " = "
									+ "\"noDatetimeStringSync=true&enabledTLSProtocols=TLSv1.2,TLSv1.1,TLSv1\"");
							log4jParamters_tDBInput_1.append(" | ");
							log4jParamters_tDBInput_1.append("ENABLE_STREAM" + " = " + "false");
							log4jParamters_tDBInput_1.append(" | ");
							log4jParamters_tDBInput_1.append("TRIM_ALL_COLUMN" + " = " + "false");
							log4jParamters_tDBInput_1.append(" | ");
							log4jParamters_tDBInput_1.append("TRIM_COLUMN" + " = " + "[{TRIM=" + ("false")
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
							log4jParamters_tDBInput_1.append(" | ");
							log4jParamters_tDBInput_1.append("UNIFIED_COMPONENTS" + " = " + "tMysqlInput");
							log4jParamters_tDBInput_1.append(" | ");
							if (log.isDebugEnabled())
								log.debug("tDBInput_1 - " + (log4jParamters_tDBInput_1));
						}
					}
					new BytesLimit65535_tDBInput_1().limitLog4jByte();
				}
				if (enableLogStash) {
					talendJobLog.addCM("tDBInput_1", "<b>Data Source</b>", "tMysqlInput");
					talendJobLogProcess(globalMap);
					s(currentComponent);
				}

				java.util.Calendar calendar_tDBInput_1 = java.util.Calendar.getInstance();
				calendar_tDBInput_1.set(0, 0, 0, 0, 0, 0);
				java.util.Date year0_tDBInput_1 = calendar_tDBInput_1.getTime();
				int nb_line_tDBInput_1 = 0;
				java.sql.Connection conn_tDBInput_1 = null;
				String driverClass_tDBInput_1 = "com.mysql.cj.jdbc.Driver";
				java.lang.Class jdbcclazz_tDBInput_1 = java.lang.Class.forName(driverClass_tDBInput_1);
				String dbUser_tDBInput_1 = "root";

				final String decryptedPassword_tDBInput_1 = routines.system.PasswordEncryptUtil.decryptPassword(
						"enc:routine.encryption.key.v2:HMtbXZ6HSbNyXPrKjwLiKMLhmZOOy9Rruz+9+tNX9H6fSXsK2A==");

				String dbPwd_tDBInput_1 = decryptedPassword_tDBInput_1;

				String properties_tDBInput_1 = "noDatetimeStringSync=true&enabledTLSProtocols=TLSv1.2,TLSv1.1,TLSv1";
				if (properties_tDBInput_1 == null || properties_tDBInput_1.trim().length() == 0) {
					properties_tDBInput_1 = "";
				}
				String url_tDBInput_1 = "jdbc:mysql://" + "localhost" + ":" + "3306" + "/" + "CHIA" + "?"
						+ properties_tDBInput_1;

				log.debug("tDBInput_1 - Driver ClassName: " + driverClass_tDBInput_1 + ".");

				log.debug("tDBInput_1 - Connection attempt to '"
						+ url_tDBInput_1.replaceAll("(?<=trustStorePassword=)[^;]*", "********")
						+ "' with the username '" + dbUser_tDBInput_1 + "'.");

				conn_tDBInput_1 = java.sql.DriverManager.getConnection(url_tDBInput_1, dbUser_tDBInput_1,
						dbPwd_tDBInput_1);
				log.debug("tDBInput_1 - Connection to '"
						+ url_tDBInput_1.replaceAll("(?<=trustStorePassword=)[^;]*", "********") + "' has succeeded.");

				java.sql.Statement stmt_tDBInput_1 = conn_tDBInput_1.createStatement();

				String dbquery_tDBInput_1 = new StringBuilder().append(
						"SELECT \n  `CHIAStage`.`FirstName`, \n  `CHIAStage`.`LastName`, \n  `CHIAStage`.`Gender`, \n  `CHIAStage`.`PatientAddress`,"
								+ " \n  `CHIAStage`.`City`, \n  `CHIAStage`.`State`, \n  `CHIAStage`.`PostalCode`, \n  `CHIAStage`.`Birthday`, \n  `CHIAStage`.`"
								+ "SSN`, \n  `CHIAStage`.`HPLNID`, \n  `CHIAStage`.`NYSIISFirstName`, \n  `CHIAStage`.`NYSIISLastName`, \n  `CHIAStage`.`Health"
								+ "PlanID`, \n  `CHIAStage`.`MRN`, \n  `CHIAStage`.`SSNBlockingKey`, \n  `CHIAStage`.`FNDOBBlockingKey`, \n  `CHIAStage`.`LNPCB"
								+ "lockingKey`, \n  `CHIAStage`.`NYSIISFNLNBlockingKey`, \n  `CHIAStage`.`DOBPCBlockingKey`, \n  `CHIAStage`.`MRNBlockingKey`,"
								+ " \n  `CHIAStage`.`HealthPlanIDBlockingKey`\n FROM `CHIAStage`")
						.toString();

				log.debug("tDBInput_1 - Executing the query: '" + dbquery_tDBInput_1 + "'.");

				globalMap.put("tDBInput_1_QUERY", dbquery_tDBInput_1);

				java.sql.ResultSet rs_tDBInput_1 = null;

				try {
					rs_tDBInput_1 = stmt_tDBInput_1.executeQuery(dbquery_tDBInput_1);
					java.sql.ResultSetMetaData rsmd_tDBInput_1 = rs_tDBInput_1.getMetaData();
					int colQtyInRs_tDBInput_1 = rsmd_tDBInput_1.getColumnCount();

					String tmpContent_tDBInput_1 = null;

					log.debug("tDBInput_1 - Retrieving records from the database.");

					while (rs_tDBInput_1.next()) {
						nb_line_tDBInput_1++;

						if (colQtyInRs_tDBInput_1 < 1) {
							row1.FirstName = null;
						} else {

							row1.FirstName = routines.system.JDBCUtil.getString(rs_tDBInput_1, 1, false);
						}
						if (colQtyInRs_tDBInput_1 < 2) {
							row1.LastName = null;
						} else {

							row1.LastName = routines.system.JDBCUtil.getString(rs_tDBInput_1, 2, false);
						}
						if (colQtyInRs_tDBInput_1 < 3) {
							row1.Gender = null;
						} else {

							row1.Gender = routines.system.JDBCUtil.getString(rs_tDBInput_1, 3, false);
						}
						if (colQtyInRs_tDBInput_1 < 4) {
							row1.PatientAddress = null;
						} else {

							row1.PatientAddress = routines.system.JDBCUtil.getString(rs_tDBInput_1, 4, false);
						}
						if (colQtyInRs_tDBInput_1 < 5) {
							row1.City = null;
						} else {

							row1.City = routines.system.JDBCUtil.getString(rs_tDBInput_1, 5, false);
						}
						if (colQtyInRs_tDBInput_1 < 6) {
							row1.State = null;
						} else {

							row1.State = routines.system.JDBCUtil.getString(rs_tDBInput_1, 6, false);
						}
						if (colQtyInRs_tDBInput_1 < 7) {
							row1.PostalCode = null;
						} else {

							row1.PostalCode = rs_tDBInput_1.getInt(7);
							if (rs_tDBInput_1.wasNull()) {
								row1.PostalCode = null;
							}
						}
						if (colQtyInRs_tDBInput_1 < 8) {
							row1.Birthday = null;
						} else {

							if (rs_tDBInput_1.getString(8) != null) {
								String dateString_tDBInput_1 = rs_tDBInput_1.getString(8);
								if (!("0000-00-00").equals(dateString_tDBInput_1)
										&& !("0000-00-00 00:00:00").equals(dateString_tDBInput_1)) {
									row1.Birthday = rs_tDBInput_1.getTimestamp(8);
								} else {
									row1.Birthday = (java.util.Date) year0_tDBInput_1.clone();
								}
							} else {
								row1.Birthday = null;
							}
						}
						if (colQtyInRs_tDBInput_1 < 9) {
							row1.SSN = null;
						} else {

							row1.SSN = routines.system.JDBCUtil.getString(rs_tDBInput_1, 9, false);
						}
						if (colQtyInRs_tDBInput_1 < 10) {
							row1.HPLNID = null;
						} else {

							row1.HPLNID = rs_tDBInput_1.getInt(10);
							if (rs_tDBInput_1.wasNull()) {
								row1.HPLNID = null;
							}
						}
						if (colQtyInRs_tDBInput_1 < 11) {
							row1.NYSIISFirstName = null;
						} else {

							row1.NYSIISFirstName = routines.system.JDBCUtil.getString(rs_tDBInput_1, 11, false);
						}
						if (colQtyInRs_tDBInput_1 < 12) {
							row1.NYSIISLastName = null;
						} else {

							row1.NYSIISLastName = routines.system.JDBCUtil.getString(rs_tDBInput_1, 12, false);
						}
						if (colQtyInRs_tDBInput_1 < 13) {
							row1.HealthPlanID = null;
						} else {

							row1.HealthPlanID = routines.system.JDBCUtil.getString(rs_tDBInput_1, 13, false);
						}
						if (colQtyInRs_tDBInput_1 < 14) {
							row1.MRN = null;
						} else {

							row1.MRN = rs_tDBInput_1.getInt(14);
							if (rs_tDBInput_1.wasNull()) {
								row1.MRN = null;
							}
						}
						if (colQtyInRs_tDBInput_1 < 15) {
							row1.SSNBlockingKey = null;
						} else {

							row1.SSNBlockingKey = routines.system.JDBCUtil.getString(rs_tDBInput_1, 15, false);
						}
						if (colQtyInRs_tDBInput_1 < 16) {
							row1.FNDOBBlockingKey = null;
						} else {

							row1.FNDOBBlockingKey = routines.system.JDBCUtil.getString(rs_tDBInput_1, 16, false);
						}
						if (colQtyInRs_tDBInput_1 < 17) {
							row1.LNPCBlockingKey = null;
						} else {

							row1.LNPCBlockingKey = routines.system.JDBCUtil.getString(rs_tDBInput_1, 17, false);
						}
						if (colQtyInRs_tDBInput_1 < 18) {
							row1.NYSIISFNLNBlockingKey = null;
						} else {

							row1.NYSIISFNLNBlockingKey = routines.system.JDBCUtil.getString(rs_tDBInput_1, 18, false);
						}
						if (colQtyInRs_tDBInput_1 < 19) {
							row1.DOBPCBlockingKey = null;
						} else {

							row1.DOBPCBlockingKey = routines.system.JDBCUtil.getString(rs_tDBInput_1, 19, false);
						}
						if (colQtyInRs_tDBInput_1 < 20) {
							row1.MRNBlockingKey = null;
						} else {

							row1.MRNBlockingKey = routines.system.JDBCUtil.getString(rs_tDBInput_1, 20, false);
						}
						if (colQtyInRs_tDBInput_1 < 21) {
							row1.HealthPlanIDBlockingKey = null;
						} else {

							row1.HealthPlanIDBlockingKey = routines.system.JDBCUtil.getString(rs_tDBInput_1, 21, false);
						}

						log.debug("tDBInput_1 - Retrieving the record " + nb_line_tDBInput_1 + ".");

						/**
						 * [tDBInput_1 begin ] stop
						 */

						/**
						 * [tDBInput_1 main ] start
						 */

						s(currentComponent = "tDBInput_1");

						cLabel = "<b>Data Source</b>";

						tos_count_tDBInput_1++;

						/**
						 * [tDBInput_1 main ] stop
						 */

						/**
						 * [tDBInput_1 process_data_begin ] start
						 */

						s(currentComponent = "tDBInput_1");

						cLabel = "<b>Data Source</b>";

						/**
						 * [tDBInput_1 process_data_begin ] stop
						 */

						/**
						 * [tRecordMatching_1 main ] start
						 */

						s(currentComponent = "tRecordMatching_1");

						cLabel = "<b>Recording Matching</b>";

						if (runStat.update(execStat, enableLogStash, iterateId, 1, 1

								, "row1", "tDBInput_1", "<b>Data Source</b>", "tMysqlInput", "tRecordMatching_1",
								"<b>Recording Matching</b>", "tRecordMatching"

						)) {
							talendJobLogProcess(globalMap);
						}

						if (log.isTraceEnabled()) {
							log.trace("row1 - " + (row1 == null ? "" : row1.toLogString()));
						}

						String[] arrMainData_tRecordMatching_1 = new String[8];
						String[] arrLookupData_tRecordMatching_1 = new String[8];
						final double UNACCEPTABLE_THRESHOLD_tRecordMatching_1 = Double.valueOf(-1 + "");
						final double ACCEPTABLE_THRESHOLD_tRecordMatching_1 = Double.valueOf(1.01 + "");
						TargetStruct currentLookupRow_Target = null;
						TargetStruct savedMatchRow_Target = null;
						TargetStruct savedPMatchRow_Target = null;
						String sMatchingDists_tRecordMatching_1 = null, savedRowDists_tRecordMatching_1 = null,
								savedPRowDists_tRecordMatching_1 = null;
						double matchingProba_tRecordMatching_1 = 0, savedRowProba_tRecordMatching_1 = 0,
								savedPRowProba_tRecordMatching_1 = 0;
						boolean bMatch_tRecordMatching_1 = false, bPMatch_tRecordMatching_1 = false,
								bHasMatchRec_tRecordMatching_1 = false, bPHasMatchRec_tRecordMatching_1 = false;
						boolean forceLoopTarget = true;
						// not primitive type case
						arrMainData_tRecordMatching_1[0] = row1.SSN == null ? null : String.valueOf(row1.SSN);

						arrMainData_tRecordMatching_1[1] = FormatterUtils.format_Date(row1.Birthday, "yyyy-MM-dd");

						// not primitive type case
						arrMainData_tRecordMatching_1[2] = row1.Gender == null ? null : String.valueOf(row1.Gender);

						// not primitive type case
						arrMainData_tRecordMatching_1[3] = row1.PostalCode == null ? null
								: String.valueOf(row1.PostalCode);

						// not primitive type case
						arrMainData_tRecordMatching_1[4] = row1.HPLNID == null ? null : String.valueOf(row1.HPLNID);

						// not primitive type case
						arrMainData_tRecordMatching_1[5] = row1.FirstName == null ? null
								: String.valueOf(row1.FirstName);

						// not primitive type case
						arrMainData_tRecordMatching_1[6] = row1.LastName == null ? null : String.valueOf(row1.LastName);

						// not primitive type case
						arrMainData_tRecordMatching_1[7] = row1.PatientAddress == null ? null
								: String.valueOf(row1.PatientAddress);

						TargetHashKey.SSNBlockingKey = row1.SSNBlockingKey;
						TargetHashKey.hashCodeDirty = true;
						tHash_Target.lookup(TargetHashKey);

						while (tHash_Target.hasNext() || forceLoopTarget) {
							PM = null;

							if (tHash_Target.hasNext()) {
								forceLoopTarget = false;
								currentLookupRow_Target = tHash_Target.next();

								// not primitive type case
								arrLookupData_tRecordMatching_1[0] = currentLookupRow_Target.TargetSSN == null ? null
										: String.valueOf(currentLookupRow_Target.TargetSSN);

								arrLookupData_tRecordMatching_1[1] = FormatterUtils
										.format_Date(currentLookupRow_Target.TargetBirthday, "yyyy-MM-dd");

								// not primitive type case
								arrLookupData_tRecordMatching_1[2] = currentLookupRow_Target.TargetGender == null ? null
										: String.valueOf(currentLookupRow_Target.TargetGender);

								// not primitive type case
								arrLookupData_tRecordMatching_1[3] = currentLookupRow_Target.TargetPostalCode == null
										? null
										: String.valueOf(currentLookupRow_Target.TargetPostalCode);

								// not primitive type case
								arrLookupData_tRecordMatching_1[4] = currentLookupRow_Target.TargetHPLNID == null ? null
										: String.valueOf(currentLookupRow_Target.TargetHPLNID);

								// not primitive type case
								arrLookupData_tRecordMatching_1[5] = currentLookupRow_Target.TargetFirstName == null
										? null
										: String.valueOf(currentLookupRow_Target.TargetFirstName);

								// not primitive type case
								arrLookupData_tRecordMatching_1[6] = currentLookupRow_Target.TargetLastName == null
										? null
										: String.valueOf(currentLookupRow_Target.TargetLastName);

								// not primitive type case
								arrLookupData_tRecordMatching_1[7] = currentLookupRow_Target.TargetPatientAddress == null
										? null
										: String.valueOf(currentLookupRow_Target.TargetPatientAddress);

								matchingProba_tRecordMatching_1 = recordMatcher_tRecordMatching_1.getMatchingWeight(
										arrMainData_tRecordMatching_1, arrLookupData_tRecordMatching_1);
								bMatch_tRecordMatching_1 = bPMatch_tRecordMatching_1 = true;
								if (ACCEPTABLE_THRESHOLD_tRecordMatching_1 <= matchingProba_tRecordMatching_1) {
									bPMatch_tRecordMatching_1 = false;
								} else if (UNACCEPTABLE_THRESHOLD_tRecordMatching_1 < matchingProba_tRecordMatching_1
										&& matchingProba_tRecordMatching_1 < ACCEPTABLE_THRESHOLD_tRecordMatching_1) {
									bMatch_tRecordMatching_1 = false;
								} else if (matchingProba_tRecordMatching_1 <= UNACCEPTABLE_THRESHOLD_tRecordMatching_1) {
									bMatch_tRecordMatching_1 = bPMatch_tRecordMatching_1 = false;
								}

								if (bMatch_tRecordMatching_1 || bPMatch_tRecordMatching_1) {
									StringBuffer sb_tRecordMatching_1 = new StringBuffer(10);
									for (double v_tRecordMatching_1 : recordMatcher_tRecordMatching_1
											.getCurrentAttributeMatchingWeights())
										sb_tRecordMatching_1.append(Double.toString(v_tRecordMatching_1)).append("|");
									sb_tRecordMatching_1.deleteCharAt(sb_tRecordMatching_1.length() - 1);
									sMatchingDists_tRecordMatching_1 = new String(sb_tRecordMatching_1);
								}

								// save current match or possible match row for output
								if (bMatch_tRecordMatching_1) {
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
									savedRowDists_tRecordMatching_1 = sMatchingDists_tRecordMatching_1;
									/* save the MATCHING_WEIGHT */
									savedRowProba_tRecordMatching_1 = matchingProba_tRecordMatching_1;
									bHasMatchRec_tRecordMatching_1 = true;
								}

								if (bPMatch_tRecordMatching_1 && !bMatch_tRecordMatching_1) {
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
									savedPRowDists_tRecordMatching_1 = sMatchingDists_tRecordMatching_1;
									/* save the MATCHING_WEIGHT */
									savedPRowProba_tRecordMatching_1 = matchingProba_tRecordMatching_1;
									bPHasMatchRec_tRecordMatching_1 = true;
								}
							}
							// } to be suitable for IS_MULTIPLYING_OUTPUTS

							// output matched rows

							// output possibly matched rows
							if (bPMatch_tRecordMatching_1) {
								PM = new PMStruct();
								PM.FirstName = row1.FirstName;
								PM.LastName = row1.LastName;
								PM.Gender = row1.Gender;
								PM.PatientAddress = row1.PatientAddress;
								PM.City = row1.City;
								PM.State = row1.State;
								PM.PostalCode = row1.PostalCode;
								PM.Birthday = row1.Birthday;
								PM.SSN = row1.SSN;
								PM.HPLNID = row1.HPLNID;
								PM.NYSIISFirstName = row1.NYSIISFirstName;
								PM.NYSIISLastName = row1.NYSIISLastName;
								PM.HealthPlanID = row1.HealthPlanID;
								PM.MRN = row1.MRN;
								PM.TargetFirstName = currentLookupRow_Target.TargetFirstName;
								PM.TargetLastName = currentLookupRow_Target.TargetLastName;
								PM.TargetGender = currentLookupRow_Target.TargetGender;
								PM.TargetPatientAddress = currentLookupRow_Target.TargetPatientAddress;
								PM.TargetCity = currentLookupRow_Target.TargetCity;
								PM.TargetState = currentLookupRow_Target.TargetState;
								PM.TargetPostalCode = currentLookupRow_Target.TargetPostalCode;
								PM.TargetBirthday = currentLookupRow_Target.TargetBirthday;
								PM.TargetSSN = currentLookupRow_Target.TargetSSN;
								PM.TargetHPLNID = currentLookupRow_Target.TargetHPLNID;
								PM.TargetNYSIISFirstName = currentLookupRow_Target.TargetNYSIISFirstName;
								PM.TargetNYSIISLastName = currentLookupRow_Target.TargetNYSIISLastName;
								PM.TargetHealthPlanID = currentLookupRow_Target.TargetHealthPlanID;
								PM.TargetMRN = currentLookupRow_Target.TargetMRN;
								PM.SSNBlockingKey = row1.SSNBlockingKey;
								PM.FNDOBBlockingKey = row1.FNDOBBlockingKey;
								PM.LNPCBlockingKey = row1.LNPCBlockingKey;
								PM.NYSIISFNLNBlockingKey = row1.NYSIISFNLNBlockingKey;
								PM.DOBPCBlockingKey = row1.DOBPCBlockingKey;
								PM.MRNBlockingKey = row1.MRNBlockingKey;
								PM.HealthPlanIDBlockingKey = row1.HealthPlanIDBlockingKey;
								PM.MATCHING_DISTANCES = sMatchingDists_tRecordMatching_1;
								PM.MATCHING_WEIGHT = matchingProba_tRecordMatching_1;
								nb_pMatches_tRecordMatching_1++;
							}

							/*
							 * none matches output, no lookup record or at the end of the loop and no
							 * matches record outputted and no possible matches record outputted
							 */
							if ((forceLoopTarget) || (!tHash_Target.hasNext() && !bHasMatchRec_tRecordMatching_1
									&& !bPHasMatchRec_tRecordMatching_1)) {
								forceLoopTarget = false;
								nb_nMatches_tRecordMatching_1++;
							}

							tos_count_tRecordMatching_1++;

							/**
							 * [tRecordMatching_1 main ] stop
							 */

							/**
							 * [tRecordMatching_1 process_data_begin ] start
							 */

							s(currentComponent = "tRecordMatching_1");

							cLabel = "<b>Recording Matching</b>";

							/**
							 * [tRecordMatching_1 process_data_begin ] stop
							 */

// Start of branch "PM"
							if (PM != null) {

								/**
								 * [tMap_2 main ] start
								 */

								s(currentComponent = "tMap_2");

								cLabel = "<b>tMap</b>";

								if (runStat.update(execStat, enableLogStash, iterateId, 1, 1

										, "PM", "tRecordMatching_1", "<b>Recording Matching</b>", "tRecordMatching",
										"tMap_2", "<b>tMap</b>", "tMap"

								)) {
									talendJobLogProcess(globalMap);
								}

								if (log.isTraceEnabled()) {
									log.trace("PM - " + (PM == null ? "" : PM.toLogString()));
								}

								boolean hasCasePrimitiveKeyWithNull_tMap_2 = false;

								// ###############################
								// # Input tables (lookups)

								boolean rejectedInnerJoin_tMap_2 = false;
								boolean mainRowRejected_tMap_2 = false;
								// ###############################
								{ // start of Var scope

									// ###############################
									// # Vars tables

									Var__tMap_2__Struct Var = Var__tMap_2;
									Var.SSN_SCORE = PM.SSN == null || PM.TargetSSN == null ? -750
											: Integer.parseInt(PM.MATCHING_DISTANCES.substring(0, 1)) == 1 ? 650 : -750;
									Var.DOB_SCORE = PM.Birthday == null || PM.TargetBirthday == null ? 0
											: Integer.parseInt(PM.MATCHING_DISTANCES.substring(4, 5)) == 1 ? 650 : -650;
									Var.GENDER_SCORE = PM.Gender == null || PM.TargetGender == null ? 0
											: Integer.parseInt(PM.MATCHING_DISTANCES.substring(8, 9)) == 1 ? 500 : -300;
									Var.POSTALCODE_SCORE = PM.PostalCode == null || PM.TargetPostalCode == null ? 0
											: Integer.parseInt(PM.MATCHING_DISTANCES.substring(12, 13)) == 1 ? 350
													: -100;
									Var.HPLNID_SCORE = PM.HPLNID == null || PM.TargetHPLNID == null ? 0
											: Integer.parseInt(PM.MATCHING_DISTANCES.substring(16, 17)) == 1 ? 450
													: -250;
									Var.FIRSTNAME = PM.FirstName == null || PM.TargetFirstName == null ? 0
											: Integer.parseInt(PM.MATCHING_DISTANCES.substring(20, 21)) == 1 ? 500
													: -350;
									Var.LASTNAME_SCORE = PM.LastName == null || PM.TargetLastName == null ? 0
											: Integer.parseInt(PM.MATCHING_DISTANCES.substring(24, 25)) == 1 ? 400
													: -100;
									Var.PATIENTADDRESS_SCORE = PM.PatientAddress == null
											|| PM.TargetPatientAddress == null
													? 0
													: Integer.parseInt(PM.MATCHING_DISTANCES.substring(28, 29)) == 1
															? 200
															: 0;// ###############################
									// ###############################
									// # Output tables

									PM_Output = null;

// # Output table : 'PM_Output'
									count_PM_Output_tMap_2++;

									PM_Output_tmp.FirstName = PM.FirstName;
									PM_Output_tmp.LastName = PM.LastName;
									PM_Output_tmp.Gender = PM.Gender;
									PM_Output_tmp.PatientAddress = PM.PatientAddress;
									PM_Output_tmp.City = PM.City;
									PM_Output_tmp.State = PM.State;
									PM_Output_tmp.PostalCode = PM.PostalCode;
									PM_Output_tmp.Birthday = PM.Birthday;
									PM_Output_tmp.SSN = PM.SSN;
									PM_Output_tmp.HPLNID = PM.HPLNID;
									PM_Output_tmp.NYSIISFirstName = PM.NYSIISFirstName;
									PM_Output_tmp.NYSIISLastName = PM.NYSIISLastName;
									PM_Output_tmp.HealthPlanID = PM.HealthPlanID;
									PM_Output_tmp.MRN = PM.MRN;
									PM_Output_tmp.TargetFirstName = PM.TargetFirstName;
									PM_Output_tmp.TargetLastName = PM.TargetLastName;
									PM_Output_tmp.TargetGender = PM.TargetGender;
									PM_Output_tmp.TargetPatientAddress = PM.TargetPatientAddress;
									PM_Output_tmp.TargetCity = PM.TargetCity;
									PM_Output_tmp.TargetState = PM.TargetState;
									PM_Output_tmp.TargetPostalCode = PM.TargetPostalCode;
									PM_Output_tmp.TargetBirthday = PM.TargetBirthday;
									PM_Output_tmp.TargetSSN = PM.TargetSSN;
									PM_Output_tmp.TargetHPLNID = PM.TargetHPLNID;
									PM_Output_tmp.TargetNYSIISFirstName = PM.TargetNYSIISFirstName;
									PM_Output_tmp.TargetNYSIISLastName = PM.TargetNYSIISLastName;
									PM_Output_tmp.TargetHealthPlanID = PM.TargetHealthPlanID;
									PM_Output_tmp.TargetMRN = PM.TargetMRN;
									PM_Output_tmp.SSNBlockingKey = PM.SSNBlockingKey;
									PM_Output_tmp.FNDOBBlockingKey = PM.FNDOBBlockingKey;
									PM_Output_tmp.LNPCBlockingKey = PM.LNPCBlockingKey;
									PM_Output_tmp.NYSIISFNLNBlockingKey = PM.NYSIISFNLNBlockingKey;
									PM_Output_tmp.DOBPCBlockingKey = PM.DOBPCBlockingKey;
									PM_Output_tmp.MRNBlockingKey = PM.MRNBlockingKey;
									PM_Output_tmp.HealthPlanIDBlockingKey = PM.HealthPlanIDBlockingKey;
									PM_Output_tmp.MATCHINGDISTANCES = PM.MATCHING_DISTANCES;
									PM_Output_tmp.MATCHINGWEIGHT = PM.MATCHING_WEIGHT;
									PM_Output_tmp.SSNSCORE = Var.SSN_SCORE;
									PM_Output_tmp.DOBSCORE = Var.DOB_SCORE;
									PM_Output_tmp.GENDER_SCORE = Var.GENDER_SCORE;
									PM_Output_tmp.POSTALCODESCORE = Var.POSTALCODE_SCORE;
									PM_Output_tmp.HPLNIDSCORE = Var.HPLNID_SCORE;
									PM_Output_tmp.FIRSTNAMESCORE = Var.FIRSTNAME;
									PM_Output_tmp.LASTNAMESCORE = Var.LASTNAME_SCORE;
									PM_Output_tmp.PATIENTADDRESSSCORE = Var.PATIENTADDRESS_SCORE;
									PM_Output_tmp.SUBTOTAL = Var.SSN_SCORE + Var.DOB_SCORE + Var.GENDER_SCORE
											+ Var.POSTALCODE_SCORE + Var.HPLNID_SCORE + Var.FIRSTNAME
											+ Var.LASTNAME_SCORE + Var.PATIENTADDRESS_SCORE;
									PM_Output_tmp.TOTALSCORE = (Var.SSN_SCORE + Var.DOB_SCORE + Var.GENDER_SCORE
											+ Var.POSTALCODE_SCORE + Var.HPLNID_SCORE + Var.FIRSTNAME
											+ Var.LASTNAME_SCORE + Var.PATIENTADDRESS_SCORE) / 100.0;
									PM_Output = PM_Output_tmp;
									log.debug("tMap_2 - Outputting the record " + count_PM_Output_tMap_2
											+ " of the output table 'PM_Output'.");

// ###############################

								} // end of Var scope

								rejectedInnerJoin_tMap_2 = false;

								tos_count_tMap_2++;

								/**
								 * [tMap_2 main ] stop
								 */

								/**
								 * [tMap_2 process_data_begin ] start
								 */

								s(currentComponent = "tMap_2");

								cLabel = "<b>tMap</b>";

								/**
								 * [tMap_2 process_data_begin ] stop
								 */

// Start of branch "PM_Output"
								if (PM_Output != null) {

									/**
									 * [tLogRow_1 main ] start
									 */

									s(currentComponent = "tLogRow_1");

									cLabel = "<b>Console</b>";

									if (runStat.update(execStat, enableLogStash, iterateId, 1, 1

											, "PM_Output", "tMap_2", "<b>tMap</b>", "tMap", "tLogRow_1",
											"<b>Console</b>", "tLogRow"

									)) {
										talendJobLogProcess(globalMap);
									}

									if (log.isTraceEnabled()) {
										log.trace("PM_Output - " + (PM_Output == null ? "" : PM_Output.toLogString()));
									}

///////////////////////		

									String[] row_tLogRow_1 = new String[47];

									if (PM_Output.FirstName != null) { //
										row_tLogRow_1[0] = String.valueOf(PM_Output.FirstName);

									} //

									if (PM_Output.LastName != null) { //
										row_tLogRow_1[1] = String.valueOf(PM_Output.LastName);

									} //

									if (PM_Output.Gender != null) { //
										row_tLogRow_1[2] = String.valueOf(PM_Output.Gender);

									} //

									if (PM_Output.PatientAddress != null) { //
										row_tLogRow_1[3] = String.valueOf(PM_Output.PatientAddress);

									} //

									if (PM_Output.City != null) { //
										row_tLogRow_1[4] = String.valueOf(PM_Output.City);

									} //

									if (PM_Output.State != null) { //
										row_tLogRow_1[5] = String.valueOf(PM_Output.State);

									} //

									if (PM_Output.PostalCode != null) { //
										row_tLogRow_1[6] = String.valueOf(PM_Output.PostalCode);

									} //

									if (PM_Output.Birthday != null) { //
										row_tLogRow_1[7] = FormatterUtils.format_Date(PM_Output.Birthday, "MM/dd/yyyy");

									} //

									if (PM_Output.SSN != null) { //
										row_tLogRow_1[8] = String.valueOf(PM_Output.SSN);

									} //

									if (PM_Output.HPLNID != null) { //
										row_tLogRow_1[9] = String.valueOf(PM_Output.HPLNID);

									} //

									if (PM_Output.NYSIISFirstName != null) { //
										row_tLogRow_1[10] = String.valueOf(PM_Output.NYSIISFirstName);

									} //

									if (PM_Output.NYSIISLastName != null) { //
										row_tLogRow_1[11] = String.valueOf(PM_Output.NYSIISLastName);

									} //

									if (PM_Output.HealthPlanID != null) { //
										row_tLogRow_1[12] = String.valueOf(PM_Output.HealthPlanID);

									} //

									if (PM_Output.MRN != null) { //
										row_tLogRow_1[13] = String.valueOf(PM_Output.MRN);

									} //

									if (PM_Output.TargetFirstName != null) { //
										row_tLogRow_1[14] = String.valueOf(PM_Output.TargetFirstName);

									} //

									if (PM_Output.TargetLastName != null) { //
										row_tLogRow_1[15] = String.valueOf(PM_Output.TargetLastName);

									} //

									if (PM_Output.TargetGender != null) { //
										row_tLogRow_1[16] = String.valueOf(PM_Output.TargetGender);

									} //

									if (PM_Output.TargetPatientAddress != null) { //
										row_tLogRow_1[17] = String.valueOf(PM_Output.TargetPatientAddress);

									} //

									if (PM_Output.TargetCity != null) { //
										row_tLogRow_1[18] = String.valueOf(PM_Output.TargetCity);

									} //

									if (PM_Output.TargetState != null) { //
										row_tLogRow_1[19] = String.valueOf(PM_Output.TargetState);

									} //

									if (PM_Output.TargetPostalCode != null) { //
										row_tLogRow_1[20] = String.valueOf(PM_Output.TargetPostalCode);

									} //

									if (PM_Output.TargetBirthday != null) { //
										row_tLogRow_1[21] = FormatterUtils.format_Date(PM_Output.TargetBirthday,
												"MM/dd/yyyy");

									} //

									if (PM_Output.TargetSSN != null) { //
										row_tLogRow_1[22] = String.valueOf(PM_Output.TargetSSN);

									} //

									if (PM_Output.TargetHPLNID != null) { //
										row_tLogRow_1[23] = String.valueOf(PM_Output.TargetHPLNID);

									} //

									if (PM_Output.TargetNYSIISFirstName != null) { //
										row_tLogRow_1[24] = String.valueOf(PM_Output.TargetNYSIISFirstName);

									} //

									if (PM_Output.TargetNYSIISLastName != null) { //
										row_tLogRow_1[25] = String.valueOf(PM_Output.TargetNYSIISLastName);

									} //

									if (PM_Output.TargetHealthPlanID != null) { //
										row_tLogRow_1[26] = String.valueOf(PM_Output.TargetHealthPlanID);

									} //

									if (PM_Output.TargetMRN != null) { //
										row_tLogRow_1[27] = String.valueOf(PM_Output.TargetMRN);

									} //

									if (PM_Output.SSNBlockingKey != null) { //
										row_tLogRow_1[28] = String.valueOf(PM_Output.SSNBlockingKey);

									} //

									if (PM_Output.FNDOBBlockingKey != null) { //
										row_tLogRow_1[29] = String.valueOf(PM_Output.FNDOBBlockingKey);

									} //

									if (PM_Output.LNPCBlockingKey != null) { //
										row_tLogRow_1[30] = String.valueOf(PM_Output.LNPCBlockingKey);

									} //

									if (PM_Output.NYSIISFNLNBlockingKey != null) { //
										row_tLogRow_1[31] = String.valueOf(PM_Output.NYSIISFNLNBlockingKey);

									} //

									if (PM_Output.DOBPCBlockingKey != null) { //
										row_tLogRow_1[32] = String.valueOf(PM_Output.DOBPCBlockingKey);

									} //

									if (PM_Output.MRNBlockingKey != null) { //
										row_tLogRow_1[33] = String.valueOf(PM_Output.MRNBlockingKey);

									} //

									if (PM_Output.HealthPlanIDBlockingKey != null) { //
										row_tLogRow_1[34] = String.valueOf(PM_Output.HealthPlanIDBlockingKey);

									} //

									if (PM_Output.MATCHINGDISTANCES != null) { //
										row_tLogRow_1[35] = String.valueOf(PM_Output.MATCHINGDISTANCES);

									} //

									if (PM_Output.MATCHINGWEIGHT != null) { //
										row_tLogRow_1[36] = FormatterUtils.formatUnwithE(PM_Output.MATCHINGWEIGHT);

									} //

									if (PM_Output.SSNSCORE != null) { //
										row_tLogRow_1[37] = String.valueOf(PM_Output.SSNSCORE);

									} //

									if (PM_Output.DOBSCORE != null) { //
										row_tLogRow_1[38] = String.valueOf(PM_Output.DOBSCORE);

									} //

									if (PM_Output.GENDER_SCORE != null) { //
										row_tLogRow_1[39] = String.valueOf(PM_Output.GENDER_SCORE);

									} //

									if (PM_Output.POSTALCODESCORE != null) { //
										row_tLogRow_1[40] = String.valueOf(PM_Output.POSTALCODESCORE);

									} //

									if (PM_Output.HPLNIDSCORE != null) { //
										row_tLogRow_1[41] = String.valueOf(PM_Output.HPLNIDSCORE);

									} //

									if (PM_Output.FIRSTNAMESCORE != null) { //
										row_tLogRow_1[42] = String.valueOf(PM_Output.FIRSTNAMESCORE);

									} //

									if (PM_Output.LASTNAMESCORE != null) { //
										row_tLogRow_1[43] = String.valueOf(PM_Output.LASTNAMESCORE);

									} //

									if (PM_Output.PATIENTADDRESSSCORE != null) { //
										row_tLogRow_1[44] = String.valueOf(PM_Output.PATIENTADDRESSSCORE);

									} //

									if (PM_Output.SUBTOTAL != null) { //
										row_tLogRow_1[45] = String.valueOf(PM_Output.SUBTOTAL);

									} //

									if (PM_Output.TOTALSCORE != null) { //
										row_tLogRow_1[46] = FormatterUtils.formatUnwithE(PM_Output.TOTALSCORE);

									} //

									util_tLogRow_1.addRow(row_tLogRow_1);
									nb_line_tLogRow_1++;
									log.info("tLogRow_1 - Content of row " + nb_line_tLogRow_1 + ": "
											+ TalendString.unionString("|", row_tLogRow_1));
//////

//////                    

///////////////////////    			

									SSN = PM_Output;

									tos_count_tLogRow_1++;

									/**
									 * [tLogRow_1 main ] stop
									 */

									/**
									 * [tLogRow_1 process_data_begin ] start
									 */

									s(currentComponent = "tLogRow_1");

									cLabel = "<b>Console</b>";

									/**
									 * [tLogRow_1 process_data_begin ] stop
									 */

									/**
									 * [tFileOutputExcel_1 main ] start
									 */

									s(currentComponent = "tFileOutputExcel_1");

									cLabel = "<b>CHIA MDM SCORING</b>";

									if (runStat.update(execStat, enableLogStash, iterateId, 1, 1

											, "SSN", "tLogRow_1", "<b>Console</b>", "tLogRow", "tFileOutputExcel_1",
											"<b>CHIA MDM SCORING</b>", "tFileOutputExcel"

									)) {
										talendJobLogProcess(globalMap);
									}

									if (log.isTraceEnabled()) {
										log.trace("SSN - " + (SSN == null ? "" : SSN.toLogString()));
									}

									xlsxTool_tFileOutputExcel_1.addRow();

									if (SSN.FirstName != null) {

										xlsxTool_tFileOutputExcel_1.addCellValue(String.valueOf(SSN.FirstName));
									} else {
										xlsxTool_tFileOutputExcel_1.addCellNullValue();
									}

									if (SSN.LastName != null) {

										xlsxTool_tFileOutputExcel_1.addCellValue(String.valueOf(SSN.LastName));
									} else {
										xlsxTool_tFileOutputExcel_1.addCellNullValue();
									}

									if (SSN.Gender != null) {

										xlsxTool_tFileOutputExcel_1.addCellValue(String.valueOf(SSN.Gender));
									} else {
										xlsxTool_tFileOutputExcel_1.addCellNullValue();
									}

									if (SSN.PatientAddress != null) {

										xlsxTool_tFileOutputExcel_1.addCellValue(String.valueOf(SSN.PatientAddress));
									} else {
										xlsxTool_tFileOutputExcel_1.addCellNullValue();
									}

									if (SSN.City != null) {

										xlsxTool_tFileOutputExcel_1.addCellValue(String.valueOf(SSN.City));
									} else {
										xlsxTool_tFileOutputExcel_1.addCellNullValue();
									}

									if (SSN.State != null) {

										xlsxTool_tFileOutputExcel_1.addCellValue(String.valueOf(SSN.State));
									} else {
										xlsxTool_tFileOutputExcel_1.addCellNullValue();
									}

									if (SSN.PostalCode != null) {

										xlsxTool_tFileOutputExcel_1
												.addCellValue(Double.parseDouble(String.valueOf(SSN.PostalCode)));
									} else {
										xlsxTool_tFileOutputExcel_1.addCellNullValue();
									}

									if (SSN.Birthday != null) {

										xlsxTool_tFileOutputExcel_1.addCellValue(SSN.Birthday, "MM/dd/yyyy");
									} else {
										xlsxTool_tFileOutputExcel_1.addCellNullValue();
									}

									if (SSN.SSN != null) {

										xlsxTool_tFileOutputExcel_1.addCellValue(String.valueOf(SSN.SSN));
									} else {
										xlsxTool_tFileOutputExcel_1.addCellNullValue();
									}

									if (SSN.HPLNID != null) {

										xlsxTool_tFileOutputExcel_1
												.addCellValue(Double.parseDouble(String.valueOf(SSN.HPLNID)));
									} else {
										xlsxTool_tFileOutputExcel_1.addCellNullValue();
									}

									if (SSN.NYSIISFirstName != null) {

										xlsxTool_tFileOutputExcel_1.addCellValue(String.valueOf(SSN.NYSIISFirstName));
									} else {
										xlsxTool_tFileOutputExcel_1.addCellNullValue();
									}

									if (SSN.NYSIISLastName != null) {

										xlsxTool_tFileOutputExcel_1.addCellValue(String.valueOf(SSN.NYSIISLastName));
									} else {
										xlsxTool_tFileOutputExcel_1.addCellNullValue();
									}

									if (SSN.HealthPlanID != null) {

										xlsxTool_tFileOutputExcel_1.addCellValue(String.valueOf(SSN.HealthPlanID));
									} else {
										xlsxTool_tFileOutputExcel_1.addCellNullValue();
									}

									if (SSN.MRN != null) {

										xlsxTool_tFileOutputExcel_1
												.addCellValue(Double.parseDouble(String.valueOf(SSN.MRN)));
									} else {
										xlsxTool_tFileOutputExcel_1.addCellNullValue();
									}

									if (SSN.TargetFirstName != null) {

										xlsxTool_tFileOutputExcel_1.addCellValue(String.valueOf(SSN.TargetFirstName));
									} else {
										xlsxTool_tFileOutputExcel_1.addCellNullValue();
									}

									if (SSN.TargetLastName != null) {

										xlsxTool_tFileOutputExcel_1.addCellValue(String.valueOf(SSN.TargetLastName));
									} else {
										xlsxTool_tFileOutputExcel_1.addCellNullValue();
									}

									if (SSN.TargetGender != null) {

										xlsxTool_tFileOutputExcel_1.addCellValue(String.valueOf(SSN.TargetGender));
									} else {
										xlsxTool_tFileOutputExcel_1.addCellNullValue();
									}

									if (SSN.TargetPatientAddress != null) {

										xlsxTool_tFileOutputExcel_1
												.addCellValue(String.valueOf(SSN.TargetPatientAddress));
									} else {
										xlsxTool_tFileOutputExcel_1.addCellNullValue();
									}

									if (SSN.TargetCity != null) {

										xlsxTool_tFileOutputExcel_1.addCellValue(String.valueOf(SSN.TargetCity));
									} else {
										xlsxTool_tFileOutputExcel_1.addCellNullValue();
									}

									if (SSN.TargetState != null) {

										xlsxTool_tFileOutputExcel_1.addCellValue(String.valueOf(SSN.TargetState));
									} else {
										xlsxTool_tFileOutputExcel_1.addCellNullValue();
									}

									if (SSN.TargetPostalCode != null) {

										xlsxTool_tFileOutputExcel_1
												.addCellValue(Double.parseDouble(String.valueOf(SSN.TargetPostalCode)));
									} else {
										xlsxTool_tFileOutputExcel_1.addCellNullValue();
									}

									if (SSN.TargetBirthday != null) {

										xlsxTool_tFileOutputExcel_1.addCellValue(SSN.TargetBirthday, "MM/dd/yyyy");
									} else {
										xlsxTool_tFileOutputExcel_1.addCellNullValue();
									}

									if (SSN.TargetSSN != null) {

										xlsxTool_tFileOutputExcel_1.addCellValue(String.valueOf(SSN.TargetSSN));
									} else {
										xlsxTool_tFileOutputExcel_1.addCellNullValue();
									}

									if (SSN.TargetHPLNID != null) {

										xlsxTool_tFileOutputExcel_1
												.addCellValue(Double.parseDouble(String.valueOf(SSN.TargetHPLNID)));
									} else {
										xlsxTool_tFileOutputExcel_1.addCellNullValue();
									}

									if (SSN.TargetNYSIISFirstName != null) {

										xlsxTool_tFileOutputExcel_1
												.addCellValue(String.valueOf(SSN.TargetNYSIISFirstName));
									} else {
										xlsxTool_tFileOutputExcel_1.addCellNullValue();
									}

									if (SSN.TargetNYSIISLastName != null) {

										xlsxTool_tFileOutputExcel_1
												.addCellValue(String.valueOf(SSN.TargetNYSIISLastName));
									} else {
										xlsxTool_tFileOutputExcel_1.addCellNullValue();
									}

									if (SSN.TargetHealthPlanID != null) {

										xlsxTool_tFileOutputExcel_1
												.addCellValue(String.valueOf(SSN.TargetHealthPlanID));
									} else {
										xlsxTool_tFileOutputExcel_1.addCellNullValue();
									}

									if (SSN.TargetMRN != null) {

										xlsxTool_tFileOutputExcel_1
												.addCellValue(Double.parseDouble(String.valueOf(SSN.TargetMRN)));
									} else {
										xlsxTool_tFileOutputExcel_1.addCellNullValue();
									}

									if (SSN.SSNBlockingKey != null) {

										xlsxTool_tFileOutputExcel_1.addCellValue(String.valueOf(SSN.SSNBlockingKey));
									} else {
										xlsxTool_tFileOutputExcel_1.addCellNullValue();
									}

									if (SSN.FNDOBBlockingKey != null) {

										xlsxTool_tFileOutputExcel_1.addCellValue(String.valueOf(SSN.FNDOBBlockingKey));
									} else {
										xlsxTool_tFileOutputExcel_1.addCellNullValue();
									}

									if (SSN.LNPCBlockingKey != null) {

										xlsxTool_tFileOutputExcel_1.addCellValue(String.valueOf(SSN.LNPCBlockingKey));
									} else {
										xlsxTool_tFileOutputExcel_1.addCellNullValue();
									}

									if (SSN.NYSIISFNLNBlockingKey != null) {

										xlsxTool_tFileOutputExcel_1
												.addCellValue(String.valueOf(SSN.NYSIISFNLNBlockingKey));
									} else {
										xlsxTool_tFileOutputExcel_1.addCellNullValue();
									}

									if (SSN.DOBPCBlockingKey != null) {

										xlsxTool_tFileOutputExcel_1.addCellValue(String.valueOf(SSN.DOBPCBlockingKey));
									} else {
										xlsxTool_tFileOutputExcel_1.addCellNullValue();
									}

									if (SSN.MRNBlockingKey != null) {

										xlsxTool_tFileOutputExcel_1.addCellValue(String.valueOf(SSN.MRNBlockingKey));
									} else {
										xlsxTool_tFileOutputExcel_1.addCellNullValue();
									}

									if (SSN.HealthPlanIDBlockingKey != null) {

										xlsxTool_tFileOutputExcel_1
												.addCellValue(String.valueOf(SSN.HealthPlanIDBlockingKey));
									} else {
										xlsxTool_tFileOutputExcel_1.addCellNullValue();
									}

									if (SSN.MATCHINGDISTANCES != null) {

										xlsxTool_tFileOutputExcel_1.addCellValue(String.valueOf(SSN.MATCHINGDISTANCES));
									} else {
										xlsxTool_tFileOutputExcel_1.addCellNullValue();
									}

									if (SSN.MATCHINGWEIGHT != null) {

										xlsxTool_tFileOutputExcel_1.addCellValue(SSN.MATCHINGWEIGHT);
									} else {
										xlsxTool_tFileOutputExcel_1.addCellNullValue();
									}

									if (SSN.SSNSCORE != null) {

										xlsxTool_tFileOutputExcel_1
												.addCellValue(Double.parseDouble(String.valueOf(SSN.SSNSCORE)));
									} else {
										xlsxTool_tFileOutputExcel_1.addCellNullValue();
									}

									if (SSN.DOBSCORE != null) {

										xlsxTool_tFileOutputExcel_1
												.addCellValue(Double.parseDouble(String.valueOf(SSN.DOBSCORE)));
									} else {
										xlsxTool_tFileOutputExcel_1.addCellNullValue();
									}

									if (SSN.GENDER_SCORE != null) {

										xlsxTool_tFileOutputExcel_1
												.addCellValue(Double.parseDouble(String.valueOf(SSN.GENDER_SCORE)));
									} else {
										xlsxTool_tFileOutputExcel_1.addCellNullValue();
									}

									if (SSN.POSTALCODESCORE != null) {

										xlsxTool_tFileOutputExcel_1
												.addCellValue(Double.parseDouble(String.valueOf(SSN.POSTALCODESCORE)));
									} else {
										xlsxTool_tFileOutputExcel_1.addCellNullValue();
									}

									if (SSN.HPLNIDSCORE != null) {

										xlsxTool_tFileOutputExcel_1
												.addCellValue(Double.parseDouble(String.valueOf(SSN.HPLNIDSCORE)));
									} else {
										xlsxTool_tFileOutputExcel_1.addCellNullValue();
									}

									if (SSN.FIRSTNAMESCORE != null) {

										xlsxTool_tFileOutputExcel_1
												.addCellValue(Double.parseDouble(String.valueOf(SSN.FIRSTNAMESCORE)));
									} else {
										xlsxTool_tFileOutputExcel_1.addCellNullValue();
									}

									if (SSN.LASTNAMESCORE != null) {

										xlsxTool_tFileOutputExcel_1
												.addCellValue(Double.parseDouble(String.valueOf(SSN.LASTNAMESCORE)));
									} else {
										xlsxTool_tFileOutputExcel_1.addCellNullValue();
									}

									if (SSN.PATIENTADDRESSSCORE != null) {

										xlsxTool_tFileOutputExcel_1.addCellValue(
												Double.parseDouble(String.valueOf(SSN.PATIENTADDRESSSCORE)));
									} else {
										xlsxTool_tFileOutputExcel_1.addCellNullValue();
									}

									if (SSN.SUBTOTAL != null) {

										xlsxTool_tFileOutputExcel_1
												.addCellValue(Double.parseDouble(String.valueOf(SSN.SUBTOTAL)));
									} else {
										xlsxTool_tFileOutputExcel_1.addCellNullValue();
									}

									if (SSN.TOTALSCORE != null) {

										xlsxTool_tFileOutputExcel_1.addCellValue(SSN.TOTALSCORE);
									} else {
										xlsxTool_tFileOutputExcel_1.addCellNullValue();
									}

									nb_line_tFileOutputExcel_1++;

									log.debug("tFileOutputExcel_1 - Writing the record " + nb_line_tFileOutputExcel_1
											+ " to the file.");

									tos_count_tFileOutputExcel_1++;

									/**
									 * [tFileOutputExcel_1 main ] stop
									 */

									/**
									 * [tFileOutputExcel_1 process_data_begin ] start
									 */

									s(currentComponent = "tFileOutputExcel_1");

									cLabel = "<b>CHIA MDM SCORING</b>";

									/**
									 * [tFileOutputExcel_1 process_data_begin ] stop
									 */

									/**
									 * [tFileOutputExcel_1 process_data_end ] start
									 */

									s(currentComponent = "tFileOutputExcel_1");

									cLabel = "<b>CHIA MDM SCORING</b>";

									/**
									 * [tFileOutputExcel_1 process_data_end ] stop
									 */

									/**
									 * [tLogRow_1 process_data_end ] start
									 */

									s(currentComponent = "tLogRow_1");

									cLabel = "<b>Console</b>";

									/**
									 * [tLogRow_1 process_data_end ] stop
									 */

								} // End of branch "PM_Output"

								/**
								 * [tMap_2 process_data_end ] start
								 */

								s(currentComponent = "tMap_2");

								cLabel = "<b>tMap</b>";

								/**
								 * [tMap_2 process_data_end ] stop
								 */

							} // End of branch "PM"

							// end for
						}

						/**
						 * [tRecordMatching_1 process_data_end ] start
						 */

						s(currentComponent = "tRecordMatching_1");

						cLabel = "<b>Recording Matching</b>";

						/**
						 * [tRecordMatching_1 process_data_end ] stop
						 */

						/**
						 * [tDBInput_1 process_data_end ] start
						 */

						s(currentComponent = "tDBInput_1");

						cLabel = "<b>Data Source</b>";

						/**
						 * [tDBInput_1 process_data_end ] stop
						 */

						/**
						 * [tDBInput_1 end ] start
						 */

						s(currentComponent = "tDBInput_1");

						cLabel = "<b>Data Source</b>";

					}
				} finally {
					if (rs_tDBInput_1 != null) {
						rs_tDBInput_1.close();
					}
					if (stmt_tDBInput_1 != null) {
						stmt_tDBInput_1.close();
					}
					if (conn_tDBInput_1 != null && !conn_tDBInput_1.isClosed()) {

						log.debug("tDBInput_1 - Closing the connection to the database.");

						conn_tDBInput_1.close();

						if ("com.mysql.cj.jdbc.Driver".equals((String) globalMap.get("driverClass_"))
								&& routines.system.BundleUtils.inOSGi()) {
							Class.forName("com.mysql.cj.jdbc.AbandonedConnectionCleanupThread")
									.getMethod("checkedShutdown").invoke(null, (Object[]) null);
						}

						log.debug("tDBInput_1 - Connection to the database closed.");

					}

				}
				globalMap.put("tDBInput_1_NB_LINE", nb_line_tDBInput_1);
				log.debug("tDBInput_1 - Retrieved records count: " + nb_line_tDBInput_1 + " .");

				if (log.isDebugEnabled())
					log.debug("tDBInput_1 - " + ("Done."));

				ok_Hash.put("tDBInput_1", true);
				end_Hash.put("tDBInput_1", System.currentTimeMillis());

				/**
				 * [tDBInput_1 end ] stop
				 */

				/**
				 * [tRecordMatching_1 end ] start
				 */

				s(currentComponent = "tRecordMatching_1");

				cLabel = "<b>Recording Matching</b>";

				globalMap.put("tRecordMatching_1_NB_MATCH_LINE", nb_matches_tRecordMatching_1);
				globalMap.put("tRecordMatching_1_NB_POSSIBLE_MATCH_LINE", nb_pMatches_tRecordMatching_1);
				globalMap.put("tRecordMatching_1_NB_NONE_MATCH_LINE", nb_nMatches_tRecordMatching_1);
				if (runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, "row1", 2, 0,
						"tDBInput_1", "<b>Data Source</b>", "tMysqlInput", "tRecordMatching_1",
						"<b>Recording Matching</b>", "tRecordMatching", "output")) {
					talendJobLogProcess(globalMap);
				}

				if (log.isDebugEnabled())
					log.debug("tRecordMatching_1 - " + ("Done."));

				ok_Hash.put("tRecordMatching_1", true);
				end_Hash.put("tRecordMatching_1", System.currentTimeMillis());

				/**
				 * [tRecordMatching_1 end ] stop
				 */

				/**
				 * [tMap_2 end ] start
				 */

				s(currentComponent = "tMap_2");

				cLabel = "<b>tMap</b>";

// ###############################
// # Lookup hashes releasing
// ###############################      
				log.debug("tMap_2 - Written records count in the table 'PM_Output': " + count_PM_Output_tMap_2 + ".");

				if (runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, "PM", 2, 0,
						"tRecordMatching_1", "<b>Recording Matching</b>", "tRecordMatching", "tMap_2", "<b>tMap</b>",
						"tMap", "output")) {
					talendJobLogProcess(globalMap);
				}

				if (log.isDebugEnabled())
					log.debug("tMap_2 - " + ("Done."));

				ok_Hash.put("tMap_2", true);
				end_Hash.put("tMap_2", System.currentTimeMillis());

				/**
				 * [tMap_2 end ] stop
				 */

				/**
				 * [tLogRow_1 end ] start
				 */

				s(currentComponent = "tLogRow_1");

				cLabel = "<b>Console</b>";

//////

				java.io.PrintStream consoleOut_tLogRow_1 = null;
				if (globalMap.get("tLogRow_CONSOLE") != null) {
					consoleOut_tLogRow_1 = (java.io.PrintStream) globalMap.get("tLogRow_CONSOLE");
				} else {
					consoleOut_tLogRow_1 = new java.io.PrintStream(new java.io.BufferedOutputStream(System.out));
					globalMap.put("tLogRow_CONSOLE", consoleOut_tLogRow_1);
				}

				consoleOut_tLogRow_1.println(util_tLogRow_1.format().toString());
				consoleOut_tLogRow_1.flush();
//////
				globalMap.put("tLogRow_1_NB_LINE", nb_line_tLogRow_1);
				if (log.isInfoEnabled())
					log.info("tLogRow_1 - " + ("Printed row count: ") + (nb_line_tLogRow_1) + ("."));

///////////////////////    			

				if (runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, "PM_Output", 2, 0,
						"tMap_2", "<b>tMap</b>", "tMap", "tLogRow_1", "<b>Console</b>", "tLogRow", "output")) {
					talendJobLogProcess(globalMap);
				}

				if (log.isDebugEnabled())
					log.debug("tLogRow_1 - " + ("Done."));

				ok_Hash.put("tLogRow_1", true);
				end_Hash.put("tLogRow_1", System.currentTimeMillis());

				/**
				 * [tLogRow_1 end ] stop
				 */

				/**
				 * [tFileOutputExcel_1 end ] start
				 */

				s(currentComponent = "tFileOutputExcel_1");

				cLabel = "<b>CHIA MDM SCORING</b>";

				xlsxTool_tFileOutputExcel_1.writeExcel(fileName_tFileOutputExcel_1, true);

				if (headerIsInserted_tFileOutputExcel_1 && nb_line_tFileOutputExcel_1 > 0) {
					nb_line_tFileOutputExcel_1 = nb_line_tFileOutputExcel_1 - 1;
				}
				globalMap.put("tFileOutputExcel_1_NB_LINE", nb_line_tFileOutputExcel_1);

				log.debug("tFileOutputExcel_1 - Written records count: " + nb_line_tFileOutputExcel_1 + " .");

				if (runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, "SSN", 2, 0, "tLogRow_1",
						"<b>Console</b>", "tLogRow", "tFileOutputExcel_1", "<b>CHIA MDM SCORING</b>",
						"tFileOutputExcel", "output")) {
					talendJobLogProcess(globalMap);
				}

				if (log.isDebugEnabled())
					log.debug("tFileOutputExcel_1 - " + ("Done."));

				ok_Hash.put("tFileOutputExcel_1", true);
				end_Hash.put("tFileOutputExcel_1", System.currentTimeMillis());

				/**
				 * [tFileOutputExcel_1 end ] stop
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

			// free memory for "tRecordMatching_1"
			globalMap.remove("tHash_Target");

			try {

				/**
				 * [tDBInput_1 finally ] start
				 */

				s(currentComponent = "tDBInput_1");

				cLabel = "<b>Data Source</b>";

				/**
				 * [tDBInput_1 finally ] stop
				 */

				/**
				 * [tRecordMatching_1 finally ] start
				 */

				s(currentComponent = "tRecordMatching_1");

				cLabel = "<b>Recording Matching</b>";

				/**
				 * [tRecordMatching_1 finally ] stop
				 */

				/**
				 * [tMap_2 finally ] start
				 */

				s(currentComponent = "tMap_2");

				cLabel = "<b>tMap</b>";

				/**
				 * [tMap_2 finally ] stop
				 */

				/**
				 * [tLogRow_1 finally ] start
				 */

				s(currentComponent = "tLogRow_1");

				cLabel = "<b>Console</b>";

				/**
				 * [tLogRow_1 finally ] stop
				 */

				/**
				 * [tFileOutputExcel_1 finally ] start
				 */

				s(currentComponent = "tFileOutputExcel_1");

				cLabel = "<b>CHIA MDM SCORING</b>";

				/**
				 * [tFileOutputExcel_1 finally ] stop
				 */

			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tDBInput_1_SUBPROCESS_STATE", 1);
	}

	public static class TargetStruct implements routines.system.IPersistableComparableLookupRow<TargetStruct> {
		final static byte[] commonByteArrayLock_TALENDCLOUDDEMOBANK_CHIA_MDM_MatchingDistance_Full_Calculations = new byte[0];
		static byte[] commonByteArray_TALENDCLOUDDEMOBANK_CHIA_MDM_MatchingDistance_Full_Calculations = new byte[0];
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

			return "yyyy-MM-dd";

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
				if (length > commonByteArray_TALENDCLOUDDEMOBANK_CHIA_MDM_MatchingDistance_Full_Calculations.length) {
					if (length < 1024
							&& commonByteArray_TALENDCLOUDDEMOBANK_CHIA_MDM_MatchingDistance_Full_Calculations.length == 0) {
						commonByteArray_TALENDCLOUDDEMOBANK_CHIA_MDM_MatchingDistance_Full_Calculations = new byte[1024];
					} else {
						commonByteArray_TALENDCLOUDDEMOBANK_CHIA_MDM_MatchingDistance_Full_Calculations = new byte[2
								* length];
					}
				}
				dis.readFully(commonByteArray_TALENDCLOUDDEMOBANK_CHIA_MDM_MatchingDistance_Full_Calculations, 0,
						length);
				strReturn = new String(commonByteArray_TALENDCLOUDDEMOBANK_CHIA_MDM_MatchingDistance_Full_Calculations,
						0, length, utf8Charset);
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
				if (length > commonByteArray_TALENDCLOUDDEMOBANK_CHIA_MDM_MatchingDistance_Full_Calculations.length) {
					if (length < 1024
							&& commonByteArray_TALENDCLOUDDEMOBANK_CHIA_MDM_MatchingDistance_Full_Calculations.length == 0) {
						commonByteArray_TALENDCLOUDDEMOBANK_CHIA_MDM_MatchingDistance_Full_Calculations = new byte[1024];
					} else {
						commonByteArray_TALENDCLOUDDEMOBANK_CHIA_MDM_MatchingDistance_Full_Calculations = new byte[2
								* length];
					}
				}
				unmarshaller.readFully(commonByteArray_TALENDCLOUDDEMOBANK_CHIA_MDM_MatchingDistance_Full_Calculations,
						0, length);
				strReturn = new String(commonByteArray_TALENDCLOUDDEMOBANK_CHIA_MDM_MatchingDistance_Full_Calculations,
						0, length, utf8Charset);
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

			synchronized (commonByteArrayLock_TALENDCLOUDDEMOBANK_CHIA_MDM_MatchingDistance_Full_Calculations) {

				try {

					int length = 0;

					this.SSNBlockingKey = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readKeysData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_TALENDCLOUDDEMOBANK_CHIA_MDM_MatchingDistance_Full_Calculations) {

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

	public void tDBInput_3Process(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("tDBInput_3_SUBPROCESS_STATE", 0);

		final boolean execStat = this.execStat;

		mdc("tDBInput_3", "QlOPL2_");

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
				// source node:tDBInput_3 - inputs:(after_tDBInput_1) outputs:(Target,Target) |
				// target node:tAdvancedHash_Target - inputs:(Target) outputs:()
				// linked node: tRecordMatching_1 - inputs:(row1,Target) outputs:(PM)

				org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE matchingModeEnum_Target = org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE.ALL_MATCHES;

				org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<TargetStruct> tHash_Lookup_Target = org.talend.designer.components.lookup.memory.AdvancedMemoryLookup
						.<TargetStruct>getLookup(matchingModeEnum_Target);

				globalMap.put("tHash_Lookup_Target", tHash_Lookup_Target);

				/**
				 * [tAdvancedHash_Target begin ] stop
				 */

				/**
				 * [tDBInput_3 begin ] start
				 */

				sh("tDBInput_3");

				s(currentComponent = "tDBInput_3");

				cLabel = "<b>Reference Source</b>";

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
									"enc:routine.encryption.key.v2:FjtfpzmTKOTXEBDbHToz3WS7IsXV681CE3tEyLJMaQjnLTQ4yg==")
									.substring(0, 4) + "...");
							log4jParamters_tDBInput_3.append(" | ");
							log4jParamters_tDBInput_3.append("TABLE" + " = " + "\"CHIATargetSource\"");
							log4jParamters_tDBInput_3.append(" | ");
							log4jParamters_tDBInput_3.append("QUERYSTORE" + " = " + "\"\"");
							log4jParamters_tDBInput_3.append(" | ");
							log4jParamters_tDBInput_3.append("QUERY" + " = "
									+ "\"SELECT    `CHIATargetSource`.`TargetFirstName`,    `CHIATargetSource`.`TargetLastName`,    `CHIATargetSource`.`TargetGender`,    `CHIATargetSource`.`TargetPatientAddress`,    `CHIATargetSource`.`TargetCity`,    `CHIATargetSource`.`TargetState`,    `CHIATargetSource`.`TargetPostalCode`,    `CHIATargetSource`.`TargetBirthday`,    `CHIATargetSource`.`TargetSSN`,    `CHIATargetSource`.`TargetHPLNID`,    `CHIATargetSource`.`TargetNYSIISFirstName`,    `CHIATargetSource`.`TargetNYSIISLastName`,    `CHIATargetSource`.`TargetHealthPlanID`,    `CHIATargetSource`.`TargetMRN`,    `CHIATargetSource`.`SSNBlockingKey`,    `CHIATargetSource`.`FNDOBBlockingKey`,    `CHIATargetSource`.`LNPCBlockingKey`,    `CHIATargetSource`.`NYSIISFNLNBlockingKey`,    `CHIATargetSource`.`DOBPCBlockingKey`,    `CHIATargetSource`.`MRNBlockingKey`,    `CHIATargetSource`.`HealthPlanIDBlockingKey`  FROM `CHIATargetSource`\"");
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
					talendJobLog.addCM("tDBInput_3", "<b>Reference Source</b>", "tMysqlInput");
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
						"enc:routine.encryption.key.v2:/e2DlGWsQYwhvbjyDxSwWdJDwvrrf8I33CTnudlVoMlp5tBKfA==");

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
						"SELECT \n  `CHIATargetSource`.`TargetFirstName`, \n  `CHIATargetSource`.`TargetLastName`, \n  `CHIATargetSource`.`TargetGe"
								+ "nder`, \n  `CHIATargetSource`.`TargetPatientAddress`, \n  `CHIATargetSource`.`TargetCity`, \n  `CHIATargetSource`.`TargetSt"
								+ "ate`, \n  `CHIATargetSource`.`TargetPostalCode`, \n  `CHIATargetSource`.`TargetBirthday`, \n  `CHIATargetSource`.`TargetSSN"
								+ "`, \n  `CHIATargetSource`.`TargetHPLNID`, \n  `CHIATargetSource`.`TargetNYSIISFirstName`, \n  `CHIATargetSource`.`TargetNYS"
								+ "IISLastName`, \n  `CHIATargetSource`.`TargetHealthPlanID`, \n  `CHIATargetSource`.`TargetMRN`, \n  `CHIATargetSource`.`SSNB"
								+ "lockingKey`, \n  `CHIATargetSource`.`FNDOBBlockingKey`, \n  `CHIATargetSource`.`LNPCBlockingKey`, \n  `CHIATargetSource`.`N"
								+ "YSIISFNLNBlockingKey`, \n  `CHIATargetSource`.`DOBPCBlockingKey`, \n  `CHIATargetSource`.`MRNBlockingKey`, \n  `CHIATargetS"
								+ "ource`.`HealthPlanIDBlockingKey`\n FROM `CHIATargetSource`")
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
							Target.TargetFirstName = null;
						} else {

							Target.TargetFirstName = routines.system.JDBCUtil.getString(rs_tDBInput_3, 1, false);
						}
						if (colQtyInRs_tDBInput_3 < 2) {
							Target.TargetLastName = null;
						} else {

							Target.TargetLastName = routines.system.JDBCUtil.getString(rs_tDBInput_3, 2, false);
						}
						if (colQtyInRs_tDBInput_3 < 3) {
							Target.TargetGender = null;
						} else {

							Target.TargetGender = routines.system.JDBCUtil.getString(rs_tDBInput_3, 3, false);
						}
						if (colQtyInRs_tDBInput_3 < 4) {
							Target.TargetPatientAddress = null;
						} else {

							Target.TargetPatientAddress = routines.system.JDBCUtil.getString(rs_tDBInput_3, 4, false);
						}
						if (colQtyInRs_tDBInput_3 < 5) {
							Target.TargetCity = null;
						} else {

							Target.TargetCity = routines.system.JDBCUtil.getString(rs_tDBInput_3, 5, false);
						}
						if (colQtyInRs_tDBInput_3 < 6) {
							Target.TargetState = null;
						} else {

							Target.TargetState = routines.system.JDBCUtil.getString(rs_tDBInput_3, 6, false);
						}
						if (colQtyInRs_tDBInput_3 < 7) {
							Target.TargetPostalCode = null;
						} else {

							Target.TargetPostalCode = rs_tDBInput_3.getInt(7);
							if (rs_tDBInput_3.wasNull()) {
								Target.TargetPostalCode = null;
							}
						}
						if (colQtyInRs_tDBInput_3 < 8) {
							Target.TargetBirthday = null;
						} else {

							if (rs_tDBInput_3.getString(8) != null) {
								String dateString_tDBInput_3 = rs_tDBInput_3.getString(8);
								if (!("0000-00-00").equals(dateString_tDBInput_3)
										&& !("0000-00-00 00:00:00").equals(dateString_tDBInput_3)) {
									Target.TargetBirthday = rs_tDBInput_3.getTimestamp(8);
								} else {
									Target.TargetBirthday = (java.util.Date) year0_tDBInput_3.clone();
								}
							} else {
								Target.TargetBirthday = null;
							}
						}
						if (colQtyInRs_tDBInput_3 < 9) {
							Target.TargetSSN = null;
						} else {

							Target.TargetSSN = routines.system.JDBCUtil.getString(rs_tDBInput_3, 9, false);
						}
						if (colQtyInRs_tDBInput_3 < 10) {
							Target.TargetHPLNID = null;
						} else {

							Target.TargetHPLNID = rs_tDBInput_3.getInt(10);
							if (rs_tDBInput_3.wasNull()) {
								Target.TargetHPLNID = null;
							}
						}
						if (colQtyInRs_tDBInput_3 < 11) {
							Target.TargetNYSIISFirstName = null;
						} else {

							Target.TargetNYSIISFirstName = routines.system.JDBCUtil.getString(rs_tDBInput_3, 11, false);
						}
						if (colQtyInRs_tDBInput_3 < 12) {
							Target.TargetNYSIISLastName = null;
						} else {

							Target.TargetNYSIISLastName = routines.system.JDBCUtil.getString(rs_tDBInput_3, 12, false);
						}
						if (colQtyInRs_tDBInput_3 < 13) {
							Target.TargetHealthPlanID = null;
						} else {

							Target.TargetHealthPlanID = routines.system.JDBCUtil.getString(rs_tDBInput_3, 13, false);
						}
						if (colQtyInRs_tDBInput_3 < 14) {
							Target.TargetMRN = null;
						} else {

							Target.TargetMRN = rs_tDBInput_3.getInt(14);
							if (rs_tDBInput_3.wasNull()) {
								Target.TargetMRN = null;
							}
						}
						if (colQtyInRs_tDBInput_3 < 15) {
							Target.SSNBlockingKey = null;
						} else {

							Target.SSNBlockingKey = routines.system.JDBCUtil.getString(rs_tDBInput_3, 15, false);
						}
						if (colQtyInRs_tDBInput_3 < 16) {
							Target.FNDOBBlockingKey = null;
						} else {

							Target.FNDOBBlockingKey = routines.system.JDBCUtil.getString(rs_tDBInput_3, 16, false);
						}
						if (colQtyInRs_tDBInput_3 < 17) {
							Target.LNPCBlockingKey = null;
						} else {

							Target.LNPCBlockingKey = routines.system.JDBCUtil.getString(rs_tDBInput_3, 17, false);
						}
						if (colQtyInRs_tDBInput_3 < 18) {
							Target.NYSIISFNLNBlockingKey = null;
						} else {

							Target.NYSIISFNLNBlockingKey = routines.system.JDBCUtil.getString(rs_tDBInput_3, 18, false);
						}
						if (colQtyInRs_tDBInput_3 < 19) {
							Target.DOBPCBlockingKey = null;
						} else {

							Target.DOBPCBlockingKey = routines.system.JDBCUtil.getString(rs_tDBInput_3, 19, false);
						}
						if (colQtyInRs_tDBInput_3 < 20) {
							Target.MRNBlockingKey = null;
						} else {

							Target.MRNBlockingKey = routines.system.JDBCUtil.getString(rs_tDBInput_3, 20, false);
						}
						if (colQtyInRs_tDBInput_3 < 21) {
							Target.HealthPlanIDBlockingKey = null;
						} else {

							Target.HealthPlanIDBlockingKey = routines.system.JDBCUtil.getString(rs_tDBInput_3, 21,
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

						cLabel = "<b>Reference Source</b>";

						tos_count_tDBInput_3++;

						/**
						 * [tDBInput_3 main ] stop
						 */

						/**
						 * [tDBInput_3 process_data_begin ] start
						 */

						s(currentComponent = "tDBInput_3");

						cLabel = "<b>Reference Source</b>";

						/**
						 * [tDBInput_3 process_data_begin ] stop
						 */

						/**
						 * [tAdvancedHash_Target main ] start
						 */

						s(currentComponent = "tAdvancedHash_Target");

						if (runStat.update(execStat, enableLogStash, iterateId, 1, 1

								, "Target", "tDBInput_3", "<b>Reference Source</b>", "tMysqlInput",
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
						 * [tDBInput_3 process_data_end ] start
						 */

						s(currentComponent = "tDBInput_3");

						cLabel = "<b>Reference Source</b>";

						/**
						 * [tDBInput_3 process_data_end ] stop
						 */

						/**
						 * [tDBInput_3 end ] start
						 */

						s(currentComponent = "tDBInput_3");

						cLabel = "<b>Reference Source</b>";

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
				 * [tAdvancedHash_Target end ] start
				 */

				s(currentComponent = "tAdvancedHash_Target");

				tHash_Lookup_Target.endPut();

				if (runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, "Target", 2, 0,
						"tDBInput_3", "<b>Reference Source</b>", "tMysqlInput", "tAdvancedHash_Target",
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
				 * [tDBInput_3 finally ] start
				 */

				s(currentComponent = "tDBInput_3");

				cLabel = "<b>Reference Source</b>";

				/**
				 * [tDBInput_3 finally ] stop
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

		globalMap.put("tDBInput_3_SUBPROCESS_STATE", 1);
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
		final CHIA_MDM_MatchingDistance_Full_Calculations CHIA_MDM_MatchingDistance_Full_CalculationsClass = new CHIA_MDM_MatchingDistance_Full_Calculations();

		int exitCode = CHIA_MDM_MatchingDistance_Full_CalculationsClass.runJobInTOS(args);
		if (exitCode == 0) {
			log.info("TalendJob: 'CHIA_MDM_MatchingDistance_Full_Calculations' - Done.");
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
		log.info("TalendJob: 'CHIA_MDM_MatchingDistance_Full_Calculations' - Start.");

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
		org.slf4j.MDC.put("_jobRepositoryId", "_Ed-q0Pb3Ee6gXdUuqyUjQQ");
		org.slf4j.MDC.put("_compiledAtTimestamp", "2025-07-20T23:00:33.726608600Z");

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
			java.io.InputStream inContext = CHIA_MDM_MatchingDistance_Full_Calculations.class.getClassLoader()
					.getResourceAsStream("talendclouddemobank/chia_mdm_matchingdistance_full_calculations_0_1/contexts/"
							+ contextStr + ".properties");
			if (inContext == null) {
				inContext = CHIA_MDM_MatchingDistance_Full_Calculations.class.getClassLoader()
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
					context.setContextType("MySQL_CRM_Password", "id_Password");
					if (context.getStringValue("MySQL_CRM_Password") == null) {
						context.MySQL_CRM_Password = null;
					} else {
						String pwd_MySQL_CRM_Password_value = context.getProperty("MySQL_CRM_Password");
						context.MySQL_CRM_Password = null;
						if (pwd_MySQL_CRM_Password_value != null) {
							if (context_param.containsKey("MySQL_CRM_Password")) {// no need to decrypt if it come from
																					// program argument or parent job
																					// runtime
								context.MySQL_CRM_Password = pwd_MySQL_CRM_Password_value;
							} else if (!pwd_MySQL_CRM_Password_value.isEmpty()) {
								try {
									context.MySQL_CRM_Password = routines.system.PasswordEncryptUtil
											.decryptPassword(pwd_MySQL_CRM_Password_value);
									context.put("MySQL_CRM_Password", context.MySQL_CRM_Password);
								} catch (java.lang.RuntimeException e) {
									// do nothing
								}
							}
						}
					}
					context.setContextType("MySQL_CRM_Port", "id_String");
					if (context.getStringValue("MySQL_CRM_Port") == null) {
						context.MySQL_CRM_Port = null;
					} else {
						context.MySQL_CRM_Port = (String) context.getProperty("MySQL_CRM_Port");
					}
					context.setContextType("MySQL_CRM_Server", "id_String");
					if (context.getStringValue("MySQL_CRM_Server") == null) {
						context.MySQL_CRM_Server = null;
					} else {
						context.MySQL_CRM_Server = (String) context.getProperty("MySQL_CRM_Server");
					}
					context.setContextType("MySQL_CRM_Database", "id_String");
					if (context.getStringValue("MySQL_CRM_Database") == null) {
						context.MySQL_CRM_Database = null;
					} else {
						context.MySQL_CRM_Database = (String) context.getProperty("MySQL_CRM_Database");
					}
					context.setContextType("MySQL_CRM_AdditionalParams", "id_String");
					if (context.getStringValue("MySQL_CRM_AdditionalParams") == null) {
						context.MySQL_CRM_AdditionalParams = null;
					} else {
						context.MySQL_CRM_AdditionalParams = (String) context.getProperty("MySQL_CRM_AdditionalParams");
					}
					context.setContextType("MySQL_CRM_Login", "id_String");
					if (context.getStringValue("MySQL_CRM_Login") == null) {
						context.MySQL_CRM_Login = null;
					} else {
						context.MySQL_CRM_Login = (String) context.getProperty("MySQL_CRM_Login");
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
			if (parentContextMap.containsKey("MySQL_CRM_Password")) {
				context.MySQL_CRM_Password = (java.lang.String) parentContextMap.get("MySQL_CRM_Password");
			}
			if (parentContextMap.containsKey("MySQL_CRM_Port")) {
				context.MySQL_CRM_Port = (String) parentContextMap.get("MySQL_CRM_Port");
			}
			if (parentContextMap.containsKey("MySQL_CRM_Server")) {
				context.MySQL_CRM_Server = (String) parentContextMap.get("MySQL_CRM_Server");
			}
			if (parentContextMap.containsKey("MySQL_CRM_Database")) {
				context.MySQL_CRM_Database = (String) parentContextMap.get("MySQL_CRM_Database");
			}
			if (parentContextMap.containsKey("MySQL_CRM_AdditionalParams")) {
				context.MySQL_CRM_AdditionalParams = (String) parentContextMap.get("MySQL_CRM_AdditionalParams");
			}
			if (parentContextMap.containsKey("MySQL_CRM_Login")) {
				context.MySQL_CRM_Login = (String) parentContextMap.get("MySQL_CRM_Login");
			}
		}

		// Resume: init the resumeUtil
		resumeEntryMethodName = ResumeUtil.getResumeEntryMethodName(resuming_checkpoint_path);
		resumeUtil = new ResumeUtil(resuming_logs_dir_path, isChildJob, rootPid);
		resumeUtil.initCommonInfo(pid, rootPid, fatherPid, projectName, jobName, contextStr, jobVersion);

		List<String> parametersToEncrypt = new java.util.ArrayList<String>();
		parametersToEncrypt.add("MySQL_CRM_Password");
		// Resume: jobStart
		resumeUtil.addLog("JOB_STARTED", "JOB:" + jobName, parent_part_launcher, Thread.currentThread().getId() + "",
				"", "", "", "", resumeUtil.convertToJsonText(context, ContextProperties.class, parametersToEncrypt));

		org.slf4j.MDC.put("_context", contextStr);
		log.info("TalendJob: 'CHIA_MDM_MatchingDistance_Full_Calculations' - Started.");
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
			tDBInput_1Process(globalMap);
			if (!"failure".equals(status)) {
				status = "end";
			}
		} catch (TalendException e_tDBInput_1) {
			globalMap.put("tDBInput_1_SUBPROCESS_STATE", -1);

			e_tDBInput_1.printStackTrace();

		}

		this.globalResumeTicket = true;// to run tPostJob

		end = System.currentTimeMillis();

		if (watch) {
			System.out.println((end - startTime) + " milliseconds");
		}

		endUsedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
		if (false) {
			System.out.println((endUsedMemory - startUsedMemory)
					+ " bytes memory increase when running : CHIA_MDM_MatchingDistance_Full_Calculations");
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
		log.info("TalendJob: 'CHIA_MDM_MatchingDistance_Full_Calculations' - Finished - status: " + status
				+ " returnCode: " + returnCode);

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
 * 508103 characters generated by Talend Cloud Data Fabric on the July 20, 2025
 * at 7:00:33 PM EDT
 ************************************************************************************************/