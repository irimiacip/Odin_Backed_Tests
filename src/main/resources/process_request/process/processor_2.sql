INSERT INTO %s.processes 
            (NAME, 
             version, 
             content) 
VALUES     ('ProcessDeTest', 
            'v_2.2_0', 
            '<?xml version="1.0" encoding="UTF-8"?> <!DOCTYPE xml>   <processRequest>         <name>ProcessDeTest</name>         <displayName>Display pentru ProcessDeTest</displayName>         <description>Folosit pentru test</description>         <mainElementName>Incident</mainElementName> <!-- first node from the document -->         <logFilterKey>Domain/column1</logFilterKey> <!-- element/s that define unique the document -->         <logUniqueID>Domain/column1</logUniqueID> <!-- correlationId of the document -->         <requestNodeName>content/request</requestNodeName>                 <fileMapping>             <fileExtension>CSV</fileExtension>             <startLineNo>2</startLineNo>           <groupRequestColumns>1,2,3,4</groupRequestColumns>           <groupResponseColumns>1,2,3,4</groupResponseColumns>             <columnMapping>               <sourceColumnNo>1</sourceColumnNo>               <targetXMLNode>Domain</targetXMLNode>                     <targetXMLElement>column1</targetXMLElement>             </columnMapping>               <columnMapping>               <sourceColumnNo>2</sourceColumnNo>               <targetXMLNode>Domain</targetXMLNode>                     <targetXMLElement>column2</targetXMLElement>             </columnMapping>               <columnMapping>               <sourceColumnNo>3</sourceColumnNo>               <targetXMLNode>content/request</targetXMLNode>                     <targetXMLElement>column3</targetXMLElement>             </columnMapping>               <columnMapping>               <sourceColumnNo>4</sourceColumnNo>               <targetXMLNode>content/request</targetXMLNode>                     <targetXMLElement>column4</targetXMLElement>             </columnMapping>                </fileMapping>               <validations> <!--TODO: add all elements and put all data in it -->               <validation>                     <elementName>Domain/column1</elementName> <!-- node, element or attribute -->                     <XMLType>element</XMLType>                     <dataType>number</dataType> <!-- string, number, boolean, date, timestamp -->                     <maxLength>7</maxLength>                     <minLength>1</minLength>                     <minValue>2</minValue>                     <maxValue>100</maxValue>                     <digits>0</digits>                                      <minOccurs>1</minOccurs>                     <maxOccurs>1</maxOccurs> <!-- 0, 1, n allowed values -->               </validation>               <validation>                     <elementName>Domain/column1/@attribute1</elementName>                     <XMLType>attribute</XMLType>                     <dataType>string</dataType> <!-- string, number, boolean, date, timestamp -->                     <maxLength>7</maxLength>                     <minLength>1</minLength>                                      <minOccurs>0</minOccurs>                     <maxOccurs>1</maxOccurs> <!-- 0, 1, n allowed values -->               </validation>               <validation>                     <elementName>Domain/column2</elementName> <!-- node, element or attribute -->                     <XMLType>element</XMLType>                     <dataType>boolean</dataType> <!-- string, number, boolean, date, timestamp -->                     <minOccurs>1</minOccurs>                     <maxOccurs>2</maxOccurs> <!-- 0, 1, n allowed values -->               </validation>               <validation>                     <elementName>content/request/column3</elementName>                     <XMLType>element</XMLType>                     <dataType>string</dataType> <!-- string, number, boolean, date, timestamp -->                     <maxLength>8</maxLength>                     <minLength>1</minLength>                                      <minOccurs>1</minOccurs>                     <maxOccurs>1</maxOccurs> <!-- 0, 1, n allowed values -->               </validation>               <validation>                     <elementName>content/request/column4</elementName>                     <XMLType>element</XMLType>                     <dataType>number</dataType> <!-- string, number, boolean, date, timestamp -->                                        <minLength>1</minLength>                         <maxLength>10</maxLength>                     <minOccurs>1</minOccurs>                     <maxOccurs>1</maxOccurs> <!-- 0, 1, n allowed values -->               </validation>         </validations>         <complexValidations>               <consistencyCheck >{Domain/column1}.compareTo({content/request/column4}) &lt;= 0</consistencyCheck>         </complexValidations>                 <mappings>               <table name="ODIN_TEST">                     <uniqueKey>COLOANA1</uniqueKey>                     <uniqueKeyWithoutValidFrom>COLOANA1</uniqueKeyWithoutValidFrom>                     <multiplyRecordsOn>content/request[n]</multiplyRecordsOn>                     <columnMapping>                           <sourceXMLElement>Domain/column1</sourceXMLElement>                           <targetColumn>COLOANA1</targetColumn>                     </columnMapping>                     <columnMapping>                           <sourceXMLElement>Domain/column2</sourceXMLElement>                           <targetColumn>COLOANA2</targetColumn>                     </columnMapping>                     <columnMapping>                           <sourceXMLElement>content/request[n]/column3</sourceXMLElement>                           <targetColumn>COLOANA3</targetColumn>     <mappingRule>SUBSTR(''{source}'',0,5)</mappingRule>                     </columnMapping>                     <columnMapping>                           <sourceXMLElement>content/request[n]/column4</sourceXMLElement>                           <targetColumn>COLOANA4</targetColumn>                                   </columnMapping>               </table>         </mappings>                 <processes>               <transaction name="" description="">                     <insert name="Insert de test" description="">                       <table>ODIN_TEST</table>                   </insert>               </transaction>         </processes>   </processRequest>'); 