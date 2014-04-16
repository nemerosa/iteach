package net.nemerosa.iteach.dao.jdbc;

public interface SQL {

    String ACCOUNT_ID_BY_IDENTIFIER = "SELECT ID FROM ACCOUNT WHERE IDENTIFIER = :identifier";
    String ACCOUNT_ID_BY_EMAIL = "SELECT ID FROM ACCOUNT WHERE EMAIL = :email";
    String ACCOUNT_SUMMARY_BY_ID = "SELECT * FROM ACCOUNT WHERE ID = :id";
    String ACCOUNT_BY_ID = "SELECT * FROM ACCOUNT WHERE ID = :id";
    String ACCOUNT_ALL = "SELECT * FROM ACCOUNT ORDER BY NAME";
    String ACCOUNT_SUMMARY_BY_EMAIL = "SELECT * FROM ACCOUNT WHERE EMAIL = :email";
    String ACCOUNT_CREATE = "INSERT INTO ACCOUNT (ADMINISTRATOR, VERIFIED, MODE, IDENTIFIER, PASSWORD, EMAIL, NAME, DISABLED) VALUES (FALSE, FALSE, :mode, :identifier, :password, :email, :name, FALSE)";
    String ACCOUNT_SET_VERIFIED = "UPDATE ACCOUNT SET VERIFIED = TRUE WHERE ID = :id";
    String ACCOUNT_BY_PASSWORD = "SELECT * FROM ACCOUNT WHERE MODE = 'PASSWORD' AND IDENTIFIER = :identifier AND VERIFIED IS TRUE AND DISABLED IS FALSE";
    String ACCOUNT_BY_OPENID = "SELECT * FROM ACCOUNT WHERE MODE = 'OPEN_ID' AND IDENTIFIER = :identifier";
    String ACCOUNT_PASSWORD = "SELECT PASSWORD FROM ACCOUNT WHERE MODE = 'PASSWORD' AND ID = :id AND VERIFIED IS TRUE AND DISABLED IS FALSE";
    String ACCOUNT_DELETE = "DELETE FROM ACCOUNT WHERE ID = :id";
    String ACCOUNT_UPDATE_PROFILE = "UPDATE ACCOUNT SET COMPANY = :company, POSTALADDRESS = :postalAddress, PHONE = :phone, VAT = :vat, IBAN = :iban, BIC = :bic WHERE ID = :id";
    String ACCOUNT_CHANGE_EMAIL_ONLY = "UPDATE ACCOUNT SET EMAIL = :email WHERE ID = :id AND (MODE = 'OPEN_ID' OR IDENTIFIER = 'admin') ";
    String ACCOUNT_CHANGE_EMAIL_AND_IDENTIFIER = "UPDATE ACCOUNT SET EMAIL = :email, IDENTIFIER = :email WHERE ID = :id AND MODE = 'PASSWORD'";
    String ACCOUNT_CHANGE_PASSWORD = "UPDATE ACCOUNT SET PASSWORD = :encodedPassword WHERE ID = :id AND MODE = 'PASSWORD'";
    String ACCOUNT_DISABLE = "UPDATE ACCOUNT SET DISABLED = :disabled WHERE ID = :id";
    String ACCOUNT_SAVE_PROFILE_COMPANY_LOGO = "UPDATE ACCOUNT SET COMPANYLOGO_TYPE = :companyLogo_type, COMPANYLOGO_CONTENT = :companyLogo_content WHERE ID = :id";

    String TOKEN_SAVE = "INSERT INTO TOKEN (TOKEN, TOKENTYPE, TOKENKEY, CREATION) VALUES (:token, :tokentype, :tokenkey, :creation)";
    String TOKEN_BY_TOKEN_AND_TYPE = "SELECT * FROM TOKEN WHERE TOKEN = :token AND TOKENTYPE = :tokentype ORDER BY CREATION DESC LIMIT 1";
    String TOKEN_DELETE = "DELETE FROM TOKEN WHERE TOKENTYPE = :tokentype AND TOKENKEY = :tokenkey";

    String SCHOOL_ALL = "SELECT * FROM SCHOOL WHERE TEACHERID = :teacherId ORDER BY NAME";
    String SCHOOL_BY_ID = "SELECT * FROM SCHOOL WHERE TEACHERID = :teacherId AND ID = :schoolId";
    String SCHOOL_CREATE = "INSERT INTO SCHOOL (TEACHERID, NAME, CONTACT, COLOUR, EMAIL, HOURLYRATE, POSTALADDRESS, PHONE, MOBILEPHONE, WEBSITE, VAT, VATRATE) VALUES (:teacherId, :name, :contact, :colour, :email, :hourlyRate, :postalAddress, :phone, :mobilePhone, :webSite, :vat, :vatRate)";
    String SCHOOL_DELETE = "DELETE FROM SCHOOL WHERE TEACHERID = :teacherId AND ID = :id";
    String SCHOOL_UPDATE = "UPDATE SCHOOL SET NAME = :name, CONTACT = :contact, COLOUR = :colour, EMAIL = :email, HOURLYRATE = :hourlyRate, POSTALADDRESS = :postalAddress, PHONE = :phone, MOBILEPHONE = :mobilePhone, WEBSITE = :webSite, VAT = :vat, VATRATE = :vatRate WHERE TEACHERID = :teacherId AND ID = :schoolId";

