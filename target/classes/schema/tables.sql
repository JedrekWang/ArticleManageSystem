#用户信息表
CREATE TABLE user(
  user_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  username VARCHAR(20) NOT NULL ,
  truename VARCHAR(20) NOT NULL ,
  password VARCHAR(80) NOT NULL ,
  degree TINYINT NOT NULL
)CHARSET = utf8;

# 公文信息表
CREATE TABLE article(
  article_id INT NOT NULL PRIMARY KEY  AUTO_INCREMENT,
  content TEXT ,
  title VARCHAR(80) NOT NULL ,
  submit_date TIMESTAMP NOT NULL ,
  writer VARCHAR(20) NOT NULL ,
  institution VARCHAR(20) NOT NULL ,
  department_pass int ,
  department_review TEXT,
  department_pass_user_id int,
  unit_pass int,
  unit_review TEXT,
  unit_pass_user_id int,
  secret int
)CHARSET =utf8;


INSERT into article(content, title, submit_date, writer, institution, department_pass, department_review,
                    department_pass_user, unit_pass, unit_review, unit_pass_user, secret)
VALUES ('人工智能的技术应用主要是在以下几个方面：自然语言处理（包括语音和语义识别、自动翻译）、计算机视觉（图像识别）、知识表示、自动推理（包括规划和决策）、机器学习和机器人学。按照技术类别来分，可以分成感知输入和学习与训练两种。计算机通过语音识别、图像识别、读取知识库、人机交互、物理传感等方式，获得音视频的感知输入，然后从大数据中进行学习，得到一个有决策和创造能力的大脑。从上世纪八九十年代的PC时代，进入到互联网时代后，给我们带来的是信息的爆炸和信息载体的去中心化。而网络信息获取渠道从PC转移到移动端后，万物互联成为趋势，但技术的限制导致移动互联网难以催生出更多的新应用和商业模式。而如今，人工智能已经成为这个时代最激动人心、最值得期待的技术，将成为未来10年乃至更长时间内IT产业发展的焦点。'
  ,'人工智能',now(),'Lsy','产品部门',1,'部门同意该条公文','Jedrek',1,'单位同意','Zex',1);

INSERT into article(content, title, submit_date, writer, institution, department_pass, department_review,
                    department_pass_user)
VALUES
  ('解决方案
　（1）经营模式多元化。例如可以提供房屋短租、社会化租车、制定服装服务等多元化的服务，而且在盈利模式上也非常灵活，有面向用户收费的，也有面向商家收费的，更有通过广告来收费的。根据具体的情况因地制宜地确定经营策略，因此，才能够共生共存，互利共赢。
　　（2）在经营思路上，O2O经营者也不能仅仅锁定低价格路线，而是应当借助自身的媒体优势，帮助商家挖掘一些增值业务。很多商家并不是没有退出多元化的业务体系，但是因为宣传不到位，这些服务没有获得用户。此时，O2O经营者就可以同商检协力合作进行多元化业务的开发。
　　（3）O2O本身是非常强调线下体验的经营模式，现有的团购网站并没有把握住这一精髓，仅仅依靠低价吸引用户。而O2O本身是可以做出很多“花样儿”的，在线下实体店的客户咨询、免费体验等环节都有文章可做。关键看O2O经营者和商家是否有足够的创新意识进行探索。',
   '电子商务',now(),'Lsy','营销部门',1,'部门同意该条','Jedrek');

INSERT into article(content, title, submit_date, writer, institution)VALUES('造成这一问题，固然是因为团购网站对商家资质不够严格，更重要的，还在于其对于O2O经营模式理解不到位。有些团购网站为了提升用户数量，扩大经营领域，不断在全国扩张，结果固然能够为消费者提供更多的产品或服务，但是却无法保证这些产品和服务的质量。O2O本身是非常强调本地化经营的商业模式，在某个区域内做精做透，这样才能长久维持客户。对于O2O经营者无法把握住这一点，就一定会在经营中发生策略上的失误',
'团购haha',now(),'Lsy','营销部门');