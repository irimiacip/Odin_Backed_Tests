INSERT INTO %s.processes 
            (NAME, 
             version, 
             content) 
VALUES     ('ProcessDeTest', 
            'v_2.8_0', 
            '<?xml version="1.0" encoding="UTF-8"?>   <!DOCTYPE xml>   <processRequest>         <name>ProcessDeTest</name>         <displayName>Display pentru ProcessDeTest</displayName>         <description>Folosit pentru test</description>         <mainElementName>Incident</mainElementName> <!-- first node from the document -->         <logFilterKey>Domain/column1</logFilterKey> <!-- element/s that define unique the document -->         <logUniqueID>Domain/column1</logUniqueID> <!-- correlationId of the document -->         <requestNodeName>content/request</requestNodeName>                 <fileMapping>             <fileExtension>CSV</fileExtension>             <startLineNo>2</startLineNo>           <groupRequestColumns>1,2,3,4</groupRequestColumns>           <groupResponseColumns>1,2,3,4</groupResponseColumns>             <columnMapping>               <sourceColumnNo>1</sourceColumnNo>               <targetXMLNode>Domain</targetXMLNode>                     <targetXMLElement>column1</targetXMLElement>             </columnMapping>               <columnMapping>               <sourceColumnNo>2</sourceColumnNo>               <targetXMLNode>Domain</targetXMLNode>                     <targetXMLElement>column2</targetXMLElement>             </columnMapping>               <columnMapping>               <sourceColumnNo>3</sourceColumnNo>               <targetXMLNode>content/request</targetXMLNode>                     <targetXMLElement>column3</targetXMLElement>             </columnMapping>               <columnMapping>               <sourceColumnNo>4</sourceColumnNo>               <targetXMLNode>content/request</targetXMLNode>                     <targetXMLElement>column4</targetXMLElement>             </columnMapping>                </fileMapping>               <validations> <!--TODO: add all elements and put all data in it -->               <validation>                     <elementName>Domain/column1</elementName> <!-- node, element or attribute -->                     <XMLType>element</XMLType>                     <dataType>number</dataType> <!-- string, number, boolean, date, timestamp -->                             </validation>               <validation>                     <elementName>Domain/column1/@attribute1</elementName>                     <XMLType>attribute</XMLType>                     <dataType>string</dataType> <!-- string, number, boolean, date, timestamp -->                     </validation>               <validation>                     <elementName>Domain/column2</elementName> <!-- node, element or attribute -->                     <XMLType>element</XMLType>                           </validation>               <validation>                     <elementName>content/request/column3</elementName>                     <XMLType>element</XMLType>                     <dataType>string</dataType> <!-- string, number, boolean, date, timestamp -->                             </validation>               <validation>                     <elementName>content/request/column4</elementName>                                   </validation>         </validations>         <complexValidations>                 </complexValidations>                 <mappings>               <table name="ODIN_TEST">                     <uniqueKey>COLOANA1</uniqueKey>                   <uniqueKeyWithoutValidFrom>COLOANA1</uniqueKeyWithoutValidFrom>                   <multiplyRecordsOn>content/request[n]</multiplyRecordsOn>                   <columnMapping>                         <sourceXMLElement>Domain/column1</sourceXMLElement>                         <targetColumn>COLOANA1</targetColumn>                   </columnMapping>                   <columnMapping>                         <sourceXMLElement>Domain/column2</sourceXMLElement>                         <targetColumn>COLOANA2</targetColumn>                   </columnMapping>                   <columnMapping>                         <sourceXMLElement>content/request[n]/column3</sourceXMLElement>                                       <targetColumn>COLOANA3</targetColumn>                   </columnMapping>                   <columnMapping>                         <sourceXMLElement>content/request[n]/column4</sourceXMLElement>                         <targetColumn>COLOANA4</targetColumn>                  <mappingRule>{FUNCTION:select COLOANA4 from odin_test where COLOANA2 like ''{Domain/column2}'' and COLOANA3 like ''%{content/request[n]/column3}%''}</mappingRule>         <actionIfLineFunctionReturnNull>ERROR</actionIfLineFunctionReturnNull>                   </columnMapping>             </table>       </mappings>       <processes>             <transaction name="" description="">                   <insert name="Insert de test" description="">                 <table>ODIN_TEST</table>             </insert>             </transaction>       </processes> </processRequest>'); 
