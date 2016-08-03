# camel-rabbitMQ
camel路由下的rabbitMQ
# camel  rabbitmq 
1. 需要引入
   <dependency>
    <groupId>org.apache.camel</groupId>
    <artifactId>camel-rabbitmq</artifactId>
    <version>x.x.x</version>
    <!-- use the same version as your Camel core version -->
  </dependency>
2. camel rabbitmq 路由的格式
   rabbitmq://hostname[:port]/exchangeName?[options]
     1. hostname  实例地址   
     2. port 可选，如果不写默认为： 5672
     3. exchangeName 绑定交换queue名称
     4. options 其他参数，详细请查看 http://camel.apache.org/rabbitmq.html
    
3. 自定义连接工厂：
   <bean id="customConnectionFactory" class="com.rabbitmq.client.ConnectionFactory">
    <property name="host" value="localhost"/>
    <property name="port" value="5672"/>
    <property name="username" value="camel"/>
    <property name="password" value="bugsbunny"/>
   </bean>
   <camelContext>
    <route>
      <from uri="direct:rabbitMQEx2"/>
      <to uri="rabbitmq://localhost:5672/ex2?connectionFactory=#customConnectionFactory"/>
    </route>
   </camelContext>
   
4. 示例
  from("rabbitmq://localhost/A?routingKey=B")
  from("rabbitmq://localhost/A?routingKey=B&threadPoolSize=1&autoAck=false")
  ...to("rabbitmq://localhost/B")
