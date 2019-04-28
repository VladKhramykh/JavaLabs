package by.belstu.XML;import by.belstu.Employees.Developer;import by.belstu.Employees.Employees;import by.belstu.Employees.Engineer;import by.belstu.Employees.SystemAdministrator;import by.belstu.ItCompany;import org.xml.sax.*;import org.xml.sax.helpers.DefaultHandler;public class SAXParserXML {    public static class XMLHandler extends DefaultHandler {        private String itCompanyName, directorFirstName, directorSecondName;        private String firstName, secondName, type, lastElementName, posStr;        Developer.Position position;        private double salary;        ItCompany company;        Employees tmp;        public ItCompany getCompany() {            if (company != null)                return company;            else                return null;        }        @Override        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {            lastElementName = qName;        }        @Override        public void characters(char[] ch, int start, int length) throws SAXException {            String information = new String(ch, start, length);            information = information.replace("\n", "").trim();            if (!information.isEmpty()) {                if (lastElementName.equals("nameCompany"))                    itCompanyName = information;                if (lastElementName.equals("directorFirstName"))                    directorFirstName = information;                if (lastElementName.equals("directorSecondName"))                    directorSecondName = information;                if (lastElementName.equals("firstName"))                    firstName = information;                if (lastElementName.equals("secondName"))                    secondName = information;                if (lastElementName.equals("position")) {                    posStr = information;                    if (posStr.equals("Junior")) {                        position = Developer.Position.Junior;                    }                    if (posStr.equals("Middle")) {                        position = Developer.Position.Middle;                    }                    if (posStr.equals("Senior")) {                        position = Developer.Position.Senior;                    }                }                if (lastElementName.equals("type"))                    type = information;                if (lastElementName.equals("salary"))                    salary = Double.parseDouble(information);            }        }        @Override        public void endElement(String uri, String localName, String qName) throws SAXException {            if (company == null) {                if ((itCompanyName != null && !itCompanyName.isEmpty()) && (directorFirstName != null && !directorFirstName.isEmpty()) && (directorSecondName != null && !directorSecondName.isEmpty())) {                    company = new ItCompany(itCompanyName, directorFirstName, directorSecondName);                }            }            if ((firstName != null && !firstName.isEmpty()) && (secondName != null && !secondName.isEmpty()) && (position!=null) && (type!=null && !type.isEmpty() && salary!=0)) {                if(type.equals(Developer.getType())) {                    tmp = new Developer(firstName,secondName,position,salary);                    company.addEmployee(tmp);                    firstName=null;                    secondName=null;                    position=null;                    salary = 0;                    return;                }                if(type.equals(SystemAdministrator.getType())) {                    tmp = new SystemAdministrator(firstName, secondName, salary);                    company.addEmployee(tmp);                    firstName=null;                    secondName=null;                    position=null;                    salary = 0;                    return;                }                if(type.equals(Engineer.getType())) {                    tmp = new Engineer(firstName, secondName, salary);                    company.addEmployee(tmp);                    firstName=null;                    secondName=null;                    position=null;                    salary = 0;                    return;                }            }        }        @Override        public void endDocument() throws SAXException {            System.out.println("SAX выполнен!");        }    }}