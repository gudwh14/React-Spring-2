

const LoginPage = () => {

    return (
      <div className='container'>
          <div className='login-container'>
              <div className='login-box'>
                  <div className='logo-box'>
                      <span className='logo-span'></span>
                  </div>
                  <form>
                      <input type="text" className='login-input' placeholder="관리자 ID"/>
                      <input type="password" className='login-input' placeholder="비밀번호"/>
                      <button className='purple-button'>로그인</button>
                  </form>
                  <div className='notice-box'>
                      <span className='notice-span'>아직 회원이 아니신가요?</span>
                      <span className='link-span'>회원가입</span>
                  </div>
              </div>
          </div>
      </div>
    );
}

export default LoginPage;