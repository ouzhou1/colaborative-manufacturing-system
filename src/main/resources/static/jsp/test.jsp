<html>
<body>
<jsp:useBean id="hardresource" class="edu.tongji.CMS.domain.Resource.HardwareResource">
   <jsp:setProperty name="hardresource" property="deviceCode" value="170001"/>
   <jsp:setProperty name="hardresource" property="name" value="Smith"/>
   <jsp:setProperty name="hardresource" property="deviceOwner" value="tongji"/>
</jsp:useBean>

<p>Student First Name: <jsp:getProperty name="hardresource" property="deviceCode"/>
</p>
<p>Student Last Name: <jsp:getProperty name="hardresource" property="name"/>
</p>
<p>Student Age: <jsp:getProperty name="hardresource" property="deviceOwner"/>
</p>

</body>
</html>