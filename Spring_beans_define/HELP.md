# - Định nghĩa Bean :
Để 1 đối tượng java trở thành spring bean thì cần 2 điều kiện
- Khai báo POJO
- Cấu hình trong 3 cách :
## 1. Khai báo trong file XML
- phương pháp truyền thống và ít được sử dụng trong Spring Boot. Bean được cấu hình trong các file XM
## 2. Dùng annotation trên class
- Spring cung cấp các annotation như @Component, @Service, @Repository, và @Controller để đánh dấu class là bean. Khi một class được đánh dấu bằng các annotation này, IoC container sẽ biết và tạo bean từ class đó.
- Các annotation này giúp đơn giản hóa quá trình cấu hình bean, đặc biệt khi sử dụng Spring Boot, nơi cấu hình tự động được khuyến khích.
## 3. Dùng @Configuration và @Bean
- được sử dụng khi cần định nghĩa các bean phức tạp hoặc khi có nhiều bean liên quan với nhau
- Class @Configuration cũng là một bean (do kế thừa từ @Component), vì vậy nó sẽ được tạo và quản lý bởi IoC container. Trong quá trình khởi tạo, các phương thức khởi tạo trong class này sẽ được gọi để chuẩn bị các bean bên trong
- Các phương thức @Bean trong class @Configuration sẽ return các instance của bean và sẽ được đưa vào ApplicationContext như bình thường