    String STUDENT_CREATE = "INSERT INTO STUDENT (TEACHERID, SCHOOLID, DISABLED, NAME, SUBJECT, EMAIL, POSTALADDRESS, PHONE, MOBILEPHONE) VALUES (:teacherId, :schoolId, FALSE, :name, :subject, :email, :postalAddress, :phone, :mobilePhone)";
    String STUDENT_BY_ID = "SELECT * FROM STUDENT WHERE TEACHERID = :teacherId AND ID = :studentId";
    String STUDENT_ALL = "SELECT * FROM STUDENT WHERE TEACHERID = :teacherId ORDER BY NAME ASC";
    String STUDENT_BY_SCHOOL = "SELECT * FROM STUDENT WHERE TEACHERID = :teacherId AND SCHOOLID = :schoolId ORDER BY NAME ASC";
    String STUDENT_DISABLE = "UPDATE STUDENT SET DISABLED = :disabled WHERE TEACHERID = :teacherId AND ID = :id";
    String STUDENT_DELETE = "DELETE FROM STUDENT WHERE TEACHERID = :teacherId AND ID = :id";
    String STUDENT_UPDATE = "UPDATE STUDENT SET SCHOOLID = :schoolId, NAME = :name, SUBJECT = :subject, EMAIL = :email, POSTALADDRESS = :postalAddress, PHONE = :phone, MOBILEPHONE = :mobilePhone WHERE TEACHERID = :teacherId AND ID = :studentId";

    String LESSON_CREATE = "INSERT INTO LESSON (TEACHERID, STUDENTID, LOCATION, PLANNINGFROM, PLANNINGTO) VALUES (:teacherId, :studentId, :location, :planningFrom, :planningTo)";
    String LESSON_UPDATE = "UPDATE LESSON SET LOCATION = :location, PLANNINGFROM = :planningFrom, PLANNINGTO = :planningTo WHERE TEACHERID = :teacherId AND ID = :lessonId";
    String LESSON_BY_ID = "SELECT * FROM LESSON WHERE TEACHERID = :teacherId AND ID = :lessonId";
    String LESSON_DELETE = "DELETE FROM LESSON WHERE TEACHERID = :teacherId AND ID = :lessonId";

    String COMMENT_BY_ENTITY_ID = "SELECT * FROM COMMENT WHERE TEACHER = :teacherId AND %s = :entityId ORDER BY CREATION DESC";
    String COMMENT_BY_ID = "SELECT * FROM COMMENT WHERE TEACHER = :teacherId AND ID = :commentId";
    String COMMENT_POST = "INSERT INTO COMMENT (TEACHER, %s, CREATION, CONTENT) VALUES (:teacherId, :entityId, :creation, :content)";
    String COMMENT_IMPORT = "INSERT INTO COMMENT (TEACHER, %s, CREATION, EDITION, CONTENT) VALUES (:teacherId, :entityId, :creation, :edition, :content)";
    String COMMENT_DELETE = "DELETE FROM COMMENT WHERE TEACHER = :teacherId AND ID = :commentId";
    String COMMENT_UPDATE = "UPDATE COMMENT SET EDITION = :edition, CONTENT = :content WHERE TEACHER = :teacherId AND ID = :commentId";
    String COMMENT_COUNT = "SELECT COUNT(ID) FROM COMMENT WHERE TEACHER = :teacherId AND %s = :entityId";

    String INVOICE_DOWNLOAD = "SELECT DOCUMENTTYPE, DOCUMENT FROM INVOICE WHERE TEACHER = :teacherId AND ID = :invoiceId";
    String INVOICE_LAST_NB = "SELECT INVOICENB FROM INVOICE WHERE TEACHER = :teacherId ORDER BY INVOICENB DESC";
    String INVOICE_CREATE = "INSERT INTO INVOICE (TEACHER, STATUS, SCHOOL, YEAR, MONTH, GENERATION, INVOICENB, DOWNLOADED, DOCUMENTTYPE) " +
            "VALUES (:teacher, :status, :school, :year, :month, :generation, :invoiceNb, FALSE, :documentType)";
    String INVOICE_DOWNLOADED = "UPDATE INVOICE SET DOWNLOADED = TRUE WHERE TEACHER = :teacherId AND ID = :invoiceId";
    String INVOICE_STARTED = "UPDATE INVOICE SET STATUS = :status WHERE TEACHER = :teacherId AND ID = :invoiceId";
    String INVOICE_SAVE = "UPDATE INVOICE SET STATUS = :status, DOCUMENT = :document WHERE TEACHER = :teacherId AND ID = :invoiceId";
    String INVOICE_BY_ID = "SELECT ID, STATUS, ERRORMESSAGE, ERRORUUID, DOWNLOADED, SCHOOL, YEAR, MONTH, GENERATION, INVOICENB, DOCUMENTTYPE FROM INVOICE WHERE TEACHER = :teacherId AND ID = :invoiceId";
    String INVOICE_ERROR = "UPDATE INVOICE SET STATUS = :status, ERRORMESSAGE = :message, ERRORUUID = :uuid WHERE TEACHER = :teacherId AND ID = :invoiceId";
    String INVOICE_DELETE = "DELETE FROM INVOICE WHERE TEACHER = :teacherId AND ID = :invoiceId";
    String INVOICE_TOTAL = "SELECT COUNT(*) FROM INVOICE WHERE TEACHER = :teacherId";

    String PREFERENCES_GET = "SELECT VALUE FROM PREFERENCES WHERE TEACHER = :teacherId AND NAME = :name";
    String PREFERENCES_DELETE = "DELETE FROM PREFERENCES WHERE TEACHER = :teacherId AND NAME = :name";
    String PREFERENCES_INSERT = "INSERT INTO PREFERENCES (TEACHER, NAME, VALUE) VALUES (:teacherId, :name, :value)";
}
