
const SignUpPage = () => {
    return (
        <div className='container'>
            <div className='signup-container'>
                <form className='signup-input-box'>
                    <span className='logo-box'>
                        <span className='logo-span'></span>
                    </span>
                    <span className='signup-input-title-span'>시설 이름</span>
                    <input type="text" className="login-input" placeholder='XX필라테스 (수원 광교점)'/>

                    <span className='signup-input-title-span'>비밀번호</span>
                    <input type="password" className="login-input" placeholder="비밀번호를 입력해주세요"/>

                    <span className='signup-input-title-span'>비밀번호 확인</span>
                    <input type="password" className="login-input" placeholder='비밀번호를 한번 더 입력해 주세요'/>

                    <span className='signup-input-title-span'>시설 종류</span>
                    <select type="number" className="login-input">
                        <option>필라테스</option>
                        <option>요가</option>
                        <option>헬스</option>
                    </select>

                    <span className='signup-input-title-span'>시설 연락처</span>
                    <input type="text" className="login-input" placeholder='010-XXXX-XXXX'/>

                    <span className='signup-input-title-span'>시설 위치</span>
                    <div>
                        <input disabled={true} type="number" className="address-input"/>
                        <span className='address-find-button'>검색</span>
                    </div>

                    <button className="purple-button">Sign Up</button>
                </form>
            </div>
        </div>
    );
}

export default SignUpPage;