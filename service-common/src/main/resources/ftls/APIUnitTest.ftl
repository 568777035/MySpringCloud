package ${BasePackageName}${TestPackageName};


/**
* Author ${Author}
* Date  ${Date}
*/
@RunWith(SpringRunner.class)
@SpringBootTest
public class ${ClassName}APITest {

@Autowired
private WebApplicationContext wac;
private MockMvc mockMvc;

@Before
public void setUp() {
mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
}

}
