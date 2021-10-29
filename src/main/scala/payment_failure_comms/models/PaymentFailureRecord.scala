package payment_failure_comms.models

import java.time.ZoneOffset.UTC
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeFormatter.ISO_OFFSET_DATE_TIME
import java.time.{LocalDate, OffsetDateTime, ZoneOffset}

case class PaymentFailureRecord(
    Id: String,
    Contact__r: SFContact,
    SF_Subscription__r: SFSubscription,
    Status__c: String,
    PF_Comms_Status__c: String,
    PF_Comms_Last_Stage_Processed__c: Option[String] = None,
    PF_Comms_Number_of_Attempts__c: Option[Int] = Some(0),
    Currency__c: String,
    Invoice_Total_Amount__c: Double,
    Initial_Payment_Created_Date__c: Option[OffsetDateTime],
    Last_Attempt_Date__c: Option[LocalDate],
    Cut_Off_Date__c: LocalDate
)

case class SFContact(IdentityID__c: String)

case class SFSubscription(
    Product_Name__c: String,
    Cancellation_Request_Date__c: Option[OffsetDateTime]
)

case class SFPaymentFailureRecordWrapper(totalSize: Int, done: Boolean, records: Seq[PaymentFailureRecord])
