INSERT INTO %s.processes 
            (NAME, 
             version, 
             content) 
VALUES     ('ProcessDeTest', 
            'v_2.21_0', 
            '<?xml version="1.0" encoding="UTF-8"?> <!DOCTYPE xml> <processRequest> <name>BrandChangeRequest</name> <description>Import brand names, sub brand names and supplier assignments</description> <mainElementName>Incident</mainElementName> <!-- first node from the document --> <logFilterKey>../Domain/bdm_brand_id</logFilterKey> <!-- element/s that define unique the document --> <validations> <validation> <elementName>brand/BDM_BRAND_ID</elementName> <!-- node, element or attribute --> <XMLType>element</XMLType> <dataType>number</dataType> <!-- string, number, boolean, date, timestamp --> <maxLength>12</maxLength> <digits>0</digits> <minOccurs>1</minOccurs>  <maxOccurs>1</maxOccurs> <!-- 0, 1, n allowed values -->  </validation> <validation> <elementName>brand/BRANDNAME</elementName> <XMLType>element</XMLType> <dataType>string</dataType> <maxLength>50</maxLength> <minOccurs>0</minOccurs>  <maxOccurs>n</maxOccurs>	</validation> <validation> <elementName>brand/BRANDNAME/@language_code</elementName> <!-- "@" sign must be used for attributes --> <XMLType>attribute</XMLType> <dataType>string</dataType> <maxLength>3</maxLength> </validation>	<validation> <elementName>brand/IS_VALID_FOR_LOV</elementName> <XMLType>element</XMLType> <dataType>boolean</dataType> <minOccurs>1</minOccurs>  <maxOccurs>1</maxOccurs>	</validation> <validation> <elementName>brand/IS_TECHNICAL</elementName> <XMLType>element</XMLType> <dataType>boolean</dataType> <minOccurs>1</minOccurs>  <maxOccurs>1</maxOccurs>	</validation> <validation> <elementName>brand/subbrands</elementName> <XMLType>node</XMLType> <minOccurs>0</minOccurs>  <maxOccurs>1</maxOccurs> </validation> <validation> <elementName>brand/subbrands/subbrand</elementName> <XMLType>node</XMLType> <minOccurs>0</minOccurs>  <maxOccurs>n</maxOccurs> </validation>	<validation> <elementName>brand/subbrands/subbrand[n]/BDM_SUB_BRAND_ID</elementName> <XMLType>element</XMLType> <dataType>number</dataType> <maxLength>12</maxLength> <digits>0</digits> <minOccurs>0</minOccurs>  <maxOccurs>1</maxOccurs> </validation> <validation> <elementName>brand/subbrands/subbrand[n]/SUB_BRAND_NAME</elementName> <XMLType>element</XMLType> <dataType>string</dataType> <maxLength>50</maxLength> <minOccurs>0</minOccurs>  <maxOccurs>n</maxOccurs> </validation> <validation> <elementName>brand/subbrands/subbrand[n]/SUB_BRAND_NAME/@language_code</elementName> <XMLType>attribute</XMLType>	<dataType>string</dataType> <maxLength>3</maxLength> </validation> <validation> <elementName>brand/suppliers</elementName> <XMLType>node</XMLType> <minOccurs>0</minOccurs>  <maxOccurs>1</maxOccurs> </validation>	<validation> <elementName>brand/suppliers/SUPPLIER_NO</elementName> <XMLType>element</XMLType> <dataType>number</dataType> <maxLength>5</maxLength> <digits>0</digits> <minOccurs>0</minOccurs>  <maxOccurs>n</maxOccurs> </validation>	</validations> <complexValidations>     <!-- TODO: Here we need to decide how to validate the language, the mandatory languages and also the suppliers --> <mandatoryLanguages>SELECT sprach_kz FROM c15_data_languages WHERE mandatory = 1</mandatoryLanguages>  <allowedLanguages>SELECT sprach_kz FROM c15_data_languages</allowedLanguages> <consistencyCheck><![CDATA[1 == 1]]></consistencyCheck> </complexValidations> <mappings> <table name="RT_BRANDS_ML"> <uniqueKey>BRAND_ID, LANG_CD, VALID_FROM</uniqueKey> <uniqueKeyWithoutValidFrom>BRAND_ID, LANG_CD</uniqueKeyWithoutValidFrom> <multiplyRecordsOn>brand/BRANDNAME[n]/@language_code</multiplyRecordsOn> <columnMapping> <sourceXMLElement>brand/BDM_BRAND_ID</sourceXMLElement> <targetColumn>BRAND_ID</targetColumn> <mappingRule></mappingRule> </columnMapping> <columnMapping> <sourceXMLElement>brand/BRANDNAME[n]/@language_code</sourceXMLElement> <targetColumn>LANG_CD</targetColumn> <mappingRule></mappingRule> </columnMapping> <columnMapping> <defaultValue>17.01.2019</defaultValue> <targetColumn>VALID_FROM</targetColumn> <mappingRule></mappingRule> </columnMapping> <columnMapping> <defaultValue>20.01.2019</defaultValue> <targetColumn>VALID_TO</targetColumn> <mappingRule></mappingRule> </columnMapping> <columnMapping> <sourceXMLElement>brand/IS_VALID_FOR_LOV</sourceXMLElement> <targetColumn>BRAND_IS_VALID</targetColumn> <mappingRule>CASE WHEN lower(''{source}'') = ''true'' THEN 1 ELSE 0 END</mappingRule> </columnMapping> <columnMapping> <sourceXMLElement>brand/BRANDNAME[n]</sourceXMLElement> <targetColumn>BRAND_NAME</targetColumn> <defaultValue>@EXISTING_VALUE</defaultValue> </columnMapping> <columnMapping> <sourceXMLElement>brand/IS_TECHNICAL</sourceXMLElement> <targetColumn>TECHNICAL_BRAND</targetColumn> <mappingRule>CASE WHEN lower(''{source}'') = ''true'' THEN 1 ELSE 0 END</mappingRule> </columnMapping> <columnMapping> <defaultValue>@EXISTING</defaultValue> <targetColumn>CREATED_AT</targetColumn> <columnType>auditCreationDate</columnType> </columnMapping> <columnMapping> <defaultValue>{STRING:APPLICATION}_{DOCUMENT:../../Transaction/@time}</defaultValue> <targetColumn>CREATED_BY</targetColumn> <columnType>auditCreationUser</columnType> </columnMapping> <columnMapping> <defaultValue>{DATE:SYSTIMESTAMP}</defaultValue> <targetColumn>CHANGED_AT</targetColumn> <columnType>auditChangedDate</columnType> </columnMapping> <columnMapping> <defaultValue>{STRING:APPLICATION}_{DOCUMENT:../../Transaction/@time}</defaultValue> <targetColumn>CHANGED_BY</targetColumn> <columnType>auditChangedUser</columnType> </columnMapping> </table> <!-- SUBBRANDS and SUPPLIERS node can miss, how should the configuration be made? --> <table name="RT_SUB_BRANDS_ML"> <uniqueKey>BRAND_ID, SUB_BRAND_ID, LANG_CD, VALID_FROM</uniqueKey> <uniqueKeyWithoutValidFrom>BRAND_ID, SUB_BRAND_ID, LANG_CD</uniqueKeyWithoutValidFrom> <multiplyRecordsOn>brand/subbrands/subbrand[n]/SUB_BRAND_NAME[n]/@language_code</multiplyRecordsOn> <columnMapping> <sourceXMLElement>brand/BDM_BRAND_ID</sourceXMLElement> <targetColumn>BRAND_ID</targetColumn> </columnMapping> <columnMapping> <sourceXMLElement>brand/subbrands/subbrand[n]/BDM_SUB_BRAND_ID</sourceXMLElement> <targetColumn>SUB_BRAND_ID</targetColumn> </columnMapping> <columnMapping> <sourceXMLElement>brand/subbrands/subbrand[n]/SUB_BRAND_NAME[n]/@language_code</sourceXMLElement> <targetColumn>LANG_CD</targetColumn> </columnMapping> <columnMapping> <defaultValue>17.01.2019</defaultValue> <targetColumn>VALID_FROM</targetColumn> </columnMapping> <columnMapping> <defaultValue>20.01.2019</defaultValue> <targetColumn>VALID_TO</targetColumn> </columnMapping> <columnMapping> <sourceXMLElement>brand/subbrands/subbrand[n]/SUB_BRAND_NAME[n]</sourceXMLElement> <targetColumn>SUB_BRAND_NAME</targetColumn> </columnMapping> <columnMapping> <defaultValue>{DATE:SYSTIMESTAMP}</defaultValue> <targetColumn>CREATED_AT</targetColumn> <columnType>auditCreationDate</columnType> </columnMapping> <columnMapping> <defaultValue>{STRING:APPLICATION}_{DOCUMENT:../../Transaction/@time}</defaultValue> <targetColumn>CREATED_BY</targetColumn> <columnType>auditCreationUser</columnType> </columnMapping> <columnMapping> <defaultValue>{DATE:SYSTIMESTAMP}</defaultValue> <targetColumn>CHANGED_AT</targetColumn> <columnType>auditChangedDate</columnType> </columnMapping> <columnMapping> <defaultValue>{STRING:APPLICATION}_{DOCUMENT:../../Transaction/@time}</defaultValue> <targetColumn>CHANGED_BY</targetColumn> <columnType>auditChangedUser</columnType> </columnMapping> </table> <table name="LI_SUPPLIER_BRAND_ASSIGNMENT"> <uniqueKey>SUPPLIER_NO, BRAND_ID, VALID_FROM</uniqueKey> <uniqueKeyWithoutValidFrom>SUPPLIER_NO, BRAND_ID</uniqueKeyWithoutValidFrom> <multiplyRecordsOn>brand/suppliers/SUPPLIER_NO[n]</multiplyRecordsOn> <columnMapping> <sourceXMLElement>brand/suppliers/SUPPLIER_NO[n]</sourceXMLElement> <targetColumn>SUPPLIER_NO</targetColumn> </columnMapping> <columnMapping> <sourceXMLElement>brand/BDM_BRAND_ID</sourceXMLElement> <targetColumn>BRAND_ID</targetColumn> </columnMapping> <columnMapping> <defaultValue>17.01.2019</defaultValue> <targetColumn>VALID_FROM</targetColumn> </columnMapping> <columnMapping> <defaultValue>20.01.2019</defaultValue> <targetColumn>VALID_TO</targetColumn> </columnMapping> <columnMapping> <defaultValue>{DATE:SYSTIMESTAMP}</defaultValue> <targetColumn>CREATED_AT</targetColumn> <columnType>auditCreationDate</columnType> </columnMapping> <columnMapping> <defaultValue>{STRING:APPLICATION}_{DOCUMENT:../../Transaction/@time}</defaultValue> <targetColumn>CREATED_BY</targetColumn> <columnType>auditCreationUser</columnType> </columnMapping> <columnMapping> <defaultValue>{DATE:SYSTIMESTAMP}</defaultValue> <targetColumn>CHANGED_AT</targetColumn> <columnType>auditChangedDate</columnType> </columnMapping> <columnMapping> <defaultValue>{STRING:APPLICATION}_{DOCUMENT:../../Transaction/@time}</defaultValue> <targetColumn>CHANGED_BY</targetColumn> <columnType>auditChangedUser</columnType> </columnMapping> </table> </mappings> <processes> <transaction name="" description=""> <mergeMMS name="updateBrandsCT" description="Import brand data reference data from cache to MMS HO"> <mergeTable>RT_BRANDS_ML</mergeTable> <mergeTable>RT_SUB_BRANDS_ML</mergeTable> <mergeTable>LI_SUPPLIER_BRAND_ASSIGNMENT</mergeTable> </mergeMMS> </transaction>	</processes> </processRequest>'); 
