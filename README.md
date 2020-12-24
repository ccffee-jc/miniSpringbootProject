# miniSpringbootProject
springboot的一个项目模板

食用方法：

1.项目名称修改，pom.xml中修改11、12、17、18行，修改src/main/java/xxx/xxx/xxx。（选）

2.修改数据库，application.properties文件修改6，7行中的xxxx。

3.修改generator(数据库表model自动创建工具)配置，修改generator.properties文件中的xxxxx，generatorConfig.xml中34、36、39行的targetProject地址。

4.配置好之后可以运行src/main/java/xxx/xxx/xxx/mbg/Generator.java，生成对应数据库文件，然后根据模板写业务就行了，后面需要用到什么组件就往里面添加。
