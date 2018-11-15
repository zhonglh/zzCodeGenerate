import EncryptUtil from '@/utils/EncryptUtil';

let responseVO = {
    result: '',
    sign: ''
};

let resultVO = {
    code: 200,
    body: '',
    msg: ''
};



 function responseData(resultVO){

     // const encrypt = process.env.ENCRYPT;
     const encrypt = false;
    if (encrypt) {
        const encryptResult = EncryptUtil.encrypt(JSON.stringify(resultVO));
        responseVO.result = `${encryptResult}`;
    }else {
        responseVO.result = resultVO;
    }

    const sign = EncryptUtil.sign(1);
    responseVO.sign = sign;
    return responseVO;
}

module.exports = {
    responseVO,
    resultVO,
    responseData

};