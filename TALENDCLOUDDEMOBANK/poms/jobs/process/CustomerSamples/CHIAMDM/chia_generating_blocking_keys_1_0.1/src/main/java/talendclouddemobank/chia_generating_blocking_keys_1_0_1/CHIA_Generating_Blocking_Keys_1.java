
package talendclouddemobank.chia_generating_blocking_keys_1_0_1;

import routines.DataOperation;
import routines.TalendDataGenerator;
import routines.DataQuality;
import routines.Relational;
import routines.DataQualityDependencies;
import routines.Mathematical;
import routines.SQLike;
import routines.Numeric;
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
 * Job: CHIA_Generating_Blocking_Keys_1 Purpose: <br>
 * Description: <br>
 * 
 * @author Teklai, Hailemichael
 * @version 8.0.1.20250704_1436-patch
 * @status
 */
public class CHIA_Generating_Blocking_Keys_1 implements TalendJob {
	static {
		System.setProperty("TalendJob.log", "CHIA_Generating_Blocking_Keys_1.log");
	}

	private static org.apache.logging.log4j.Logger log = org.apache.logging.log4j.LogManager
			.getLogger(CHIA_Generating_Blocking_Keys_1.class);

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

		}

		// if the stored or passed value is "<TALEND_NULL>" string, it mean null
		public String getStringValue(String key) {
			String origin_value = this.getProperty(key);
			if (NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY.equals(origin_value)) {
				return null;
			}
			return origin_value;
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
	private final String jobName = "CHIA_Generating_Blocking_Keys_1";
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
			"_vgqFgLx5Ee-ILekM8jCPpA", "0.1");
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
				CHIA_Generating_Blocking_Keys_1.this.exception = e;
			}
			if (!(e instanceof TalendException)) {
				try {
					for (java.lang.reflect.Method m : this.getClass().getEnclosingClass().getMethods()) {
						if (m.getName().compareTo(currentComponent + "_error") == 0) {
							m.invoke(CHIA_Generating_Blocking_Keys_1.this,
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

	public void tFileInputExcel_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFileInputExcel_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tGenKey_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFileInputExcel_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tMap_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap)
			throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFileInputExcel_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tGenKey_2_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFileInputExcel_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tMap_2_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap)
			throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFileInputExcel_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tGenKey_3_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFileInputExcel_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tMap_3_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap)
			throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFileInputExcel_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tGenKey_4_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFileInputExcel_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tMap_4_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap)
			throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFileInputExcel_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tGenKey_5_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFileInputExcel_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tMap_5_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap)
			throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFileInputExcel_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tGenKey_6_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFileInputExcel_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tMap_6_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap)
			throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFileInputExcel_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tGenKey_7_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFileInputExcel_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tMap_7_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap)
			throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFileInputExcel_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tLogRow_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFileInputExcel_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tDBOutput_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFileInputExcel_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void talendJobLog_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		talendJobLog_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tFileInputExcel_1_onSubJobError(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public void talendJobLog_onSubJobError(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public static class row1Struct implements routines.system.IPersistableRow<row1Struct> {
		final static byte[] commonByteArrayLock_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1 = new byte[0];
		static byte[] commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1 = new byte[0];

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

			return "dd-MM-yyyy";

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

			return "dd-MM-yyyy";

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

			return "dd-MM-yyyy";

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

			return "dd-MM-yyyy";

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

			return "dd-MM-yyyy";

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

			return "dd-MM-yyyy";

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
			return 5;
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

			return "dd-MM-yyyy";

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
			return 10;
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

			return "dd-MM-yyyy";

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
			return 7;
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

			return "dd-MM-yyyy";

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

			return "dd-MM-yyyy";

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

			return "dd-MM-yyyy";

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

			return "dd-MM-yyyy";

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
			return 7;
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

			return "dd-MM-yyyy";

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
			return null;
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
			return null;
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
			return null;
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
			return null;
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
			return null;
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
			return null;
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
			return null;
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
				if (length > commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1.length) {
					if (length < 1024
							&& commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1.length == 0) {
						commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1 = new byte[1024];
					} else {
						commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1 = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1, 0, length);
				strReturn = new String(commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1, 0, length,
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
				if (length > commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1.length) {
					if (length < 1024
							&& commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1.length == 0) {
						commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1 = new byte[1024];
					} else {
						commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1 = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1, 0, length);
				strReturn = new String(commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1, 0, length,
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

			synchronized (commonByteArrayLock_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1) {

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

			synchronized (commonByteArrayLock_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1) {

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

	public static class HealthPlanID_OutputStruct
			implements routines.system.IPersistableRow<HealthPlanID_OutputStruct> {
		final static byte[] commonByteArrayLock_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1 = new byte[0];
		static byte[] commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1 = new byte[0];

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

			return "dd-MM-yyyy";

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

			return "dd-MM-yyyy";

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

			return "dd-MM-yyyy";

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

			return "dd-MM-yyyy";

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

			return "dd-MM-yyyy";

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

			return "dd-MM-yyyy";

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
			return 5;
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

			return "dd-MM-yyyy";

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
			return 10;
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

			return "dd-MM-yyyy";

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
			return 7;
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

			return "dd-MM-yyyy";

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

			return "dd-MM-yyyy";

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

			return "dd-MM-yyyy";

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

			return "dd-MM-yyyy";

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
			return 7;
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

			return "dd-MM-yyyy";

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
			return null;
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
			return null;
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
			return null;
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
			return null;
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
			return null;
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
			return null;
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
			return null;
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
				if (length > commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1.length) {
					if (length < 1024
							&& commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1.length == 0) {
						commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1 = new byte[1024];
					} else {
						commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1 = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1, 0, length);
				strReturn = new String(commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1, 0, length,
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
				if (length > commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1.length) {
					if (length < 1024
							&& commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1.length == 0) {
						commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1 = new byte[1024];
					} else {
						commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1 = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1, 0, length);
				strReturn = new String(commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1, 0, length,
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

			synchronized (commonByteArrayLock_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1) {

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

			synchronized (commonByteArrayLock_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1) {

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
		public int compareTo(HealthPlanID_OutputStruct other) {

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

	public static class HealthPlanIDStruct implements routines.system.IPersistableRow<HealthPlanIDStruct> {
		final static byte[] commonByteArrayLock_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1 = new byte[0];
		static byte[] commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1 = new byte[0];

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

			return "dd-MM-yyyy";

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

			return "dd-MM-yyyy";

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

			return "dd-MM-yyyy";

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

			return "dd-MM-yyyy";

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

			return "dd-MM-yyyy";

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

			return "dd-MM-yyyy";

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
			return 5;
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

			return "dd-MM-yyyy";

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
			return 10;
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

			return "dd-MM-yyyy";

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
			return 7;
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

			return "dd-MM-yyyy";

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

			return "dd-MM-yyyy";

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

			return "dd-MM-yyyy";

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

			return "dd-MM-yyyy";

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
			return 7;
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

			return "dd-MM-yyyy";

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
			return null;
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
			return null;
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
			return null;
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
			return null;
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
			return null;
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
			return null;
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

		public String T_GEN_KEY;

		public String getT_GEN_KEY() {
			return this.T_GEN_KEY;
		}

		public Boolean T_GEN_KEYIsNullable() {
			return true;
		}

		public Boolean T_GEN_KEYIsKey() {
			return false;
		}

		public Integer T_GEN_KEYLength() {
			return 255;
		}

		public Integer T_GEN_KEYPrecision() {
			return 0;
		}

		public String T_GEN_KEYDefault() {

			return null;

		}

		public String T_GEN_KEYComment() {

			return null;

		}

		public String T_GEN_KEYPattern() {

			return null;

		}

		public String T_GEN_KEYOriginalDbColumnName() {

			return "T_GEN_KEY";

		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1.length) {
					if (length < 1024
							&& commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1.length == 0) {
						commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1 = new byte[1024];
					} else {
						commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1 = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1, 0, length);
				strReturn = new String(commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1, 0, length,
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
				if (length > commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1.length) {
					if (length < 1024
							&& commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1.length == 0) {
						commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1 = new byte[1024];
					} else {
						commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1 = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1, 0, length);
				strReturn = new String(commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1, 0, length,
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

			synchronized (commonByteArrayLock_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1) {

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

					this.T_GEN_KEY = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1) {

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

					this.T_GEN_KEY = readString(dis);

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

				writeString(this.T_GEN_KEY, dos);

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

				writeString(this.T_GEN_KEY, dos);

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
			sb.append(",T_GEN_KEY=" + T_GEN_KEY);
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

			if (T_GEN_KEY == null) {
				sb.append("<null>");
			} else {
				sb.append(T_GEN_KEY);
			}

			sb.append("|");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(HealthPlanIDStruct other) {

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

	public static class MRN_OutputStruct implements routines.system.IPersistableRow<MRN_OutputStruct> {
		final static byte[] commonByteArrayLock_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1 = new byte[0];
		static byte[] commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1 = new byte[0];

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

			return "dd-MM-yyyy";

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

			return "dd-MM-yyyy";

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

			return "dd-MM-yyyy";

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

			return "dd-MM-yyyy";

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

			return "dd-MM-yyyy";

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

			return "dd-MM-yyyy";

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
			return 5;
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

			return "dd-MM-yyyy";

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
			return 10;
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

			return "dd-MM-yyyy";

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
			return 7;
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

			return "dd-MM-yyyy";

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

			return "dd-MM-yyyy";

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

			return "dd-MM-yyyy";

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

			return "dd-MM-yyyy";

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
			return 7;
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

			return "dd-MM-yyyy";

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
			return null;
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
			return null;
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
			return null;
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
			return null;
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
			return null;
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
			return null;
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

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1.length) {
					if (length < 1024
							&& commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1.length == 0) {
						commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1 = new byte[1024];
					} else {
						commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1 = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1, 0, length);
				strReturn = new String(commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1, 0, length,
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
				if (length > commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1.length) {
					if (length < 1024
							&& commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1.length == 0) {
						commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1 = new byte[1024];
					} else {
						commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1 = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1, 0, length);
				strReturn = new String(commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1, 0, length,
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

			synchronized (commonByteArrayLock_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1) {

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

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1) {

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

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(MRN_OutputStruct other) {

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

	public static class MRNStruct implements routines.system.IPersistableRow<MRNStruct> {
		final static byte[] commonByteArrayLock_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1 = new byte[0];
		static byte[] commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1 = new byte[0];

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

			return "dd-MM-yyyy";

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

			return "dd-MM-yyyy";

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

			return "dd-MM-yyyy";

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

			return "dd-MM-yyyy";

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

			return "dd-MM-yyyy";

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

			return "dd-MM-yyyy";

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
			return 5;
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

			return "dd-MM-yyyy";

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
			return 10;
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

			return "dd-MM-yyyy";

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
			return 7;
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

			return "dd-MM-yyyy";

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

			return "dd-MM-yyyy";

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

			return "dd-MM-yyyy";

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

			return "dd-MM-yyyy";

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
			return 7;
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

			return "dd-MM-yyyy";

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
			return null;
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
			return null;
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
			return null;
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
			return null;
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
			return null;
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

		public String T_GEN_KEY;

		public String getT_GEN_KEY() {
			return this.T_GEN_KEY;
		}

		public Boolean T_GEN_KEYIsNullable() {
			return true;
		}

		public Boolean T_GEN_KEYIsKey() {
			return false;
		}

		public Integer T_GEN_KEYLength() {
			return 255;
		}

		public Integer T_GEN_KEYPrecision() {
			return 0;
		}

		public String T_GEN_KEYDefault() {

			return null;

		}

		public String T_GEN_KEYComment() {

			return null;

		}

		public String T_GEN_KEYPattern() {

			return null;

		}

		public String T_GEN_KEYOriginalDbColumnName() {

			return "T_GEN_KEY";

		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1.length) {
					if (length < 1024
							&& commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1.length == 0) {
						commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1 = new byte[1024];
					} else {
						commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1 = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1, 0, length);
				strReturn = new String(commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1, 0, length,
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
				if (length > commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1.length) {
					if (length < 1024
							&& commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1.length == 0) {
						commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1 = new byte[1024];
					} else {
						commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1 = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1, 0, length);
				strReturn = new String(commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1, 0, length,
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

			synchronized (commonByteArrayLock_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1) {

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

					this.T_GEN_KEY = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1) {

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

					this.T_GEN_KEY = readString(dis);

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

				writeString(this.T_GEN_KEY, dos);

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

				writeString(this.T_GEN_KEY, dos);

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
			sb.append(",T_GEN_KEY=" + T_GEN_KEY);
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

			if (T_GEN_KEY == null) {
				sb.append("<null>");
			} else {
				sb.append(T_GEN_KEY);
			}

			sb.append("|");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(MRNStruct other) {

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

	public static class DOBPC_OutputStruct implements routines.system.IPersistableRow<DOBPC_OutputStruct> {
		final static byte[] commonByteArrayLock_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1 = new byte[0];
		static byte[] commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1 = new byte[0];

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

			return "dd-MM-yyyy";

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

			return "dd-MM-yyyy";

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

			return "dd-MM-yyyy";

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

			return "dd-MM-yyyy";

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

			return "dd-MM-yyyy";

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

			return "dd-MM-yyyy";

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
			return 5;
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

			return "dd-MM-yyyy";

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
			return 10;
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

			return "dd-MM-yyyy";

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
			return 7;
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

			return "dd-MM-yyyy";

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

			return "dd-MM-yyyy";

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

			return "dd-MM-yyyy";

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

			return "dd-MM-yyyy";

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
			return 7;
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

			return "dd-MM-yyyy";

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
			return null;
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
			return null;
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
			return null;
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
			return null;
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
			return null;
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

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1.length) {
					if (length < 1024
							&& commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1.length == 0) {
						commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1 = new byte[1024];
					} else {
						commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1 = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1, 0, length);
				strReturn = new String(commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1, 0, length,
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
				if (length > commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1.length) {
					if (length < 1024
							&& commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1.length == 0) {
						commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1 = new byte[1024];
					} else {
						commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1 = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1, 0, length);
				strReturn = new String(commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1, 0, length,
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

			synchronized (commonByteArrayLock_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1) {

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

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1) {

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

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(DOBPC_OutputStruct other) {

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

	public static class DOBPCStruct implements routines.system.IPersistableRow<DOBPCStruct> {
		final static byte[] commonByteArrayLock_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1 = new byte[0];
		static byte[] commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1 = new byte[0];

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

			return "dd-MM-yyyy";

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

			return "dd-MM-yyyy";

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

			return "dd-MM-yyyy";

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

			return "dd-MM-yyyy";

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

			return "dd-MM-yyyy";

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

			return "dd-MM-yyyy";

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
			return 5;
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

			return "dd-MM-yyyy";

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
			return 10;
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

			return "dd-MM-yyyy";

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
			return 7;
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

			return "dd-MM-yyyy";

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

			return "dd-MM-yyyy";

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

			return "dd-MM-yyyy";

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

			return "dd-MM-yyyy";

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
			return 7;
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

			return "dd-MM-yyyy";

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
			return null;
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
			return null;
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
			return null;
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
			return null;
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

		public String T_GEN_KEY;

		public String getT_GEN_KEY() {
			return this.T_GEN_KEY;
		}

		public Boolean T_GEN_KEYIsNullable() {
			return true;
		}

		public Boolean T_GEN_KEYIsKey() {
			return false;
		}

		public Integer T_GEN_KEYLength() {
			return 255;
		}

		public Integer T_GEN_KEYPrecision() {
			return 0;
		}

		public String T_GEN_KEYDefault() {

			return null;

		}

		public String T_GEN_KEYComment() {

			return null;

		}

		public String T_GEN_KEYPattern() {

			return null;

		}

		public String T_GEN_KEYOriginalDbColumnName() {

			return "T_GEN_KEY";

		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1.length) {
					if (length < 1024
							&& commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1.length == 0) {
						commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1 = new byte[1024];
					} else {
						commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1 = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1, 0, length);
				strReturn = new String(commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1, 0, length,
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
				if (length > commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1.length) {
					if (length < 1024
							&& commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1.length == 0) {
						commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1 = new byte[1024];
					} else {
						commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1 = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1, 0, length);
				strReturn = new String(commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1, 0, length,
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

			synchronized (commonByteArrayLock_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1) {

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

					this.T_GEN_KEY = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1) {

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

					this.T_GEN_KEY = readString(dis);

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

				writeString(this.T_GEN_KEY, dos);

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

				writeString(this.T_GEN_KEY, dos);

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
			sb.append(",T_GEN_KEY=" + T_GEN_KEY);
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

			if (T_GEN_KEY == null) {
				sb.append("<null>");
			} else {
				sb.append(T_GEN_KEY);
			}

			sb.append("|");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(DOBPCStruct other) {

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

	public static class NYSIISFNLN_OutputStruct implements routines.system.IPersistableRow<NYSIISFNLN_OutputStruct> {
		final static byte[] commonByteArrayLock_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1 = new byte[0];
		static byte[] commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1 = new byte[0];

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

			return "dd-MM-yyyy";

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

			return "dd-MM-yyyy";

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

			return "dd-MM-yyyy";

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

			return "dd-MM-yyyy";

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

			return "dd-MM-yyyy";

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

			return "dd-MM-yyyy";

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
			return 5;
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

			return "dd-MM-yyyy";

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
			return 10;
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

			return "dd-MM-yyyy";

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
			return 7;
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

			return "dd-MM-yyyy";

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

			return "dd-MM-yyyy";

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

			return "dd-MM-yyyy";

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

			return "dd-MM-yyyy";

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
			return 7;
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

			return "dd-MM-yyyy";

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
			return null;
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
			return null;
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
			return null;
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
			return null;
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

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1.length) {
					if (length < 1024
							&& commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1.length == 0) {
						commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1 = new byte[1024];
					} else {
						commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1 = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1, 0, length);
				strReturn = new String(commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1, 0, length,
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
				if (length > commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1.length) {
					if (length < 1024
							&& commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1.length == 0) {
						commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1 = new byte[1024];
					} else {
						commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1 = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1, 0, length);
				strReturn = new String(commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1, 0, length,
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

			synchronized (commonByteArrayLock_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1) {

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

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1) {

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

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(NYSIISFNLN_OutputStruct other) {

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

	public static class NYSIISFNLNStruct implements routines.system.IPersistableRow<NYSIISFNLNStruct> {
		final static byte[] commonByteArrayLock_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1 = new byte[0];
		static byte[] commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1 = new byte[0];

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

			return "dd-MM-yyyy";

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

			return "dd-MM-yyyy";

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

			return "dd-MM-yyyy";

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

			return "dd-MM-yyyy";

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

			return "dd-MM-yyyy";

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

			return "dd-MM-yyyy";

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
			return 5;
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

			return "dd-MM-yyyy";

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
			return 10;
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

			return "dd-MM-yyyy";

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
			return 7;
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

			return "dd-MM-yyyy";

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

			return "dd-MM-yyyy";

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

			return "dd-MM-yyyy";

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

			return "dd-MM-yyyy";

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
			return 7;
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

			return "dd-MM-yyyy";

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
			return null;
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
			return null;
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
			return null;
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

		public String T_GEN_KEY;

		public String getT_GEN_KEY() {
			return this.T_GEN_KEY;
		}

		public Boolean T_GEN_KEYIsNullable() {
			return true;
		}

		public Boolean T_GEN_KEYIsKey() {
			return false;
		}

		public Integer T_GEN_KEYLength() {
			return 255;
		}

		public Integer T_GEN_KEYPrecision() {
			return 0;
		}

		public String T_GEN_KEYDefault() {

			return null;

		}

		public String T_GEN_KEYComment() {

			return null;

		}

		public String T_GEN_KEYPattern() {

			return null;

		}

		public String T_GEN_KEYOriginalDbColumnName() {

			return "T_GEN_KEY";

		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1.length) {
					if (length < 1024
							&& commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1.length == 0) {
						commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1 = new byte[1024];
					} else {
						commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1 = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1, 0, length);
				strReturn = new String(commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1, 0, length,
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
				if (length > commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1.length) {
					if (length < 1024
							&& commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1.length == 0) {
						commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1 = new byte[1024];
					} else {
						commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1 = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1, 0, length);
				strReturn = new String(commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1, 0, length,
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

			synchronized (commonByteArrayLock_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1) {

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

					this.T_GEN_KEY = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1) {

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

					this.T_GEN_KEY = readString(dis);

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

				writeString(this.T_GEN_KEY, dos);

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

				writeString(this.T_GEN_KEY, dos);

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
			sb.append(",T_GEN_KEY=" + T_GEN_KEY);
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

			if (T_GEN_KEY == null) {
				sb.append("<null>");
			} else {
				sb.append(T_GEN_KEY);
			}

			sb.append("|");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(NYSIISFNLNStruct other) {

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

	public static class LNPC_OutputStruct implements routines.system.IPersistableRow<LNPC_OutputStruct> {
		final static byte[] commonByteArrayLock_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1 = new byte[0];
		static byte[] commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1 = new byte[0];

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

			return "dd-MM-yyyy";

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

			return "dd-MM-yyyy";

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

			return "dd-MM-yyyy";

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

			return "dd-MM-yyyy";

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

			return "dd-MM-yyyy";

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

			return "dd-MM-yyyy";

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
			return 5;
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

			return "dd-MM-yyyy";

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
			return 10;
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

			return "dd-MM-yyyy";

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
			return 7;
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

			return "dd-MM-yyyy";

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

			return "dd-MM-yyyy";

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

			return "dd-MM-yyyy";

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

			return "dd-MM-yyyy";

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
			return 7;
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

			return "dd-MM-yyyy";

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
			return null;
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
			return null;
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
			return null;
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

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1.length) {
					if (length < 1024
							&& commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1.length == 0) {
						commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1 = new byte[1024];
					} else {
						commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1 = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1, 0, length);
				strReturn = new String(commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1, 0, length,
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
				if (length > commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1.length) {
					if (length < 1024
							&& commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1.length == 0) {
						commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1 = new byte[1024];
					} else {
						commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1 = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1, 0, length);
				strReturn = new String(commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1, 0, length,
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

			synchronized (commonByteArrayLock_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1) {

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

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1) {

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

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(LNPC_OutputStruct other) {

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

	public static class LNPCStruct implements routines.system.IPersistableRow<LNPCStruct> {
		final static byte[] commonByteArrayLock_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1 = new byte[0];
		static byte[] commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1 = new byte[0];

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

			return "dd-MM-yyyy";

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

			return "dd-MM-yyyy";

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

			return "dd-MM-yyyy";

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

			return "dd-MM-yyyy";

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

			return "dd-MM-yyyy";

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

			return "dd-MM-yyyy";

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
			return 5;
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

			return "dd-MM-yyyy";

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
			return 10;
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

			return "dd-MM-yyyy";

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
			return 7;
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

			return "dd-MM-yyyy";

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

			return "dd-MM-yyyy";

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

			return "dd-MM-yyyy";

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

			return "dd-MM-yyyy";

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
			return 7;
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

			return "dd-MM-yyyy";

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
			return null;
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
			return null;
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

		public String T_GEN_KEY;

		public String getT_GEN_KEY() {
			return this.T_GEN_KEY;
		}

		public Boolean T_GEN_KEYIsNullable() {
			return true;
		}

		public Boolean T_GEN_KEYIsKey() {
			return false;
		}

		public Integer T_GEN_KEYLength() {
			return 255;
		}

		public Integer T_GEN_KEYPrecision() {
			return 0;
		}

		public String T_GEN_KEYDefault() {

			return null;

		}

		public String T_GEN_KEYComment() {

			return null;

		}

		public String T_GEN_KEYPattern() {

			return null;

		}

		public String T_GEN_KEYOriginalDbColumnName() {

			return "T_GEN_KEY";

		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1.length) {
					if (length < 1024
							&& commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1.length == 0) {
						commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1 = new byte[1024];
					} else {
						commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1 = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1, 0, length);
				strReturn = new String(commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1, 0, length,
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
				if (length > commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1.length) {
					if (length < 1024
							&& commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1.length == 0) {
						commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1 = new byte[1024];
					} else {
						commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1 = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1, 0, length);
				strReturn = new String(commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1, 0, length,
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

			synchronized (commonByteArrayLock_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1) {

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

					this.T_GEN_KEY = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1) {

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

					this.T_GEN_KEY = readString(dis);

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

				writeString(this.T_GEN_KEY, dos);

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

				writeString(this.T_GEN_KEY, dos);

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
			sb.append(",T_GEN_KEY=" + T_GEN_KEY);
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

			if (T_GEN_KEY == null) {
				sb.append("<null>");
			} else {
				sb.append(T_GEN_KEY);
			}

			sb.append("|");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(LNPCStruct other) {

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

	public static class FNDOB_OutputStruct implements routines.system.IPersistableRow<FNDOB_OutputStruct> {
		final static byte[] commonByteArrayLock_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1 = new byte[0];
		static byte[] commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1 = new byte[0];

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

			return "dd-MM-yyyy";

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

			return "dd-MM-yyyy";

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

			return "dd-MM-yyyy";

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

			return "dd-MM-yyyy";

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

			return "dd-MM-yyyy";

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

			return "dd-MM-yyyy";

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
			return 5;
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

			return "dd-MM-yyyy";

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
			return 10;
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

			return "dd-MM-yyyy";

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
			return 7;
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

			return "dd-MM-yyyy";

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

			return "dd-MM-yyyy";

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

			return "dd-MM-yyyy";

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

			return "dd-MM-yyyy";

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
			return 7;
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

			return "dd-MM-yyyy";

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
			return null;
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
			return null;
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

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1.length) {
					if (length < 1024
							&& commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1.length == 0) {
						commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1 = new byte[1024];
					} else {
						commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1 = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1, 0, length);
				strReturn = new String(commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1, 0, length,
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
				if (length > commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1.length) {
					if (length < 1024
							&& commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1.length == 0) {
						commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1 = new byte[1024];
					} else {
						commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1 = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1, 0, length);
				strReturn = new String(commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1, 0, length,
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

			synchronized (commonByteArrayLock_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1) {

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

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1) {

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

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(FNDOB_OutputStruct other) {

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

	public static class FNDOBStruct implements routines.system.IPersistableRow<FNDOBStruct> {
		final static byte[] commonByteArrayLock_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1 = new byte[0];
		static byte[] commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1 = new byte[0];

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

			return "dd-MM-yyyy";

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

			return "dd-MM-yyyy";

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

			return "dd-MM-yyyy";

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

			return "dd-MM-yyyy";

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

			return "dd-MM-yyyy";

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

			return "dd-MM-yyyy";

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
			return 5;
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

			return "dd-MM-yyyy";

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
			return 10;
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

			return "dd-MM-yyyy";

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
			return 7;
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

			return "dd-MM-yyyy";

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

			return "dd-MM-yyyy";

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

			return "dd-MM-yyyy";

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

			return "dd-MM-yyyy";

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
			return 7;
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

			return "dd-MM-yyyy";

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
			return null;
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

		public String T_GEN_KEY;

		public String getT_GEN_KEY() {
			return this.T_GEN_KEY;
		}

		public Boolean T_GEN_KEYIsNullable() {
			return true;
		}

		public Boolean T_GEN_KEYIsKey() {
			return false;
		}

		public Integer T_GEN_KEYLength() {
			return 255;
		}

		public Integer T_GEN_KEYPrecision() {
			return 0;
		}

		public String T_GEN_KEYDefault() {

			return null;

		}

		public String T_GEN_KEYComment() {

			return null;

		}

		public String T_GEN_KEYPattern() {

			return null;

		}

		public String T_GEN_KEYOriginalDbColumnName() {

			return "T_GEN_KEY";

		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1.length) {
					if (length < 1024
							&& commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1.length == 0) {
						commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1 = new byte[1024];
					} else {
						commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1 = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1, 0, length);
				strReturn = new String(commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1, 0, length,
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
				if (length > commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1.length) {
					if (length < 1024
							&& commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1.length == 0) {
						commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1 = new byte[1024];
					} else {
						commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1 = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1, 0, length);
				strReturn = new String(commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1, 0, length,
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

			synchronized (commonByteArrayLock_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1) {

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

					this.T_GEN_KEY = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1) {

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

					this.T_GEN_KEY = readString(dis);

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

				writeString(this.T_GEN_KEY, dos);

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

				writeString(this.T_GEN_KEY, dos);

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
			sb.append(",T_GEN_KEY=" + T_GEN_KEY);
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

			if (T_GEN_KEY == null) {
				sb.append("<null>");
			} else {
				sb.append(T_GEN_KEY);
			}

			sb.append("|");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(FNDOBStruct other) {

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

	public static class SSN_OutputStruct implements routines.system.IPersistableRow<SSN_OutputStruct> {
		final static byte[] commonByteArrayLock_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1 = new byte[0];
		static byte[] commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1 = new byte[0];

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

			return "dd-MM-yyyy";

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

			return "dd-MM-yyyy";

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

			return "dd-MM-yyyy";

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

			return "dd-MM-yyyy";

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

			return "dd-MM-yyyy";

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

			return "dd-MM-yyyy";

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
			return 5;
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

			return "dd-MM-yyyy";

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
			return 10;
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

			return "dd-MM-yyyy";

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
			return 7;
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

			return "dd-MM-yyyy";

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

			return "dd-MM-yyyy";

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

			return "dd-MM-yyyy";

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

			return "dd-MM-yyyy";

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
			return 7;
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

			return "dd-MM-yyyy";

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
			return null;
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

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1.length) {
					if (length < 1024
							&& commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1.length == 0) {
						commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1 = new byte[1024];
					} else {
						commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1 = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1, 0, length);
				strReturn = new String(commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1, 0, length,
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
				if (length > commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1.length) {
					if (length < 1024
							&& commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1.length == 0) {
						commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1 = new byte[1024];
					} else {
						commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1 = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1, 0, length);
				strReturn = new String(commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1, 0, length,
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

			synchronized (commonByteArrayLock_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1) {

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

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1) {

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

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(SSN_OutputStruct other) {

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

	public static class SSNStruct implements routines.system.IPersistableRow<SSNStruct> {
		final static byte[] commonByteArrayLock_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1 = new byte[0];
		static byte[] commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1 = new byte[0];

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

			return "dd-MM-yyyy";

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

			return "dd-MM-yyyy";

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

			return "dd-MM-yyyy";

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

			return "dd-MM-yyyy";

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

			return "dd-MM-yyyy";

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

			return "dd-MM-yyyy";

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
			return 5;
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

			return "dd-MM-yyyy";

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
			return 10;
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

			return "dd-MM-yyyy";

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
			return 7;
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

			return "dd-MM-yyyy";

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

			return "dd-MM-yyyy";

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

			return "dd-MM-yyyy";

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

			return "dd-MM-yyyy";

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
			return 7;
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

			return "dd-MM-yyyy";

		}

		public String MRNOriginalDbColumnName() {

			return "MRN";

		}

		public String T_GEN_KEY;

		public String getT_GEN_KEY() {
			return this.T_GEN_KEY;
		}

		public Boolean T_GEN_KEYIsNullable() {
			return true;
		}

		public Boolean T_GEN_KEYIsKey() {
			return false;
		}

		public Integer T_GEN_KEYLength() {
			return 255;
		}

		public Integer T_GEN_KEYPrecision() {
			return 0;
		}

		public String T_GEN_KEYDefault() {

			return null;

		}

		public String T_GEN_KEYComment() {

			return null;

		}

		public String T_GEN_KEYPattern() {

			return null;

		}

		public String T_GEN_KEYOriginalDbColumnName() {

			return "T_GEN_KEY";

		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1.length) {
					if (length < 1024
							&& commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1.length == 0) {
						commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1 = new byte[1024];
					} else {
						commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1 = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1, 0, length);
				strReturn = new String(commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1, 0, length,
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
				if (length > commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1.length) {
					if (length < 1024
							&& commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1.length == 0) {
						commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1 = new byte[1024];
					} else {
						commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1 = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1, 0, length);
				strReturn = new String(commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1, 0, length,
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

			synchronized (commonByteArrayLock_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1) {

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

					this.T_GEN_KEY = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1) {

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

					this.T_GEN_KEY = readString(dis);

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

				writeString(this.T_GEN_KEY, dos);

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

				writeString(this.T_GEN_KEY, dos);

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
			sb.append(",T_GEN_KEY=" + T_GEN_KEY);
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

			if (T_GEN_KEY == null) {
				sb.append("<null>");
			} else {
				sb.append(T_GEN_KEY);
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

	public static class CHIAStruct implements routines.system.IPersistableRow<CHIAStruct> {
		final static byte[] commonByteArrayLock_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1 = new byte[0];
		static byte[] commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1 = new byte[0];

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

			return "dd-MM-yyyy";

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

			return "dd-MM-yyyy";

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

			return "dd-MM-yyyy";

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

			return "dd-MM-yyyy";

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

			return "dd-MM-yyyy";

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

			return "dd-MM-yyyy";

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
			return 5;
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

			return "dd-MM-yyyy";

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
			return 10;
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

			return "dd-MM-yyyy";

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
			return 7;
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

			return "dd-MM-yyyy";

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

			return "dd-MM-yyyy";

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

			return "dd-MM-yyyy";

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

			return "dd-MM-yyyy";

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
			return 7;
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

			return "dd-MM-yyyy";

		}

		public String MRNOriginalDbColumnName() {

			return "MRN";

		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1.length) {
					if (length < 1024
							&& commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1.length == 0) {
						commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1 = new byte[1024];
					} else {
						commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1 = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1, 0, length);
				strReturn = new String(commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1, 0, length,
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
				if (length > commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1.length) {
					if (length < 1024
							&& commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1.length == 0) {
						commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1 = new byte[1024];
					} else {
						commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1 = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1, 0, length);
				strReturn = new String(commonByteArray_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1, 0, length,
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

			synchronized (commonByteArrayLock_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1) {

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

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_TALENDCLOUDDEMOBANK_CHIA_Generating_Blocking_Keys_1) {

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

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(CHIAStruct other) {

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

	public void tFileInputExcel_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("tFileInputExcel_1_SUBPROCESS_STATE", 0);

		final boolean execStat = this.execStat;

		mdc("tFileInputExcel_1", "vBAfaI_");

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

				CHIAStruct CHIA = new CHIAStruct();
				SSNStruct SSN = new SSNStruct();
				SSN_OutputStruct SSN_Output = new SSN_OutputStruct();
				FNDOBStruct FNDOB = new FNDOBStruct();
				FNDOB_OutputStruct FNDOB_Output = new FNDOB_OutputStruct();
				LNPCStruct LNPC = new LNPCStruct();
				LNPC_OutputStruct LNPC_Output = new LNPC_OutputStruct();
				NYSIISFNLNStruct NYSIISFNLN = new NYSIISFNLNStruct();
				NYSIISFNLN_OutputStruct NYSIISFNLN_Output = new NYSIISFNLN_OutputStruct();
				DOBPCStruct DOBPC = new DOBPCStruct();
				DOBPC_OutputStruct DOBPC_Output = new DOBPC_OutputStruct();
				MRNStruct MRN = new MRNStruct();
				MRN_OutputStruct MRN_Output = new MRN_OutputStruct();
				HealthPlanIDStruct HealthPlanID = new HealthPlanIDStruct();
				HealthPlanID_OutputStruct HealthPlanID_Output = new HealthPlanID_OutputStruct();
				HealthPlanID_OutputStruct row1 = HealthPlanID_Output;

				/**
				 * [tDBOutput_1 begin ] start
				 */

				sh("tDBOutput_1");

				s(currentComponent = "tDBOutput_1");

				cLabel = "MYSQCHIA";

				runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, 0, 0, "row1");

				int tos_count_tDBOutput_1 = 0;

				if (log.isDebugEnabled())
					log.debug("tDBOutput_1 - " + ("Start to work."));
				if (log.isDebugEnabled()) {
					class BytesLimit65535_tDBOutput_1 {
						public void limitLog4jByte() throws Exception {
							StringBuilder log4jParamters_tDBOutput_1 = new StringBuilder();
							log4jParamters_tDBOutput_1.append("Parameters:");
							log4jParamters_tDBOutput_1.append("DB_VERSION" + " = " + "MYSQL_8");
							log4jParamters_tDBOutput_1.append(" | ");
							log4jParamters_tDBOutput_1.append("USE_EXISTING_CONNECTION" + " = " + "false");
							log4jParamters_tDBOutput_1.append(" | ");
							log4jParamters_tDBOutput_1.append("HOST" + " = " + "\"localhost\"");
							log4jParamters_tDBOutput_1.append(" | ");
							log4jParamters_tDBOutput_1.append("PORT" + " = " + "\"3306\"");
							log4jParamters_tDBOutput_1.append(" | ");
							log4jParamters_tDBOutput_1.append("DBNAME" + " = " + "\"CHIA\"");
							log4jParamters_tDBOutput_1.append(" | ");
							log4jParamters_tDBOutput_1.append("USER" + " = " + "\"root\"");
							log4jParamters_tDBOutput_1.append(" | ");
							log4jParamters_tDBOutput_1.append("PASS" + " = " + String.valueOf(
									"enc:routine.encryption.key.v2:71NXbFuauiLpfs1LdIRLP84kPPp1XS4rU2mOBwAISnYDYLFo9A==")
									.substring(0, 4) + "...");
							log4jParamters_tDBOutput_1.append(" | ");
							log4jParamters_tDBOutput_1.append("TABLE" + " = " + "\"CHIAStage\"");
							log4jParamters_tDBOutput_1.append(" | ");
							log4jParamters_tDBOutput_1.append("TABLE_ACTION" + " = " + "DROP_IF_EXISTS_AND_CREATE");
							log4jParamters_tDBOutput_1.append(" | ");
							log4jParamters_tDBOutput_1.append("DATA_ACTION" + " = " + "INSERT");
							log4jParamters_tDBOutput_1.append(" | ");
							log4jParamters_tDBOutput_1.append("SPECIFY_DATASOURCE_ALIAS" + " = " + "false");
							log4jParamters_tDBOutput_1.append(" | ");
							log4jParamters_tDBOutput_1.append("DIE_ON_ERROR" + " = " + "false");
							log4jParamters_tDBOutput_1.append(" | ");
							log4jParamters_tDBOutput_1.append("PROPERTIES" + " = "
									+ "\"noDatetimeStringSync=true&enabledTLSProtocols=TLSv1.2,TLSv1.1,TLSv1\"");
							log4jParamters_tDBOutput_1.append(" | ");
							log4jParamters_tDBOutput_1.append("USE_BATCH_SIZE" + " = " + "true");
							log4jParamters_tDBOutput_1.append(" | ");
							log4jParamters_tDBOutput_1.append("BATCH_SIZE" + " = " + "100");
							log4jParamters_tDBOutput_1.append(" | ");
							log4jParamters_tDBOutput_1.append("COMMIT_EVERY" + " = " + "10000");
							log4jParamters_tDBOutput_1.append(" | ");
							log4jParamters_tDBOutput_1.append("ADD_COLS" + " = " + "[]");
							log4jParamters_tDBOutput_1.append(" | ");
							log4jParamters_tDBOutput_1.append("USE_FIELD_OPTIONS" + " = " + "false");
							log4jParamters_tDBOutput_1.append(" | ");
							log4jParamters_tDBOutput_1.append("USE_HINT_OPTIONS" + " = " + "false");
							log4jParamters_tDBOutput_1.append(" | ");
							log4jParamters_tDBOutput_1.append("ENABLE_DEBUG_MODE" + " = " + "false");
							log4jParamters_tDBOutput_1.append(" | ");
							log4jParamters_tDBOutput_1.append("ON_DUPLICATE_KEY_UPDATE" + " = " + "false");
							log4jParamters_tDBOutput_1.append(" | ");
							log4jParamters_tDBOutput_1.append("UNIFIED_COMPONENTS" + " = " + "tMysqlOutput");
							log4jParamters_tDBOutput_1.append(" | ");
							if (log.isDebugEnabled())
								log.debug("tDBOutput_1 - " + (log4jParamters_tDBOutput_1));
						}
					}
					new BytesLimit65535_tDBOutput_1().limitLog4jByte();
				}
				if (enableLogStash) {
					talendJobLog.addCM("tDBOutput_1", "MYSQCHIA", "tMysqlOutput");
					talendJobLogProcess(globalMap);
					s(currentComponent);
				}

				int nb_line_tDBOutput_1 = 0;
				int nb_line_update_tDBOutput_1 = 0;
				int nb_line_inserted_tDBOutput_1 = 0;
				int nb_line_deleted_tDBOutput_1 = 0;
				int nb_line_rejected_tDBOutput_1 = 0;

				int deletedCount_tDBOutput_1 = 0;
				int updatedCount_tDBOutput_1 = 0;
				int insertedCount_tDBOutput_1 = 0;
				int rowsToCommitCount_tDBOutput_1 = 0;
				int rejectedCount_tDBOutput_1 = 0;

				String tableName_tDBOutput_1 = "CHIAStage";
				boolean whetherReject_tDBOutput_1 = false;

				java.util.Calendar calendar_tDBOutput_1 = java.util.Calendar.getInstance();
				calendar_tDBOutput_1.set(1, 0, 1, 0, 0, 0);
				long year1_tDBOutput_1 = calendar_tDBOutput_1.getTime().getTime();
				calendar_tDBOutput_1.set(10000, 0, 1, 0, 0, 0);
				long year10000_tDBOutput_1 = calendar_tDBOutput_1.getTime().getTime();
				long date_tDBOutput_1;

				java.sql.Connection conn_tDBOutput_1 = null;

				String properties_tDBOutput_1 = "noDatetimeStringSync=true&enabledTLSProtocols=TLSv1.2,TLSv1.1,TLSv1";
				if (properties_tDBOutput_1 == null || properties_tDBOutput_1.trim().length() == 0) {
					properties_tDBOutput_1 = "rewriteBatchedStatements=true&allowLoadLocalInfile=true";
				} else {
					if (!properties_tDBOutput_1.contains("rewriteBatchedStatements=")) {
						properties_tDBOutput_1 += "&rewriteBatchedStatements=true";
					}

					if (!properties_tDBOutput_1.contains("allowLoadLocalInfile=")) {
						properties_tDBOutput_1 += "&allowLoadLocalInfile=true";
					}
				}

				String url_tDBOutput_1 = "jdbc:mysql://" + "localhost" + ":" + "3306" + "/" + "CHIA" + "?"
						+ properties_tDBOutput_1;

				String driverClass_tDBOutput_1 = "com.mysql.cj.jdbc.Driver";

				if (log.isDebugEnabled())
					log.debug("tDBOutput_1 - " + ("Driver ClassName: ") + (driverClass_tDBOutput_1) + ("."));
				String dbUser_tDBOutput_1 = "root";

				final String decryptedPassword_tDBOutput_1 = routines.system.PasswordEncryptUtil.decryptPassword(
						"enc:routine.encryption.key.v2:PAoG9fsRKRW0BIiC2DBSgNfajWO+kvNNjdJRiigeJiBvGHzFsA==");

				String dbPwd_tDBOutput_1 = decryptedPassword_tDBOutput_1;
				java.lang.Class.forName(driverClass_tDBOutput_1);

				if (log.isDebugEnabled())
					log.debug("tDBOutput_1 - " + ("Connection attempts to '") + (url_tDBOutput_1)
							+ ("' with the username '") + (dbUser_tDBOutput_1) + ("'."));
				conn_tDBOutput_1 = java.sql.DriverManager.getConnection(url_tDBOutput_1, dbUser_tDBOutput_1,
						dbPwd_tDBOutput_1);

				if (log.isDebugEnabled())
					log.debug("tDBOutput_1 - " + ("Connection to '") + (url_tDBOutput_1) + ("' has succeeded."));

				resourceMap.put("conn_tDBOutput_1", conn_tDBOutput_1);

				conn_tDBOutput_1.setAutoCommit(false);
				int commitEvery_tDBOutput_1 = 10000;
				int commitCounter_tDBOutput_1 = 0;

				if (log.isDebugEnabled())
					log.debug("tDBOutput_1 - " + ("Connection is set auto commit to '")
							+ (conn_tDBOutput_1.getAutoCommit()) + ("'."));

				int count_tDBOutput_1 = 0;

				java.sql.DatabaseMetaData dbMetaData_tDBOutput_1 = conn_tDBOutput_1.getMetaData();
				java.sql.ResultSet rsTable_tDBOutput_1 = dbMetaData_tDBOutput_1.getTables("CHIA", null, null,
						new String[] { "TABLE" });
				boolean whetherExist_tDBOutput_1 = false;
				while (rsTable_tDBOutput_1.next()) {
					String table_tDBOutput_1 = rsTable_tDBOutput_1.getString("TABLE_NAME");
					if (table_tDBOutput_1.equalsIgnoreCase("CHIAStage")) {
						whetherExist_tDBOutput_1 = true;
						break;
					}
				}
				if (whetherExist_tDBOutput_1) {
					try (java.sql.Statement stmtDrop_tDBOutput_1 = conn_tDBOutput_1.createStatement()) {
						if (log.isDebugEnabled())
							log.debug(
									"tDBOutput_1 - " + ("Dropping") + (" table '") + (tableName_tDBOutput_1) + ("'."));
						stmtDrop_tDBOutput_1.execute("DROP TABLE `" + tableName_tDBOutput_1 + "`");
						if (log.isDebugEnabled())
							log.debug("tDBOutput_1 - " + ("Drop") + (" table '") + (tableName_tDBOutput_1)
									+ ("' has succeeded."));
					}
				}
				try (java.sql.Statement stmtCreate_tDBOutput_1 = conn_tDBOutput_1.createStatement()) {
					if (log.isDebugEnabled())
						log.debug("tDBOutput_1 - " + ("Creating") + (" table '") + (tableName_tDBOutput_1) + ("'."));
					stmtCreate_tDBOutput_1.execute("CREATE TABLE `" + tableName_tDBOutput_1
							+ "`(`FirstName` VARCHAR(16)  ,`LastName` VARCHAR(10)  ,`Gender` VARCHAR(6)  ,`PatientAddress` VARCHAR(38)  ,`City` VARCHAR(14)  ,`State` VARCHAR(2)  ,`PostalCode` INT(5)  ,`Birthday` DATE ,`SSN` VARCHAR(11)  ,`HPLNID` INT(7)  ,`NYSIISFirstName` VARCHAR(16)  ,`NYSIISLastName` VARCHAR(10)  ,`HealthPlanID` VARCHAR(8)  ,`MRN` INT(7)  ,`SSNBlockingKey` VARCHAR(20)  ,`FNDOBBlockingKey` VARCHAR(25)  ,`LNPCBlockingKey` VARCHAR(20)  ,`NYSIISFNLNBlockingKey` VARCHAR(30)  ,`DOBPCBlockingKey` VARCHAR(20)  ,`MRNBlockingKey` VARCHAR(20)  ,`HealthPlanIDBlockingKey` VARCHAR(20)  )");
					if (log.isDebugEnabled())
						log.debug("tDBOutput_1 - " + ("Create") + (" table '") + (tableName_tDBOutput_1)
								+ ("' has succeeded."));
				}

				String insert_tDBOutput_1 = "INSERT INTO `" + "CHIAStage"
						+ "` (`FirstName`,`LastName`,`Gender`,`PatientAddress`,`City`,`State`,`PostalCode`,`Birthday`,`SSN`,`HPLNID`,`NYSIISFirstName`,`NYSIISLastName`,`HealthPlanID`,`MRN`,`SSNBlockingKey`,`FNDOBBlockingKey`,`LNPCBlockingKey`,`NYSIISFNLNBlockingKey`,`DOBPCBlockingKey`,`MRNBlockingKey`,`HealthPlanIDBlockingKey`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

				int batchSize_tDBOutput_1 = 100;
				int batchSizeCounter_tDBOutput_1 = 0;

				java.sql.PreparedStatement pstmt_tDBOutput_1 = conn_tDBOutput_1.prepareStatement(insert_tDBOutput_1);
				resourceMap.put("pstmt_tDBOutput_1", pstmt_tDBOutput_1);

				/**
				 * [tDBOutput_1 begin ] stop
				 */

				/**
				 * [tLogRow_1 begin ] start
				 */

				sh("tLogRow_1");

				s(currentComponent = "tLogRow_1");

				cLabel = "<b>Console</b>";

				runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, 0, 0, "HealthPlanID_Output");

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

					int[] colLengths = new int[21];

					public void addRow(String[] row) {

						for (int i = 0; i < 21; i++) {
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
						for (k = 0; k < (totals + 20 - name.length()) / 2; k++) {
							sb.append(' ');
						}
						sb.append(name);
						for (int i = 0; i < totals + 20 - name.length() - k; i++) {
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

						// last column
						for (int i = 0; i < colLengths[20] - fillChars[1].length() + 1; i++) {
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
						"HealthPlanID", "MRN", "SSNBlockingKey", "FNDOBBlockingKey", "LNPCBlockingKey",
						"NYSIISFNLNBlockingKey", "DOBPCBlockingKey", "MRNBlockingKey", "HealthPlanIDBlockingKey", });
				StringBuilder strBuffer_tLogRow_1 = null;
				int nb_line_tLogRow_1 = 0;
///////////////////////    			

				/**
				 * [tLogRow_1 begin ] stop
				 */

				/**
				 * [tMap_7 begin ] start
				 */

				sh("tMap_7");

				s(currentComponent = "tMap_7");

				cLabel = "<b>Mapping 7</b>";

				runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, 0, 0, "HealthPlanID");

				int tos_count_tMap_7 = 0;

				if (log.isDebugEnabled())
					log.debug("tMap_7 - " + ("Start to work."));
				if (log.isDebugEnabled()) {
					class BytesLimit65535_tMap_7 {
						public void limitLog4jByte() throws Exception {
							StringBuilder log4jParamters_tMap_7 = new StringBuilder();
							log4jParamters_tMap_7.append("Parameters:");
							log4jParamters_tMap_7.append("LINK_STYLE" + " = " + "AUTO");
							log4jParamters_tMap_7.append(" | ");
							log4jParamters_tMap_7.append("TEMPORARY_DATA_DIRECTORY" + " = " + "");
							log4jParamters_tMap_7.append(" | ");
							log4jParamters_tMap_7.append("ROWS_BUFFER_SIZE" + " = " + "2000000");
							log4jParamters_tMap_7.append(" | ");
							log4jParamters_tMap_7.append("CHANGE_HASH_AND_EQUALS_FOR_BIGDECIMAL" + " = " + "true");
							log4jParamters_tMap_7.append(" | ");
							if (log.isDebugEnabled())
								log.debug("tMap_7 - " + (log4jParamters_tMap_7));
						}
					}
					new BytesLimit65535_tMap_7().limitLog4jByte();
				}
				if (enableLogStash) {
					talendJobLog.addCM("tMap_7", "<b>Mapping 7</b>", "tMap");
					talendJobLogProcess(globalMap);
					s(currentComponent);
				}

// ###############################
// # Lookup's keys initialization
				int count_HealthPlanID_tMap_7 = 0;

// ###############################        

// ###############################
// # Vars initialization
				class Var__tMap_7__Struct {
				}
				Var__tMap_7__Struct Var__tMap_7 = new Var__tMap_7__Struct();
// ###############################

// ###############################
// # Outputs initialization
				int count_HealthPlanID_Output_tMap_7 = 0;

				HealthPlanID_OutputStruct HealthPlanID_Output_tmp = new HealthPlanID_OutputStruct();
// ###############################

				/**
				 * [tMap_7 begin ] stop
				 */

				/**
				 * [tGenKey_7 begin ] start
				 */

				sh("tGenKey_7");

				s(currentComponent = "tGenKey_7");

				cLabel = "<b>Blocking Key 7</b>";

				runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, 0, 0, "MRN_Output");

				int tos_count_tGenKey_7 = 0;

				if (log.isDebugEnabled())
					log.debug("tGenKey_7 - " + ("Start to work."));
				if (log.isDebugEnabled()) {
					class BytesLimit65535_tGenKey_7 {
						public void limitLog4jByte() throws Exception {
							StringBuilder log4jParamters_tGenKey_7 = new StringBuilder();
							log4jParamters_tGenKey_7.append("Parameters:");
							log4jParamters_tGenKey_7.append("ALGO" + " = " + "[{POST_ALGO=" + ("NON_ALGO")
									+ ", POST_VALUE=" + ("") + ", PRECOLUMN=" + ("HealthPlanID") + ", PRE_ALGO="
									+ ("NON_ALGO") + ", PRE_VALUE=" + ("") + ", KEY_ALGO=" + ("exact") + ", KEY_VALUE="
									+ ("") + "}]");
							log4jParamters_tGenKey_7.append(" | ");
							log4jParamters_tGenKey_7.append("SHOW_HELP_KEY" + " = " + "false");
							log4jParamters_tGenKey_7.append(" | ");
							if (log.isDebugEnabled())
								log.debug("tGenKey_7 - " + (log4jParamters_tGenKey_7));
						}
					}
					new BytesLimit65535_tGenKey_7().limitLog4jByte();
				}
				if (enableLogStash) {
					talendJobLog.addCM("tGenKey_7", "<b>Blocking Key 7</b>", "tGenKey");
					talendJobLogProcess(globalMap);
					s(currentComponent);
				}

				/**
				 * [tGenKey_7 begin ] stop
				 */

				/**
				 * [tMap_6 begin ] start
				 */

				sh("tMap_6");

				s(currentComponent = "tMap_6");

				cLabel = "<b>Mapping 6</b>";

				runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, 0, 0, "MRN");

				int tos_count_tMap_6 = 0;

				if (log.isDebugEnabled())
					log.debug("tMap_6 - " + ("Start to work."));
				if (log.isDebugEnabled()) {
					class BytesLimit65535_tMap_6 {
						public void limitLog4jByte() throws Exception {
							StringBuilder log4jParamters_tMap_6 = new StringBuilder();
							log4jParamters_tMap_6.append("Parameters:");
							log4jParamters_tMap_6.append("LINK_STYLE" + " = " + "AUTO");
							log4jParamters_tMap_6.append(" | ");
							log4jParamters_tMap_6.append("TEMPORARY_DATA_DIRECTORY" + " = " + "");
							log4jParamters_tMap_6.append(" | ");
							log4jParamters_tMap_6.append("ROWS_BUFFER_SIZE" + " = " + "2000000");
							log4jParamters_tMap_6.append(" | ");
							log4jParamters_tMap_6.append("CHANGE_HASH_AND_EQUALS_FOR_BIGDECIMAL" + " = " + "true");
							log4jParamters_tMap_6.append(" | ");
							if (log.isDebugEnabled())
								log.debug("tMap_6 - " + (log4jParamters_tMap_6));
						}
					}
					new BytesLimit65535_tMap_6().limitLog4jByte();
				}
				if (enableLogStash) {
					talendJobLog.addCM("tMap_6", "<b>Mapping 6</b>", "tMap");
					talendJobLogProcess(globalMap);
					s(currentComponent);
				}

// ###############################
// # Lookup's keys initialization
				int count_MRN_tMap_6 = 0;

// ###############################        

// ###############################
// # Vars initialization
				class Var__tMap_6__Struct {
				}
				Var__tMap_6__Struct Var__tMap_6 = new Var__tMap_6__Struct();
// ###############################

// ###############################
// # Outputs initialization
				int count_MRN_Output_tMap_6 = 0;

				MRN_OutputStruct MRN_Output_tmp = new MRN_OutputStruct();
// ###############################

				/**
				 * [tMap_6 begin ] stop
				 */

				/**
				 * [tGenKey_6 begin ] start
				 */

				sh("tGenKey_6");

				s(currentComponent = "tGenKey_6");

				cLabel = "<b>Blocking Key 6</b>";

				runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, 0, 0, "DOBPC_Output");

				int tos_count_tGenKey_6 = 0;

				if (log.isDebugEnabled())
					log.debug("tGenKey_6 - " + ("Start to work."));
				if (log.isDebugEnabled()) {
					class BytesLimit65535_tGenKey_6 {
						public void limitLog4jByte() throws Exception {
							StringBuilder log4jParamters_tGenKey_6 = new StringBuilder();
							log4jParamters_tGenKey_6.append("Parameters:");
							log4jParamters_tGenKey_6.append("ALGO" + " = " + "[{POST_ALGO=" + ("NON_ALGO")
									+ ", POST_VALUE=" + ("") + ", PRECOLUMN=" + ("MRN") + ", PRE_ALGO=" + ("NON_ALGO")
									+ ", PRE_VALUE=" + ("") + ", KEY_ALGO=" + ("exact") + ", KEY_VALUE=" + ("") + "}]");
							log4jParamters_tGenKey_6.append(" | ");
							log4jParamters_tGenKey_6.append("SHOW_HELP_KEY" + " = " + "false");
							log4jParamters_tGenKey_6.append(" | ");
							if (log.isDebugEnabled())
								log.debug("tGenKey_6 - " + (log4jParamters_tGenKey_6));
						}
					}
					new BytesLimit65535_tGenKey_6().limitLog4jByte();
				}
				if (enableLogStash) {
					talendJobLog.addCM("tGenKey_6", "<b>Blocking Key 6</b>", "tGenKey");
					talendJobLogProcess(globalMap);
					s(currentComponent);
				}

				/**
				 * [tGenKey_6 begin ] stop
				 */

				/**
				 * [tMap_5 begin ] start
				 */

				sh("tMap_5");

				s(currentComponent = "tMap_5");

				cLabel = "<b>Mapping 5</b>";

				runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, 0, 0, "DOBPC");

				int tos_count_tMap_5 = 0;

				if (log.isDebugEnabled())
					log.debug("tMap_5 - " + ("Start to work."));
				if (log.isDebugEnabled()) {
					class BytesLimit65535_tMap_5 {
						public void limitLog4jByte() throws Exception {
							StringBuilder log4jParamters_tMap_5 = new StringBuilder();
							log4jParamters_tMap_5.append("Parameters:");
							log4jParamters_tMap_5.append("LINK_STYLE" + " = " + "AUTO");
							log4jParamters_tMap_5.append(" | ");
							log4jParamters_tMap_5.append("TEMPORARY_DATA_DIRECTORY" + " = " + "");
							log4jParamters_tMap_5.append(" | ");
							log4jParamters_tMap_5.append("ROWS_BUFFER_SIZE" + " = " + "2000000");
							log4jParamters_tMap_5.append(" | ");
							log4jParamters_tMap_5.append("CHANGE_HASH_AND_EQUALS_FOR_BIGDECIMAL" + " = " + "true");
							log4jParamters_tMap_5.append(" | ");
							if (log.isDebugEnabled())
								log.debug("tMap_5 - " + (log4jParamters_tMap_5));
						}
					}
					new BytesLimit65535_tMap_5().limitLog4jByte();
				}
				if (enableLogStash) {
					talendJobLog.addCM("tMap_5", "<b>Mapping 5</b>", "tMap");
					talendJobLogProcess(globalMap);
					s(currentComponent);
				}

// ###############################
// # Lookup's keys initialization
				int count_DOBPC_tMap_5 = 0;

// ###############################        

// ###############################
// # Vars initialization
				class Var__tMap_5__Struct {
				}
				Var__tMap_5__Struct Var__tMap_5 = new Var__tMap_5__Struct();
// ###############################

// ###############################
// # Outputs initialization
				int count_DOBPC_Output_tMap_5 = 0;

				DOBPC_OutputStruct DOBPC_Output_tmp = new DOBPC_OutputStruct();
// ###############################

				/**
				 * [tMap_5 begin ] stop
				 */

				/**
				 * [tGenKey_5 begin ] start
				 */

				sh("tGenKey_5");

				s(currentComponent = "tGenKey_5");

				cLabel = "<b>Blocking Key 5</b>";

				runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, 0, 0, "NYSIISFNLN_Output");

				int tos_count_tGenKey_5 = 0;

				if (log.isDebugEnabled())
					log.debug("tGenKey_5 - " + ("Start to work."));
				if (log.isDebugEnabled()) {
					class BytesLimit65535_tGenKey_5 {
						public void limitLog4jByte() throws Exception {
							StringBuilder log4jParamters_tGenKey_5 = new StringBuilder();
							log4jParamters_tGenKey_5.append("Parameters:");
							log4jParamters_tGenKey_5.append("ALGO" + " = " + "[{POST_ALGO=" + ("NON_ALGO")
									+ ", POST_VALUE=" + ("") + ", PRECOLUMN=" + ("Birthday") + ", PRE_ALGO="
									+ ("NON_ALGO") + ", PRE_VALUE=" + ("") + ", KEY_ALGO=" + ("exact") + ", KEY_VALUE="
									+ ("") + "}, {POST_ALGO=" + ("NON_ALGO") + ", POST_VALUE=" + ("") + ", PRECOLUMN="
									+ ("PostalCode") + ", PRE_ALGO=" + ("NON_ALGO") + ", PRE_VALUE=" + ("")
									+ ", KEY_ALGO=" + ("exact") + ", KEY_VALUE=" + ("") + "}]");
							log4jParamters_tGenKey_5.append(" | ");
							log4jParamters_tGenKey_5.append("SHOW_HELP_KEY" + " = " + "false");
							log4jParamters_tGenKey_5.append(" | ");
							if (log.isDebugEnabled())
								log.debug("tGenKey_5 - " + (log4jParamters_tGenKey_5));
						}
					}
					new BytesLimit65535_tGenKey_5().limitLog4jByte();
				}
				if (enableLogStash) {
					talendJobLog.addCM("tGenKey_5", "<b>Blocking Key 5</b>", "tGenKey");
					talendJobLogProcess(globalMap);
					s(currentComponent);
				}

				/**
				 * [tGenKey_5 begin ] stop
				 */

				/**
				 * [tMap_4 begin ] start
				 */

				sh("tMap_4");

				s(currentComponent = "tMap_4");

				cLabel = "<b>Mapping Key 4</b>";

				runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, 0, 0, "NYSIISFNLN");

				int tos_count_tMap_4 = 0;

				if (log.isDebugEnabled())
					log.debug("tMap_4 - " + ("Start to work."));
				if (log.isDebugEnabled()) {
					class BytesLimit65535_tMap_4 {
						public void limitLog4jByte() throws Exception {
							StringBuilder log4jParamters_tMap_4 = new StringBuilder();
							log4jParamters_tMap_4.append("Parameters:");
							log4jParamters_tMap_4.append("LINK_STYLE" + " = " + "AUTO");
							log4jParamters_tMap_4.append(" | ");
							log4jParamters_tMap_4.append("TEMPORARY_DATA_DIRECTORY" + " = " + "");
							log4jParamters_tMap_4.append(" | ");
							log4jParamters_tMap_4.append("ROWS_BUFFER_SIZE" + " = " + "2000000");
							log4jParamters_tMap_4.append(" | ");
							log4jParamters_tMap_4.append("CHANGE_HASH_AND_EQUALS_FOR_BIGDECIMAL" + " = " + "true");
							log4jParamters_tMap_4.append(" | ");
							if (log.isDebugEnabled())
								log.debug("tMap_4 - " + (log4jParamters_tMap_4));
						}
					}
					new BytesLimit65535_tMap_4().limitLog4jByte();
				}
				if (enableLogStash) {
					talendJobLog.addCM("tMap_4", "<b>Mapping Key 4</b>", "tMap");
					talendJobLogProcess(globalMap);
					s(currentComponent);
				}

// ###############################
// # Lookup's keys initialization
				int count_NYSIISFNLN_tMap_4 = 0;

// ###############################        

// ###############################
// # Vars initialization
				class Var__tMap_4__Struct {
				}
				Var__tMap_4__Struct Var__tMap_4 = new Var__tMap_4__Struct();
// ###############################

// ###############################
// # Outputs initialization
				int count_NYSIISFNLN_Output_tMap_4 = 0;

				NYSIISFNLN_OutputStruct NYSIISFNLN_Output_tmp = new NYSIISFNLN_OutputStruct();
// ###############################

				/**
				 * [tMap_4 begin ] stop
				 */

				/**
				 * [tGenKey_4 begin ] start
				 */

				sh("tGenKey_4");

				s(currentComponent = "tGenKey_4");

				cLabel = "<b>Blocking Key 4</b>";

				runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, 0, 0, "LNPC_Output");

				int tos_count_tGenKey_4 = 0;

				if (log.isDebugEnabled())
					log.debug("tGenKey_4 - " + ("Start to work."));
				if (log.isDebugEnabled()) {
					class BytesLimit65535_tGenKey_4 {
						public void limitLog4jByte() throws Exception {
							StringBuilder log4jParamters_tGenKey_4 = new StringBuilder();
							log4jParamters_tGenKey_4.append("Parameters:");
							log4jParamters_tGenKey_4.append("ALGO" + " = " + "[{POST_ALGO=" + ("NON_ALGO")
									+ ", POST_VALUE=" + ("") + ", PRECOLUMN=" + ("FirstName") + ", PRE_ALGO="
									+ ("NON_ALGO") + ", PRE_VALUE=" + ("") + ", KEY_ALGO=" + ("exact") + ", KEY_VALUE="
									+ ("") + "}, {POST_ALGO=" + ("NON_ALGO") + ", POST_VALUE=" + ("") + ", PRECOLUMN="
									+ ("FirstName") + ", PRE_ALGO=" + ("NON_ALGO") + ", PRE_VALUE=" + ("")
									+ ", KEY_ALGO=" + ("exact") + ", KEY_VALUE=" + ("") + "}]");
							log4jParamters_tGenKey_4.append(" | ");
							log4jParamters_tGenKey_4.append("SHOW_HELP_KEY" + " = " + "false");
							log4jParamters_tGenKey_4.append(" | ");
							if (log.isDebugEnabled())
								log.debug("tGenKey_4 - " + (log4jParamters_tGenKey_4));
						}
					}
					new BytesLimit65535_tGenKey_4().limitLog4jByte();
				}
				if (enableLogStash) {
					talendJobLog.addCM("tGenKey_4", "<b>Blocking Key 4</b>", "tGenKey");
					talendJobLogProcess(globalMap);
					s(currentComponent);
				}

				/**
				 * [tGenKey_4 begin ] stop
				 */

				/**
				 * [tMap_3 begin ] start
				 */

				sh("tMap_3");

				s(currentComponent = "tMap_3");

				cLabel = "<b>Mapping 3</b>";

				runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, 0, 0, "LNPC");

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
					talendJobLog.addCM("tMap_3", "<b>Mapping 3</b>", "tMap");
					talendJobLogProcess(globalMap);
					s(currentComponent);
				}

// ###############################
// # Lookup's keys initialization
				int count_LNPC_tMap_3 = 0;

// ###############################        

// ###############################
// # Vars initialization
				class Var__tMap_3__Struct {
				}
				Var__tMap_3__Struct Var__tMap_3 = new Var__tMap_3__Struct();
// ###############################

// ###############################
// # Outputs initialization
				int count_LNPC_Output_tMap_3 = 0;

				LNPC_OutputStruct LNPC_Output_tmp = new LNPC_OutputStruct();
// ###############################

				/**
				 * [tMap_3 begin ] stop
				 */

				/**
				 * [tGenKey_3 begin ] start
				 */

				sh("tGenKey_3");

				s(currentComponent = "tGenKey_3");

				cLabel = "<b>Blocking Key 3</b>";

				runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, 0, 0, "FNDOB_Output");

				int tos_count_tGenKey_3 = 0;

				if (log.isDebugEnabled())
					log.debug("tGenKey_3 - " + ("Start to work."));
				if (log.isDebugEnabled()) {
					class BytesLimit65535_tGenKey_3 {
						public void limitLog4jByte() throws Exception {
							StringBuilder log4jParamters_tGenKey_3 = new StringBuilder();
							log4jParamters_tGenKey_3.append("Parameters:");
							log4jParamters_tGenKey_3.append("ALGO" + " = " + "[{POST_ALGO=" + ("NON_ALGO")
									+ ", POST_VALUE=" + ("") + ", PRECOLUMN=" + ("LastName") + ", PRE_ALGO="
									+ ("NON_ALGO") + ", PRE_VALUE=" + ("") + ", KEY_ALGO=" + ("exact") + ", KEY_VALUE="
									+ ("") + "}, {POST_ALGO=" + ("NON_ALGO") + ", POST_VALUE=" + ("") + ", PRECOLUMN="
									+ ("PostalCode") + ", PRE_ALGO=" + ("NON_ALGO") + ", PRE_VALUE=" + ("")
									+ ", KEY_ALGO=" + ("exact") + ", KEY_VALUE=" + ("") + "}]");
							log4jParamters_tGenKey_3.append(" | ");
							log4jParamters_tGenKey_3.append("SHOW_HELP_KEY" + " = " + "false");
							log4jParamters_tGenKey_3.append(" | ");
							if (log.isDebugEnabled())
								log.debug("tGenKey_3 - " + (log4jParamters_tGenKey_3));
						}
					}
					new BytesLimit65535_tGenKey_3().limitLog4jByte();
				}
				if (enableLogStash) {
					talendJobLog.addCM("tGenKey_3", "<b>Blocking Key 3</b>", "tGenKey");
					talendJobLogProcess(globalMap);
					s(currentComponent);
				}

				/**
				 * [tGenKey_3 begin ] stop
				 */

				/**
				 * [tMap_2 begin ] start
				 */

				sh("tMap_2");

				s(currentComponent = "tMap_2");

				cLabel = "<b>Mapping 2</b>";

				runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, 0, 0, "FNDOB");

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
					talendJobLog.addCM("tMap_2", "<b>Mapping 2</b>", "tMap");
					talendJobLogProcess(globalMap);
					s(currentComponent);
				}

// ###############################
// # Lookup's keys initialization
				int count_FNDOB_tMap_2 = 0;

// ###############################        

// ###############################
// # Vars initialization
				class Var__tMap_2__Struct {
				}
				Var__tMap_2__Struct Var__tMap_2 = new Var__tMap_2__Struct();
// ###############################

// ###############################
// # Outputs initialization
				int count_FNDOB_Output_tMap_2 = 0;

				FNDOB_OutputStruct FNDOB_Output_tmp = new FNDOB_OutputStruct();
// ###############################

				/**
				 * [tMap_2 begin ] stop
				 */

				/**
				 * [tGenKey_2 begin ] start
				 */

				sh("tGenKey_2");

				s(currentComponent = "tGenKey_2");

				cLabel = "<b>Blocking Key 2</b>";

				runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, 0, 0, "SSN_Output");

				int tos_count_tGenKey_2 = 0;

				if (log.isDebugEnabled())
					log.debug("tGenKey_2 - " + ("Start to work."));
				if (log.isDebugEnabled()) {
					class BytesLimit65535_tGenKey_2 {
						public void limitLog4jByte() throws Exception {
							StringBuilder log4jParamters_tGenKey_2 = new StringBuilder();
							log4jParamters_tGenKey_2.append("Parameters:");
							log4jParamters_tGenKey_2.append("ALGO" + " = " + "[{POST_ALGO=" + ("NON_ALGO")
									+ ", POST_VALUE=" + ("") + ", PRECOLUMN=" + ("FirstName") + ", PRE_ALGO="
									+ ("NON_ALGO") + ", PRE_VALUE=" + ("") + ", KEY_ALGO=" + ("exact") + ", KEY_VALUE="
									+ ("") + "}, {POST_ALGO=" + ("NON_ALGO") + ", POST_VALUE=" + ("") + ", PRECOLUMN="
									+ ("Birthday") + ", PRE_ALGO=" + ("NON_ALGO") + ", PRE_VALUE=" + ("")
									+ ", KEY_ALGO=" + ("exact") + ", KEY_VALUE=" + ("") + "}]");
							log4jParamters_tGenKey_2.append(" | ");
							log4jParamters_tGenKey_2.append("SHOW_HELP_KEY" + " = " + "false");
							log4jParamters_tGenKey_2.append(" | ");
							if (log.isDebugEnabled())
								log.debug("tGenKey_2 - " + (log4jParamters_tGenKey_2));
						}
					}
					new BytesLimit65535_tGenKey_2().limitLog4jByte();
				}
				if (enableLogStash) {
					talendJobLog.addCM("tGenKey_2", "<b>Blocking Key 2</b>", "tGenKey");
					talendJobLogProcess(globalMap);
					s(currentComponent);
				}

				/**
				 * [tGenKey_2 begin ] stop
				 */

				/**
				 * [tMap_1 begin ] start
				 */

				sh("tMap_1");

				s(currentComponent = "tMap_1");

				cLabel = "<b>Mapping 1</b>";

				runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, 0, 0, "SSN");

				int tos_count_tMap_1 = 0;

				if (log.isDebugEnabled())
					log.debug("tMap_1 - " + ("Start to work."));
				if (log.isDebugEnabled()) {
					class BytesLimit65535_tMap_1 {
						public void limitLog4jByte() throws Exception {
							StringBuilder log4jParamters_tMap_1 = new StringBuilder();
							log4jParamters_tMap_1.append("Parameters:");
							log4jParamters_tMap_1.append("LINK_STYLE" + " = " + "AUTO");
							log4jParamters_tMap_1.append(" | ");
							log4jParamters_tMap_1.append("TEMPORARY_DATA_DIRECTORY" + " = " + "");
							log4jParamters_tMap_1.append(" | ");
							log4jParamters_tMap_1.append("ROWS_BUFFER_SIZE" + " = " + "2000000");
							log4jParamters_tMap_1.append(" | ");
							log4jParamters_tMap_1.append("CHANGE_HASH_AND_EQUALS_FOR_BIGDECIMAL" + " = " + "true");
							log4jParamters_tMap_1.append(" | ");
							if (log.isDebugEnabled())
								log.debug("tMap_1 - " + (log4jParamters_tMap_1));
						}
					}
					new BytesLimit65535_tMap_1().limitLog4jByte();
				}
				if (enableLogStash) {
					talendJobLog.addCM("tMap_1", "<b>Mapping 1</b>", "tMap");
					talendJobLogProcess(globalMap);
					s(currentComponent);
				}

// ###############################
// # Lookup's keys initialization
				int count_SSN_tMap_1 = 0;

// ###############################        

// ###############################
// # Vars initialization
				class Var__tMap_1__Struct {
				}
				Var__tMap_1__Struct Var__tMap_1 = new Var__tMap_1__Struct();
// ###############################

// ###############################
// # Outputs initialization
				int count_SSN_Output_tMap_1 = 0;

				SSN_OutputStruct SSN_Output_tmp = new SSN_OutputStruct();
// ###############################

				/**
				 * [tMap_1 begin ] stop
				 */

				/**
				 * [tGenKey_1 begin ] start
				 */

				sh("tGenKey_1");

				s(currentComponent = "tGenKey_1");

				cLabel = "<b>Blocking Key 1</b>";

				runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, 0, 0, "CHIA");

				int tos_count_tGenKey_1 = 0;

				if (log.isDebugEnabled())
					log.debug("tGenKey_1 - " + ("Start to work."));
				if (log.isDebugEnabled()) {
					class BytesLimit65535_tGenKey_1 {
						public void limitLog4jByte() throws Exception {
							StringBuilder log4jParamters_tGenKey_1 = new StringBuilder();
							log4jParamters_tGenKey_1.append("Parameters:");
							log4jParamters_tGenKey_1.append("ALGO" + " = " + "[{POST_ALGO=" + ("NON_ALGO")
									+ ", POST_VALUE=" + ("") + ", PRECOLUMN=" + ("SSN") + ", PRE_ALGO=" + ("NON_ALGO")
									+ ", PRE_VALUE=" + ("") + ", KEY_ALGO=" + ("exact") + ", KEY_VALUE=" + ("") + "}]");
							log4jParamters_tGenKey_1.append(" | ");
							log4jParamters_tGenKey_1.append("SHOW_HELP_KEY" + " = " + "false");
							log4jParamters_tGenKey_1.append(" | ");
							if (log.isDebugEnabled())
								log.debug("tGenKey_1 - " + (log4jParamters_tGenKey_1));
						}
					}
					new BytesLimit65535_tGenKey_1().limitLog4jByte();
				}
				if (enableLogStash) {
					talendJobLog.addCM("tGenKey_1", "<b>Blocking Key 1</b>", "tGenKey");
					talendJobLogProcess(globalMap);
					s(currentComponent);
				}

				/**
				 * [tGenKey_1 begin ] stop
				 */

				/**
				 * [tFileInputExcel_1 begin ] start
				 */

				sh("tFileInputExcel_1");

				s(currentComponent = "tFileInputExcel_1");

				cLabel = "<b>Reading xlsx</b>";

				int tos_count_tFileInputExcel_1 = 0;

				if (log.isDebugEnabled())
					log.debug("tFileInputExcel_1 - " + ("Start to work."));
				if (log.isDebugEnabled()) {
					class BytesLimit65535_tFileInputExcel_1 {
						public void limitLog4jByte() throws Exception {
							StringBuilder log4jParamters_tFileInputExcel_1 = new StringBuilder();
							log4jParamters_tFileInputExcel_1.append("Parameters:");
							log4jParamters_tFileInputExcel_1.append("VERSION_2007" + " = " + "true");
							log4jParamters_tFileInputExcel_1.append(" | ");
							log4jParamters_tFileInputExcel_1
									.append("FILENAME" + " = " + "\"C:/Users/hteklai/Desktop/SE/Data/CHIA/CHIA.xlsx\"");
							log4jParamters_tFileInputExcel_1.append(" | ");
							log4jParamters_tFileInputExcel_1.append("PASSWORD" + " = "
									+ String.valueOf(
											"enc:routine.encryption.key.v2:cU9B/JpqKI7DkighVWugL1rBVYAOjqUUjxrnPg==")
											.substring(0, 4)
									+ "...");
							log4jParamters_tFileInputExcel_1.append(" | ");
							log4jParamters_tFileInputExcel_1.append("ALL_SHEETS" + " = " + "true");
							log4jParamters_tFileInputExcel_1.append(" | ");
							log4jParamters_tFileInputExcel_1.append("HEADER" + " = " + "1");
							log4jParamters_tFileInputExcel_1.append(" | ");
							log4jParamters_tFileInputExcel_1.append("FOOTER" + " = " + "0");
							log4jParamters_tFileInputExcel_1.append(" | ");
							log4jParamters_tFileInputExcel_1.append("LIMIT" + " = " + "");
							log4jParamters_tFileInputExcel_1.append(" | ");
							log4jParamters_tFileInputExcel_1.append("AFFECT_EACH_SHEET" + " = " + "false");
							log4jParamters_tFileInputExcel_1.append(" | ");
							log4jParamters_tFileInputExcel_1.append("FIRST_COLUMN" + " = " + "1");
							log4jParamters_tFileInputExcel_1.append(" | ");
							log4jParamters_tFileInputExcel_1.append("LAST_COLUMN" + " = " + "");
							log4jParamters_tFileInputExcel_1.append(" | ");
							log4jParamters_tFileInputExcel_1.append("DIE_ON_ERROR" + " = " + "false");
							log4jParamters_tFileInputExcel_1.append(" | ");
							log4jParamters_tFileInputExcel_1.append("ADVANCED_SEPARATOR" + " = " + "false");
							log4jParamters_tFileInputExcel_1.append(" | ");
							log4jParamters_tFileInputExcel_1.append("TRIMALL" + " = " + "false");
							log4jParamters_tFileInputExcel_1.append(" | ");
							log4jParamters_tFileInputExcel_1.append("TRIMSELECT" + " = " + "[{TRIM=" + ("false")
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
									+ ("HealthPlanID") + "}, {TRIM=" + ("false") + ", SCHEMA_COLUMN=" + ("MRN") + "}]");
							log4jParamters_tFileInputExcel_1.append(" | ");
							log4jParamters_tFileInputExcel_1.append("CONVERTDATETOSTRING" + " = " + "false");
							log4jParamters_tFileInputExcel_1.append(" | ");
							log4jParamters_tFileInputExcel_1.append("ENCODING" + " = " + "\"UTF-8\"");
							log4jParamters_tFileInputExcel_1.append(" | ");
							log4jParamters_tFileInputExcel_1.append("STOPREAD_ON_EMPTYROW" + " = " + "false");
							log4jParamters_tFileInputExcel_1.append(" | ");
							log4jParamters_tFileInputExcel_1.append("GENERATION_MODE" + " = " + "USER_MODE");
							log4jParamters_tFileInputExcel_1.append(" | ");
							log4jParamters_tFileInputExcel_1.append("CONFIGURE_INFLATION_RATIO" + " = " + "false");
							log4jParamters_tFileInputExcel_1.append(" | ");
							if (log.isDebugEnabled())
								log.debug("tFileInputExcel_1 - " + (log4jParamters_tFileInputExcel_1));
						}
					}
					new BytesLimit65535_tFileInputExcel_1().limitLog4jByte();
				}
				if (enableLogStash) {
					talendJobLog.addCM("tFileInputExcel_1", "<b>Reading xlsx</b>", "tFileInputExcel");
					talendJobLogProcess(globalMap);
					s(currentComponent);
				}

				final String decryptedPassword_tFileInputExcel_1 = routines.system.PasswordEncryptUtil
						.decryptPassword("enc:routine.encryption.key.v2:tOmFrJTi8nJ9WmBZsAN0u5AGUZcNGnqv96xn9w==");
				String password_tFileInputExcel_1 = decryptedPassword_tFileInputExcel_1;
				if (password_tFileInputExcel_1.isEmpty()) {
					password_tFileInputExcel_1 = null;
				}
				class RegexUtil_tFileInputExcel_1 {

					public java.util.List<org.apache.poi.xssf.usermodel.XSSFSheet> getSheets(
							org.apache.poi.xssf.usermodel.XSSFWorkbook workbook, String oneSheetName,
							boolean useRegex) {

						java.util.List<org.apache.poi.xssf.usermodel.XSSFSheet> list = new java.util.ArrayList<org.apache.poi.xssf.usermodel.XSSFSheet>();

						if (useRegex) {// this part process the regex issue

							java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(oneSheetName);
							for (org.apache.poi.ss.usermodel.Sheet sheet : workbook) {
								String sheetName = sheet.getSheetName();
								java.util.regex.Matcher matcher = pattern.matcher(sheetName);
								if (matcher.matches()) {
									if (sheet != null) {
										list.add((org.apache.poi.xssf.usermodel.XSSFSheet) sheet);
									}
								}
							}

						} else {
							org.apache.poi.xssf.usermodel.XSSFSheet sheet = (org.apache.poi.xssf.usermodel.XSSFSheet) workbook
									.getSheet(oneSheetName);
							if (sheet != null) {
								list.add(sheet);
							}

						}

						return list;
					}

					public java.util.List<org.apache.poi.xssf.usermodel.XSSFSheet> getSheets(
							org.apache.poi.xssf.usermodel.XSSFWorkbook workbook, int index, boolean useRegex) {
						java.util.List<org.apache.poi.xssf.usermodel.XSSFSheet> list = new java.util.ArrayList<org.apache.poi.xssf.usermodel.XSSFSheet>();
						org.apache.poi.xssf.usermodel.XSSFSheet sheet = (org.apache.poi.xssf.usermodel.XSSFSheet) workbook
								.getSheetAt(index);
						if (sheet != null) {
							list.add(sheet);
						}
						return list;
					}

				}
				RegexUtil_tFileInputExcel_1 regexUtil_tFileInputExcel_1 = new RegexUtil_tFileInputExcel_1();

				Object source_tFileInputExcel_1 = "C:/Users/hteklai/Desktop/SE/Data/CHIA/CHIA.xlsx";
				org.apache.poi.xssf.usermodel.XSSFWorkbook workbook_tFileInputExcel_1 = null;

				if (source_tFileInputExcel_1 instanceof String) {
					workbook_tFileInputExcel_1 = (org.apache.poi.xssf.usermodel.XSSFWorkbook) org.apache.poi.ss.usermodel.WorkbookFactory
							.create(new java.io.File((String) source_tFileInputExcel_1), password_tFileInputExcel_1,
									true);
				} else if (source_tFileInputExcel_1 instanceof java.io.InputStream) {
					workbook_tFileInputExcel_1 = (org.apache.poi.xssf.usermodel.XSSFWorkbook) org.apache.poi.ss.usermodel.WorkbookFactory
							.create((java.io.InputStream) source_tFileInputExcel_1, password_tFileInputExcel_1);
				} else {
					workbook_tFileInputExcel_1 = null;
					throw new java.lang.Exception("The data source should be specified as Inputstream or File Path!");
				}
				try {

					java.util.List<org.apache.poi.xssf.usermodel.XSSFSheet> sheetList_tFileInputExcel_1 = new java.util.ArrayList<org.apache.poi.xssf.usermodel.XSSFSheet>();
					for (org.apache.poi.ss.usermodel.Sheet sheet_tFileInputExcel_1 : workbook_tFileInputExcel_1) {
						sheetList_tFileInputExcel_1
								.add((org.apache.poi.xssf.usermodel.XSSFSheet) sheet_tFileInputExcel_1);
					}
					if (sheetList_tFileInputExcel_1.size() <= 0) {
						throw new RuntimeException("Special sheets not exist!");
					}

					java.util.List<org.apache.poi.xssf.usermodel.XSSFSheet> sheetList_FilterNull_tFileInputExcel_1 = new java.util.ArrayList<org.apache.poi.xssf.usermodel.XSSFSheet>();
					for (org.apache.poi.xssf.usermodel.XSSFSheet sheet_FilterNull_tFileInputExcel_1 : sheetList_tFileInputExcel_1) {
						if (sheet_FilterNull_tFileInputExcel_1 != null
								&& sheetList_FilterNull_tFileInputExcel_1.iterator() != null
								&& sheet_FilterNull_tFileInputExcel_1.iterator().hasNext()) {
							sheetList_FilterNull_tFileInputExcel_1.add(sheet_FilterNull_tFileInputExcel_1);
						}
					}
					sheetList_tFileInputExcel_1 = sheetList_FilterNull_tFileInputExcel_1;
					int nb_line_tFileInputExcel_1 = 0;
					if (sheetList_tFileInputExcel_1.size() > 0) {

						int begin_line_tFileInputExcel_1 = 1;

						int footer_input_tFileInputExcel_1 = 0;

						int end_line_tFileInputExcel_1 = 0;
						for (org.apache.poi.xssf.usermodel.XSSFSheet sheet_tFileInputExcel_1 : sheetList_tFileInputExcel_1) {
							end_line_tFileInputExcel_1 += (sheet_tFileInputExcel_1.getLastRowNum() + 1);
						}
						end_line_tFileInputExcel_1 -= footer_input_tFileInputExcel_1;
						int limit_tFileInputExcel_1 = -1;
						int start_column_tFileInputExcel_1 = 1 - 1;
						int end_column_tFileInputExcel_1 = -1;

						org.apache.poi.xssf.usermodel.XSSFRow row_tFileInputExcel_1 = null;
						org.apache.poi.xssf.usermodel.XSSFSheet sheet_tFileInputExcel_1 = sheetList_tFileInputExcel_1
								.get(0);
						int rowCount_tFileInputExcel_1 = 0;
						int sheetIndex_tFileInputExcel_1 = 0;
						int currentRows_tFileInputExcel_1 = (sheetList_tFileInputExcel_1.get(0).getLastRowNum() + 1);

						// for the number format
						java.text.DecimalFormat df_tFileInputExcel_1 = new java.text.DecimalFormat(
								"#.####################################");
						char decimalChar_tFileInputExcel_1 = df_tFileInputExcel_1.getDecimalFormatSymbols()
								.getDecimalSeparator();
						log.debug("tFileInputExcel_1 - Retrieving records from the datasource.");

						for (int i_tFileInputExcel_1 = begin_line_tFileInputExcel_1; i_tFileInputExcel_1 < end_line_tFileInputExcel_1; i_tFileInputExcel_1++) {

							int emptyColumnCount_tFileInputExcel_1 = 0;

							if (limit_tFileInputExcel_1 != -1 && nb_line_tFileInputExcel_1 >= limit_tFileInputExcel_1) {
								break;
							}

							while (i_tFileInputExcel_1 >= rowCount_tFileInputExcel_1 + currentRows_tFileInputExcel_1) {
								rowCount_tFileInputExcel_1 += currentRows_tFileInputExcel_1;
								sheet_tFileInputExcel_1 = sheetList_tFileInputExcel_1
										.get(++sheetIndex_tFileInputExcel_1);
								currentRows_tFileInputExcel_1 = (sheet_tFileInputExcel_1.getLastRowNum() + 1);
							}
							globalMap.put("tFileInputExcel_1_CURRENT_SHEET", sheet_tFileInputExcel_1.getSheetName());
							if (rowCount_tFileInputExcel_1 <= i_tFileInputExcel_1) {
								row_tFileInputExcel_1 = sheet_tFileInputExcel_1
										.getRow(i_tFileInputExcel_1 - rowCount_tFileInputExcel_1);
							}
							CHIA = null;
							int tempRowLength_tFileInputExcel_1 = 14;

							int columnIndex_tFileInputExcel_1 = 0;

							String[] temp_row_tFileInputExcel_1 = new String[tempRowLength_tFileInputExcel_1];
							int excel_end_column_tFileInputExcel_1;
							if (row_tFileInputExcel_1 == null) {
								excel_end_column_tFileInputExcel_1 = 0;
							} else {
								excel_end_column_tFileInputExcel_1 = row_tFileInputExcel_1.getLastCellNum();
							}
							int actual_end_column_tFileInputExcel_1;
							if (end_column_tFileInputExcel_1 == -1) {
								actual_end_column_tFileInputExcel_1 = excel_end_column_tFileInputExcel_1;
							} else {
								actual_end_column_tFileInputExcel_1 = end_column_tFileInputExcel_1 > excel_end_column_tFileInputExcel_1
										? excel_end_column_tFileInputExcel_1
										: end_column_tFileInputExcel_1;
							}
							org.apache.poi.ss.formula.eval.NumberEval ne_tFileInputExcel_1 = null;
							for (int i = 0; i < tempRowLength_tFileInputExcel_1; i++) {
								if (i + start_column_tFileInputExcel_1 < actual_end_column_tFileInputExcel_1) {
									org.apache.poi.ss.usermodel.Cell cell_tFileInputExcel_1 = row_tFileInputExcel_1
											.getCell(i + start_column_tFileInputExcel_1);
									if (cell_tFileInputExcel_1 != null) {
										switch (cell_tFileInputExcel_1.getCellType()) {
										case STRING:
											temp_row_tFileInputExcel_1[i] = cell_tFileInputExcel_1
													.getRichStringCellValue().getString();
											break;
										case NUMERIC:
											if (org.apache.poi.ss.usermodel.DateUtil
													.isCellDateFormatted(cell_tFileInputExcel_1)) {
												temp_row_tFileInputExcel_1[i] = cell_tFileInputExcel_1
														.getDateCellValue().toString();
											} else {
												temp_row_tFileInputExcel_1[i] = df_tFileInputExcel_1
														.format(cell_tFileInputExcel_1.getNumericCellValue());
											}
											break;
										case BOOLEAN:
											temp_row_tFileInputExcel_1[i] = String
													.valueOf(cell_tFileInputExcel_1.getBooleanCellValue());
											break;
										case FORMULA:
											switch (cell_tFileInputExcel_1.getCachedFormulaResultType()) {
											case STRING:
												temp_row_tFileInputExcel_1[i] = cell_tFileInputExcel_1
														.getRichStringCellValue().getString();
												break;
											case NUMERIC:
												if (org.apache.poi.ss.usermodel.DateUtil
														.isCellDateFormatted(cell_tFileInputExcel_1)) {
													temp_row_tFileInputExcel_1[i] = cell_tFileInputExcel_1
															.getDateCellValue().toString();
												} else {
													ne_tFileInputExcel_1 = new org.apache.poi.ss.formula.eval.NumberEval(
															cell_tFileInputExcel_1.getNumericCellValue());
													temp_row_tFileInputExcel_1[i] = ne_tFileInputExcel_1
															.getStringValue();
												}
												break;
											case BOOLEAN:
												temp_row_tFileInputExcel_1[i] = String
														.valueOf(cell_tFileInputExcel_1.getBooleanCellValue());
												break;
											default:
												temp_row_tFileInputExcel_1[i] = "";
											}
											break;
										default:
											temp_row_tFileInputExcel_1[i] = "";
										}
									} else {
										temp_row_tFileInputExcel_1[i] = "";
									}

								} else {
									temp_row_tFileInputExcel_1[i] = "";
								}
							}
							boolean whetherReject_tFileInputExcel_1 = false;
							CHIA = new CHIAStruct();
							int curColNum_tFileInputExcel_1 = -1;
							String curColName_tFileInputExcel_1 = "";
							try {
								columnIndex_tFileInputExcel_1 = 0;

								if (temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].length() > 0) {
									curColNum_tFileInputExcel_1 = columnIndex_tFileInputExcel_1
											+ start_column_tFileInputExcel_1 + 1;
									curColName_tFileInputExcel_1 = "FirstName";

									CHIA.FirstName = temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1];
								} else {
									CHIA.FirstName = null;
									emptyColumnCount_tFileInputExcel_1++;
								}
								columnIndex_tFileInputExcel_1 = 1;

								if (temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].length() > 0) {
									curColNum_tFileInputExcel_1 = columnIndex_tFileInputExcel_1
											+ start_column_tFileInputExcel_1 + 1;
									curColName_tFileInputExcel_1 = "LastName";

									CHIA.LastName = temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1];
								} else {
									CHIA.LastName = null;
									emptyColumnCount_tFileInputExcel_1++;
								}
								columnIndex_tFileInputExcel_1 = 2;

								if (temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].length() > 0) {
									curColNum_tFileInputExcel_1 = columnIndex_tFileInputExcel_1
											+ start_column_tFileInputExcel_1 + 1;
									curColName_tFileInputExcel_1 = "Gender";

									CHIA.Gender = temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1];
								} else {
									CHIA.Gender = null;
									emptyColumnCount_tFileInputExcel_1++;
								}
								columnIndex_tFileInputExcel_1 = 3;

								if (temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].length() > 0) {
									curColNum_tFileInputExcel_1 = columnIndex_tFileInputExcel_1
											+ start_column_tFileInputExcel_1 + 1;
									curColName_tFileInputExcel_1 = "PatientAddress";

									CHIA.PatientAddress = temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1];
								} else {
									CHIA.PatientAddress = null;
									emptyColumnCount_tFileInputExcel_1++;
								}
								columnIndex_tFileInputExcel_1 = 4;

								if (temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].length() > 0) {
									curColNum_tFileInputExcel_1 = columnIndex_tFileInputExcel_1
											+ start_column_tFileInputExcel_1 + 1;
									curColName_tFileInputExcel_1 = "City";

									CHIA.City = temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1];
								} else {
									CHIA.City = null;
									emptyColumnCount_tFileInputExcel_1++;
								}
								columnIndex_tFileInputExcel_1 = 5;

								if (temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].length() > 0) {
									curColNum_tFileInputExcel_1 = columnIndex_tFileInputExcel_1
											+ start_column_tFileInputExcel_1 + 1;
									curColName_tFileInputExcel_1 = "State";

									CHIA.State = temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1];
								} else {
									CHIA.State = null;
									emptyColumnCount_tFileInputExcel_1++;
								}
								columnIndex_tFileInputExcel_1 = 6;

								if (temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].length() > 0) {
									curColNum_tFileInputExcel_1 = columnIndex_tFileInputExcel_1
											+ start_column_tFileInputExcel_1 + 1;
									curColName_tFileInputExcel_1 = "PostalCode";

									CHIA.PostalCode = ParserUtils.parseTo_Integer(ParserUtils.parseTo_Number(
											temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1], null,
											'.' == decimalChar_tFileInputExcel_1 ? null
													: decimalChar_tFileInputExcel_1));
								} else {
									CHIA.PostalCode = null;
									emptyColumnCount_tFileInputExcel_1++;
								}
								columnIndex_tFileInputExcel_1 = 7;

								if (temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].length() > 0) {
									curColNum_tFileInputExcel_1 = columnIndex_tFileInputExcel_1
											+ start_column_tFileInputExcel_1 + 1;
									curColName_tFileInputExcel_1 = "Birthday";

									if (7 < actual_end_column_tFileInputExcel_1) {
										try {
											if (row_tFileInputExcel_1
													.getCell(columnIndex_tFileInputExcel_1
															+ start_column_tFileInputExcel_1)
													.getCellType() == org.apache.poi.ss.usermodel.CellType.NUMERIC
													&& org.apache.poi.ss.usermodel.DateUtil.isCellDateFormatted(
															row_tFileInputExcel_1.getCell(columnIndex_tFileInputExcel_1
																	+ start_column_tFileInputExcel_1))) {
												CHIA.Birthday = row_tFileInputExcel_1.getCell(
														columnIndex_tFileInputExcel_1 + start_column_tFileInputExcel_1)
														.getDateCellValue();
											} else {
												java.util.Date tempDate_tFileInputExcel_1 = ParserUtils.parseTo_Date(
														temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1],
														"yyyy-MM-dd");
												if (tempDate_tFileInputExcel_1
														.after((new SimpleDateFormat("yyyy/MM/dd hh:mm:ss.SSS"))
																.parse("9999/12/31 23:59:59.999"))
														|| tempDate_tFileInputExcel_1
																.before((new SimpleDateFormat("yyyy/MM/dd"))
																		.parse("1900/01/01"))) {
													throw new RuntimeException("The cell format is not Date in ( Row. "
															+ (nb_line_tFileInputExcel_1 + 1) + " and ColumnNum. "
															+ curColNum_tFileInputExcel_1 + " )");
												} else {
													CHIA.Birthday = tempDate_tFileInputExcel_1;
												}
											}
										} catch (java.lang.Exception e) {
											globalMap.put("tFileInputExcel_1_ERROR_MESSAGE", e.getMessage());

											throw new RuntimeException("The cell format is not Date in ( Row. "
													+ (nb_line_tFileInputExcel_1 + 1) + " and ColumnNum. "
													+ curColNum_tFileInputExcel_1 + " )");
										}
									}

								} else {
									CHIA.Birthday = null;
									emptyColumnCount_tFileInputExcel_1++;
								}
								columnIndex_tFileInputExcel_1 = 8;

								if (temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].length() > 0) {
									curColNum_tFileInputExcel_1 = columnIndex_tFileInputExcel_1
											+ start_column_tFileInputExcel_1 + 1;
									curColName_tFileInputExcel_1 = "SSN";

									CHIA.SSN = temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1];
								} else {
									CHIA.SSN = null;
									emptyColumnCount_tFileInputExcel_1++;
								}
								columnIndex_tFileInputExcel_1 = 9;

								if (temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].length() > 0) {
									curColNum_tFileInputExcel_1 = columnIndex_tFileInputExcel_1
											+ start_column_tFileInputExcel_1 + 1;
									curColName_tFileInputExcel_1 = "HPLNID";

									CHIA.HPLNID = ParserUtils.parseTo_Integer(ParserUtils.parseTo_Number(
											temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1], null,
											'.' == decimalChar_tFileInputExcel_1 ? null
													: decimalChar_tFileInputExcel_1));
								} else {
									CHIA.HPLNID = null;
									emptyColumnCount_tFileInputExcel_1++;
								}
								columnIndex_tFileInputExcel_1 = 10;

								if (temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].length() > 0) {
									curColNum_tFileInputExcel_1 = columnIndex_tFileInputExcel_1
											+ start_column_tFileInputExcel_1 + 1;
									curColName_tFileInputExcel_1 = "NYSIISFirstName";

									CHIA.NYSIISFirstName = temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1];
								} else {
									CHIA.NYSIISFirstName = null;
									emptyColumnCount_tFileInputExcel_1++;
								}
								columnIndex_tFileInputExcel_1 = 11;

								if (temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].length() > 0) {
									curColNum_tFileInputExcel_1 = columnIndex_tFileInputExcel_1
											+ start_column_tFileInputExcel_1 + 1;
									curColName_tFileInputExcel_1 = "NYSIISLastName";

									CHIA.NYSIISLastName = temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1];
								} else {
									CHIA.NYSIISLastName = null;
									emptyColumnCount_tFileInputExcel_1++;
								}
								columnIndex_tFileInputExcel_1 = 12;

								if (temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].length() > 0) {
									curColNum_tFileInputExcel_1 = columnIndex_tFileInputExcel_1
											+ start_column_tFileInputExcel_1 + 1;
									curColName_tFileInputExcel_1 = "HealthPlanID";

									CHIA.HealthPlanID = temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1];
								} else {
									CHIA.HealthPlanID = null;
									emptyColumnCount_tFileInputExcel_1++;
								}
								columnIndex_tFileInputExcel_1 = 13;

								if (temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].length() > 0) {
									curColNum_tFileInputExcel_1 = columnIndex_tFileInputExcel_1
											+ start_column_tFileInputExcel_1 + 1;
									curColName_tFileInputExcel_1 = "MRN";

									CHIA.MRN = ParserUtils.parseTo_Integer(ParserUtils.parseTo_Number(
											temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1], null,
											'.' == decimalChar_tFileInputExcel_1 ? null
													: decimalChar_tFileInputExcel_1));
								} else {
									CHIA.MRN = null;
									emptyColumnCount_tFileInputExcel_1++;
								}

								nb_line_tFileInputExcel_1++;

								log.debug("tFileInputExcel_1 - Retrieving the record " + (nb_line_tFileInputExcel_1)
										+ ".");

							} catch (java.lang.Exception e) {
								globalMap.put("tFileInputExcel_1_ERROR_MESSAGE", e.getMessage());
								whetherReject_tFileInputExcel_1 = true;
								log.error("tFileInputExcel_1 - " + e.getMessage());

								System.err.println(e.getMessage());
								CHIA = null;
							}

							/**
							 * [tFileInputExcel_1 begin ] stop
							 */

							/**
							 * [tFileInputExcel_1 main ] start
							 */

							s(currentComponent = "tFileInputExcel_1");

							cLabel = "<b>Reading xlsx</b>";

							tos_count_tFileInputExcel_1++;

							/**
							 * [tFileInputExcel_1 main ] stop
							 */

							/**
							 * [tFileInputExcel_1 process_data_begin ] start
							 */

							s(currentComponent = "tFileInputExcel_1");

							cLabel = "<b>Reading xlsx</b>";

							/**
							 * [tFileInputExcel_1 process_data_begin ] stop
							 */

// Start of branch "CHIA"
							if (CHIA != null) {

								/**
								 * [tGenKey_1 main ] start
								 */

								s(currentComponent = "tGenKey_1");

								cLabel = "<b>Blocking Key 1</b>";

								if (runStat.update(execStat, enableLogStash, iterateId, 1, 1

										, "CHIA", "tFileInputExcel_1", "<b>Reading xlsx</b>", "tFileInputExcel",
										"tGenKey_1", "<b>Blocking Key 1</b>", "tGenKey"

								)) {
									talendJobLogProcess(globalMap);
								}

								if (log.isTraceEnabled()) {
									log.trace("CHIA - " + (CHIA == null ? "" : CHIA.toLogString()));
								}

								String winKey_tGenKey_1 = "";
								String strInput_tGenKey_1 = null;
								strInput_tGenKey_1 = "";
								strInput_tGenKey_1 = TypeConvert.String2String(CHIA.SSN);
								strInput_tGenKey_1 = org.talend.windowkey.AlgoBox.exact(strInput_tGenKey_1);
								winKey_tGenKey_1 += (strInput_tGenKey_1 == null) ? "" : strInput_tGenKey_1;
								SSN.FirstName = CHIA.FirstName;
								SSN.LastName = CHIA.LastName;
								SSN.Gender = CHIA.Gender;
								SSN.PatientAddress = CHIA.PatientAddress;
								SSN.City = CHIA.City;
								SSN.State = CHIA.State;
								SSN.PostalCode = CHIA.PostalCode;
								SSN.Birthday = CHIA.Birthday;
								SSN.SSN = CHIA.SSN;
								SSN.HPLNID = CHIA.HPLNID;
								SSN.NYSIISFirstName = CHIA.NYSIISFirstName;
								SSN.NYSIISLastName = CHIA.NYSIISLastName;
								SSN.HealthPlanID = CHIA.HealthPlanID;
								SSN.MRN = CHIA.MRN;
								SSN.T_GEN_KEY = winKey_tGenKey_1;

								tos_count_tGenKey_1++;

								/**
								 * [tGenKey_1 main ] stop
								 */

								/**
								 * [tGenKey_1 process_data_begin ] start
								 */

								s(currentComponent = "tGenKey_1");

								cLabel = "<b>Blocking Key 1</b>";

								/**
								 * [tGenKey_1 process_data_begin ] stop
								 */

								/**
								 * [tMap_1 main ] start
								 */

								s(currentComponent = "tMap_1");

								cLabel = "<b>Mapping 1</b>";

								if (runStat.update(execStat, enableLogStash, iterateId, 1, 1

										, "SSN", "tGenKey_1", "<b>Blocking Key 1</b>", "tGenKey", "tMap_1",
										"<b>Mapping 1</b>", "tMap"

								)) {
									talendJobLogProcess(globalMap);
								}

								if (log.isTraceEnabled()) {
									log.trace("SSN - " + (SSN == null ? "" : SSN.toLogString()));
								}

								boolean hasCasePrimitiveKeyWithNull_tMap_1 = false;

								// ###############################
								// # Input tables (lookups)

								boolean rejectedInnerJoin_tMap_1 = false;
								boolean mainRowRejected_tMap_1 = false;
								// ###############################
								{ // start of Var scope

									// ###############################
									// # Vars tables

									Var__tMap_1__Struct Var = Var__tMap_1;// ###############################
									// ###############################
									// # Output tables

									SSN_Output = null;

// # Output table : 'SSN_Output'
									count_SSN_Output_tMap_1++;

									SSN_Output_tmp.FirstName = SSN.FirstName;
									SSN_Output_tmp.LastName = SSN.LastName;
									SSN_Output_tmp.Gender = SSN.Gender;
									SSN_Output_tmp.PatientAddress = SSN.PatientAddress;
									SSN_Output_tmp.City = SSN.City;
									SSN_Output_tmp.State = SSN.State;
									SSN_Output_tmp.PostalCode = SSN.PostalCode;
									SSN_Output_tmp.Birthday = SSN.Birthday;
									SSN_Output_tmp.SSN = SSN.SSN;
									SSN_Output_tmp.HPLNID = SSN.HPLNID;
									SSN_Output_tmp.NYSIISFirstName = SSN.NYSIISFirstName;
									SSN_Output_tmp.NYSIISLastName = SSN.NYSIISLastName;
									SSN_Output_tmp.HealthPlanID = SSN.HealthPlanID;
									SSN_Output_tmp.MRN = SSN.MRN;
									SSN_Output_tmp.SSNBlockingKey = SSN.T_GEN_KEY;
									SSN_Output = SSN_Output_tmp;
									log.debug("tMap_1 - Outputting the record " + count_SSN_Output_tMap_1
											+ " of the output table 'SSN_Output'.");

// ###############################

								} // end of Var scope

								rejectedInnerJoin_tMap_1 = false;

								tos_count_tMap_1++;

								/**
								 * [tMap_1 main ] stop
								 */

								/**
								 * [tMap_1 process_data_begin ] start
								 */

								s(currentComponent = "tMap_1");

								cLabel = "<b>Mapping 1</b>";

								/**
								 * [tMap_1 process_data_begin ] stop
								 */

// Start of branch "SSN_Output"
								if (SSN_Output != null) {

									/**
									 * [tGenKey_2 main ] start
									 */

									s(currentComponent = "tGenKey_2");

									cLabel = "<b>Blocking Key 2</b>";

									if (runStat.update(execStat, enableLogStash, iterateId, 1, 1

											, "SSN_Output", "tMap_1", "<b>Mapping 1</b>", "tMap", "tGenKey_2",
											"<b>Blocking Key 2</b>", "tGenKey"

									)) {
										talendJobLogProcess(globalMap);
									}

									if (log.isTraceEnabled()) {
										log.trace(
												"SSN_Output - " + (SSN_Output == null ? "" : SSN_Output.toLogString()));
									}

									String winKey_tGenKey_2 = "";
									String strInput_tGenKey_2 = null;
									strInput_tGenKey_2 = "";
									strInput_tGenKey_2 = TypeConvert.String2String(SSN_Output.FirstName);
									strInput_tGenKey_2 = org.talend.windowkey.AlgoBox.exact(strInput_tGenKey_2);
									winKey_tGenKey_2 += (strInput_tGenKey_2 == null) ? "" : strInput_tGenKey_2;
									strInput_tGenKey_2 = "";
									strInput_tGenKey_2 = TypeConvert.Date2String(SSN_Output.Birthday, "yyyy-MM-dd");
									strInput_tGenKey_2 = org.talend.windowkey.AlgoBox.exact(strInput_tGenKey_2);
									winKey_tGenKey_2 += (strInput_tGenKey_2 == null) ? "" : strInput_tGenKey_2;
									FNDOB.FirstName = SSN_Output.FirstName;
									FNDOB.LastName = SSN_Output.LastName;
									FNDOB.Gender = SSN_Output.Gender;
									FNDOB.PatientAddress = SSN_Output.PatientAddress;
									FNDOB.City = SSN_Output.City;
									FNDOB.State = SSN_Output.State;
									FNDOB.PostalCode = SSN_Output.PostalCode;
									FNDOB.Birthday = SSN_Output.Birthday;
									FNDOB.SSN = SSN_Output.SSN;
									FNDOB.HPLNID = SSN_Output.HPLNID;
									FNDOB.NYSIISFirstName = SSN_Output.NYSIISFirstName;
									FNDOB.NYSIISLastName = SSN_Output.NYSIISLastName;
									FNDOB.HealthPlanID = SSN_Output.HealthPlanID;
									FNDOB.MRN = SSN_Output.MRN;
									FNDOB.SSNBlockingKey = SSN_Output.SSNBlockingKey;
									FNDOB.T_GEN_KEY = winKey_tGenKey_2;

									tos_count_tGenKey_2++;

									/**
									 * [tGenKey_2 main ] stop
									 */

									/**
									 * [tGenKey_2 process_data_begin ] start
									 */

									s(currentComponent = "tGenKey_2");

									cLabel = "<b>Blocking Key 2</b>";

									/**
									 * [tGenKey_2 process_data_begin ] stop
									 */

									/**
									 * [tMap_2 main ] start
									 */

									s(currentComponent = "tMap_2");

									cLabel = "<b>Mapping 2</b>";

									if (runStat.update(execStat, enableLogStash, iterateId, 1, 1

											, "FNDOB", "tGenKey_2", "<b>Blocking Key 2</b>", "tGenKey", "tMap_2",
											"<b>Mapping 2</b>", "tMap"

									)) {
										talendJobLogProcess(globalMap);
									}

									if (log.isTraceEnabled()) {
										log.trace("FNDOB - " + (FNDOB == null ? "" : FNDOB.toLogString()));
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

										Var__tMap_2__Struct Var = Var__tMap_2;// ###############################
										// ###############################
										// # Output tables

										FNDOB_Output = null;

// # Output table : 'FNDOB_Output'
										count_FNDOB_Output_tMap_2++;

										FNDOB_Output_tmp.FirstName = FNDOB.FirstName;
										FNDOB_Output_tmp.LastName = FNDOB.LastName;
										FNDOB_Output_tmp.Gender = FNDOB.Gender;
										FNDOB_Output_tmp.PatientAddress = FNDOB.PatientAddress;
										FNDOB_Output_tmp.City = FNDOB.City;
										FNDOB_Output_tmp.State = FNDOB.State;
										FNDOB_Output_tmp.PostalCode = FNDOB.PostalCode;
										FNDOB_Output_tmp.Birthday = FNDOB.Birthday;
										FNDOB_Output_tmp.SSN = FNDOB.SSN;
										FNDOB_Output_tmp.HPLNID = FNDOB.HPLNID;
										FNDOB_Output_tmp.NYSIISFirstName = FNDOB.NYSIISFirstName;
										FNDOB_Output_tmp.NYSIISLastName = FNDOB.NYSIISLastName;
										FNDOB_Output_tmp.HealthPlanID = FNDOB.HealthPlanID;
										FNDOB_Output_tmp.MRN = FNDOB.MRN;
										FNDOB_Output_tmp.SSNBlockingKey = FNDOB.SSNBlockingKey;
										FNDOB_Output_tmp.FNDOBBlockingKey = FNDOB.T_GEN_KEY;
										FNDOB_Output = FNDOB_Output_tmp;
										log.debug("tMap_2 - Outputting the record " + count_FNDOB_Output_tMap_2
												+ " of the output table 'FNDOB_Output'.");

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

									cLabel = "<b>Mapping 2</b>";

									/**
									 * [tMap_2 process_data_begin ] stop
									 */

// Start of branch "FNDOB_Output"
									if (FNDOB_Output != null) {

										/**
										 * [tGenKey_3 main ] start
										 */

										s(currentComponent = "tGenKey_3");

										cLabel = "<b>Blocking Key 3</b>";

										if (runStat.update(execStat, enableLogStash, iterateId, 1, 1

												, "FNDOB_Output", "tMap_2", "<b>Mapping 2</b>", "tMap", "tGenKey_3",
												"<b>Blocking Key 3</b>", "tGenKey"

										)) {
											talendJobLogProcess(globalMap);
										}

										if (log.isTraceEnabled()) {
											log.trace("FNDOB_Output - "
													+ (FNDOB_Output == null ? "" : FNDOB_Output.toLogString()));
										}

										String winKey_tGenKey_3 = "";
										String strInput_tGenKey_3 = null;
										strInput_tGenKey_3 = "";
										strInput_tGenKey_3 = TypeConvert.String2String(FNDOB_Output.LastName);
										strInput_tGenKey_3 = org.talend.windowkey.AlgoBox.exact(strInput_tGenKey_3);
										winKey_tGenKey_3 += (strInput_tGenKey_3 == null) ? "" : strInput_tGenKey_3;
										strInput_tGenKey_3 = "";
										strInput_tGenKey_3 = TypeConvert.Integer2String(FNDOB_Output.PostalCode);
										strInput_tGenKey_3 = org.talend.windowkey.AlgoBox.exact(strInput_tGenKey_3);
										winKey_tGenKey_3 += (strInput_tGenKey_3 == null) ? "" : strInput_tGenKey_3;
										LNPC.FirstName = FNDOB_Output.FirstName;
										LNPC.LastName = FNDOB_Output.LastName;
										LNPC.Gender = FNDOB_Output.Gender;
										LNPC.PatientAddress = FNDOB_Output.PatientAddress;
										LNPC.City = FNDOB_Output.City;
										LNPC.State = FNDOB_Output.State;
										LNPC.PostalCode = FNDOB_Output.PostalCode;
										LNPC.Birthday = FNDOB_Output.Birthday;
										LNPC.SSN = FNDOB_Output.SSN;
										LNPC.HPLNID = FNDOB_Output.HPLNID;
										LNPC.NYSIISFirstName = FNDOB_Output.NYSIISFirstName;
										LNPC.NYSIISLastName = FNDOB_Output.NYSIISLastName;
										LNPC.HealthPlanID = FNDOB_Output.HealthPlanID;
										LNPC.MRN = FNDOB_Output.MRN;
										LNPC.SSNBlockingKey = FNDOB_Output.SSNBlockingKey;
										LNPC.FNDOBBlockingKey = FNDOB_Output.FNDOBBlockingKey;
										LNPC.T_GEN_KEY = winKey_tGenKey_3;

										tos_count_tGenKey_3++;

										/**
										 * [tGenKey_3 main ] stop
										 */

										/**
										 * [tGenKey_3 process_data_begin ] start
										 */

										s(currentComponent = "tGenKey_3");

										cLabel = "<b>Blocking Key 3</b>";

										/**
										 * [tGenKey_3 process_data_begin ] stop
										 */

										/**
										 * [tMap_3 main ] start
										 */

										s(currentComponent = "tMap_3");

										cLabel = "<b>Mapping 3</b>";

										if (runStat.update(execStat, enableLogStash, iterateId, 1, 1

												, "LNPC", "tGenKey_3", "<b>Blocking Key 3</b>", "tGenKey", "tMap_3",
												"<b>Mapping 3</b>", "tMap"

										)) {
											talendJobLogProcess(globalMap);
										}

										if (log.isTraceEnabled()) {
											log.trace("LNPC - " + (LNPC == null ? "" : LNPC.toLogString()));
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

											LNPC_Output = null;

// # Output table : 'LNPC_Output'
											count_LNPC_Output_tMap_3++;

											LNPC_Output_tmp.FirstName = LNPC.FirstName;
											LNPC_Output_tmp.LastName = LNPC.LastName;
											LNPC_Output_tmp.Gender = LNPC.Gender;
											LNPC_Output_tmp.PatientAddress = LNPC.PatientAddress;
											LNPC_Output_tmp.City = LNPC.City;
											LNPC_Output_tmp.State = LNPC.State;
											LNPC_Output_tmp.PostalCode = LNPC.PostalCode;
											LNPC_Output_tmp.Birthday = LNPC.Birthday;
											LNPC_Output_tmp.SSN = LNPC.SSN;
											LNPC_Output_tmp.HPLNID = LNPC.HPLNID;
											LNPC_Output_tmp.NYSIISFirstName = LNPC.NYSIISFirstName;
											LNPC_Output_tmp.NYSIISLastName = LNPC.NYSIISLastName;
											LNPC_Output_tmp.HealthPlanID = LNPC.HealthPlanID;
											LNPC_Output_tmp.MRN = LNPC.MRN;
											LNPC_Output_tmp.SSNBlockingKey = LNPC.SSNBlockingKey;
											LNPC_Output_tmp.FNDOBBlockingKey = LNPC.FNDOBBlockingKey;
											LNPC_Output_tmp.LNPCBlockingKey = LNPC.T_GEN_KEY;
											LNPC_Output = LNPC_Output_tmp;
											log.debug("tMap_3 - Outputting the record " + count_LNPC_Output_tMap_3
													+ " of the output table 'LNPC_Output'.");

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

										cLabel = "<b>Mapping 3</b>";

										/**
										 * [tMap_3 process_data_begin ] stop
										 */

// Start of branch "LNPC_Output"
										if (LNPC_Output != null) {

											/**
											 * [tGenKey_4 main ] start
											 */

											s(currentComponent = "tGenKey_4");

											cLabel = "<b>Blocking Key 4</b>";

											if (runStat.update(execStat, enableLogStash, iterateId, 1, 1

													, "LNPC_Output", "tMap_3", "<b>Mapping 3</b>", "tMap", "tGenKey_4",
													"<b>Blocking Key 4</b>", "tGenKey"

											)) {
												talendJobLogProcess(globalMap);
											}

											if (log.isTraceEnabled()) {
												log.trace("LNPC_Output - "
														+ (LNPC_Output == null ? "" : LNPC_Output.toLogString()));
											}

											String winKey_tGenKey_4 = "";
											String strInput_tGenKey_4 = null;
											strInput_tGenKey_4 = "";
											strInput_tGenKey_4 = TypeConvert.String2String(LNPC_Output.FirstName);
											strInput_tGenKey_4 = org.talend.windowkey.AlgoBox.exact(strInput_tGenKey_4);
											winKey_tGenKey_4 += (strInput_tGenKey_4 == null) ? "" : strInput_tGenKey_4;
											strInput_tGenKey_4 = "";
											strInput_tGenKey_4 = TypeConvert.String2String(LNPC_Output.FirstName);
											strInput_tGenKey_4 = org.talend.windowkey.AlgoBox.exact(strInput_tGenKey_4);
											winKey_tGenKey_4 += (strInput_tGenKey_4 == null) ? "" : strInput_tGenKey_4;
											NYSIISFNLN.FirstName = LNPC_Output.FirstName;
											NYSIISFNLN.LastName = LNPC_Output.LastName;
											NYSIISFNLN.Gender = LNPC_Output.Gender;
											NYSIISFNLN.PatientAddress = LNPC_Output.PatientAddress;
											NYSIISFNLN.City = LNPC_Output.City;
											NYSIISFNLN.State = LNPC_Output.State;
											NYSIISFNLN.PostalCode = LNPC_Output.PostalCode;
											NYSIISFNLN.Birthday = LNPC_Output.Birthday;
											NYSIISFNLN.SSN = LNPC_Output.SSN;
											NYSIISFNLN.HPLNID = LNPC_Output.HPLNID;
											NYSIISFNLN.NYSIISFirstName = LNPC_Output.NYSIISFirstName;
											NYSIISFNLN.NYSIISLastName = LNPC_Output.NYSIISLastName;
											NYSIISFNLN.HealthPlanID = LNPC_Output.HealthPlanID;
											NYSIISFNLN.MRN = LNPC_Output.MRN;
											NYSIISFNLN.SSNBlockingKey = LNPC_Output.SSNBlockingKey;
											NYSIISFNLN.FNDOBBlockingKey = LNPC_Output.FNDOBBlockingKey;
											NYSIISFNLN.LNPCBlockingKey = LNPC_Output.LNPCBlockingKey;
											NYSIISFNLN.T_GEN_KEY = winKey_tGenKey_4;

											tos_count_tGenKey_4++;

											/**
											 * [tGenKey_4 main ] stop
											 */

											/**
											 * [tGenKey_4 process_data_begin ] start
											 */

											s(currentComponent = "tGenKey_4");

											cLabel = "<b>Blocking Key 4</b>";

											/**
											 * [tGenKey_4 process_data_begin ] stop
											 */

											/**
											 * [tMap_4 main ] start
											 */

											s(currentComponent = "tMap_4");

											cLabel = "<b>Mapping Key 4</b>";

											if (runStat.update(execStat, enableLogStash, iterateId, 1, 1

													, "NYSIISFNLN", "tGenKey_4", "<b>Blocking Key 4</b>", "tGenKey",
													"tMap_4", "<b>Mapping Key 4</b>", "tMap"

											)) {
												talendJobLogProcess(globalMap);
											}

											if (log.isTraceEnabled()) {
												log.trace("NYSIISFNLN - "
														+ (NYSIISFNLN == null ? "" : NYSIISFNLN.toLogString()));
											}

											boolean hasCasePrimitiveKeyWithNull_tMap_4 = false;

											// ###############################
											// # Input tables (lookups)

											boolean rejectedInnerJoin_tMap_4 = false;
											boolean mainRowRejected_tMap_4 = false;
											// ###############################
											{ // start of Var scope

												// ###############################
												// # Vars tables

												Var__tMap_4__Struct Var = Var__tMap_4;// ###############################
												// ###############################
												// # Output tables

												NYSIISFNLN_Output = null;

// # Output table : 'NYSIISFNLN_Output'
												count_NYSIISFNLN_Output_tMap_4++;

												NYSIISFNLN_Output_tmp.FirstName = NYSIISFNLN.FirstName;
												NYSIISFNLN_Output_tmp.LastName = NYSIISFNLN.LastName;
												NYSIISFNLN_Output_tmp.Gender = NYSIISFNLN.Gender;
												NYSIISFNLN_Output_tmp.PatientAddress = NYSIISFNLN.PatientAddress;
												NYSIISFNLN_Output_tmp.City = NYSIISFNLN.City;
												NYSIISFNLN_Output_tmp.State = NYSIISFNLN.State;
												NYSIISFNLN_Output_tmp.PostalCode = NYSIISFNLN.PostalCode;
												NYSIISFNLN_Output_tmp.Birthday = NYSIISFNLN.Birthday;
												NYSIISFNLN_Output_tmp.SSN = NYSIISFNLN.SSN;
												NYSIISFNLN_Output_tmp.HPLNID = NYSIISFNLN.HPLNID;
												NYSIISFNLN_Output_tmp.NYSIISFirstName = NYSIISFNLN.NYSIISFirstName;
												NYSIISFNLN_Output_tmp.NYSIISLastName = NYSIISFNLN.NYSIISLastName;
												NYSIISFNLN_Output_tmp.HealthPlanID = NYSIISFNLN.HealthPlanID;
												NYSIISFNLN_Output_tmp.MRN = NYSIISFNLN.MRN;
												NYSIISFNLN_Output_tmp.SSNBlockingKey = NYSIISFNLN.SSNBlockingKey;
												NYSIISFNLN_Output_tmp.FNDOBBlockingKey = NYSIISFNLN.FNDOBBlockingKey;
												NYSIISFNLN_Output_tmp.LNPCBlockingKey = NYSIISFNLN.LNPCBlockingKey;
												NYSIISFNLN_Output_tmp.NYSIISFNLNBlockingKey = NYSIISFNLN.T_GEN_KEY;
												NYSIISFNLN_Output = NYSIISFNLN_Output_tmp;
												log.debug("tMap_4 - Outputting the record "
														+ count_NYSIISFNLN_Output_tMap_4
														+ " of the output table 'NYSIISFNLN_Output'.");

// ###############################

											} // end of Var scope

											rejectedInnerJoin_tMap_4 = false;

											tos_count_tMap_4++;

											/**
											 * [tMap_4 main ] stop
											 */

											/**
											 * [tMap_4 process_data_begin ] start
											 */

											s(currentComponent = "tMap_4");

											cLabel = "<b>Mapping Key 4</b>";

											/**
											 * [tMap_4 process_data_begin ] stop
											 */

// Start of branch "NYSIISFNLN_Output"
											if (NYSIISFNLN_Output != null) {

												/**
												 * [tGenKey_5 main ] start
												 */

												s(currentComponent = "tGenKey_5");

												cLabel = "<b>Blocking Key 5</b>";

												if (runStat.update(execStat, enableLogStash, iterateId, 1, 1

														, "NYSIISFNLN_Output", "tMap_4", "<b>Mapping Key 4</b>", "tMap",
														"tGenKey_5", "<b>Blocking Key 5</b>", "tGenKey"

												)) {
													talendJobLogProcess(globalMap);
												}

												if (log.isTraceEnabled()) {
													log.trace("NYSIISFNLN_Output - " + (NYSIISFNLN_Output == null ? ""
															: NYSIISFNLN_Output.toLogString()));
												}

												String winKey_tGenKey_5 = "";
												String strInput_tGenKey_5 = null;
												strInput_tGenKey_5 = "";
												strInput_tGenKey_5 = TypeConvert.Date2String(NYSIISFNLN_Output.Birthday,
														"yyyy-MM-dd");
												strInput_tGenKey_5 = org.talend.windowkey.AlgoBox
														.exact(strInput_tGenKey_5);
												winKey_tGenKey_5 += (strInput_tGenKey_5 == null) ? ""
														: strInput_tGenKey_5;
												strInput_tGenKey_5 = "";
												strInput_tGenKey_5 = TypeConvert
														.Integer2String(NYSIISFNLN_Output.PostalCode);
												strInput_tGenKey_5 = org.talend.windowkey.AlgoBox
														.exact(strInput_tGenKey_5);
												winKey_tGenKey_5 += (strInput_tGenKey_5 == null) ? ""
														: strInput_tGenKey_5;
												DOBPC.FirstName = NYSIISFNLN_Output.FirstName;
												DOBPC.LastName = NYSIISFNLN_Output.LastName;
												DOBPC.Gender = NYSIISFNLN_Output.Gender;
												DOBPC.PatientAddress = NYSIISFNLN_Output.PatientAddress;
												DOBPC.City = NYSIISFNLN_Output.City;
												DOBPC.State = NYSIISFNLN_Output.State;
												DOBPC.PostalCode = NYSIISFNLN_Output.PostalCode;
												DOBPC.Birthday = NYSIISFNLN_Output.Birthday;
												DOBPC.SSN = NYSIISFNLN_Output.SSN;
												DOBPC.HPLNID = NYSIISFNLN_Output.HPLNID;
												DOBPC.NYSIISFirstName = NYSIISFNLN_Output.NYSIISFirstName;
												DOBPC.NYSIISLastName = NYSIISFNLN_Output.NYSIISLastName;
												DOBPC.HealthPlanID = NYSIISFNLN_Output.HealthPlanID;
												DOBPC.MRN = NYSIISFNLN_Output.MRN;
												DOBPC.SSNBlockingKey = NYSIISFNLN_Output.SSNBlockingKey;
												DOBPC.FNDOBBlockingKey = NYSIISFNLN_Output.FNDOBBlockingKey;
												DOBPC.LNPCBlockingKey = NYSIISFNLN_Output.LNPCBlockingKey;
												DOBPC.NYSIISFNLNBlockingKey = NYSIISFNLN_Output.NYSIISFNLNBlockingKey;
												DOBPC.T_GEN_KEY = winKey_tGenKey_5;

												tos_count_tGenKey_5++;

												/**
												 * [tGenKey_5 main ] stop
												 */

												/**
												 * [tGenKey_5 process_data_begin ] start
												 */

												s(currentComponent = "tGenKey_5");

												cLabel = "<b>Blocking Key 5</b>";

												/**
												 * [tGenKey_5 process_data_begin ] stop
												 */

												/**
												 * [tMap_5 main ] start
												 */

												s(currentComponent = "tMap_5");

												cLabel = "<b>Mapping 5</b>";

												if (runStat.update(execStat, enableLogStash, iterateId, 1, 1

														, "DOBPC", "tGenKey_5", "<b>Blocking Key 5</b>", "tGenKey",
														"tMap_5", "<b>Mapping 5</b>", "tMap"

												)) {
													talendJobLogProcess(globalMap);
												}

												if (log.isTraceEnabled()) {
													log.trace("DOBPC - " + (DOBPC == null ? "" : DOBPC.toLogString()));
												}

												boolean hasCasePrimitiveKeyWithNull_tMap_5 = false;

												// ###############################
												// # Input tables (lookups)

												boolean rejectedInnerJoin_tMap_5 = false;
												boolean mainRowRejected_tMap_5 = false;
												// ###############################
												{ // start of Var scope

													// ###############################
													// # Vars tables

													Var__tMap_5__Struct Var = Var__tMap_5;// ###############################
													// ###############################
													// # Output tables

													DOBPC_Output = null;

// # Output table : 'DOBPC_Output'
													count_DOBPC_Output_tMap_5++;

													DOBPC_Output_tmp.FirstName = DOBPC.FirstName;
													DOBPC_Output_tmp.LastName = DOBPC.LastName;
													DOBPC_Output_tmp.Gender = DOBPC.Gender;
													DOBPC_Output_tmp.PatientAddress = DOBPC.PatientAddress;
													DOBPC_Output_tmp.City = DOBPC.City;
													DOBPC_Output_tmp.State = DOBPC.State;
													DOBPC_Output_tmp.PostalCode = DOBPC.PostalCode;
													DOBPC_Output_tmp.Birthday = DOBPC.Birthday;
													DOBPC_Output_tmp.SSN = DOBPC.SSN;
													DOBPC_Output_tmp.HPLNID = DOBPC.HPLNID;
													DOBPC_Output_tmp.NYSIISFirstName = DOBPC.NYSIISFirstName;
													DOBPC_Output_tmp.NYSIISLastName = DOBPC.NYSIISLastName;
													DOBPC_Output_tmp.HealthPlanID = DOBPC.HealthPlanID;
													DOBPC_Output_tmp.MRN = DOBPC.MRN;
													DOBPC_Output_tmp.SSNBlockingKey = DOBPC.SSNBlockingKey;
													DOBPC_Output_tmp.FNDOBBlockingKey = DOBPC.FNDOBBlockingKey;
													DOBPC_Output_tmp.LNPCBlockingKey = DOBPC.LNPCBlockingKey;
													DOBPC_Output_tmp.NYSIISFNLNBlockingKey = DOBPC.NYSIISFNLNBlockingKey;
													DOBPC_Output_tmp.DOBPCBlockingKey = DOBPC.T_GEN_KEY;
													DOBPC_Output = DOBPC_Output_tmp;
													log.debug("tMap_5 - Outputting the record "
															+ count_DOBPC_Output_tMap_5
															+ " of the output table 'DOBPC_Output'.");

// ###############################

												} // end of Var scope

												rejectedInnerJoin_tMap_5 = false;

												tos_count_tMap_5++;

												/**
												 * [tMap_5 main ] stop
												 */

												/**
												 * [tMap_5 process_data_begin ] start
												 */

												s(currentComponent = "tMap_5");

												cLabel = "<b>Mapping 5</b>";

												/**
												 * [tMap_5 process_data_begin ] stop
												 */

// Start of branch "DOBPC_Output"
												if (DOBPC_Output != null) {

													/**
													 * [tGenKey_6 main ] start
													 */

													s(currentComponent = "tGenKey_6");

													cLabel = "<b>Blocking Key 6</b>";

													if (runStat.update(execStat, enableLogStash, iterateId, 1, 1

															, "DOBPC_Output", "tMap_5", "<b>Mapping 5</b>", "tMap",
															"tGenKey_6", "<b>Blocking Key 6</b>", "tGenKey"

													)) {
														talendJobLogProcess(globalMap);
													}

													if (log.isTraceEnabled()) {
														log.trace("DOBPC_Output - " + (DOBPC_Output == null ? ""
																: DOBPC_Output.toLogString()));
													}

													String winKey_tGenKey_6 = "";
													String strInput_tGenKey_6 = null;
													strInput_tGenKey_6 = "";
													strInput_tGenKey_6 = TypeConvert.Integer2String(DOBPC_Output.MRN);
													strInput_tGenKey_6 = org.talend.windowkey.AlgoBox
															.exact(strInput_tGenKey_6);
													winKey_tGenKey_6 += (strInput_tGenKey_6 == null) ? ""
															: strInput_tGenKey_6;
													MRN.FirstName = DOBPC_Output.FirstName;
													MRN.LastName = DOBPC_Output.LastName;
													MRN.Gender = DOBPC_Output.Gender;
													MRN.PatientAddress = DOBPC_Output.PatientAddress;
													MRN.City = DOBPC_Output.City;
													MRN.State = DOBPC_Output.State;
													MRN.PostalCode = DOBPC_Output.PostalCode;
													MRN.Birthday = DOBPC_Output.Birthday;
													MRN.SSN = DOBPC_Output.SSN;
													MRN.HPLNID = DOBPC_Output.HPLNID;
													MRN.NYSIISFirstName = DOBPC_Output.NYSIISFirstName;
													MRN.NYSIISLastName = DOBPC_Output.NYSIISLastName;
													MRN.HealthPlanID = DOBPC_Output.HealthPlanID;
													MRN.MRN = DOBPC_Output.MRN;
													MRN.SSNBlockingKey = DOBPC_Output.SSNBlockingKey;
													MRN.FNDOBBlockingKey = DOBPC_Output.FNDOBBlockingKey;
													MRN.LNPCBlockingKey = DOBPC_Output.LNPCBlockingKey;
													MRN.NYSIISFNLNBlockingKey = DOBPC_Output.NYSIISFNLNBlockingKey;
													MRN.DOBPCBlockingKey = DOBPC_Output.DOBPCBlockingKey;
													MRN.T_GEN_KEY = winKey_tGenKey_6;

													tos_count_tGenKey_6++;

													/**
													 * [tGenKey_6 main ] stop
													 */

													/**
													 * [tGenKey_6 process_data_begin ] start
													 */

													s(currentComponent = "tGenKey_6");

													cLabel = "<b>Blocking Key 6</b>";

													/**
													 * [tGenKey_6 process_data_begin ] stop
													 */

													/**
													 * [tMap_6 main ] start
													 */

													s(currentComponent = "tMap_6");

													cLabel = "<b>Mapping 6</b>";

													if (runStat.update(execStat, enableLogStash, iterateId, 1, 1

															, "MRN", "tGenKey_6", "<b>Blocking Key 6</b>", "tGenKey",
															"tMap_6", "<b>Mapping 6</b>", "tMap"

													)) {
														talendJobLogProcess(globalMap);
													}

													if (log.isTraceEnabled()) {
														log.trace("MRN - " + (MRN == null ? "" : MRN.toLogString()));
													}

													boolean hasCasePrimitiveKeyWithNull_tMap_6 = false;

													// ###############################
													// # Input tables (lookups)

													boolean rejectedInnerJoin_tMap_6 = false;
													boolean mainRowRejected_tMap_6 = false;
													// ###############################
													{ // start of Var scope

														// ###############################
														// # Vars tables

														Var__tMap_6__Struct Var = Var__tMap_6;// ###############################
														// ###############################
														// # Output tables

														MRN_Output = null;

// # Output table : 'MRN_Output'
														count_MRN_Output_tMap_6++;

														MRN_Output_tmp.FirstName = MRN.FirstName;
														MRN_Output_tmp.LastName = MRN.LastName;
														MRN_Output_tmp.Gender = MRN.Gender;
														MRN_Output_tmp.PatientAddress = MRN.PatientAddress;
														MRN_Output_tmp.City = MRN.City;
														MRN_Output_tmp.State = MRN.State;
														MRN_Output_tmp.PostalCode = MRN.PostalCode;
														MRN_Output_tmp.Birthday = MRN.Birthday;
														MRN_Output_tmp.SSN = MRN.SSN;
														MRN_Output_tmp.HPLNID = MRN.HPLNID;
														MRN_Output_tmp.NYSIISFirstName = MRN.NYSIISFirstName;
														MRN_Output_tmp.NYSIISLastName = MRN.NYSIISLastName;
														MRN_Output_tmp.HealthPlanID = MRN.HealthPlanID;
														MRN_Output_tmp.MRN = MRN.MRN;
														MRN_Output_tmp.SSNBlockingKey = MRN.SSNBlockingKey;
														MRN_Output_tmp.FNDOBBlockingKey = MRN.FNDOBBlockingKey;
														MRN_Output_tmp.LNPCBlockingKey = MRN.LNPCBlockingKey;
														MRN_Output_tmp.NYSIISFNLNBlockingKey = MRN.NYSIISFNLNBlockingKey;
														MRN_Output_tmp.DOBPCBlockingKey = MRN.DOBPCBlockingKey;
														MRN_Output_tmp.MRNBlockingKey = MRN.T_GEN_KEY;
														MRN_Output = MRN_Output_tmp;
														log.debug("tMap_6 - Outputting the record "
																+ count_MRN_Output_tMap_6
																+ " of the output table 'MRN_Output'.");

// ###############################

													} // end of Var scope

													rejectedInnerJoin_tMap_6 = false;

													tos_count_tMap_6++;

													/**
													 * [tMap_6 main ] stop
													 */

													/**
													 * [tMap_6 process_data_begin ] start
													 */

													s(currentComponent = "tMap_6");

													cLabel = "<b>Mapping 6</b>";

													/**
													 * [tMap_6 process_data_begin ] stop
													 */

// Start of branch "MRN_Output"
													if (MRN_Output != null) {

														/**
														 * [tGenKey_7 main ] start
														 */

														s(currentComponent = "tGenKey_7");

														cLabel = "<b>Blocking Key 7</b>";

														if (runStat.update(execStat, enableLogStash, iterateId, 1, 1

																, "MRN_Output", "tMap_6", "<b>Mapping 6</b>", "tMap",
																"tGenKey_7", "<b>Blocking Key 7</b>", "tGenKey"

														)) {
															talendJobLogProcess(globalMap);
														}

														if (log.isTraceEnabled()) {
															log.trace("MRN_Output - " + (MRN_Output == null ? ""
																	: MRN_Output.toLogString()));
														}

														String winKey_tGenKey_7 = "";
														String strInput_tGenKey_7 = null;
														strInput_tGenKey_7 = "";
														strInput_tGenKey_7 = TypeConvert
																.String2String(MRN_Output.HealthPlanID);
														strInput_tGenKey_7 = org.talend.windowkey.AlgoBox
																.exact(strInput_tGenKey_7);
														winKey_tGenKey_7 += (strInput_tGenKey_7 == null) ? ""
																: strInput_tGenKey_7;
														HealthPlanID.FirstName = MRN_Output.FirstName;
														HealthPlanID.LastName = MRN_Output.LastName;
														HealthPlanID.Gender = MRN_Output.Gender;
														HealthPlanID.PatientAddress = MRN_Output.PatientAddress;
														HealthPlanID.City = MRN_Output.City;
														HealthPlanID.State = MRN_Output.State;
														HealthPlanID.PostalCode = MRN_Output.PostalCode;
														HealthPlanID.Birthday = MRN_Output.Birthday;
														HealthPlanID.SSN = MRN_Output.SSN;
														HealthPlanID.HPLNID = MRN_Output.HPLNID;
														HealthPlanID.NYSIISFirstName = MRN_Output.NYSIISFirstName;
														HealthPlanID.NYSIISLastName = MRN_Output.NYSIISLastName;
														HealthPlanID.HealthPlanID = MRN_Output.HealthPlanID;
														HealthPlanID.MRN = MRN_Output.MRN;
														HealthPlanID.SSNBlockingKey = MRN_Output.SSNBlockingKey;
														HealthPlanID.FNDOBBlockingKey = MRN_Output.FNDOBBlockingKey;
														HealthPlanID.LNPCBlockingKey = MRN_Output.LNPCBlockingKey;
														HealthPlanID.NYSIISFNLNBlockingKey = MRN_Output.NYSIISFNLNBlockingKey;
														HealthPlanID.DOBPCBlockingKey = MRN_Output.DOBPCBlockingKey;
														HealthPlanID.MRNBlockingKey = MRN_Output.MRNBlockingKey;
														HealthPlanID.T_GEN_KEY = winKey_tGenKey_7;

														tos_count_tGenKey_7++;

														/**
														 * [tGenKey_7 main ] stop
														 */

														/**
														 * [tGenKey_7 process_data_begin ] start
														 */

														s(currentComponent = "tGenKey_7");

														cLabel = "<b>Blocking Key 7</b>";

														/**
														 * [tGenKey_7 process_data_begin ] stop
														 */

														/**
														 * [tMap_7 main ] start
														 */

														s(currentComponent = "tMap_7");

														cLabel = "<b>Mapping 7</b>";

														if (runStat.update(execStat, enableLogStash, iterateId, 1, 1

																, "HealthPlanID", "tGenKey_7", "<b>Blocking Key 7</b>",
																"tGenKey", "tMap_7", "<b>Mapping 7</b>", "tMap"

														)) {
															talendJobLogProcess(globalMap);
														}

														if (log.isTraceEnabled()) {
															log.trace("HealthPlanID - " + (HealthPlanID == null ? ""
																	: HealthPlanID.toLogString()));
														}

														boolean hasCasePrimitiveKeyWithNull_tMap_7 = false;

														// ###############################
														// # Input tables (lookups)

														boolean rejectedInnerJoin_tMap_7 = false;
														boolean mainRowRejected_tMap_7 = false;
														// ###############################
														{ // start of Var scope

															// ###############################
															// # Vars tables

															Var__tMap_7__Struct Var = Var__tMap_7;// ###############################
															// ###############################
															// # Output tables

															HealthPlanID_Output = null;

// # Output table : 'HealthPlanID_Output'
															count_HealthPlanID_Output_tMap_7++;

															HealthPlanID_Output_tmp.FirstName = HealthPlanID.FirstName;
															HealthPlanID_Output_tmp.LastName = HealthPlanID.LastName;
															HealthPlanID_Output_tmp.Gender = HealthPlanID.Gender;
															HealthPlanID_Output_tmp.PatientAddress = HealthPlanID.PatientAddress;
															HealthPlanID_Output_tmp.City = HealthPlanID.City;
															HealthPlanID_Output_tmp.State = HealthPlanID.State;
															HealthPlanID_Output_tmp.PostalCode = HealthPlanID.PostalCode;
															HealthPlanID_Output_tmp.Birthday = HealthPlanID.Birthday;
															HealthPlanID_Output_tmp.SSN = HealthPlanID.SSN;
															HealthPlanID_Output_tmp.HPLNID = HealthPlanID.HPLNID;
															HealthPlanID_Output_tmp.NYSIISFirstName = HealthPlanID.NYSIISFirstName;
															HealthPlanID_Output_tmp.NYSIISLastName = HealthPlanID.NYSIISLastName;
															HealthPlanID_Output_tmp.HealthPlanID = HealthPlanID.HealthPlanID;
															HealthPlanID_Output_tmp.MRN = HealthPlanID.MRN;
															HealthPlanID_Output_tmp.SSNBlockingKey = HealthPlanID.SSNBlockingKey;
															HealthPlanID_Output_tmp.FNDOBBlockingKey = HealthPlanID.FNDOBBlockingKey;
															HealthPlanID_Output_tmp.LNPCBlockingKey = HealthPlanID.LNPCBlockingKey;
															HealthPlanID_Output_tmp.NYSIISFNLNBlockingKey = HealthPlanID.NYSIISFNLNBlockingKey;
															HealthPlanID_Output_tmp.DOBPCBlockingKey = HealthPlanID.DOBPCBlockingKey;
															HealthPlanID_Output_tmp.MRNBlockingKey = HealthPlanID.MRNBlockingKey;
															HealthPlanID_Output_tmp.HealthPlanIDBlockingKey = HealthPlanID.T_GEN_KEY;
															HealthPlanID_Output = HealthPlanID_Output_tmp;
															log.debug("tMap_7 - Outputting the record "
																	+ count_HealthPlanID_Output_tMap_7
																	+ " of the output table 'HealthPlanID_Output'.");

// ###############################

														} // end of Var scope

														rejectedInnerJoin_tMap_7 = false;

														tos_count_tMap_7++;

														/**
														 * [tMap_7 main ] stop
														 */

														/**
														 * [tMap_7 process_data_begin ] start
														 */

														s(currentComponent = "tMap_7");

														cLabel = "<b>Mapping 7</b>";

														/**
														 * [tMap_7 process_data_begin ] stop
														 */

// Start of branch "HealthPlanID_Output"
														if (HealthPlanID_Output != null) {

															/**
															 * [tLogRow_1 main ] start
															 */

															s(currentComponent = "tLogRow_1");

															cLabel = "<b>Console</b>";

															if (runStat.update(execStat, enableLogStash, iterateId, 1, 1

																	, "HealthPlanID_Output", "tMap_7",
																	"<b>Mapping 7</b>", "tMap", "tLogRow_1",
																	"<b>Console</b>", "tLogRow"

															)) {
																talendJobLogProcess(globalMap);
															}

															if (log.isTraceEnabled()) {
																log.trace("HealthPlanID_Output - "
																		+ (HealthPlanID_Output == null ? ""
																				: HealthPlanID_Output.toLogString()));
															}

///////////////////////		

															String[] row_tLogRow_1 = new String[21];

															if (HealthPlanID_Output.FirstName != null) { //
																row_tLogRow_1[0] = String
																		.valueOf(HealthPlanID_Output.FirstName);

															} //

															if (HealthPlanID_Output.LastName != null) { //
																row_tLogRow_1[1] = String
																		.valueOf(HealthPlanID_Output.LastName);

															} //

															if (HealthPlanID_Output.Gender != null) { //
																row_tLogRow_1[2] = String
																		.valueOf(HealthPlanID_Output.Gender);

															} //

															if (HealthPlanID_Output.PatientAddress != null) { //
																row_tLogRow_1[3] = String
																		.valueOf(HealthPlanID_Output.PatientAddress);

															} //

															if (HealthPlanID_Output.City != null) { //
																row_tLogRow_1[4] = String
																		.valueOf(HealthPlanID_Output.City);

															} //

															if (HealthPlanID_Output.State != null) { //
																row_tLogRow_1[5] = String
																		.valueOf(HealthPlanID_Output.State);

															} //

															if (HealthPlanID_Output.PostalCode != null) { //
																row_tLogRow_1[6] = String
																		.valueOf(HealthPlanID_Output.PostalCode);

															} //

															if (HealthPlanID_Output.Birthday != null) { //
																row_tLogRow_1[7] = FormatterUtils.format_Date(
																		HealthPlanID_Output.Birthday, "yyyy-MM-dd");

															} //

															if (HealthPlanID_Output.SSN != null) { //
																row_tLogRow_1[8] = String
																		.valueOf(HealthPlanID_Output.SSN);

															} //

															if (HealthPlanID_Output.HPLNID != null) { //
																row_tLogRow_1[9] = String
																		.valueOf(HealthPlanID_Output.HPLNID);

															} //

															if (HealthPlanID_Output.NYSIISFirstName != null) { //
																row_tLogRow_1[10] = String
																		.valueOf(HealthPlanID_Output.NYSIISFirstName);

															} //

															if (HealthPlanID_Output.NYSIISLastName != null) { //
																row_tLogRow_1[11] = String
																		.valueOf(HealthPlanID_Output.NYSIISLastName);

															} //

															if (HealthPlanID_Output.HealthPlanID != null) { //
																row_tLogRow_1[12] = String
																		.valueOf(HealthPlanID_Output.HealthPlanID);

															} //

															if (HealthPlanID_Output.MRN != null) { //
																row_tLogRow_1[13] = String
																		.valueOf(HealthPlanID_Output.MRN);

															} //

															if (HealthPlanID_Output.SSNBlockingKey != null) { //
																row_tLogRow_1[14] = String
																		.valueOf(HealthPlanID_Output.SSNBlockingKey);

															} //

															if (HealthPlanID_Output.FNDOBBlockingKey != null) { //
																row_tLogRow_1[15] = String
																		.valueOf(HealthPlanID_Output.FNDOBBlockingKey);

															} //

															if (HealthPlanID_Output.LNPCBlockingKey != null) { //
																row_tLogRow_1[16] = String
																		.valueOf(HealthPlanID_Output.LNPCBlockingKey);

															} //

															if (HealthPlanID_Output.NYSIISFNLNBlockingKey != null) { //
																row_tLogRow_1[17] = String.valueOf(
																		HealthPlanID_Output.NYSIISFNLNBlockingKey);

															} //

															if (HealthPlanID_Output.DOBPCBlockingKey != null) { //
																row_tLogRow_1[18] = String
																		.valueOf(HealthPlanID_Output.DOBPCBlockingKey);

															} //

															if (HealthPlanID_Output.MRNBlockingKey != null) { //
																row_tLogRow_1[19] = String
																		.valueOf(HealthPlanID_Output.MRNBlockingKey);

															} //

															if (HealthPlanID_Output.HealthPlanIDBlockingKey != null) { //
																row_tLogRow_1[20] = String.valueOf(
																		HealthPlanID_Output.HealthPlanIDBlockingKey);

															} //

															util_tLogRow_1.addRow(row_tLogRow_1);
															nb_line_tLogRow_1++;
															log.info("tLogRow_1 - Content of row " + nb_line_tLogRow_1
																	+ ": "
																	+ TalendString.unionString("|", row_tLogRow_1));
//////

//////                    

///////////////////////    			

															row1 = HealthPlanID_Output;

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
															 * [tDBOutput_1 main ] start
															 */

															s(currentComponent = "tDBOutput_1");

															cLabel = "MYSQCHIA";

															if (runStat.update(execStat, enableLogStash, iterateId, 1, 1

																	, "row1", "tLogRow_1", "<b>Console</b>", "tLogRow",
																	"tDBOutput_1", "MYSQCHIA", "tMysqlOutput"

															)) {
																talendJobLogProcess(globalMap);
															}

															if (log.isTraceEnabled()) {
																log.trace("row1 - "
																		+ (row1 == null ? "" : row1.toLogString()));
															}

															whetherReject_tDBOutput_1 = false;
															if (row1.FirstName == null) {
																pstmt_tDBOutput_1.setNull(1, java.sql.Types.VARCHAR);
															} else {
																pstmt_tDBOutput_1.setString(1, row1.FirstName);
															}

															if (row1.LastName == null) {
																pstmt_tDBOutput_1.setNull(2, java.sql.Types.VARCHAR);
															} else {
																pstmt_tDBOutput_1.setString(2, row1.LastName);
															}

															if (row1.Gender == null) {
																pstmt_tDBOutput_1.setNull(3, java.sql.Types.VARCHAR);
															} else {
																pstmt_tDBOutput_1.setString(3, row1.Gender);
															}

															if (row1.PatientAddress == null) {
																pstmt_tDBOutput_1.setNull(4, java.sql.Types.VARCHAR);
															} else {
																pstmt_tDBOutput_1.setString(4, row1.PatientAddress);
															}

															if (row1.City == null) {
																pstmt_tDBOutput_1.setNull(5, java.sql.Types.VARCHAR);
															} else {
																pstmt_tDBOutput_1.setString(5, row1.City);
															}

															if (row1.State == null) {
																pstmt_tDBOutput_1.setNull(6, java.sql.Types.VARCHAR);
															} else {
																pstmt_tDBOutput_1.setString(6, row1.State);
															}

															if (row1.PostalCode == null) {
																pstmt_tDBOutput_1.setNull(7, java.sql.Types.INTEGER);
															} else {
																pstmt_tDBOutput_1.setInt(7, row1.PostalCode);
															}

															if (row1.Birthday != null) {
																date_tDBOutput_1 = row1.Birthday.getTime();
																if (date_tDBOutput_1 < year1_tDBOutput_1
																		|| date_tDBOutput_1 >= year10000_tDBOutput_1) {
																	pstmt_tDBOutput_1.setString(8,
																			"0000-00-00 00:00:00");
																} else {
																	pstmt_tDBOutput_1.setTimestamp(8,
																			new java.sql.Timestamp(date_tDBOutput_1));
																}
															} else {
																pstmt_tDBOutput_1.setNull(8, java.sql.Types.DATE);
															}

															if (row1.SSN == null) {
																pstmt_tDBOutput_1.setNull(9, java.sql.Types.VARCHAR);
															} else {
																pstmt_tDBOutput_1.setString(9, row1.SSN);
															}

															if (row1.HPLNID == null) {
																pstmt_tDBOutput_1.setNull(10, java.sql.Types.INTEGER);
															} else {
																pstmt_tDBOutput_1.setInt(10, row1.HPLNID);
															}

															if (row1.NYSIISFirstName == null) {
																pstmt_tDBOutput_1.setNull(11, java.sql.Types.VARCHAR);
															} else {
																pstmt_tDBOutput_1.setString(11, row1.NYSIISFirstName);
															}

															if (row1.NYSIISLastName == null) {
																pstmt_tDBOutput_1.setNull(12, java.sql.Types.VARCHAR);
															} else {
																pstmt_tDBOutput_1.setString(12, row1.NYSIISLastName);
															}

															if (row1.HealthPlanID == null) {
																pstmt_tDBOutput_1.setNull(13, java.sql.Types.VARCHAR);
															} else {
																pstmt_tDBOutput_1.setString(13, row1.HealthPlanID);
															}

															if (row1.MRN == null) {
																pstmt_tDBOutput_1.setNull(14, java.sql.Types.INTEGER);
															} else {
																pstmt_tDBOutput_1.setInt(14, row1.MRN);
															}

															if (row1.SSNBlockingKey == null) {
																pstmt_tDBOutput_1.setNull(15, java.sql.Types.VARCHAR);
															} else {
																pstmt_tDBOutput_1.setString(15, row1.SSNBlockingKey);
															}

															if (row1.FNDOBBlockingKey == null) {
																pstmt_tDBOutput_1.setNull(16, java.sql.Types.VARCHAR);
															} else {
																pstmt_tDBOutput_1.setString(16, row1.FNDOBBlockingKey);
															}

															if (row1.LNPCBlockingKey == null) {
																pstmt_tDBOutput_1.setNull(17, java.sql.Types.VARCHAR);
															} else {
																pstmt_tDBOutput_1.setString(17, row1.LNPCBlockingKey);
															}

															if (row1.NYSIISFNLNBlockingKey == null) {
																pstmt_tDBOutput_1.setNull(18, java.sql.Types.VARCHAR);
															} else {
																pstmt_tDBOutput_1.setString(18,
																		row1.NYSIISFNLNBlockingKey);
															}

															if (row1.DOBPCBlockingKey == null) {
																pstmt_tDBOutput_1.setNull(19, java.sql.Types.VARCHAR);
															} else {
																pstmt_tDBOutput_1.setString(19, row1.DOBPCBlockingKey);
															}

															if (row1.MRNBlockingKey == null) {
																pstmt_tDBOutput_1.setNull(20, java.sql.Types.VARCHAR);
															} else {
																pstmt_tDBOutput_1.setString(20, row1.MRNBlockingKey);
															}

															if (row1.HealthPlanIDBlockingKey == null) {
																pstmt_tDBOutput_1.setNull(21, java.sql.Types.VARCHAR);
															} else {
																pstmt_tDBOutput_1.setString(21,
																		row1.HealthPlanIDBlockingKey);
															}

															pstmt_tDBOutput_1.addBatch();
															nb_line_tDBOutput_1++;

															if (log.isDebugEnabled())
																log.debug("tDBOutput_1 - " + ("Adding the record ")
																		+ (nb_line_tDBOutput_1) + (" to the ")
																		+ ("INSERT") + (" batch."));
															batchSizeCounter_tDBOutput_1++;
															if (batchSize_tDBOutput_1 <= batchSizeCounter_tDBOutput_1) {
																try {
																	int countSum_tDBOutput_1 = 0;
																	if (log.isDebugEnabled())
																		log.debug("tDBOutput_1 - " + ("Executing the ")
																				+ ("INSERT") + (" batch."));
																	for (int countEach_tDBOutput_1 : pstmt_tDBOutput_1
																			.executeBatch()) {
																		countSum_tDBOutput_1 += (countEach_tDBOutput_1 == java.sql.Statement.EXECUTE_FAILED
																				? 0
																				: 1);
																	}
																	rowsToCommitCount_tDBOutput_1 += countSum_tDBOutput_1;
																	if (log.isDebugEnabled())
																		log.debug("tDBOutput_1 - " + ("The ")
																				+ ("INSERT")
																				+ (" batch execution has succeeded."));
																	insertedCount_tDBOutput_1 += countSum_tDBOutput_1;
																} catch (java.sql.BatchUpdateException e) {
																	globalMap.put("tDBOutput_1_ERROR_MESSAGE",
																			e.getMessage());
																	int countSum_tDBOutput_1 = 0;
																	for (int countEach_tDBOutput_1 : e
																			.getUpdateCounts()) {
																		countSum_tDBOutput_1 += (countEach_tDBOutput_1 < 0
																				? 0
																				: countEach_tDBOutput_1);
																	}
																	rowsToCommitCount_tDBOutput_1 += countSum_tDBOutput_1;
																	insertedCount_tDBOutput_1 += countSum_tDBOutput_1;
																	System.err.println(e.getMessage());
																	log.error("tDBOutput_1 - " + (e.getMessage()));
																}

																batchSizeCounter_tDBOutput_1 = 0;
															}
															commitCounter_tDBOutput_1++;

															if (commitEvery_tDBOutput_1 <= commitCounter_tDBOutput_1) {

																try {
																	int countSum_tDBOutput_1 = 0;
																	if (log.isDebugEnabled())
																		log.debug("tDBOutput_1 - " + ("Executing the ")
																				+ ("INSERT") + (" batch."));
																	for (int countEach_tDBOutput_1 : pstmt_tDBOutput_1
																			.executeBatch()) {
																		countSum_tDBOutput_1 += (countEach_tDBOutput_1 < 0
																				? 0
																				: 1);
																	}
																	rowsToCommitCount_tDBOutput_1 += countSum_tDBOutput_1;
																	if (log.isDebugEnabled())
																		log.debug("tDBOutput_1 - " + ("The ")
																				+ ("INSERT")
																				+ (" batch execution has succeeded."));
																	insertedCount_tDBOutput_1 += countSum_tDBOutput_1;
																} catch (java.sql.BatchUpdateException e) {
																	globalMap.put("tDBOutput_1_ERROR_MESSAGE",
																			e.getMessage());
																	int countSum_tDBOutput_1 = 0;
																	for (int countEach_tDBOutput_1 : e
																			.getUpdateCounts()) {
																		countSum_tDBOutput_1 += (countEach_tDBOutput_1 < 0
																				? 0
																				: countEach_tDBOutput_1);
																	}
																	rowsToCommitCount_tDBOutput_1 += countSum_tDBOutput_1;
																	insertedCount_tDBOutput_1 += countSum_tDBOutput_1;
																	System.err.println(e.getMessage());
																	log.error("tDBOutput_1 - " + (e.getMessage()));

																}
																if (rowsToCommitCount_tDBOutput_1 != 0) {
																	if (log.isDebugEnabled())
																		log.debug("tDBOutput_1 - "
																				+ ("Connection starting to commit ")
																				+ (rowsToCommitCount_tDBOutput_1)
																				+ (" record(s)."));
																}
																conn_tDBOutput_1.commit();
																if (rowsToCommitCount_tDBOutput_1 != 0) {
																	if (log.isDebugEnabled())
																		log.debug("tDBOutput_1 - "
																				+ ("Connection commit has succeeded."));
																	rowsToCommitCount_tDBOutput_1 = 0;
																}
																commitCounter_tDBOutput_1 = 0;
															}

															tos_count_tDBOutput_1++;

															/**
															 * [tDBOutput_1 main ] stop
															 */

															/**
															 * [tDBOutput_1 process_data_begin ] start
															 */

															s(currentComponent = "tDBOutput_1");

															cLabel = "MYSQCHIA";

															/**
															 * [tDBOutput_1 process_data_begin ] stop
															 */

															/**
															 * [tDBOutput_1 process_data_end ] start
															 */

															s(currentComponent = "tDBOutput_1");

															cLabel = "MYSQCHIA";

															/**
															 * [tDBOutput_1 process_data_end ] stop
															 */

															/**
															 * [tLogRow_1 process_data_end ] start
															 */

															s(currentComponent = "tLogRow_1");

															cLabel = "<b>Console</b>";

															/**
															 * [tLogRow_1 process_data_end ] stop
															 */

														} // End of branch "HealthPlanID_Output"

														/**
														 * [tMap_7 process_data_end ] start
														 */

														s(currentComponent = "tMap_7");

														cLabel = "<b>Mapping 7</b>";

														/**
														 * [tMap_7 process_data_end ] stop
														 */

														/**
														 * [tGenKey_7 process_data_end ] start
														 */

														s(currentComponent = "tGenKey_7");

														cLabel = "<b>Blocking Key 7</b>";

														/**
														 * [tGenKey_7 process_data_end ] stop
														 */

													} // End of branch "MRN_Output"

													/**
													 * [tMap_6 process_data_end ] start
													 */

													s(currentComponent = "tMap_6");

													cLabel = "<b>Mapping 6</b>";

													/**
													 * [tMap_6 process_data_end ] stop
													 */

													/**
													 * [tGenKey_6 process_data_end ] start
													 */

													s(currentComponent = "tGenKey_6");

													cLabel = "<b>Blocking Key 6</b>";

													/**
													 * [tGenKey_6 process_data_end ] stop
													 */

												} // End of branch "DOBPC_Output"

												/**
												 * [tMap_5 process_data_end ] start
												 */

												s(currentComponent = "tMap_5");

												cLabel = "<b>Mapping 5</b>";

												/**
												 * [tMap_5 process_data_end ] stop
												 */

												/**
												 * [tGenKey_5 process_data_end ] start
												 */

												s(currentComponent = "tGenKey_5");

												cLabel = "<b>Blocking Key 5</b>";

												/**
												 * [tGenKey_5 process_data_end ] stop
												 */

											} // End of branch "NYSIISFNLN_Output"

											/**
											 * [tMap_4 process_data_end ] start
											 */

											s(currentComponent = "tMap_4");

											cLabel = "<b>Mapping Key 4</b>";

											/**
											 * [tMap_4 process_data_end ] stop
											 */

											/**
											 * [tGenKey_4 process_data_end ] start
											 */

											s(currentComponent = "tGenKey_4");

											cLabel = "<b>Blocking Key 4</b>";

											/**
											 * [tGenKey_4 process_data_end ] stop
											 */

										} // End of branch "LNPC_Output"

										/**
										 * [tMap_3 process_data_end ] start
										 */

										s(currentComponent = "tMap_3");

										cLabel = "<b>Mapping 3</b>";

										/**
										 * [tMap_3 process_data_end ] stop
										 */

										/**
										 * [tGenKey_3 process_data_end ] start
										 */

										s(currentComponent = "tGenKey_3");

										cLabel = "<b>Blocking Key 3</b>";

										/**
										 * [tGenKey_3 process_data_end ] stop
										 */

									} // End of branch "FNDOB_Output"

									/**
									 * [tMap_2 process_data_end ] start
									 */

									s(currentComponent = "tMap_2");

									cLabel = "<b>Mapping 2</b>";

									/**
									 * [tMap_2 process_data_end ] stop
									 */

									/**
									 * [tGenKey_2 process_data_end ] start
									 */

									s(currentComponent = "tGenKey_2");

									cLabel = "<b>Blocking Key 2</b>";

									/**
									 * [tGenKey_2 process_data_end ] stop
									 */

								} // End of branch "SSN_Output"

								/**
								 * [tMap_1 process_data_end ] start
								 */

								s(currentComponent = "tMap_1");

								cLabel = "<b>Mapping 1</b>";

								/**
								 * [tMap_1 process_data_end ] stop
								 */

								/**
								 * [tGenKey_1 process_data_end ] start
								 */

								s(currentComponent = "tGenKey_1");

								cLabel = "<b>Blocking Key 1</b>";

								/**
								 * [tGenKey_1 process_data_end ] stop
								 */

							} // End of branch "CHIA"

							/**
							 * [tFileInputExcel_1 process_data_end ] start
							 */

							s(currentComponent = "tFileInputExcel_1");

							cLabel = "<b>Reading xlsx</b>";

							/**
							 * [tFileInputExcel_1 process_data_end ] stop
							 */

							/**
							 * [tFileInputExcel_1 end ] start
							 */

							s(currentComponent = "tFileInputExcel_1");

							cLabel = "<b>Reading xlsx</b>";

						}

						log.debug("tFileInputExcel_1 - Retrieved records count: " + nb_line_tFileInputExcel_1 + " .");

					}

					globalMap.put("tFileInputExcel_1_NB_LINE", nb_line_tFileInputExcel_1);
				} finally {

					if (!(source_tFileInputExcel_1 instanceof java.io.InputStream)) {
						workbook_tFileInputExcel_1.getPackage().revert();
					}

				}

				if (log.isDebugEnabled())
					log.debug("tFileInputExcel_1 - " + ("Done."));

				ok_Hash.put("tFileInputExcel_1", true);
				end_Hash.put("tFileInputExcel_1", System.currentTimeMillis());

				/**
				 * [tFileInputExcel_1 end ] stop
				 */

				/**
				 * [tGenKey_1 end ] start
				 */

				s(currentComponent = "tGenKey_1");

				cLabel = "<b>Blocking Key 1</b>";

				if (runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, "CHIA", 2, 0,
						"tFileInputExcel_1", "<b>Reading xlsx</b>", "tFileInputExcel", "tGenKey_1",
						"<b>Blocking Key 1</b>", "tGenKey", "output")) {
					talendJobLogProcess(globalMap);
				}

				if (log.isDebugEnabled())
					log.debug("tGenKey_1 - " + ("Done."));

				ok_Hash.put("tGenKey_1", true);
				end_Hash.put("tGenKey_1", System.currentTimeMillis());

				/**
				 * [tGenKey_1 end ] stop
				 */

				/**
				 * [tMap_1 end ] start
				 */

				s(currentComponent = "tMap_1");

				cLabel = "<b>Mapping 1</b>";

// ###############################
// # Lookup hashes releasing
// ###############################      
				log.debug("tMap_1 - Written records count in the table 'SSN_Output': " + count_SSN_Output_tMap_1 + ".");

				if (runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, "SSN", 2, 0, "tGenKey_1",
						"<b>Blocking Key 1</b>", "tGenKey", "tMap_1", "<b>Mapping 1</b>", "tMap", "output")) {
					talendJobLogProcess(globalMap);
				}

				if (log.isDebugEnabled())
					log.debug("tMap_1 - " + ("Done."));

				ok_Hash.put("tMap_1", true);
				end_Hash.put("tMap_1", System.currentTimeMillis());

				/**
				 * [tMap_1 end ] stop
				 */

				/**
				 * [tGenKey_2 end ] start
				 */

				s(currentComponent = "tGenKey_2");

				cLabel = "<b>Blocking Key 2</b>";

				if (runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, "SSN_Output", 2, 0,
						"tMap_1", "<b>Mapping 1</b>", "tMap", "tGenKey_2", "<b>Blocking Key 2</b>", "tGenKey",
						"output")) {
					talendJobLogProcess(globalMap);
				}

				if (log.isDebugEnabled())
					log.debug("tGenKey_2 - " + ("Done."));

				ok_Hash.put("tGenKey_2", true);
				end_Hash.put("tGenKey_2", System.currentTimeMillis());

				/**
				 * [tGenKey_2 end ] stop
				 */

				/**
				 * [tMap_2 end ] start
				 */

				s(currentComponent = "tMap_2");

				cLabel = "<b>Mapping 2</b>";

// ###############################
// # Lookup hashes releasing
// ###############################      
				log.debug("tMap_2 - Written records count in the table 'FNDOB_Output': " + count_FNDOB_Output_tMap_2
						+ ".");

				if (runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, "FNDOB", 2, 0,
						"tGenKey_2", "<b>Blocking Key 2</b>", "tGenKey", "tMap_2", "<b>Mapping 2</b>", "tMap",
						"output")) {
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
				 * [tGenKey_3 end ] start
				 */

				s(currentComponent = "tGenKey_3");

				cLabel = "<b>Blocking Key 3</b>";

				if (runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, "FNDOB_Output", 2, 0,
						"tMap_2", "<b>Mapping 2</b>", "tMap", "tGenKey_3", "<b>Blocking Key 3</b>", "tGenKey",
						"output")) {
					talendJobLogProcess(globalMap);
				}

				if (log.isDebugEnabled())
					log.debug("tGenKey_3 - " + ("Done."));

				ok_Hash.put("tGenKey_3", true);
				end_Hash.put("tGenKey_3", System.currentTimeMillis());

				/**
				 * [tGenKey_3 end ] stop
				 */

				/**
				 * [tMap_3 end ] start
				 */

				s(currentComponent = "tMap_3");

				cLabel = "<b>Mapping 3</b>";

// ###############################
// # Lookup hashes releasing
// ###############################      
				log.debug(
						"tMap_3 - Written records count in the table 'LNPC_Output': " + count_LNPC_Output_tMap_3 + ".");

				if (runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, "LNPC", 2, 0,
						"tGenKey_3", "<b>Blocking Key 3</b>", "tGenKey", "tMap_3", "<b>Mapping 3</b>", "tMap",
						"output")) {
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
				 * [tGenKey_4 end ] start
				 */

				s(currentComponent = "tGenKey_4");

				cLabel = "<b>Blocking Key 4</b>";

				if (runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, "LNPC_Output", 2, 0,
						"tMap_3", "<b>Mapping 3</b>", "tMap", "tGenKey_4", "<b>Blocking Key 4</b>", "tGenKey",
						"output")) {
					talendJobLogProcess(globalMap);
				}

				if (log.isDebugEnabled())
					log.debug("tGenKey_4 - " + ("Done."));

				ok_Hash.put("tGenKey_4", true);
				end_Hash.put("tGenKey_4", System.currentTimeMillis());

				/**
				 * [tGenKey_4 end ] stop
				 */

				/**
				 * [tMap_4 end ] start
				 */

				s(currentComponent = "tMap_4");

				cLabel = "<b>Mapping Key 4</b>";

// ###############################
// # Lookup hashes releasing
// ###############################      
				log.debug("tMap_4 - Written records count in the table 'NYSIISFNLN_Output': "
						+ count_NYSIISFNLN_Output_tMap_4 + ".");

				if (runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, "NYSIISFNLN", 2, 0,
						"tGenKey_4", "<b>Blocking Key 4</b>", "tGenKey", "tMap_4", "<b>Mapping Key 4</b>", "tMap",
						"output")) {
					talendJobLogProcess(globalMap);
				}

				if (log.isDebugEnabled())
					log.debug("tMap_4 - " + ("Done."));

				ok_Hash.put("tMap_4", true);
				end_Hash.put("tMap_4", System.currentTimeMillis());

				/**
				 * [tMap_4 end ] stop
				 */

				/**
				 * [tGenKey_5 end ] start
				 */

				s(currentComponent = "tGenKey_5");

				cLabel = "<b>Blocking Key 5</b>";

				if (runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, "NYSIISFNLN_Output", 2,
						0, "tMap_4", "<b>Mapping Key 4</b>", "tMap", "tGenKey_5", "<b>Blocking Key 5</b>", "tGenKey",
						"output")) {
					talendJobLogProcess(globalMap);
				}

				if (log.isDebugEnabled())
					log.debug("tGenKey_5 - " + ("Done."));

				ok_Hash.put("tGenKey_5", true);
				end_Hash.put("tGenKey_5", System.currentTimeMillis());

				/**
				 * [tGenKey_5 end ] stop
				 */

				/**
				 * [tMap_5 end ] start
				 */

				s(currentComponent = "tMap_5");

				cLabel = "<b>Mapping 5</b>";

// ###############################
// # Lookup hashes releasing
// ###############################      
				log.debug("tMap_5 - Written records count in the table 'DOBPC_Output': " + count_DOBPC_Output_tMap_5
						+ ".");

				if (runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, "DOBPC", 2, 0,
						"tGenKey_5", "<b>Blocking Key 5</b>", "tGenKey", "tMap_5", "<b>Mapping 5</b>", "tMap",
						"output")) {
					talendJobLogProcess(globalMap);
				}

				if (log.isDebugEnabled())
					log.debug("tMap_5 - " + ("Done."));

				ok_Hash.put("tMap_5", true);
				end_Hash.put("tMap_5", System.currentTimeMillis());

				/**
				 * [tMap_5 end ] stop
				 */

				/**
				 * [tGenKey_6 end ] start
				 */

				s(currentComponent = "tGenKey_6");

				cLabel = "<b>Blocking Key 6</b>";

				if (runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, "DOBPC_Output", 2, 0,
						"tMap_5", "<b>Mapping 5</b>", "tMap", "tGenKey_6", "<b>Blocking Key 6</b>", "tGenKey",
						"output")) {
					talendJobLogProcess(globalMap);
				}

				if (log.isDebugEnabled())
					log.debug("tGenKey_6 - " + ("Done."));

				ok_Hash.put("tGenKey_6", true);
				end_Hash.put("tGenKey_6", System.currentTimeMillis());

				/**
				 * [tGenKey_6 end ] stop
				 */

				/**
				 * [tMap_6 end ] start
				 */

				s(currentComponent = "tMap_6");

				cLabel = "<b>Mapping 6</b>";

// ###############################
// # Lookup hashes releasing
// ###############################      
				log.debug("tMap_6 - Written records count in the table 'MRN_Output': " + count_MRN_Output_tMap_6 + ".");

				if (runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, "MRN", 2, 0, "tGenKey_6",
						"<b>Blocking Key 6</b>", "tGenKey", "tMap_6", "<b>Mapping 6</b>", "tMap", "output")) {
					talendJobLogProcess(globalMap);
				}

				if (log.isDebugEnabled())
					log.debug("tMap_6 - " + ("Done."));

				ok_Hash.put("tMap_6", true);
				end_Hash.put("tMap_6", System.currentTimeMillis());

				/**
				 * [tMap_6 end ] stop
				 */

				/**
				 * [tGenKey_7 end ] start
				 */

				s(currentComponent = "tGenKey_7");

				cLabel = "<b>Blocking Key 7</b>";

				if (runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, "MRN_Output", 2, 0,
						"tMap_6", "<b>Mapping 6</b>", "tMap", "tGenKey_7", "<b>Blocking Key 7</b>", "tGenKey",
						"output")) {
					talendJobLogProcess(globalMap);
				}

				if (log.isDebugEnabled())
					log.debug("tGenKey_7 - " + ("Done."));

				ok_Hash.put("tGenKey_7", true);
				end_Hash.put("tGenKey_7", System.currentTimeMillis());

				/**
				 * [tGenKey_7 end ] stop
				 */

				/**
				 * [tMap_7 end ] start
				 */

				s(currentComponent = "tMap_7");

				cLabel = "<b>Mapping 7</b>";

// ###############################
// # Lookup hashes releasing
// ###############################      
				log.debug("tMap_7 - Written records count in the table 'HealthPlanID_Output': "
						+ count_HealthPlanID_Output_tMap_7 + ".");

				if (runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, "HealthPlanID", 2, 0,
						"tGenKey_7", "<b>Blocking Key 7</b>", "tGenKey", "tMap_7", "<b>Mapping 7</b>", "tMap",
						"output")) {
					talendJobLogProcess(globalMap);
				}

				if (log.isDebugEnabled())
					log.debug("tMap_7 - " + ("Done."));

				ok_Hash.put("tMap_7", true);
				end_Hash.put("tMap_7", System.currentTimeMillis());

				/**
				 * [tMap_7 end ] stop
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

				if (runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, "HealthPlanID_Output", 2,
						0, "tMap_7", "<b>Mapping 7</b>", "tMap", "tLogRow_1", "<b>Console</b>", "tLogRow", "output")) {
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
				 * [tDBOutput_1 end ] start
				 */

				s(currentComponent = "tDBOutput_1");

				cLabel = "MYSQCHIA";

				try {
					if (batchSizeCounter_tDBOutput_1 != 0) {
						int countSum_tDBOutput_1 = 0;

						if (log.isDebugEnabled())
							log.debug("tDBOutput_1 - " + ("Executing the ") + ("INSERT") + (" batch."));
						for (int countEach_tDBOutput_1 : pstmt_tDBOutput_1.executeBatch()) {
							countSum_tDBOutput_1 += (countEach_tDBOutput_1 == java.sql.Statement.EXECUTE_FAILED ? 0
									: 1);
						}
						rowsToCommitCount_tDBOutput_1 += countSum_tDBOutput_1;

						if (log.isDebugEnabled())
							log.debug("tDBOutput_1 - " + ("The ") + ("INSERT") + (" batch execution has succeeded."));

						insertedCount_tDBOutput_1 += countSum_tDBOutput_1;

					}
				} catch (java.sql.BatchUpdateException e) {
					globalMap.put(currentComponent + "_ERROR_MESSAGE", e.getMessage());

					int countSum_tDBOutput_1 = 0;
					for (int countEach_tDBOutput_1 : e.getUpdateCounts()) {
						countSum_tDBOutput_1 += (countEach_tDBOutput_1 < 0 ? 0 : countEach_tDBOutput_1);
					}
					rowsToCommitCount_tDBOutput_1 += countSum_tDBOutput_1;

					insertedCount_tDBOutput_1 += countSum_tDBOutput_1;

					log.error("tDBOutput_1 - " + (e.getMessage()));
					System.err.println(e.getMessage());

				}
				batchSizeCounter_tDBOutput_1 = 0;

				if (pstmt_tDBOutput_1 != null) {

					pstmt_tDBOutput_1.close();
					resourceMap.remove("pstmt_tDBOutput_1");

				}

				resourceMap.put("statementClosed_tDBOutput_1", true);

				if (commitCounter_tDBOutput_1 > 0 && rowsToCommitCount_tDBOutput_1 != 0) {

					if (log.isDebugEnabled())
						log.debug("tDBOutput_1 - " + ("Connection starting to commit ")
								+ (rowsToCommitCount_tDBOutput_1) + (" record(s)."));
				}
				conn_tDBOutput_1.commit();
				if (commitCounter_tDBOutput_1 > 0 && rowsToCommitCount_tDBOutput_1 != 0) {

					if (log.isDebugEnabled())
						log.debug("tDBOutput_1 - " + ("Connection commit has succeeded."));
					rowsToCommitCount_tDBOutput_1 = 0;
				}
				commitCounter_tDBOutput_1 = 0;

				if (log.isDebugEnabled())
					log.debug("tDBOutput_1 - " + ("Closing the connection to the database."));
				conn_tDBOutput_1.close();

				if (log.isDebugEnabled())
					log.debug("tDBOutput_1 - " + ("Connection to the database has closed."));
				resourceMap.put("finish_tDBOutput_1", true);

				nb_line_deleted_tDBOutput_1 = nb_line_deleted_tDBOutput_1 + deletedCount_tDBOutput_1;
				nb_line_update_tDBOutput_1 = nb_line_update_tDBOutput_1 + updatedCount_tDBOutput_1;
				nb_line_inserted_tDBOutput_1 = nb_line_inserted_tDBOutput_1 + insertedCount_tDBOutput_1;
				nb_line_rejected_tDBOutput_1 = nb_line_rejected_tDBOutput_1 + rejectedCount_tDBOutput_1;

				globalMap.put("tDBOutput_1_NB_LINE", nb_line_tDBOutput_1);
				globalMap.put("tDBOutput_1_NB_LINE_UPDATED", nb_line_update_tDBOutput_1);
				globalMap.put("tDBOutput_1_NB_LINE_INSERTED", nb_line_inserted_tDBOutput_1);
				globalMap.put("tDBOutput_1_NB_LINE_DELETED", nb_line_deleted_tDBOutput_1);
				globalMap.put("tDBOutput_1_NB_LINE_REJECTED", nb_line_rejected_tDBOutput_1);

				if (log.isDebugEnabled())
					log.debug("tDBOutput_1 - " + ("Has ") + ("inserted") + (" ") + (nb_line_inserted_tDBOutput_1)
							+ (" record(s)."));

				if (runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, "row1", 2, 0,
						"tLogRow_1", "<b>Console</b>", "tLogRow", "tDBOutput_1", "MYSQCHIA", "tMysqlOutput",
						"output")) {
					talendJobLogProcess(globalMap);
				}

				if (log.isDebugEnabled())
					log.debug("tDBOutput_1 - " + ("Done."));

				ok_Hash.put("tDBOutput_1", true);
				end_Hash.put("tDBOutput_1", System.currentTimeMillis());

				/**
				 * [tDBOutput_1 end ] stop
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
				 * [tFileInputExcel_1 finally ] start
				 */

				s(currentComponent = "tFileInputExcel_1");

				cLabel = "<b>Reading xlsx</b>";

				/**
				 * [tFileInputExcel_1 finally ] stop
				 */

				/**
				 * [tGenKey_1 finally ] start
				 */

				s(currentComponent = "tGenKey_1");

				cLabel = "<b>Blocking Key 1</b>";

				/**
				 * [tGenKey_1 finally ] stop
				 */

				/**
				 * [tMap_1 finally ] start
				 */

				s(currentComponent = "tMap_1");

				cLabel = "<b>Mapping 1</b>";

				/**
				 * [tMap_1 finally ] stop
				 */

				/**
				 * [tGenKey_2 finally ] start
				 */

				s(currentComponent = "tGenKey_2");

				cLabel = "<b>Blocking Key 2</b>";

				/**
				 * [tGenKey_2 finally ] stop
				 */

				/**
				 * [tMap_2 finally ] start
				 */

				s(currentComponent = "tMap_2");

				cLabel = "<b>Mapping 2</b>";

				/**
				 * [tMap_2 finally ] stop
				 */

				/**
				 * [tGenKey_3 finally ] start
				 */

				s(currentComponent = "tGenKey_3");

				cLabel = "<b>Blocking Key 3</b>";

				/**
				 * [tGenKey_3 finally ] stop
				 */

				/**
				 * [tMap_3 finally ] start
				 */

				s(currentComponent = "tMap_3");

				cLabel = "<b>Mapping 3</b>";

				/**
				 * [tMap_3 finally ] stop
				 */

				/**
				 * [tGenKey_4 finally ] start
				 */

				s(currentComponent = "tGenKey_4");

				cLabel = "<b>Blocking Key 4</b>";

				/**
				 * [tGenKey_4 finally ] stop
				 */

				/**
				 * [tMap_4 finally ] start
				 */

				s(currentComponent = "tMap_4");

				cLabel = "<b>Mapping Key 4</b>";

				/**
				 * [tMap_4 finally ] stop
				 */

				/**
				 * [tGenKey_5 finally ] start
				 */

				s(currentComponent = "tGenKey_5");

				cLabel = "<b>Blocking Key 5</b>";

				/**
				 * [tGenKey_5 finally ] stop
				 */

				/**
				 * [tMap_5 finally ] start
				 */

				s(currentComponent = "tMap_5");

				cLabel = "<b>Mapping 5</b>";

				/**
				 * [tMap_5 finally ] stop
				 */

				/**
				 * [tGenKey_6 finally ] start
				 */

				s(currentComponent = "tGenKey_6");

				cLabel = "<b>Blocking Key 6</b>";

				/**
				 * [tGenKey_6 finally ] stop
				 */

				/**
				 * [tMap_6 finally ] start
				 */

				s(currentComponent = "tMap_6");

				cLabel = "<b>Mapping 6</b>";

				/**
				 * [tMap_6 finally ] stop
				 */

				/**
				 * [tGenKey_7 finally ] start
				 */

				s(currentComponent = "tGenKey_7");

				cLabel = "<b>Blocking Key 7</b>";

				/**
				 * [tGenKey_7 finally ] stop
				 */

				/**
				 * [tMap_7 finally ] start
				 */

				s(currentComponent = "tMap_7");

				cLabel = "<b>Mapping 7</b>";

				/**
				 * [tMap_7 finally ] stop
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
				 * [tDBOutput_1 finally ] start
				 */

				s(currentComponent = "tDBOutput_1");

				cLabel = "MYSQCHIA";

				try {
					if (resourceMap.get("statementClosed_tDBOutput_1") == null) {
						java.sql.PreparedStatement pstmtToClose_tDBOutput_1 = null;
						if ((pstmtToClose_tDBOutput_1 = (java.sql.PreparedStatement) resourceMap
								.remove("pstmt_tDBOutput_1")) != null) {
							pstmtToClose_tDBOutput_1.close();
						}
					}
				} finally {
					if (resourceMap.get("finish_tDBOutput_1") == null) {
						java.sql.Connection ctn_tDBOutput_1 = null;
						if ((ctn_tDBOutput_1 = (java.sql.Connection) resourceMap.get("conn_tDBOutput_1")) != null) {
							try {
								if (log.isDebugEnabled())
									log.debug("tDBOutput_1 - " + ("Closing the connection to the database."));
								ctn_tDBOutput_1.close();
								if (log.isDebugEnabled())
									log.debug("tDBOutput_1 - " + ("Connection to the database has closed."));
							} catch (java.sql.SQLException sqlEx_tDBOutput_1) {
								String errorMessage_tDBOutput_1 = "failed to close the connection in tDBOutput_1 :"
										+ sqlEx_tDBOutput_1.getMessage();
								log.error("tDBOutput_1 - " + (errorMessage_tDBOutput_1));
								System.err.println(errorMessage_tDBOutput_1);
							}
						}
					}
				}

				/**
				 * [tDBOutput_1 finally ] stop
				 */

			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tFileInputExcel_1_SUBPROCESS_STATE", 1);
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
		final CHIA_Generating_Blocking_Keys_1 CHIA_Generating_Blocking_Keys_1Class = new CHIA_Generating_Blocking_Keys_1();

		int exitCode = CHIA_Generating_Blocking_Keys_1Class.runJobInTOS(args);
		if (exitCode == 0) {
			log.info("TalendJob: 'CHIA_Generating_Blocking_Keys_1' - Done.");
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
		log.info("TalendJob: 'CHIA_Generating_Blocking_Keys_1' - Start.");

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
		org.slf4j.MDC.put("_jobRepositoryId", "_vgqFgLx5Ee-ILekM8jCPpA");
		org.slf4j.MDC.put("_compiledAtTimestamp", "2025-07-20T22:48:25.252766300Z");

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
			java.io.InputStream inContext = CHIA_Generating_Blocking_Keys_1.class.getClassLoader().getResourceAsStream(
					"talendclouddemobank/chia_generating_blocking_keys_1_0_1/contexts/" + contextStr + ".properties");
			if (inContext == null) {
				inContext = CHIA_Generating_Blocking_Keys_1.class.getClassLoader()
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
		}

		// Resume: init the resumeUtil
		resumeEntryMethodName = ResumeUtil.getResumeEntryMethodName(resuming_checkpoint_path);
		resumeUtil = new ResumeUtil(resuming_logs_dir_path, isChildJob, rootPid);
		resumeUtil.initCommonInfo(pid, rootPid, fatherPid, projectName, jobName, contextStr, jobVersion);

		List<String> parametersToEncrypt = new java.util.ArrayList<String>();
		// Resume: jobStart
		resumeUtil.addLog("JOB_STARTED", "JOB:" + jobName, parent_part_launcher, Thread.currentThread().getId() + "",
				"", "", "", "", resumeUtil.convertToJsonText(context, ContextProperties.class, parametersToEncrypt));

		org.slf4j.MDC.put("_context", contextStr);
		log.info("TalendJob: 'CHIA_Generating_Blocking_Keys_1' - Started.");
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
			tFileInputExcel_1Process(globalMap);
			if (!"failure".equals(status)) {
				status = "end";
			}
		} catch (TalendException e_tFileInputExcel_1) {
			globalMap.put("tFileInputExcel_1_SUBPROCESS_STATE", -1);

			e_tFileInputExcel_1.printStackTrace();

		}

		this.globalResumeTicket = true;// to run tPostJob

		end = System.currentTimeMillis();

		if (watch) {
			System.out.println((end - startTime) + " milliseconds");
		}

		endUsedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
		if (false) {
			System.out.println((endUsedMemory - startUsedMemory)
					+ " bytes memory increase when running : CHIA_Generating_Blocking_Keys_1");
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
		log.info("TalendJob: 'CHIA_Generating_Blocking_Keys_1' - Finished - status: " + status + " returnCode: "
				+ returnCode);

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
 * 682526 characters generated by Talend Cloud Data Fabric on the July 20, 2025
 * at 6:48:25 PM EDT
 ************************************************************************************************/